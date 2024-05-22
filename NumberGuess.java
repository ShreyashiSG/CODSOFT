package Tasks;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    
    public static void main(String[] args) 
    {
        //Defining the upper and lower limits
        int lower =1;
        int upper =100;

        //Generate the number
        Random randomData = new Random();
        int num= randomData.nextInt(lower, upper+1);

        //Taking the input from the user
        System.out.printf(" Guess a number between %d and %d: ", lower,upper);
        Scanner userInput= new Scanner(System.in);
        
        //Starting the loop
        int guess;
        int counter=0;
        do
        {
            guess = userInput.nextInt();
            counter++;

            //Guessing conditions
            if (guess > num){
                System.out.println("Guess again! (HINT:Try a lower number).");
            }else if (guess < num) {
                System.out.println("Guess again! (HINT: Try a higher number).");
            }
        } while(guess != num);

        
        System.out.println("Your guess is CORRECT! It took you "+ counter+ " tries.");
    }
}
