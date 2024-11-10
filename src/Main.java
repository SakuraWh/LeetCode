public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        messageQueue.registerConsumer("consumer1", message -> System.out.println("消费者1消费了消息：" + message));
        messageQueue.registerConsumer("consumer2", message -> System.out.println("消费者2消费了消息：" + message));

        messageQueue.start();

        for (int i = 0; i < 10; i++) {
            messageQueue.produce("消息" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
