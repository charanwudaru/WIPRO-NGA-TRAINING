public class encapsulationage {
    private int age;

    public encapsulationage(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age check git branch.");
        }
    }

    public void check() {
        if (age >= 18) {
            System.out.println("Eligible to vote.");
        } else {
            System.out.println("Not eligible to vote.");
        }
    }

    public static void main(String[] args) {
        encapsulationage ob1 = new encapsulationage(18);
        ob1.check();
        System.out.println(ob1.getAge());


        encapsulationage ob2 = new encapsulationage(19);
        ob2.check();
        System.out.println(ob2.getAge());
    }
}