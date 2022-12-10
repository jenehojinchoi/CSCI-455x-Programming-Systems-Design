import java.awt.*;
import java.util.*;

public class problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack myStack = new Stack();
        Queue myQ = new Queue();

        while (in.hasNext()) {
            myStack.push(in.next());
        }

        Iterator value = stack.iterator();

        // Displaying the values
        // after iterating through the stack
        System.out.println("The iterator values are: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }


        while (!myStack.empty()) {
            myQ.enqueue(myStack.pop());
        }

        while (!myQ.empty()) {
            myStack.push(myQ.dequeue());
        }
    }
}