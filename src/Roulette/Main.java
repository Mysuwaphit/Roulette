
package Roulette;

import java.util.Scanner;
import java.util.Random;

public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //Scanner
        Scanner inputNum = new Scanner(System.in);//double or int
        Scanner inputString = new Scanner(System.in);//String
        
        //Attribute
        int choose;
        String response;
        Roulette play = new Roulette();
        Menu m = new Menu();
        double amount = 0;
        int choice = -1;
        int number = 0;
        int result;
        
        //Solution
        //Menu
        System.out.println("Welcome to OUR Roulette Game!!!");
        m.Menu(play);
        //Play again
      
        while(true){
           //choice
         while (true) {
            System.out.println("Do you want to play? Y/N");
            response = inputString.next();
            if("n".equals(response) || "N".equals(response)){
                System.out.println("Good Bye!!");
                System.exit(0);
                break;
            }else if("Y".equals(response) || "y".equals(response)){
                System.out.print("Enter your bet amount: ");
                amount = inputString.nextDouble();
                System.out.print("0 - Even\n1 - Odd\n2 - Number\n");
                while (choice < 0 || choice > 2) {
                    System.out.print("Place your bet on: ");
                    choice = inputString.nextInt();
                }
                if (choice == 2) {
                    while (number < 1 || number > 36) {
                        System.out.print("Place your bet on number(0-36): ");
                        number = inputString.nextInt();
                    }
                }
                
                play.generate();
                break;
            }else{
                System.out.println("Please input Y OR N.");    
            }
        }
        
            //Rule 
            if(play.b2.isEven() == choice){
                result = 1; //win
            }
            else if(play.b2.getNumber() == number){
                result = 35; //win
            }
            else{
                result = 0; //lose
            }

            //result
            play.check(result, amount);
            if(result>0){
                System.out.println("Congratulatons!!! You win!");
                System.out.printf("You have won $"+result * amount+" \n");
                System.out.printf("Here's your money back: $"+(result + 1) * amount+ "\n");
            }
            else{
                System.out.println("You lose. Better luck next time!");
                System.out.println("You have lost $"+(result + 1) * amount +"\n");

            }
            System.out.println("current money: " + play.getMoney());


            if(play.getMoney() <= 0){
                System.out.println("You're broke!!");
                System.exit(0);
            }
          }
    }
}
