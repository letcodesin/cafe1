package cafe.domain;

import cafe.domain.*;
import cafe.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AlreadyMaked extends AbstractEvent {

    private Long id;

    public AlreadyMaked(Menu aggregate) {
        super(aggregate);
    }

    public AlreadyMaked() {
        super();
    }
}
//>>> DDD / Domain Event
