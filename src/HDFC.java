public class HDFC implements RBI {
    double balance;
    int count=0;
    double roi;
    int year;



    HDFC (){
        balance=1000.0D;
        roi=5.0D;
        year=3;

    }

    @Override
    public void deposit(double amount) {
        if (amount >= 0) {
            System.out.println(balance+"hiii");
            balance += amount;
            System.out.println("Deposit successful. Your new balance is: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a non-negative value.");
        }

    }

    @Override
    public void withdraw(double withdrawAmount) {
        count++;
        if(count>3 && (withdrawAmount+((1*withdrawAmount)/100) <= balance-1000) ){
            balance=balance-withdrawAmount-((1*withdrawAmount)/100);
            System.out.println("Deposit successful. Your new balance is: " + balance);
        }
        else if (withdrawAmount <= balance-1000) {
            balance=balance-withdrawAmount;
            System.out.println("Deposit successful. Your new balance is: " + balance);
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

