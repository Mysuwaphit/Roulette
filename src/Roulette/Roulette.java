package Roulette;


import java.util.Random;
import java.util.Scanner;


public class Roulette {
    //Scanner
    Scanner inputNum = new Scanner(System.in);//int or double
    Scanner inputString = new Scanner(System.in);//String
    
    //Attribute
    double money=0;
    double amount;
    int choice;
    int number;
    int rouletteNum;
    int result;
    double moneyinput;
    String response;
    Ball b2 = new Ball();
    
    //Random
    Random generator = new Random();
    
    /**
     *
     * @return b2
     */
    public Ball generate() {

        
        //Adds random to a variable then generates a number between 0 - 36.
        Random rand = new Random();
        int ballNumber = rand.nextInt(36);
        b2.setNumber(ballNumber);
        b2.setEven(oddOrEven(ballNumber));
        return b2;
    }

    /**
     *
     * @return money
     */
    public void inputMoney() {
        //increase money
        System.out.println("deposit your money for bet.");
        System.out.println("( you must have more than 1000 to play )");
        if(money < 1000){
            while (true) {
                moneyinput = inputNum.nextDouble();
                money += moneyinput;
                if (money >= 1000) {
                    System.out.println("current money:" + money);
                    break;
                } else {
                    System.out.println("not enough money!!");
                    System.out.println("please input more :");
                }
            } 
        }else{
            System.out.println("Do you want to add more money? Y/N");
            response = inputString.nextLine();
            if("y".equals(response) || "Y".equals(response)){
               moneyinput = inputNum.nextDouble();
               money += moneyinput;
            }
        }
    }

    /**
     *
     * @return money
     */
    public double getMoney() {
        return money;
    }
    
    /**
     *
     * @return even
     */
    private int oddOrEven(int checkNumber) { //ballNumber = checkNumber
        
        int even = -1;
        if (checkNumber == 0) {
            even = 0; //even
        }

        if (checkNumber % 2 == 0) {
            even = 0; //even
        }

        if (checkNumber % 2 == 1) {
            even = 1; //odd
        }
        return even;
    }
    
    /**
     *
     * @param result
     * check that you win or lose
     * @param amount
     */
    public void check(int result, double amount){
        if (result > 0) {
            money = (money - amount) + (result + 1) * amount;
        }
        else{
            money = money - amount;
        }
    }

}
