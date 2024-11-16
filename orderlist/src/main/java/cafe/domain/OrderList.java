package cafe.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "OrderList_table")
@Data
public class OrderList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String userId;
    private String userName;
    private String menuId;
    private String menuName;
    private String orderId;
    private String menuStatus;
    private Date orderTime;
    private String size;
}
