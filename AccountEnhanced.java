public class AccountEnhanced {
    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status;
    private Integer pin;

    public AccountEnhanced(int accountNumber, String name, int age, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.name = name;
        
        // Enhancement 1: Age Validation
        if (age < 18) {
            this.age = 18;
        } else {
            this.age = age;
        }

        // Enhancement 2: Account Type Validation
        if (accountType != null && (accountType.equalsIgnoreCase("Savings") || accountType.equalsIgnoreCase("Current"))) {
            if (accountType.equalsIgnoreCase("Savings")) {
                this.accountType = "Savings";
            } else {
                this.accountType = "Current";
            }
        } else {
            this.accountType = "Savings"; // Default to Savings for invalid inputs
        }

        // Enhancement 3: Minimum Balance Rules on Creation
        double minBalance = getMinimumBalance();
        if (initialBalance < minBalance) {
            this.balance = minBalance;
        } else {
            this.balance = initialBalance;
        }

        this.status = "Active";
        this.pin = null;
    }

    private double getMinimumBalance() {
        if ("Current".equals(this.accountType)) {
            return 1000.0;
        }
        return 500.0; // Default Savings
    }

    // Enhancement 5: Account Status Management - deposit
    public boolean deposit(double amount) {
        if ("Inactive".equals(this.status)) {
            return false; // Cannot deposit into inactive account
        }
        if (amount <= 0) {
            return false;
        }
        this.balance += amount;
        return true;
    }

    // Enhancement 4, 5 & 6: withdraw with PIN and Minimum Balance Enforcement
    public boolean withdraw(double amount, int pin) {
        if ("Inactive".equals(this.status)) {
            return false; // Cannot withdraw from inactive account
        }
        if (!verifyPin(pin)) {
            return false; // Invalid PIN
        }
        if (amount <= 0) {
            return false; // Invalid amount
        }
        
        double minBalance = "Current".equals(this.accountType) ? 0.0 : 500.0;
        double newBalance = this.balance - amount;
        if (newBalance < minBalance) {
            return false; // Enforcement: Balance cannot fall below minimum
        }
        
        this.balance = newBalance;
        return true;
    }

    // Enhancement 5: Status management methods
    public boolean closeAccount() {
        if ("Inactive".equals(this.status)) {
            return false; // Already closed
        }
        this.status = "Inactive";
        return true;
    }

    public boolean reopenAccount() {
        if ("Active".equals(this.status)) {
            return false; // Already active
        }
        this.status = "Active";
        return true;
    }

    // Enhancement 6: PIN protection
    public boolean setPin(int pin) {
        // Enforcing 4 digits using mathematical bounds since it is an integer. 
        // This ensures the integer is strictly exactly 4 digits long (1000 to 9999).
        if (pin >= 1000 && pin <= 9999) {
            this.pin = pin;
            return true;
        }
        return false;
    }

    public boolean verifyPin(int pin) {
        if (this.pin == null) {
            return false;
        }
        return this.pin.equals(pin);
    }

    public boolean hasPin() {
        return this.pin != null;
    }

    // Basic Getters and Setters
    public int getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public String getStatus() { return status; }
    
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { 
        if (age < 18) {
            this.age = 18;
        } else {
            this.age = age;
        }
    }
}
