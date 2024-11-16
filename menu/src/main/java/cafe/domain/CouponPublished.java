package cafe.domain;

import cafe.domain.*;
import cafe.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CouponPublished extends AbstractEvent {

    private Long id;

    public CouponPublished(Menu aggregate) {
        super(aggregate);
    }

    public CouponPublished() {
        super();
    }
}
//>>> DDD / Domain Event
