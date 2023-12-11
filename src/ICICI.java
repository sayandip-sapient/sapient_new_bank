import java.util.*;


public class ICICI implements RBI {
    double balance;
    int count=0;
    double roi;
    int year;
    public List<Customer> customers;
    public Map<String, Customer> myHashMap ;




    ICICI (){
        balance=1000.0D;
        roi=5.0D;
        year=3;
        customers = new ArrayList<>();
        myHashMap = new HashMap<>();



    }
    @Override
    public void addInitialamount(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add initial amount you want to add should be more than 1000");
        System.out.print("Enter initial balance: ");
        float balance = scanner.nextFloat();
        customer.balance=balance;
//        this.balance=balance;
    }

    @Override
    public void displayCustomers() {
        System.out.println("Customers in HDFC bank:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    @Override
    public void addCustomer(Customer customer) {
        addInitialamount(customer);
        customers.add(customer);
        myHashMap.put(customer.customerAadhar, customer);
        System.out.println("Customer added to HDFC bank.");
    }
    @Override
    public void deposit(double amount,Customer customer) {
        if (amount >= 0) {
            System.out.println(customer.balance+"hiii");
            customer.balance += amount;
            System.out.println("Deposit successful. " + customer);
        } else {
            System.out.println("Invalid deposit amount. Please enter a non-negative value.");
        }

    }

    @Override
    public void withdraw(double withdrawAmount, Customer customer) {
        count++;
        if(count>3 && (withdrawAmount+((1*withdrawAmount)/100) <= customer.balance-1000) ){
            customer.balance= (float) (customer.balance-withdrawAmount-((1*withdrawAmount)/100));
            System.out.println("Deposit successful. Your new balance is: " +customer.balance);
        }
        else if (withdrawAmount <= customer.balance-1000) {
            customer.balance= (float) (customer.balance-withdrawAmount);
            System.out.println("Deposit successful. Your new balance is: " + customer.balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a non-negative value.");
        }

    }

    @Override
    public void createFixedDeposit(double amount, int durationInYears,double ROI) {
        double interestRateDecimal = ROI / 100.0;

        double maturityAmount = amount * Math.pow(1 + interestRateDecimal, durationInYears);
        System.out.println(maturityAmount);
        System.out.println("ICICI: Fixed Deposit of $" + amount + " for " + durationInYears + " years created.");
    }

    @Override
    public void applyLoan(int loanType, double amount, int years) {
        double rate;
        switch (loanType) {
            case 1: {
                rate = 5;
                break;
            }
            case 2: {
                rate = 3;
                break;
            }
            case 3: {
                rate = 6;
                break;
            }
            case 4: {
                rate = 8;
                break;
            }
            default: {
                rate = roi;
            }
        }
        double prinDeduction = amount / years;
        System.out.println("Interest per year will be as following");
        for (int i = 0; i < years; i++) {
            System.out.println(amount * rate * 0.01);
            amount -= prinDeduction;
        }

    }
}

