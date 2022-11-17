import java.util.Scanner;

public class ElectBilling
{
    Scanner kb = new Scanner(System.in);
    final double RES_RATE = 0.06;
    final double MULT_RATE = 0.05;
    final double COM_RATE = 0.04;
    final double DISCOUNT = 0.10;
    final double CHARGE = 15.00;
    final double GST = 1.05;
    final int CUSTOMER_NUMBER_LOW = 999999;
    final int CUSTMER_NUMBER_HIGH = 10000000;
    final int MAX_METER = 100000;
    final int RES_THRESHOLD = 400;
    final int MULT_THRESHOLD = 8000;
    final int COM_THRESHOLD = 2000;
    
    public void run()
    {
        hello();
        
        int custNumber;
        
        custNumber = number("\nPlease enter your Customer ID (7-digits): ");
        
        while (custNumber > 0)
        {
            if (custNumber > CUSTOMER_NUMBER_LOW && custNumber < CUSTMER_NUMBER_HIGH)
            {
                createBill(custNumber);
            }
            else
            {
                System.out.println("This Customer ID is invalid, please enter another.");
            }
        
            custNumber = number("Please enter your Customer ID (7-digits): ");
        }
        
        goodbye();
    }
    
    public void createBill(int custNo)
    {
        char customerType;
        int meterReadingBeg;
        int meterReadingEnd;
        int usage;
        
        customerType = character("Please enter your Customer Type \n(R for Residential, M for Multi-Use, or C for Commercial): ");
        meterReadingBeg = number("Please enter your meter reading at the beginning of the month: ");
        meterReadingEnd = number("Please enter your meter reading at the end of the month: ");
        usage = kwhUsed(meterReadingBeg, meterReadingEnd);
        
        if (customerType == 'R')
        {
            residential(custNo, usage);
        }
        
        else if (customerType == 'M')
        {
            multi(custNo, usage);
        }
        
        else if (customerType == 'C')
        {
            commercial(custNo, usage);
        }
        
        else
        {
            System.out.println("Invalid input");        
        }
    }
    
    public void residential(int customer, int use)
    {
        double total;
        String type = "Residential";
        double cost = usageCost(use, RES_RATE);
        double discount = resDiscount(use, cost);
        
        total = ((cost - discount) + CHARGE) * GST;
        
        printElectricBill(customer, type, use, total);        
    }
        
    public void multi(int customer, int use)
    {
        double total;
        String type = "Multi-Use";
        double cost = usageCost(use, MULT_RATE);
        double discount = multDiscount(use, cost);
        
        total = ((cost - discount) + CHARGE) * GST;
        
        printElectricBill(customer, type, use, total);
    }
    
    public void commercial(int customer, int use)
    {
        double total;
        String type = "Commercial";
        double cost = usageCost(use, COM_RATE);
        double discount = comDiscount(use, cost);
        
        total = ((cost - discount) + CHARGE) * GST;
        
        printElectricBill(customer, type, use, total);
    }
    
    public int kwhUsed(int beginning, int end)
    {
        int hours = 0;
        
        if (end < beginning)
        {
            hours = (MAX_METER - beginning) + end;
        }
        
        else
        {
            hours = end - beginning;
        }
        
        return hours;
    }
    
    public double usageCost(int hours, double rate)
    {
        double cost;
        
        cost = hours * rate;
        
        return cost;    
    }
    
    public double resDiscount(int kwHours, double cost)
    {
        double discount = 0;
        
        if (kwHours < RES_THRESHOLD)
        {
            discount = cost * DISCOUNT;
        }
        
        return discount;
    }
    
    public double multDiscount(int kwHours, double cost)
    {
        double discount = 0;
        
        if (kwHours < MULT_THRESHOLD)
        {
            discount = cost * DISCOUNT;
        }
        
        return discount;
    }
    
    public double comDiscount(int kwHours, double cost)
    {
        double discount = 0;
        
        if (kwHours < COM_THRESHOLD)
        {
            discount = cost * DISCOUNT;
        }
        
        return discount;
    }
    
    public int number(String statement)
    {
        int enteredNumber;
        
        System.out.print(statement);
        enteredNumber = kb.nextInt();
        
        return enteredNumber;
    }
    
    public char character(String statement)
    {
        char enteredChar;
        String type;
        
        System.out.print(statement);
        type = kb.next();
        enteredChar = type.toUpperCase().charAt(0);
        
        return enteredChar;        
    }
    
    public void printElectricBill(int id, String type, int kwh, double totalBill)
    {
        System.out.println ("\nCustomer Electric Bill\n");
        System.out.printf ("Customer Number:%9d %n", id);
        System.out.printf ("Customer Type:    %-14s %n", type);
        System.out.printf ("Electric Usage:   %-4d kWh %n", kwh);
        System.out.printf ("Total Bill:       $ %-7.2f %n%n", totalBill);
    }
    
    public void hello()
    {
        System.out.println("Welcome to the Customer Billing App for the City of Utopia");
    }
    
    public void goodbye()
    {
        System.out.println("\nThank you for using the Customer Billing App for the City of Utopia");
    }
}