package cafe.infra;

import cafe.config.kafka.KafkaProcessor;
import cafe.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    MenuRepository menuRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_MakeMenu(@Payload OrderPlaced orderPlaced) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener MakeMenu : " + orderPlaced + "\n\n"
        );

        // Sample Logic //
        Menu.makeMenu(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancled'"
    )
    public void wheneverOrderCancled_StopMenu(
        @Payload OrderCancled orderCancled
    ) {
        OrderCancled event = orderCancled;
        System.out.println(
            "\n\n##### listener StopMenu : " + orderCancled + "\n\n"
        );

        // Sample Logic //
        Menu.stopMenu(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
