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
        RBI depo =new RBI();
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
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


            switch (obj.selectedOperation) {
                case 1:

                    depo.depositMoney();
                    break;
                case 2:
                    // code to be executed if expression matches value2
                    depo.withdrawMoney();
                    break;

                case 3:


                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                        System.out.print("Enter the amount to fd: ");
                        String input = reader.readLine();
                        float fdAmount = Float.parseFloat(input);
                        depo.openFD(fdAmount,6.0F,3);
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Error reading input. Please enter a valid number.");
                    }


                    break ;
                // more cases as needed
                default:
                    break temp;
                    // code to be executed if expression doesn't match any case
            }

        }

    }
}