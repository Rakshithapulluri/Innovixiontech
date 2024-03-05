import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
//To take user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Command Line Calculator!");
//take first input value from user
        System.out.print("Enter first number: ");
        float num1=scanner.nextFloat();
//input operator
        System.out.print("Enter operator (+, -, *, /, %): ");
        char operator = scanner.next().charAt(0);
//take second input value from user
        System.out.print("Enter second number: ");
        float num2 = scanner.nextFloat();

        float result = 0;
//perform calculation based on the operator
        switch (operator) {
            case '+':
                result = num1 + num2;
//display result if operator is '+'
                System.out.println("Your answer is:"+result);
                break;
            case '-':
                result = num1 - num2;
//display result if operator is '-'
		System.out.println("Your answer is:"+result);
                break;
            case '*':
                result = num1 * num2;
//display result if operator is '*'
		System.out.println("Your answer is:"+result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
//display result if operator is '/'		   System.out.println("Your answer is:"+result);
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                    return;
                }
                break;
            case '%':
                if (num2 != 0) {
                    result = num1 % num2;
//display result if operator is '%'		   System.out.println("Your answer is:"+result);
                } else {
                    System.out.println("Error! Modulo by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.println("Error! Invalid operator.");
                return;
        }

    }
}
