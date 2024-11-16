package cafe.domain;

import cafe.domain.*;
import cafe.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CouponPublished extends AbstractEvent {

    private Long id;
    private String userId;
    private String userName;
    private String menuId;
    private String menuName;
    private String orderId;
    private String orderStatus;
    private String recipe;
}
