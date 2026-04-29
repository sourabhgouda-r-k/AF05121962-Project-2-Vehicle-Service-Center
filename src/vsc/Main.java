package vsc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ServiceDAO dao = new ServiceDAO();

        while (true) {

            System.out.println("\n===== Vehicle Service Center =====");
            System.out.println("1. Add Customer");
            System.out.println("2. View Records");
            System.out.println("3. Update Status");
            System.out.println("4. Generate Bill");
            System.out.println("5. Delete Record");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    dao.addCustomer();
                    break;

                case 2:
                    dao.viewRecords();
                    break;

                case 3:
                    dao.updateStatus();
                    break;

                case 4:
                    dao.generateBill();
                    break;

                case 5:
                    dao.deleteRecord();
                    break;

                case 6:
                    System.out.println("Thank You");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}