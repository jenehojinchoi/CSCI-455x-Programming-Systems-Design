// Name: Jene (Hojin) Choi
// USC NetID: hojincho
// CSCI455 PA2
// Fall 2022

import java.util.ArrayList;

public class BookshelfTester {
    public static void main (String []args) {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);

        Bookshelf bookshelf1 = new Bookshelf(arr1);
        System.out.println("Test class constructed");

        System.out.println("==============================");
        System.out.println("Expected: [1, 2, 3, 4]");
        System.out.println("output: " + bookshelf1.toString());

        // Exercise 2
        System.out.println("==============================");
        System.out.println("Expected: true");
        System.out.println("output: " + bookshelf1.isSorted());

        System.out.println("==============================");
        System.out.println("Expected: 2");
        System.out.println("output: " + bookshelf1.getHeight(1));

        System.out.println("==============================");
        System.out.println("Expected: 4");
        System.out.println("output: " + bookshelf1.size());


        System.out.println("==============================");
        System.out.println("Expected: [1, 2, 3, 4, 5]");
        bookshelf1.addLast(5);
        System.out.println("output: " + bookshelf1.toString());

        System.out.println("==============================");
        System.out.println("Expected: [1, 2, 3, 4]");
        bookshelf1.removeLast();
        System.out.println("output: " + bookshelf1.toString());

        System.out.println("==============================");
        System.out.println("Expected: [2, 3, 4]");
        bookshelf1.removeFront();
        System.out.println("output: " + bookshelf1.toString());

        System.out.println("==============================");
        System.out.println("Expected: [1, 2, 3, 4]");
        bookshelf1.addFront(1);
        System.out.println("output: " + bookshelf1.toString());


        System.out.println("==============================");
        System.out.println("Expected: false");
        bookshelf1.addLast(1);
        System.out.println("output: " + bookshelf1.isSorted());

        System.out.println("==============================");
        ArrayList<Integer> a = new ArrayList<>();
        a.add(-1);
        System.out.println("test assert");
        Bookshelf bookshelf3 = new Bookshelf(a);

        // ex2
        System.out.println("==============================");
        Bookshelf bookshelf2 = new Bookshelf();
        System.out.println("expected []");
        System.out.println("output: " + bookshelf2.toString());

        bookshelf1.size();

    }
}
