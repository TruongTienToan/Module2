package Stack_Queoe;

public class TestGenericQueue {
    public static void main(String[] args) {
        GenericQueue<String> queue = new GenericQueue<>();

        queue.enqueue("America");
        queue.enqueue("Canada");
        queue.enqueue("France");
        queue.poll();

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
