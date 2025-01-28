import java.util.Scanner;
import java.util.concurrent.*;


public class ConcurrentCalculatorwiththreadcount {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        scanner.close();

        // Create a thread pool with 2 threads to force task switching
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            System.out.println("Starting all tasks...\n");

            // Submit tasks with different execution times
            Future<String> add = executor.submit(() -> add(num1, num2));
            Future<String> sub = executor.submit(() -> subtract(num1, num2));
            Future<String> mul = executor.submit(() -> multiply(num1, num2));
            Future<String> div = executor.submit(() -> divide(num1, num2));
            Future<String> sq1 = executor.submit(() -> square(num1));
            Future<String> sq2 = executor.submit(() -> square(num2));

            // Get results in submission order
            System.out.println("\nResults:");
            System.out.println(add.get());
            System.out.println(sub.get());
            System.out.println(mul.get());
            System.out.println(div.get());
            System.out.println(sq1.get());
            System.out.println(sq2.get());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static String add(int a, int b) throws InterruptedException {
        System.out.println("[Add] STARTED by " + Thread.currentThread().getName());
        Thread.sleep(1500); // Simulate work
        System.out.println("[Add] FINISHED by " + Thread.currentThread().getName());
        return "Addition = " + (a + b);
    }

    private static String subtract(int a, int b) throws InterruptedException {
        System.out.println("[Subtract] STARTED by " + Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("[Subtract] FINISHED by " + Thread.currentThread().getName());
        return "Subtraction = " + (a - b);
    }

    private static String multiply(int a, int b) throws InterruptedException {
        System.out.println("[Multiply] STARTED by " + Thread.currentThread().getName());
        Thread.sleep(2000);
        System.out.println("[Multiply] FINISHED by " + Thread.currentThread().getName());
        return "Multiplication = " + (a * b);
    }

    private static String divide(int a, int b) throws InterruptedException {
        System.out.println("[Divide] STARTED by " + Thread.currentThread().getName());
        Thread.sleep(800);
        System.out.println("[Divide] FINISHED by " + Thread.currentThread().getName());
        return "Division = " + String.format("%.2f", (double) a / b);
    }

    private static String square(int number) throws InterruptedException {
        System.out.println("[Square] STARTED by " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("[Square] FINISHED by " + Thread.currentThread().getName());
        return "Square of " + number + " = " + (number * number);
    }
}