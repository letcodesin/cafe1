package cafe.domain;

import cafe.domain.*;
import cafe.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class MenuStopped extends AbstractEvent {

    private Long id;
}
