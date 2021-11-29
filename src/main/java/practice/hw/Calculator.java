package practice.hw;


import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String s1 = getInput("Enter num1: ");
        String s2 = getInput("Enter num2: ");
        String symbol = getInput("Please choose between + - * /: ");
        double result = 0;
        try {
            switch (symbol) {
                case "+":
                    result = addition(s1, s2);
                    break;
                case "-":
                    result = subtraction(s1, s2);
                    break;
                case "*":
                    result = multyplyng(s1, s2);
                    break;
                case "/":
                    result = division(s1, s2);
                    break;
                default:
                    System.out.println("Something went with wrong");
                    break;
            }
            System.out.println("The result is: " + result);
        } catch (Exception e) {
            System.out.println("Number formatting exception " + e.getMessage());
        }
    }

    static String getInput(String prompt) {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }

    public static double addition(String st1, String st2) {
        double d1 = Double.parseDouble(st1);
        double d2 = Double.parseDouble(st2);
        return d1 + d2;
    }

    static double subtraction(String st1, String st2) {
        double d1 = Double.parseDouble(st1);
        double d2 = Double.parseDouble(st2);
        return d1 - d2;
    }

    static double multyplyng(String st1, String st2) {
        double d1 = Double.parseDouble(st1);
        double d2 = Double.parseDouble(st2);
        return d1 * d2;
    }

    static double division(String st1, String st2) {
        double d1 = Double.parseDouble(st1);
        double d2 = Double.parseDouble(st2);
        return d1 / d2;
    }
}