import java.util.concurrent.*;
import java.util.Scanner;


public class ConcurrentCalculator {

    public static void main(String[] args) {
        // Input numbers
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        scanner.close();

        // Create thread pool
        ExecutorService executor = Executors.newFixedThreadPool(4);
        try {
            // Submit all calculation tasks
            Future<String> addition = executor.submit(() -> add(num1, num2));
            Future<String> subtraction = executor.submit(() -> subtract(num1, num2));
            Future<String> multiplication = executor.submit(() -> multiply(num1, num2));
            Future<String> division = executor.submit(() -> divide(num1, num2));
            Future<String> square1 = executor.submit(() -> square(num1));
            Future<String> square2 = executor.submit(() -> square(num2));

            // Get and print results
            System.out.println("Calculator Results:");
            System.out.println(addition.get());
            System.out.println(subtraction.get());
            System.out.println(multiplication.get());
            System.out.println(division.get());
            System.out.println(square1.get());
            System.out.println(square2.get());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    // Arithmetic operations with simplified output
    private static String add(int a, int b) {
        return "Addition = " + (a + b);
    }

    private static String subtract(int a, int b) {
        return "Subtraction = " + (a - b);
    }

    private static String multiply(int a, int b) {
        return "Multiplication = " + (a * b);
    }

    private static String divide(int a, int b) {
        try {
            double result = (double) a / b;
            return "Division = " + String.format("%.2f", result);
        } catch (ArithmeticException e) {
            return "Division Error: Cannot divide by zero!";
        }
    }

    private static String square(int number) {
        return "Square of " + number + " = " + (number * number);
    }
}