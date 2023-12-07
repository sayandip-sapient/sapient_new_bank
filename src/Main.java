import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }

    int selectedBank, selectedOperation;
    public static void main(String[] args) {
        Main obj = new Main();
//        RBI icici =new ICICI();
//        RBI  =new ICICI();
//        RBI depo =new ICICI();
//        RBI depo =new ICICI();
        RBI temp=null;

        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
//            RBI req=new obj.selectedBank;

            switch (obj.selectedBank){
                case 1:
                    temp = new ICICI();
                    break;
                case 2:
                    temp = new HDFC();
                    break;

                default:
                   System.out.println("wrong bank");

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedBank);
       temp: while(true) {
            System.out.println("Select your choi1ce\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply CC");
            try {
                obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Customer Selected " + obj.selectedOperation);

           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            switch (obj.selectedOperation) {
                case 1:


        try {
            System.out.print("Enter the amount to deposit: ");
            String input = reader.readLine();
            double amount= Double.parseDouble(input);
            temp.deposit(amount);

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading input. Please enter a valid number.");
        }

                    break;
                case 2:
                    try{
                        System.out.print("Enter the amount to withdraw: ");
                        String input = reader.readLine();
                        double withdrawAmount = Double.parseDouble(input);
                        temp.withdraw(withdrawAmount);
                    }catch (IOException | NumberFormatException e){
                        System.out.println("Error reading input. Please enter a valid number.");
                    }

                    break;

                case 3:


                    try {

                        System.out.print("Enter the amount to fd: ");
                        String input = reader.readLine();
                        float fdAmount = Float.parseFloat(input);
                        temp.createFixedDeposit(fdAmount,2,6.0);
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Error reading input. Please enter a valid number.");
                    }


                    break ;
                // more cases as needed
                case 4:
                    System.out.println("Select your choi1ce\n1. Home\n2. Education\n3. Personal\n4. Car");
                    try {
                        obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Customer Selected " + obj.selectedOperation);
                    try{
                        System.out.print("Enter the amount for loan: ");
                        String input = reader.readLine();
                        double loanAmount = Double.parseDouble(input);
                        temp.applyLoan(obj.selectedOperation,loanAmount,4);
                    }catch (IOException | NumberFormatException e){
                        System.out.println("Error reading input. Please enter a valid number.");
                    }
                    break;

                default:
                    break temp;
                    // code to be executed if expression doesn't match any case
            }

        }

    }
}