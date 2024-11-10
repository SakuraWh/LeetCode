import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageQueue {
    private Queue<String> queue = new LinkedList<>();
    private ConcurrentHashMap<String, Consumer> consumers = new ConcurrentHashMap<>();

    public void produce(String message) {
        queue.add(message);
    }

    public void registerConsumer(String consumerId, Consumer consumer) {
        consumers.put(consumerId, consumer);
    }

    public void start() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            while (true) {
                if (!queue.isEmpty()) {
                    String message = queue.poll();
                    for (Consumer consumer : consumers.values()) {
                        executorService.submit(() -> {
                            try {
                                consumer.consume(message);
                            } catch (Exception e) {
                                System.out.println("消费异常：" + e.getMessage());
                            }
                        });
                    }
                }
            }
        });
    }

    public interface Consumer {
        void consume(String message) throws Exception;
    }


}
