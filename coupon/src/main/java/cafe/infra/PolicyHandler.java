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
    CouponRepository couponRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CouponPublished'"
    )
    public void wheneverCouponPublished_AddCoupon(
        @Payload CouponPublished couponPublished
    ) {
        CouponPublished event = couponPublished;
        System.out.println(
            "\n\n##### listener AddCoupon : " + couponPublished + "\n\n"
        );

        // Sample Logic //
        Coupon.addCoupon(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
