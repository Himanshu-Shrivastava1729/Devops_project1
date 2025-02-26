package org.example;

import java.util.Scanner;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            if (choice == 5) break;
            handleChoice(choice, scanner);
        }
        scanner.close();
    }

    // Extracted methods for operations
    public static double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Square root of negative number is not real");
        }
        return Math.sqrt(x);
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial of negative number is undefined");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double naturalLogarithm(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Logarithm undefined for non-positive numbers");
        }
        return Math.log(x);
    }

    public static double powerFunction(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Helper methods for UI
    private static void printMenu() {
        System.out.println("\n--- Scientific Calculator ---");
        System.out.println("1. Square root (√x)");
        System.out.println("2. Factorial (x!)");
        System.out.println("3. Natural Logarithm (ln(x))");
        System.out.println("4. Power (x^b)");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void handleChoice(int choice, Scanner scanner) {
        try {
            switch (choice) {
                case 1 -> handleSquareRoot(scanner);
                case 2 -> handleFactorial(scanner);
                case 3 -> handleLogarithm(scanner);
                case 4 -> handlePower(scanner);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleSquareRoot(Scanner scanner) {
        System.out.print("Enter number: ");
        double x = scanner.nextDouble();
        System.out.println("Result: " + squareRoot(x));
    }

    private static void handleFactorial(Scanner scanner) {
        System.out.print("Enter number: ");
        int n = scanner.nextInt();
        System.out.println("Result: " + factorial(n));
    }

    private static void handleLogarithm(Scanner scanner) {
        System.out.print("Enter number: ");
        double x = scanner.nextDouble();
        System.out.println("Result: " + naturalLogarithm(x));
    }

    private static void handlePower(Scanner scanner) {
        System.out.print("Enter base: ");
        double base = scanner.nextDouble();
        System.out.print("Enter exponent: ");
        double exponent = scanner.nextDouble();
        System.out.println("Result: " + powerFunction(base, exponent));
    }
}