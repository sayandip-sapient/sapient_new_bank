import com.sun.source.tree.TryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// RBI.java
public interface RBI {

//    double balance=1000.0D;
    void addInitialamount(Customer customer);
void displayCustomers();
    void addCustomer(Customer customer);

    void deposit(double amount, Customer customer);

    void withdraw(double amount,Customer customer);

    void createFixedDeposit(double amount, int durationInYears,double roi);

    void applyLoan(int  loanType, double amount, int years);
}

// ICICI.java


// SBI.java
// ... similar changes ...

// HDFC.java
// ... similar changes ...

// Axis.java
// ... similar changes ...













//public class RBI {
//   double balance;
//   int count;
//
//    public RBI() {
//        balance = 1000.0D;
//    }
//    public void depositMoney() {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            System.out.print("Enter the amount to deposit: ");
//            String input = reader.readLine();
//            double depositAmount = Double.parseDouble(input);
//
//
//        } catch (IOException | NumberFormatException e) {
//            System.out.println("Error reading input. Please enter a valid number.");
//        }
//    }
//
//    public void withdrawMoney(){
//        count++;
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            System.out.print("Enter the amount to withdraw: ");
//            String input = reader.readLine();
//           double withdrawAmount = Double.parseDouble(input);
//
//            // Validate if the deposit amount is non-negative
//
//            if(count>3 && (withdrawAmount+((1*withdrawAmount)/100) <= balance-1000) ){
//                balance=balance-withdrawAmount-((1*withdrawAmount)/100);
//                System.out.println("Deposit successful. Your new balance is: " + balance);
//            }
//           else if (withdrawAmount <= balance-1000) {
//               balance=balance-withdrawAmount;
//                System.out.println("Deposit successful. Your new balance is: " + balance);
//            } else {
//                System.out.println("Invalid deposit amount. Please enter a non-negative value.");
//            }
//        } catch (IOException | NumberFormatException e) {
//            System.out.println("Error reading input. Please enter a valid number.");
//        }
//
//
//    }
//    public void openFD(float amount, float ROI, int years) {
//        double interestRateDecimal = ROI / 100.0;
//
//        // Calculate maturity amount using the compound interest formula
//        double maturityAmount = amount * Math.pow(1 + interestRateDecimal, years);
//        System.out.println(maturityAmount);
//    }
//    public void applyLoan(String loanType, float amount, float ROI, int years) {
//
//    }
//    public void applyCreditCard() {}
//    public float getBalance() {
//        return 0.0f;
//    }
//}
