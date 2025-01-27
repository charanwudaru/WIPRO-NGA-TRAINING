import java.util.Arrays;

public class AnagramChecker {
    public static void main(String[] args) {
        String str1 = "charan";
        String str2 = "narkc";
        if (str1.length() == str2.length()) {
            char[] check1 = str1.toCharArray();
            char[] check2 = str2.toCharArray();
            Arrays.sort(check1);
            Arrays.sort(check2);
            if (Arrays.equals(check1, check2) == true) {
                System.out.println("they are Anagram");
            } else {
                System.out.println("they are not Anagram");
            }
        }
        else {
            System.out.println("they are not a Anagram ");
        }
    }


    
}