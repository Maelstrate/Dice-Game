import java.util.Arrays;
import java.util.Scanner;

public class Labb1ITHS {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] winRecordPlayer = new int[100];
        int[] winRecordComputer = new int[100];
        int counter = 0;
        boolean gameOn = true;


        do {
            int numberOfDice;

            System.out.println("Time to roll dice! Who will score most, you or the computer?!");
            System.out.println("How many dice would you like to roll?");
            numberOfDice = sc.nextInt();
            int[] diceRolls = new int[numberOfDice];
            int sumPlayer = 0;

            diceRolls = rollDice(diceRolls, numberOfDice);
            sumPlayer = sumDice(diceRolls);
            System.out.println("You rolled: " + Arrays.toString(diceRolls));
            System.out.println("Your sum is: " + sumPlayer);

            int[] computerDiceRolls = new int[numberOfDice];
            int sumComputer = 0;
            computerDiceRolls = rollDice(computerDiceRolls, numberOfDice);
            sumComputer = sumDice(computerDiceRolls);
            System.out.println("Computer rolled: " + Arrays.toString(computerDiceRolls));
            System.out.println("Computer sum is: " + sumComputer);

            announceWinner(sumPlayer, sumComputer);

            winRecordPlayer[counter] = sumPlayer;
            winRecordComputer[counter] = sumComputer;
            counter++;

            System.out.println("Would you like to play more? y or n");
            sc.nextLine();
            String answer = sc.nextLine();
            if (answer.equals("n")){
                gameOn = false;
                System.out.println("Goodbye!");
                printRecordList(winRecordPlayer,winRecordComputer);
                }

        } while (gameOn == true);
    }

    static int[] rollDice ( int[] array, int noOfDice){
        for (int i = 0; i < noOfDice; i++) {
            int roll = (int) (Math.random() * 6);
            array[i] = roll;
        }
        return array;
    }

    static int sumDice ( int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    static void announceWinner ( int sumPlayer, int sumComputer) {
        if (sumPlayer > sumComputer) {
            System.out.println("You win!");
        } else if (sumPlayer < sumComputer) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("Its a draw!");
        }
    }
    static void printRecordList (int[] winRecordPlayer, int[] winRecordComputer){
        System.out.println("Your recorded dice rolls are:");
        for (int i = 0; i < 100; i++){
            if (winRecordPlayer[i] > 0){
                System.out.println("Turn "+ (i+1) + ": " + winRecordPlayer[i]);
            }
        }
        System.out.println("Computers recorded dice rolls are:");
        for (int i = 0; i < 100; i++){
            if (winRecordComputer[i] > 0){
                System.out.println("Turn "+ (i+1) + ": " + winRecordComputer[i]);
            }
        }
        int counterWins = 0;
        for (int i = 0; i < 100; i++){
            if (winRecordPlayer[i] > winRecordComputer[i]){
                counterWins++;
            }
        }
        if (counterWins == 1){
            System.out.println("You won 1 time.");
        }
        else {
            System.out.println("You won " + counterWins + " times.");
        }
    }
}
