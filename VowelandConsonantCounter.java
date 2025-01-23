public class VowelandConsonantCounter {
    public static void main(String[] args) {
        String a = "charan";
        int k = a.length();
        int vowels = 0;
        int cons = 0;
        for (int i = 0; i < k; i++) {
            char ch = a.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowels++;
                default:
                    cons++;
                }
            }

    }
    System.out.println("vowels=" + vowels + "\ncons =" + cons);
    }
    
    
}
