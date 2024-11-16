package cafe.domain;

import cafe.MenuApplication;
import cafe.domain.AlreadyMaked;
import cafe.domain.CouponPublished;
import cafe.domain.MenuMaked;
import cafe.domain.MenuStopped;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import java.time.ZoneId;
import java.time.LocalDateTime;

@Entity
@Table(name = "Menu_table")
@Data
//<<< DDD / Aggregate Root
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String userName;

    private String menuId;

    private String menuName;

    private String orderId;

    private String menuStatus;

    private String recipe;

    @PostPersist
    public void onPostPersist() {
        MenuMaked menuMaked = new MenuMaked(this);
        menuMaked.publishAfterCommit();

        MenuStopped menuStopped = new MenuStopped(this);
        menuStopped.publishAfterCommit();

        AlreadyMaked alreadyMaked = new AlreadyMaked(this);
        alreadyMaked.publishAfterCommit();

        CouponPublished couponPublished = new CouponPublished(this);
        couponPublished.publishAfterCommit();
    }

    public static MenuRepository repository() {
        MenuRepository menuRepository = MenuApplication.applicationContext.getBean(
            MenuRepository.class
        );
        return menuRepository;
    }

    //<<< Clean Arch / Port Method
    public static void makeMenu(OrderPlaced orderPlaced) {
        //implement business logic here:

        // Example 1:  new item 
        Menu menu = new Menu();
        repository().save(menu);

        menu.setUserId(orderPlaced.getUserId());
        menu.setUserName(orderPlaced.getUserName());
        menu.setOrderId(orderPlaced.getOrderId());        
        menu.setMenuId(orderPlaced.getMenuId());
        //주문시간 체크
        // Date -> LocalDateTime 변환
        LocalDateTime orderTime = orderPlaced.getOrderTime()
                                            .toInstant()
                                            .atZone(ZoneId.systemDefault())
                                            .toLocalDateTime();

        // 현재 시간
        LocalDateTime now = LocalDateTime.now();
        if(menu.getMenuStatus().equals("0") && now.isBefore(orderTime.plusSeconds(45))){
            menu.setMenuStatus("제조중");
        }
        else if (menu.getMenuStatus().equals("제조중") &&orderTime.plusSeconds(45).isBefore(now)) {
            menu.setMenuStatus("제조완료");
        } 
        /*
        else if(menu.getMenuStatus().equals("제조중") && now.isBefore(orderPlaced.getOrderTime().plusSeconds(45))){
            menu.setMenuStatus(0);
            MenuMaked menuMaked = new MenuMaked(menu);
            menuMaked.publishAfterCommit();
        }
        */

        

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(menu->{
            
            menu // do something
            repository().save(menu);

            MenuMaked menuMaked = new MenuMaked(menu);
            menuMaked.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void stopMenu(OrderCancled orderCancled) {
        //implement business logic here:

        /** Example 1:  new item 
        Menu menu = new Menu();
        repository().save(menu);

        MenuStopped menuStopped = new MenuStopped(menu);
        menuStopped.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancled.get???()).ifPresent(menu->{
            
            menu // do something
            repository().save(menu);

            MenuStopped menuStopped = new MenuStopped(menu);
            menuStopped.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
