public class TestAccountEnhanced {
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("ENHANCED ACCOUNT TEST (BOOLEAN RETURNS)");
        System.out.println("============================================================");
        System.out.println();

        // >>> Test 1: Valid Account Creation
        System.out.println(">>> Test 1: Valid Account Creation");
        AccountEnhanced account1 = new AccountEnhanced(1001, "John Doe", 25, 1000.0, "Savings");
        printAccount(account1);

        // >>> Test 2: Invalid Age (under 18)
        System.out.println(">>> Test 2: Invalid Age (under 18)");
        System.out.println("Creating account with age 16");
        AccountEnhanced account2 = new AccountEnhanced(1002, "Young Kid", 16, 500.0, "Savings");
        System.out.println("Age auto-corrected to: " + account2.getAge());
        printAccount(account2);

        // >>> Test 3: Invalid Account Type
        System.out.println(">>> Test 3: Invalid Account Type");
        System.out.println("Creating account with type \"Invalid\"");
        AccountEnhanced account3 = new AccountEnhanced(1003, "Test User", 25, 500.0, "Invalid");
        System.out.println("Account type defaulted to: " + account3.getAccountType());
        printAccount(account3);

        // >>> Test 4: Minimum Balance Enforcement on Creation
        System.out.println(">>> Test 4: Minimum Balance Enforcement on Creation");
        System.out.println("Creating Savings account with ₹300 (below minimum)");
        AccountEnhanced account4 = new AccountEnhanced(1004, "Bob Wilson", 25, 300.0, "Savings");
        System.out.println("Balance auto-corrected to minimum: ₹" + account4.getBalance());
        printAccount(account4);

        // >>> Test 5: Withdrawal with Minimum Balance
        System.out.println(">>> Test 5: Withdrawal with Minimum Balance");
        AccountEnhanced account5 = new AccountEnhanced(1005, "Alice Brown", 30, 1000.0, "Current");
        account5.setPin(1234); // Set PIN so PIN: Yes is shown
        System.out.print("Initial: ");
        printAccount(account5);
        System.out.print("Withdrawing ₹200.0: ");
        if (account5.withdraw(200.0, 1234)) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILED");
        }
        System.out.printf("New balance: ₹%.1f%n", account5.getBalance());
        System.out.print("After withdrawal: ");
        printAccount(account5);
        System.out.print("Withdrawing ₹900.0 (would leave ₹-100): ");
        if (account5.withdraw(900.0, 1234)) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILED (Minimum balance violation)");
        }
        System.out.printf("Current balance: ₹%.1f%n", account5.getBalance());

        // >>> Test 6: Account Status Management
        System.out.println(">>> Test 6: Account Status Management");
        AccountEnhanced account6 = new AccountEnhanced(1006, "Charlie Green", 35, 2000.0, "Savings");
        System.out.print("Initial: ");
        printAccount(account6);
        System.out.print("Closing account: ");
        if (account6.closeAccount()) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILED");
        }
        System.out.print("After close: ");
        printAccount(account6);
        System.out.println();
        System.out.print("Depositing ₹500.0 to closed account: ");
        if (account6.deposit(500.0)) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILED (Account inactive)");
        }
        System.out.print("Reopening account: ");
        if (account6.reopenAccount()) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILED");
        }
        System.out.print("After reopen: ");
        printAccount(account6);

        // >>> Test 7: PIN Protection
        System.out.println(">>> Test 7: PIN Protection");
        AccountEnhanced account7 = new AccountEnhanced(1007, "Diana Prince", 28, 1500.0, "Savings");
        System.out.print("Setting PIN 1234: ");
        if (account7.setPin(1234)) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILED");
        }
        System.out.print("Withdrawing ₹200.0 with correct PIN (1234): ");
        if (account7.withdraw(200.0, 1234)) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILED");
        }
        System.out.printf("New balance: ₹%.1f%n", account7.getBalance());
        System.out.print("Withdrawing ₹100.0 with incorrect PIN (9999): ");
        if (account7.withdraw(100.0, 9999)) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILED (Incorrect PIN)");
        }
        System.out.print("Withdrawing ₹100.0 with PIN not set: ");
        if (account6.withdraw(100.0, 1234)) {
            System.out.println("SUCCESS");
        } else {
            if (!account6.hasPin()) {
                System.out.println("FAILED (PIN not set)");
            } else {
                System.out.println("FAILED (Incorrect PIN)");
            }
        }

        // >>> Test 8: All Accounts Summary
        System.out.println(">>> Test 8: All Accounts Summary");
        printAccount(account1);
        printAccount(account2);
        printAccount(account3);
        printAccount(account4);
        printAccount(account5);
        printAccount(account6);
        printAccount(account7);

        System.out.println("============================================================");
        System.out.println("ENHANCED TEST COMPLETED!");
        System.out.println("============================================================");
    }

    private static void printAccount(AccountEnhanced acc) {
        String pinStatus = acc.hasPin() ? "Yes" : "No";
        System.out.printf("Account #%d | %s (%d yrs) | %s | ₹%.1f | %s | PIN: %s%n",
                acc.getAccountNumber(),
                acc.getName(),
                acc.getAge(),
                acc.getAccountType(),
                acc.getBalance(),
                acc.getStatus(),
                pinStatus
        );
    }
}
