import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        // Last in - First out
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.search("3"));

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}

