package Stack_Queoe;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("America");
        stack.push("Canada");
        stack.push("France");

        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
