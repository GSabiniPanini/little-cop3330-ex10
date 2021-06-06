package base;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Glenroy Little
 */
import java.util.Scanner;
/**
 Exercise 10 - Self-Checkout
 Working with multiple inputs and currency can introduce some tricky precision issues.

 Create a simple self-checkout system. Prompt for the prices and quantities of three items.
 Calculate the subtotal of the items. Then calculate the tax using a tax rate of 5.5%.
 Print out the line items with the quantity and total, and then print out the subtotal, tax amount, and total.

 Example Output
 Enter the price of item 1: 25
 Enter the quantity of item 1: 2
 Enter the price of item 2: 10
 Enter the quantity of item 2: 1
 Enter the price of item 3: 4
 Enter the quantity of item 3: 1
 Subtotal: $64.00
 Tax: $3.52
 Total: $67.52

 Constraints
 Keep the input, processing, and output parts of your program separate.
 Collect the input, then do the math operations and string building, and then print out the output.
 Be sure you explicitly convert input to numerical data before doing any calculations.

 Challenges
 Revise the program to ensure that prices and quantities are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
 Alter the program so that an indeterminate number of items can be entered. The tax and total are computed when there are no more items to be entered.
 */
public class App 
{
    static Scanner in = new Scanner(System.in);
    static final double TAX_RATE = .055;

    public static void main( String[] args )
    {
        App myApp = new App();

        Integer i1 = getprice(1);
        Integer q1 = getquantity(1);
        Integer i2 = getprice(2);
        Integer q2 = getquantity(2);
        Integer i3 = getprice(3);
        Integer q3 = getquantity(3);

        float subtotal = myApp.calcsubtotal(i1, q1, i2, q2, i3, q3);
        double tax = myApp.calctax(subtotal);
        double total = myApp.findtotal(subtotal, tax);

        myApp.printtotals(subtotal, tax, total);
    }

    public void printtotals(float subtotal, double tax, double total)
    {
        System.out.printf("Subtotal: $%.2f%nTax: $%.2f%nTotal: $%.2f", subtotal, tax, total);
    }

    public double findtotal(float subtotal, double tax)
    {
        double total = subtotal + tax;
        return total;
    }

    public double calctax(float subtotal)
    {
        double tax = subtotal * TAX_RATE;
        return tax;
    }

    public float calcsubtotal(Integer i1, Integer q1, Integer i2, Integer q2, Integer i3, Integer q3)
    {
        float sum = i1 * q1 + i2 * q2 + i3 * q3;
        return sum;
    }

    public static Integer getquantity(int num)
    {
        System.out.print("Enter the quantity of item " + num + ": ");
        Integer quantity = in.nextInt();
        return quantity;
    }

    public static Integer getprice(int num)
    {
        System.out.print("Enter the price of item " + num + ": ");
        Integer price = in.nextInt();
        return price;
    }
}
