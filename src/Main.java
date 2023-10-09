import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static double[] carStats = new double[3];

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        GetInput("How much gallons does your tank hold?", 0);
        GetInput("What is your fuel effeciency in miles per gallon?", 1);
        GetInput("What is the price per gallon?", 2);

        // (distance / mpg) * fuel cost
        double costPerHundred = (100 / carStats[1]) * carStats[2];
        System.out.printf("Cost per 100 miles in $: %.02f", costPerHundred);
    }

    private static void GetInput(String question, int answerIndex) {
        Scanner scanner = new Scanner(System.in);
        boolean verify = false;

        do {
            System.out.println(question);
            if (scanner.hasNextDouble()) {
                carStats[answerIndex] = scanner.nextDouble();
                if (carStats[answerIndex] <= 0) {
                    System.out.println("Please enter a valid input, that number isn't possible.");
                } else {
                    verify = true;
                }
            } else {
                System.out.println("Please enter a valid input, use numbers only.");
            }
            scanner.nextLine();
        } while (!verify);
    }
}