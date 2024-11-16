package cafe.domain;

import cafe.domain.*;
import cafe.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancled extends AbstractEvent {

    private Long id;
    private String userId;
    private String menuId;
    private String orderStatus;
    private Date orderTime;
    private String size;
}
