import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] foodItems = {
            "Burger",
            "French Fries",
            "Pizza",
            "Spaghetti",
            "Soft Drink"
        };
        double[] prices = {
            80.00,
            50.00,
            120.00,
            90.00,
            40.00
        };
        int totalQuantity = 0;
        double totalAmount = 0.00;

        char orderAgain = 'Y';
        char studentStatus = 'N';
        System.out.println("========================================");
        System.out.println("          SCHOOL CANTEEN MENU");
        System.out.println("========================================");

        for (int i = 0; i < foodItems.length; i++) {
            System.out.printf(
                "%d. %-20s PHP %.2f%n",
                i + 1,
                foodItems[i],
                prices[i]
            );
        }

        System.out.println("========================================");
        System.out.println();
        while (orderAgain == 'Y') {

            System.out.print("Enter item number (1-5): ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity (1-10): ");
            int quantity = input.nextInt();

            System.out.print("Are you a student? (Y/N): ");
            char student = input.next().charAt(0);
            student = Character.toUpperCase(student);
            if (itemNumber < 1 || itemNumber > 5) {

                System.out.println();
                System.out.println("Invalid item number!");
                System.out.println("Please enter a number from 1 to 5.");
                System.out.println("This order will not be included.");
                System.out.println();

                continue;
            }
            if (quantity < 1 || quantity > 10) {

                System.out.println();
                System.out.println("Invalid quantity!");
                System.out.println("Quantity must be between 1 and 10.");
                System.out.println("This order will not be included.");
                System.out.println();

                continue;
            }
            if (student != 'Y' && student != 'N') {

                System.out.println();
                System.out.println("Invalid student status!");
                System.out.println("Please enter Y or N.");
                System.out.println("This order will not be included.");
                System.out.println();

                continue;
            }
            studentStatus = student;
            String selectedItem = foodItems[itemNumber - 1];
            double price = prices[itemNumber - 1];
            double orderAmount = price * quantity;
            totalQuantity = totalQuantity + quantity;
            totalAmount = totalAmount + orderAmount;
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("           ORDER ACCEPTED");
            System.out.println("----------------------------------------");

            System.out.println("Item: " + selectedItem);
            System.out.println("Quantity: " + quantity);
            System.out.printf("Price: PHP %.2f%n", price);
            System.out.printf("Order Amount: PHP %.2f%n", orderAmount);

            System.out.println("----------------------------------------");
            System.out.println();

            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = input.next().charAt(0);

            orderAgain = Character.toUpperCase(orderAgain);
            while (orderAgain != 'Y' && orderAgain != 'N') {

                System.out.println("Invalid choice!");
                System.out.print("Please enter Y or N: ");

                orderAgain = input.next().charAt(0);
                orderAgain = Character.toUpperCase(orderAgain);
            }

            System.out.println();
        }
        double deductionRate;

        if (studentStatus == 'Y' && totalAmount >= 500) {

            deductionRate = 0.15;

        }
        else if (studentStatus == 'Y') {

            deductionRate = 0.10;

        }
        else if (totalAmount >= 500) {

            deductionRate = 0.05;

        }
        else {

            deductionRate = 0.00;
        }
        double totalDeduction = totalAmount * deductionRate;

        double finalAmount = totalAmount - totalDeduction;
        System.out.println("========================================");
        System.out.println("           PURCHASE SUMMARY");
        System.out.println("========================================");

        System.out.println(
            "Total Quantity: " + totalQuantity
        );

        System.out.printf(
            "Total Amount Before Deduction: PHP %.2f%n",
            totalAmount
        );

        System.out.printf(
            "Total Deduction: PHP %.2f%n",
            totalDeduction
        );

        System.out.printf(
            "Final Amount to Pay: PHP %.2f%n",
            finalAmount
        );

        System.out.println("========================================");
        System.out.println("       Thank you for ordering!");
        System.out.println("========================================");

        input.close();
    }
}