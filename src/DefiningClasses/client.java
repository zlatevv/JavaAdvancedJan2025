package DefiningClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class client {
    private static Map<Integer, BankAccount> bankAccounts = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!command.equals("End")){
            String[] tokens = command.split("\\s+");
            switch (tokens[0]){
                case "Create":
                    createAccount();
                    break;
                case "Deposit":
                    depositSum(Integer.parseInt(tokens[1]),
                            Double.parseDouble(tokens[2]));
                    break;
                case "SetInterest":
                    setInterest(Double.parseDouble(tokens[1]));
                    break;
                case "GetInterest":
                    getInterest(Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]));
            }

            command = scanner.nextLine();
        }
    }

    private static void getInterest(int id, int years) {
        if (bankAccounts.containsKey(id)){
            BankAccount bankAccount = bankAccounts.get(id);
            double interest = bankAccount.getInterest(years);
            System.out.printf("%.2f\n", interest);
        }else{
            System.out.println("Account does not exist");
        }
    }

    private static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }

    private static void depositSum(int id, double depositedSum) {
        if (bankAccounts.containsKey(id)){
            BankAccount bankAccount = bankAccounts.get(id);
            bankAccount.deposit(depositedSum);
            System.out.printf("Deposited %.0f to ID%d\n", depositedSum, id);
        }else{
            System.out.println("Account does not exist");
        }
    }

    private static void createAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccounts.put(bankAccount.getId(), bankAccount);
        System.out.printf("Account ID%d created\n", bankAccount.getId());
    }
}
