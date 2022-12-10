import java.util.Stack;
import java.util.*;

public class stackExercise {
    public static void reverse(Scanner in) {
        Stack<Integer> stack = new Stack<Integer>();
        while (in.hasNextInt()) {
            int a = in.nextInt();
            stack.push(a);
        }
        in.close();

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
    public static void main (String[] args) {
//        Stack<Integer> s = new Stack<Integer>();
//        s.push(1);
//        s.push(2);
//        s.push(6);
//        s.push(10);
//
//        int n = s.peek();
//        System.out.println("The top element is " + n);
//        n = s.pop();
//        System.out.println("The popped top element is " + n);
//        boolean isEmpty = s.empty();
//        System.out.println("Is stack empty? " + isEmpty);
        Scanner in = new Scanner(System.in);
        reverse(in);
    }
}