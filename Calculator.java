package org.example;
//import jdk.internal.icu.impl.CharacterIteratorWrapper;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

//import static org.junit.Assert.*;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int firstOperand = getOperand();
        int secondOperand = getOperand();
        char operator = getOperator();
        int result = calculation(firstOperand, secondOperand, operator);
        System.out.println("Результат операции: " + result);
    }
    public static char getOperator() {
        System.out.println("Введите операцию: ");
        char operation = scanner.next().charAt(0);
        return operation;
    }

    public static int getOperand() {
        System.out.println("Введите число: ");
        int operand;

        if(scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте ещё раз!!!");
        } if(scanner.hasNextInt()) {
            scanner.next();
            operand = getOperand();
        } else {
            throw new IllegalStateException("Ошибка ввода данных");
        }
        return operand;
    }
    public static int calculation(int firstOperand, int
            secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if(firstOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected operator");
        }
        return result;
    }

    public double calculateDiscount(double amount, double discount) {
        if(amount < 0 || discount < 0 || discount > 100) {
            throw new ArithmeticException("Invalid arguments");
        }
        double amountDiscount = amount * discount / 100;
        return  amount - amountDiscount;
    }

    public static double computeAreaCircle(double radius) {
        return Math.PI * Math.pow(radius,2);
            }
}

