public class SavingsAccount {
    private static double annualInterestRate;

    private double savingsBalance;

    public double calculateMonthlyInterest(double testInitialBalance, int testNumOfMonths) {
        int i;
        double monthlyInterest;

        savingsBalance = testInitialBalance;
        for(i = 0; i < testNumOfMonths; i++) {
            monthlyInterest = (savingsBalance * (annualInterestRate / 12.0));
            savingsBalance += monthlyInterest;
        }
        return savingsBalance;
    }

    public static void modifyInterestRate(double testInterestRate) {
        annualInterestRate = testInterestRate;
    }
}
