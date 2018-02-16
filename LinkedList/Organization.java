/**
 * Created by Ezgi on 14.10.2017.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Organization {

    public static void main(String[] args) {
        LinkedList bankQueue = new LinkedList();
        System.out.println("-- -- -- Bank System -- -- --");
        while (true) {
            System.out.println("Current Queue: " + bankQueue.printQueue());
            System.out.println("1- Add a new customer to the queue\n" +
                    "2- Process a customer");
            int choice = 0;
            do { // To check input.
                try {
                    Scanner scan = new Scanner(System.in);
                    choice = scan.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println("Your input is invalid, please enter 1 or 2");
                }

            }
            while (choice != 1 && choice != 2);

            switch (choice) {
                case 1: // Add customer to queue.
                    boolean again = true;
                    int custPri = 0;
                    while (again) {
                        try {
                            System.out.print("Please enter the type of customer : ");
                            Scanner scan1 = new Scanner(System.in);
                            custPri = scan1.nextInt();
                            if (!(custPri > -1 && custPri < 4)) {
                                System.out.println("Please enter a number between 0-3");
                            } else
                                again = false;
                        } catch (InputMismatchException e) {
                            System.out.println("Your input is invalid, please enter a number between 0-3");
                        }

                    }

                    System.out.print("Name of the customer: ");
                    Scanner scan1 = new Scanner(System.in);
                    String custName = scan1.nextLine();
                    bankQueue.add(custName, custPri);
                    System.out.println();
                    break;
                case 2: // Process a customer.
                    Node pCustomer = bankQueue.processing();
                    if (pCustomer != null)
                        System.out.println(pCustomer.getName() + " is processed-" + pCustomer.getPriority());
                    break;

            }

        }
    }

}
