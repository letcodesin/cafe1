package cafe.domain;

import cafe.domain.*;
import cafe.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class AlreadyMaked extends AbstractEvent {

    private Long id;
}
