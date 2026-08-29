public class TestAccount {
    public static void main(String[] args) {
        // 1. Create two accounts
        Account account1 = new Account(1001, "Alice Smith", 28, 1000.0, "Savings");
        Account account2 = new Account(1002, "Bob Jones", 35, 500.0, "Current");

        System.out.println("--- Initial Account States ---");
        displayAccountInfo(account1);
        displayAccountInfo(account2);

        // 2. Test deposit functionality (including invalid deposit)
        System.out.println("\n--- Testing Deposit on Account 1 ---");
        double validDepositAmount = 500.0;
        if (account1.deposit(validDepositAmount)) {
            System.out.println("Successfully deposited $" + validDepositAmount);
        } else {
            System.out.println("Failed to deposit $" + validDepositAmount);
        }

        double invalidDepositAmount = -50.0;
        if (account1.deposit(invalidDepositAmount)) {
            System.out.println("Successfully deposited $" + invalidDepositAmount);
        } else {
            System.out.println("Failed to deposit $" + invalidDepositAmount + " (Invalid amount)");
        }

        // 3. Test withdrawal functionality (including insufficient balance)
        System.out.println("\n--- Testing Withdrawal on Account 2 ---");
        double validWithdrawalAmount = 200.0;
        if (account2.withdraw(validWithdrawalAmount)) {
            System.out.println("Successfully withdrew $" + validWithdrawalAmount);
        } else {
            System.out.println("Failed to withdraw $" + validWithdrawalAmount);
        }

        double invalidWithdrawalAmount = 1000.0;
        if (account2.withdraw(invalidWithdrawalAmount)) {
            System.out.println("Successfully withdrew $" + invalidWithdrawalAmount);
        } else {
            System.out.println("Failed to withdraw $" + invalidWithdrawalAmount + " (Insufficient balance or invalid amount)");
        }

        // Display final states
        System.out.println("\n--- Final Account States ---");
        displayAccountInfo(account1);
        displayAccountInfo(account2);
    }

    // 4. Displays all account information (formatting done in test code)
    private static void displayAccountInfo(Account account) {
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Name: " + account.getName());
        System.out.println("Age: " + account.getAge());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Status: " + account.getStatus());
        System.out.printf("Balance: $%.2f%n", account.getBalance());
        System.out.println("---------------------------");
    }
}
