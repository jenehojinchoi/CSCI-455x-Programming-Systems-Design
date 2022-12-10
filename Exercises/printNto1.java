public class printNto1 {
    public static void printDescending(int n) {
        if (n==1) {
            System.out.println(1);
        } else {
            System.out.print(n + " ");
            printDescending(n-1);
        }
    }

    public static void printAscending(int n) {
        if (n==1) {
            System.out.print(1 + " ");
        } else {
            printAscending(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Boolean isDescending = Boolean.parseBoolean(args[0]);
        int n = Integer.parseInt(args[1]);
        if (isDescending) {
            System.out.println("Descending");
            printDescending(n);
        } else {
            System.out.println("Ascending");
            printAscending(n);
        }
    }
}