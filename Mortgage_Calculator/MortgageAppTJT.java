import java.util.Scanner;
import java.text.NumberFormat;

public class MortgageAppTJT {
//This class above is public, meaning that it is accessible outside the package above.
    public static void main(String[] args) {
    //The keyword "public static void main" is the means by which I create a main method within the
    //Java application. It's the core method of the program and calls all the other methods as well.
    //The main method is the entry point for any Java program. It's where the Java Virtual Machine
    //(JVM) starts executing the program.
        final byte MONTHS_IN_YEAR = 12;
        //The final keyword is there so that the classes MONTHS_IN_YEAR and PERCENT can't be
        //modified, since they are fixed and I want them to be fixed in this program. It's also
        //known as a "constant".
        final byte PERCENT = 100;
        //The starting values for all of these variable is 0, which will allow me (the user) to
        //enter a number that I want as long as it fulfills the requirements in the while loops.
        int principal = 0;
        //I have principal (which is the original amount of money borrowed) as an int because I
        //want the principal to have no decimal places.
        float monthlyInterest = 0;
        //The monthly interest is a float because I want it to have a decimal point included. And
        //the difference between double and float is that double deals with larger numbers. But
        //"monthlyInterest" doesn't need to be that big of a number.
        int numberOfPayments = 0;
        //Like the principal, the number of payments will also be an integer, since it doesn't
        //make sense to say that the number of payments would be, let's say 2.5 times.

        Scanner sc = new Scanner(System.in);
        //Above, I am using the Scanner class, and the variable named "sc", which will store data
        //values. For every variable that involves the variable "sc" (such as "principal" or
        //"annualInterest"), I (the user) can input any value I want as long as it fulfills
        // the requirements.

        //Remember that the Scanner class is used to receive user input and allows the user to
        //interact with the program as it is running. It reads input that the user puts in via
        //keyboard. The method that I used in this program is initialize the value of the
        //variable to (like with "int numberOfPayments = 0;") AND THEN incorporate the Scanner
        //class, and finally (as seen below) read in the next value that the user puts into the
        //console when the program is running.
        //I have it like this:
        //"int principal = 0;"
        //"principal = sc.nextInt();".
        //But an easier method to do this (which I have done in the CalculateCylinder Project,
        //is just do something like this:
        //"double radius = sc.nextDouble();".
        //This method above hit two birds with one stone. The program initializes the value of
        //the radius to 0 and at the same time reads in (scans) whatever value the user puts
        //into the console when the program runs.
        //Also, the reason why I set the initial values of principal, monthlyInterest, and
        //numberOfPayments to 0 is because it is good practice for programmers to use an
        //initial value, as if I just put in "int numberOfPayments" without setting it to 0,
        //the program would give me an error. And I could set the value to 1 or 400, but
        //setting it to 0 is just common practice among software developers.

        while (true) {
            //This code below will only be valid if the while loop is true and the criteria
            //in the loop is met. Otherwise, the loop will continue looping around until the
            //inputs are valid.
            System.out.print("Principal: ");
            principal = sc.nextInt();
            //The nextInt reads in another integer value inputted in the console by the user.
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = sc.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period (Years): ");
            byte years = sc.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1 );

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}