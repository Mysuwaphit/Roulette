
package Roulette;

import java.util.Scanner;

/**
 *
 * @author Suwaphit Chotsawad
 */
public class Menu {
    
    Scanner inputNum = new Scanner(System.in);//int
    Scanner inputString = new Scanner(System.in);//String
    int choose;
    double money;
    String response;
    boolean isEnterValue = true;
    
    public void Menu(Roulette play){
        while(true){
            if(!isEnterValue) break;
            System.out.println("Select 1 2 or 3\n 1. Play\n 2. How to play\n 3. Exit");
            choose = inputNum.nextInt();
            if(choose >=1 && choose <=3){
                Case(play);
                isEnterValue = false;
            }else
                System.out.println("Please Select again.");
            
        }
    }   
    
    public void Case(Roulette play){
        switch(choose){
                case 1 -> play.inputMoney();
                case 2 -> {
                    System.out.println("HOW TO PLAY?");
                    System.out.println("1. You have to start with $1000 and your cash out with as much as possible.");
                    System.out.println("If your money goes to $0 or below, you will lose.");
                    System.out.println("-----WARNING: Cashing out will reset the game.-----");
                    System.out.println("2. Then select Odd or Even or Number that you want to bet.");
                    System.out.println("   If you select Number,You must select one number of 0-36");
                    System.out.println("3. Bet your money");
                    System.out.println("+------------------------+------+");
                    System.out.println("| Bet                    | Pays |");
                    System.out.println("+------------------------|------|");
                    System.out.println("| Odd                    |  1   |");
                    System.out.println("+------------------------|------|");
                    System.out.println("| Even                   |  1   |");
                    System.out.println("+------------------------|------|");
                    System.out.println("| Any one number         |  35  |");
                    System.out.println("+------------------------+------+");
                    System.out.println("Do you want to play? Y/N");
                    response = inputString.nextLine();
                    if("y".equals(response) || "Y".equals(response)){ 
                        play.inputMoney();
                    }else{
                        isEnterValue = false;
                    }
            }
                case 3 -> System.exit(0);
        }
    }
}
