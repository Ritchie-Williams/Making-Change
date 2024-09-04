//Ritchie Williams
//Exit Ticket 08 28



public class CoinMaker {


    public static void makeChange(double amt) {


        int cents = (int) Math.round(amt * 100);

        //Calculates amount of coins

        //Quarters
        int quarters = cents / 25;
        cents = cents % 25;

        //Dimes
        int dimes = cents / 10;
        cents = cents % 10;

        //Nickels
        int nickels = cents / 5;
        cents = cents % 5;

        //Converts remainder to pennies
        int pennies = cents;


        //Print results
        System.out.println("QUARTERS: " + quarters);
        System.out.println("DIMES: " + dimes);
        System.out.println("NICKELS: " + nickels);
        System.out.println("PENNIES: " + pennies);

        System.out.println("AMT: " + amt);

        System.out.println("Thank you for using  Ritchie's CoinMaker!");
    }

    public static void main(String[] args) {

        makeChange(342.57);

    }


}
