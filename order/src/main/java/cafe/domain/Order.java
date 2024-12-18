package cafe.domain;

import cafe.OrderApplication;
import cafe.domain.OrderCancled;
import cafe.domain.OrderPlaced;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import java.time.ZoneId;
import java.time.LocalDateTime;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String userName;

    private String orderId;

    private String orderStatus;

    private Date orderTime;

    private String menuId;

    private String size;

    //PrePersist Method to set default orderTime
    @PrePersist
    public void setDefaultOrderTime() {
        if (orderTime == null) {
            // KST 시간으로 설정
            ZoneId kstZone = ZoneId.of("Asia/Seoul");
            LocalDateTime nowKST = LocalDateTime.now(kstZone);

            // LocalDateTime -> Date 변환
            orderTime = Date.from(nowKST.atZone(kstZone).toInstant());
        }
    }

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderCancled orderCancled = new OrderCancled(this);
        orderCancled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateStatus(AlreadyMaked alreadyMaked) {
        //implement business logic here:

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(alreadyMaked.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
