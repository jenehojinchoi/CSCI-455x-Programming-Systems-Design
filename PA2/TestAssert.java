import java.util.ArrayList;

public class TestAssert {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf(new ArrayList<Integer>());
        ArrayList<Integer> bookshelfArr = new ArrayList<Integer>();
        bookshelfArr.add(-1);

        Bookshelf bookshelf2 = new Bookshelf(bookshelfArr);
    }
}
