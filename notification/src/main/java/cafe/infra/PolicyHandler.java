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
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuMaked'"
    )
    public void wheneverMenuMaked_Notify(@Payload MenuMaked menuMaked) {
        MenuMaked event = menuMaked;
        System.out.println("\n\n##### listener Notify : " + menuMaked + "\n\n");

        // Sample Logic //
        Notification.notify(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuStopped'"
    )
    public void wheneverMenuStopped_Notify(@Payload MenuStopped menuStopped) {
        MenuStopped event = menuStopped;
        System.out.println(
            "\n\n##### listener Notify : " + menuStopped + "\n\n"
        );

        // Sample Logic //
        Notification.notify(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
