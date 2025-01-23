class computer{
  
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;

    }

    public int div(int a, int b) {
        return a / b;

    }

    
    public void displayMessage() {
        System.out.println("This is a method without return type");
    }

    public void add2(int a, int b) {
        System.out.println(a + b);
    }
    
    public void sub2(int a, int b) {
        System.out.println(a - b);
    }
    
    public void mul2(int a, int b) {
        System.out.println(a * b);
    }
    
    public void div2(int a, int b) {
        System.out.println(a / b);
    }
    public static void main(String a[]) {
        computer c = new computer();
        System.out.println(c.add(5, 7));
        System.out.println(c.sub(10, 3));
        System.out.println(c.mul(5, 7));
        System.out.println(c.div(10, 2));
        c.displayMessage();//IF WE USE VOID WE CANT RETURN
        c.add2(5, 7);
        c.sub2(10, 3);
        c.mul2(5, 7);
        c.div2(10, 5);
    }
}