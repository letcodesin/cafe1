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
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AlreadyMaked'"
    )
    public void wheneverAlreadyMaked_UpdateStatus(
        @Payload AlreadyMaked alreadyMaked
    ) {
        AlreadyMaked event = alreadyMaked;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + alreadyMaked + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
