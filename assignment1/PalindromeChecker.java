public class PalindromeChecker {
    public static void main(String[] args) {
        String str = "charan";
        int b=str.length();
        String rev="";
        for (int i = b - 1; i >= 0; i--) {
            char k = str.charAt(i);
            rev = k + rev;
        }
        if (str == rev) {
            System.out.println("Palindrome");
        }
        else {
            System.out.println("Not Palindrome");

        }
        
            

        
    }
}
