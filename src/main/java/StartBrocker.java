import org.springframework.kafka.test.EmbeddedKafkaBroker;

public class StartBrocker {
    public static void main(String[] args) {
        EmbeddedKafkaBroker embeddedKafkaBroker = new EmbeddedKafkaBroker(1)
                .kafkaPorts(9092);
        embeddedKafkaBroker.afterPropertiesSet();
    }
}
