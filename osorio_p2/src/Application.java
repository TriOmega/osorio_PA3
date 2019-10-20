public class Application {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount();//calculateMonthlyInterest(2000.00);
        SavingsAccount saver2 = new SavingsAccount();

        System.out.println("Beginning tests.");

        SavingsAccount.modifyInterestRate(0.04);
        System.out.println("Test 1 Returned:");
        System.out.printf("\t$ %.2f\n", saver1.calculateMonthlyInterest(2000.00, 12));
        System.out.printf("\t$ %.2f\n", saver2.calculateMonthlyInterest(3000.00, 12));

        System.out.println("Test 2 Returned:");
        SavingsAccount.modifyInterestRate(0.05);
        System.out.printf("\t$ %.2f\n", saver1.calculateMonthlyInterest(2000.00, 12));
        System.out.printf("\t$ %.2f\n", saver2.calculateMonthlyInterest(3000.00, 12));

        System.out.println("Tests complete.");
    }
}
