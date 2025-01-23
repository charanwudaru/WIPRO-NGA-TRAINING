public class staticandwithoutstatic {
    public static void add(int a, int b) {
        System.out.println(a + b);
    }

    public static void sub(int a, int b) {
        System.out.println(a - b);
    }

    public static void mul(int a, int b) {
        System.out.println(a*b); 

    }

    public static void div(int a, int b) {
        System.out.println(a / b);

    }

    public int add2(int a, int b) {
        return a + b;
    }

    public int sub2(int a, int b) {
        return a - b;
    }

    public int mul2(int a, int b) {
        return a * b;

    }

    public int div2(int a, int b) {
        return a / b;

    }

    public static void main(String[] args) {
        staticandwithoutstatic.add(1, 2);
        staticandwithoutstatic.sub(3, 4);
        staticandwithoutstatic.mul(5, 6);
        staticandwithoutstatic.div(7, 8);
        staticandwithoutstatic c = new staticandwithoutstatic();
        System.out.println(c.add2(5, 7));
        System.out.println(c.sub2(10, 3));
        System.out.println(c.mul2(5, 7));
        System.out.println(c.div2(10, 2));
        
    }
}
