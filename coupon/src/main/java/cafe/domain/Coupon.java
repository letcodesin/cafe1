package cafe.domain;

import cafe.CouponApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Coupon_table")
@Data
//<<< DDD / Aggregate Root
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String userName;

    private Integer couponCount;

    public static CouponRepository repository() {
        CouponRepository couponRepository = CouponApplication.applicationContext.getBean(
            CouponRepository.class
        );
        return couponRepository;
    }

    //<<< Clean Arch / Port Method
    public static void addCoupon(CouponPublished couponPublished) {
        //implement business logic here:

        /** Example 1:  new item 
        Coupon coupon = new Coupon();
        repository().save(coupon);

        */

        /** Example 2:  finding and process
        
        repository().findById(couponPublished.get???()).ifPresent(coupon->{
            
            coupon // do something
            repository().save(coupon);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
