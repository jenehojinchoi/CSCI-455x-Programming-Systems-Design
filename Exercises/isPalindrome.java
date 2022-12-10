public class isPalindrome {
    public static boolean checkIfPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length()-1)) {
            return false;
        } else {
            return checkIfPalindrome(s.substring(1, s.length()-1));
        }
    }

    public static void main(String[] args) {
        String s = args[0];
        if (checkIfPalindrome(s)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not palindrome");
        }
    }
}