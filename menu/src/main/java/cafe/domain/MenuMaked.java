package cafe.domain;

import cafe.domain.*;
import cafe.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MenuMaked extends AbstractEvent {

    private Long id;

    public MenuMaked(Menu aggregate) {
        super(aggregate);
    }

    public MenuMaked() {
        super();
    }
}
//>>> DDD / Domain Event
