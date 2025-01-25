package DefiningClasses;

public class BankAccount {
    private static int counter = 0;
    private static double interest = 0.02;

    private int id;
    private double balance;
    public BankAccount(){
        counter++;
        this.id += counter;
    }
    public static void setInterestRate(double interestRate){
        BankAccount.interest = interestRate;
    }
    public double getInterest(int years){
        return interest * years * this.balance;
    }
    public void deposit(double amount){
        balance += amount;
    }

    public int getId() {
        return id;
    }
}
