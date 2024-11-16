package cafe.domain;

import cafe.domain.*;
import cafe.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MenuStopped extends AbstractEvent {

    private Long id;
    private String userId;
    private String userName;
    private String menuId;
    private String menuName;
    private String menuStatus;
    private String orderId;
    private String orderStatus;
    private String recipe;

    public MenuStopped(Menu aggregate) {
        super(aggregate);
    }

    public MenuStopped() {
        super();
    }
}
//>>> DDD / Domain Event
