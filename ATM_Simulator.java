import java.util.Scanner;

public class ATMSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 10000.00; // Initial balance
        int pin = 1234;
        int attempts = 0;

        System.out.println("💳 Welcome to Simple ATM Simulator");

        // PIN verification
        while (attempts < 3) {
            System.out.print("Enter your 4-digit PIN: ");
            int enteredPin = sc.nextInt();
            if (enteredPin == pin) {
                System.out.println("✅ Access granted!\n");
                break;
            } else {
                attempts++;
                System.out.println("❌ Incorrect PIN. Attempts left: " + (3 - attempts));
            }
            if (attempts == 3) {
                System.out.println("🚫 Too many wrong attempts. Card blocked!");
                sc.close();
                return;
            }
        }

        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("💰 Your balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double deposit = sc.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("✅ Deposited ₹" + deposit + " successfully!");
                    } else {
                        System.out.println("❌ Invalid deposit amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdraw = sc.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("✅ Withdrawn ₹" + withdraw + " successfully!");
                    } else if (withdraw > balance) {
                        System.out.println("⚠️ Insufficient balance!");
                    } else {
                        System.out.println("❌ Invalid withdrawal amount!");
                    }
                    break;

                case 4:
                    System.out.println("👋 Thank you for using ATM Simulator!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again!");
            }
        } while (choice != 4);

        sc.close();
    }
}
