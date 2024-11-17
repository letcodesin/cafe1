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

        /** Example 1:  new item 
        Menu menu = new Menu();
        repository().save(menu);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(menu->{
            
            menu // do something
            repository().save(menu);


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
