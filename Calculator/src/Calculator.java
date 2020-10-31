import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        // this input object allows us to take user input in the console
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        double number1 = input.nextDouble();

        System.out.println("Enter the second number: ");
        double number2 = input.nextDouble();

        // print the numbers out to make sure they are being saved properly
        System.out.println("The first number is " + number1);
        System.out.println("The second number is " + number2);

        int choice;
        do {
            System.out.println("Enter 1 for addition, 2 for subtraction, 3 for multiplication, or 4 for division.");
            choice = input.nextInt();
            if(choice == 1) {
                System.out.println(add(number1, number2));
            } else if (choice == 2) {
                System.out.println(subtract(number1,number2));
            } else if (choice == 3) {
                System.out.println(multiply(number1, number2));
            } else if (choice == 4) {
                System.out.println(divide(number1, number2));
            }
        } while (choice < 1 || choice > 4); // this is so if the user enters an invalid number, they are prompted again
    }

    public static double add(double num1, double num2) {
        double sum = num1 + num2;
        return sum;
    }

    public static double subtract(double num1, double num2) {
        double difference = num1 - num2;
        return difference;
    }

    public static double multiply(double num1, double num2) {
        double product = num1 * num2;
        return product;
    }

    public static double divide(double num1, double num2) {
        double quotient = num1 / num2;
        return quotient;
    }
}
