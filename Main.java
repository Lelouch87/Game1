
import java.util.Scanner;
import java.io.*;

public class Main implements Serializable{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Game currentGame = new Game();
        Player currentPlayer;
        //Player currentPlayer = new Player("TemporaryPlayer","Gender Neutral",new Weapon(), 50);
        int menuChoice = printMenu();
        if (menuChoice == 1) {
            currentPlayer = currentGame.creation();
            currentGame.play(currentPlayer);
        } else if (menuChoice == 2) {
            currentPlayer = currentGame.loadCharacter();
            currentGame.play(currentPlayer);
        } else if (menuChoice == 3) {
            System.out.println("no settings");
        }
        else if (menuChoice == 4)
        {
            currentGame.checkCharacterFiles();
        }
        else if (menuChoice == 5)
        {
            System.out.println("Exiting...");
            System.exit(0);
        }
        else if (menuChoice == 6)
        {
            currentGame.deleteCharacterFile();

        }


    }

    public static int printMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to game!");
        System.out.println("New Game - 1");
        System.out.println("Load Game - 2");
        System.out.println("Settings - 3");
        System.out.println("Look at save files - 4");
        System.out.println("Exit - 5");
        System.out.println("Delete a save file - 6");
        int answer = keyboard.nextInt();
        return answer;
    }
}
