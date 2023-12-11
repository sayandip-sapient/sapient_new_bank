import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }

    int selectedBank, selectedOperation, selected;
    public  static void callfunc(Main obj,RBI temp, Customer customer){
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
                        double amount = Double.parseDouble(input);
//                    temp.deposit(amount);
                   temp.deposit(amount,customer);

                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Error reading input. Please enter a valid number.");
                    }

                    break;
                case 2:
                    try {
                        System.out.print("Enter the amount to withdraw: ");
                        String input = reader.readLine();
                        double withdrawAmount = Double.parseDouble(input);
                        temp.withdraw(withdrawAmount, customer);
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Error reading input. Please enter a valid number.");
                    }

                    break;

                case 3:


                    try {

                        System.out.print("Enter the amount to fd: ");
                        String input = reader.readLine();
                        float fdAmount = Float.parseFloat(input);
                        temp.createFixedDeposit(fdAmount, 2, 6.0);
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Error reading input. Please enter a valid number.");
                    }


                    break;
                // more cases as needed
                case 4:
                    System.out.println("Select your choi1ce\n1. Home\n2. Education\n3. Personal\n4. Car");
                    try {
                        obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Customer Selected " + obj.selectedOperation);
                    try {
                        System.out.print("Enter the amount for loan: ");
                        String input = reader.readLine();
                        double loanAmount = Double.parseDouble(input);
                        temp.applyLoan(obj.selectedOperation, loanAmount, 4);
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Error reading input. Please enter a valid number.");
                    }
                    break;

                default:
                    break temp;
                // code to be executed if expression doesn't match any case
            }
        }


    }


    public static Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String customerAddress = scanner.nextLine();

        System.out.print("Enter customer gender: ");
        String customerGender = scanner.nextLine();

        System.out.print("Enter customer Aadhar number: ");
        String customerAadhar = scanner.nextLine();

        System.out.print("Enter customer phone number: ");
        String customerPhone = scanner.nextLine();

        // Create and return a new Customer object using the provided input
        return new Customer(customerName, customerEmail, customerAddress, customerGender, customerAadhar, customerPhone,0.0F);

    }
    public static void main(String[] args) {
        Main obj = new Main();
        RBI temp=null;
        ICICI tempicici=new ICICI();;
        HDFC temphdfc= new HDFC();
        temp: while(true) {
            System.out.println("Welcome to IBS\nPlease select \n1. open account\n2. display account\n3. display account for particulars\n4. HDFC Customers\n5. IDFC Customers");
            try {
                obj.selected = Integer.parseInt(obj.buff.readLine());


                switch (obj.selected) {
                    case 1:
                        Customer customer = createCustomer();
                        System.out.println("Customer created: " + customer);
                        System.out.println("Please select your bank in which you want to open your account\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

                        try {
                            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
                            switch (obj.selectedBank) {
                                case 1:
                                    temp = tempicici;
//
                                    tempicici.addCustomer(customer);
                                   tempicici.displayCustomers();
                                    Main.callfunc(obj,tempicici,customer);
                                    break;
                                case 2:
                                    temp = temphdfc;
                                    temphdfc.addCustomer(customer);
                                    temphdfc.displayCustomers();
                                    Main.callfunc(obj,temphdfc,customer);
                                    break;

                                default:
                                    System.out.println("wrong bank");

                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Customer Selected " + obj.selectedBank);

                        break;
                    case 2:
                       System.out.println("Customers for HDFC");
                        for (Customer cus : temphdfc.customers) {
                            System.out.println(cus);
                        }
                        System.out.println("Customers for ICICI");
                        for (Customer cus : tempicici.customers) {
                            System.out.println(cus);
                        }
                        // REPEAT THIS FOR OTHER BANK AS WELL


                        break;
                    case 3:
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Enter customer Aadhar number: ");
                        String customerAadhar = scanner.nextLine();

                        Customer var=temphdfc.myHashMap.get(customerAadhar);
                        System.out.println("customer:-: " + var);
                        var.balance=var.balance+1;
                        System.out.println(var);
                        break;
                    case 4:
                        break;
                    case 5:
                        break;


                    default:
                        break temp;


                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Customer Selected " + obj.selectedBank);
        }









//
//        temp: while(true) {
//        Customer customer = createCustomer();
//        System.out.println("Customer created: " + customer);
//
//
//        System.out.println("Please select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");
//
//        try {
//            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
//
//
//            switch (obj.selectedBank){
//                case 1:
//                   temp=tempicici;
//                   temp.addCustomer(customer);
//                    temp.displayCustomers();
//                    break;
//                case 2:
//                   temp=temphdfc;
//                    temphdfc.addCustomer(customer);
//                    temphdfc.displayCustomers();
//                    break;
//
//                default:
//                   System.out.println("wrong bank");
//
//            }
//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Customer Selected " + obj.selectedBank);
//
//            System.out.println("Select your choi1ce\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply CC");
//            try {
//                obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Customer Selected " + obj.selectedOperation);
//
//           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            switch (obj.selectedOperation) {
//                case 1:
//
//
//        try {
//            System.out.print("Enter the amount to deposit: ");
//            String input = reader.readLine();
//            double amount= Double.parseDouble(input);
//            temp.deposit(amount);
//
//        } catch (IOException | NumberFormatException e) {
//            System.out.println("Error reading input. Please enter a valid number.");
//        }
//
//                    break;
//                case 2:
//                    try{
//                        System.out.print("Enter the amount to withdraw: ");
//                        String input = reader.readLine();
//                        double withdrawAmount = Double.parseDouble(input);
//                        temp.withdraw(withdrawAmount);
//                    }catch (IOException | NumberFormatException e){
//                        System.out.println("Error reading input. Please enter a valid number.");
//                    }
//
//                    break;
//
//                case 3:
//
//
//                    try {
//
//                        System.out.print("Enter the amount to fd: ");
//                        String input = reader.readLine();
//                        float fdAmount = Float.parseFloat(input);
//                        temp.createFixedDeposit(fdAmount,2,6.0);
//                    } catch (IOException | NumberFormatException e) {
//                        System.out.println("Error reading input. Please enter a valid number.");
//                    }
//
//
//                    break ;
//                // more cases as needed
//                case 4:
//                    System.out.println("Select your choi1ce\n1. Home\n2. Education\n3. Personal\n4. Car");
//                    try {
//                        obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("Customer Selected " + obj.selectedOperation);
//                    try{
//                        System.out.print("Enter the amount for loan: ");
//                        String input = reader.readLine();
//                        double loanAmount = Double.parseDouble(input);
//                        temp.applyLoan(obj.selectedOperation,loanAmount,4);
//                    }catch (IOException | NumberFormatException e){
//                        System.out.println("Error reading input. Please enter a valid number.");
//                    }
//                    break;
//
//                default:
//                    break temp;
//                    // code to be executed if expression doesn't match any case
//            }
//
//        }

    }
}