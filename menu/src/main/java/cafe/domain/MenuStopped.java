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

    public MenuStopped(Menu aggregate) {
        super(aggregate);
    }

    public MenuStopped() {
        super();
    }
}
//>>> DDD / Domain Event
