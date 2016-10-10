import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game implements Serializable{
    public Game(){

    }

    public void start() {

    }

    public void tutorial() {

    }

    public Player creation() {
        WoodSword WoodSword1 = new WoodSword();
        Weapon WoodSword = new Weapon("Wood Sword", 1);
        File characterFiles = new File("characterfiles.dat");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your name, champion?");
        String name = keyboard.nextLine();
        System.out.println("Are you a boy, or a girl?");
        String gender = keyboard.nextLine();
        Player newPlayer = new Player(name, gender, WoodSword, 100);
        System.out.println("Creating character...");
        //add some sort of java wait to make more ....'s appear a few seconds at a time
        int count = 0;
        if (characterFiles.exists()) {
            try {
                AppendObjectOutputStream appendFile = new AppendObjectOutputStream(new FileOutputStream("characterfiles.dat", true));
                appendFile.writeObject(newPlayer);
                appendFile.close();
                return newPlayer;
            } catch (IOException e) {
                System.out.println("IO Exception!");

            }
        }
        else {
            try {
                ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("characterfiles.dat"));
                outFile.writeObject(newPlayer);
                outFile.close();
                return newPlayer;
            } catch (IOException e) {
                System.out.println("IO Exception!");
            }

        }
        return new Player("TemporaryPlayer","Gender Neutral",new Weapon(), 50);
    }

    public Player loadCharacter() {
        Scanner keyboard = new Scanner(System.in);
        Player[] arrayOfPlayers = new Player[100];
        File characterFiles = new File("characterfiles.dat");

        if (characterFiles.exists()) {
            int count = 0;

            try
            {
                ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(characterFiles));
                while (true) {
                    Player tempPlayer = (Player) inFile.readObject();
                    arrayOfPlayers[count] = tempPlayer;
                    System.out.println("Save " + (count + 1) + "\n");
                    System.out.println(tempPlayer);
                    count++;
                }
                //this will never be reached
                //inFile.close();

            }
            catch (FileNotFoundException e)
            {
                System.out.println("File not found!");
            } catch (EOFException e) {
                //cant close inFile here
                //inFile is still open
                System.out.println("In EOF Exception!");
                System.out.println("Successfully finished reading from " + characterFiles);
                System.out.println("Please enter a number to indicate your player");
                int choice = keyboard.nextInt();
                keyboard.nextLine();
                return arrayOfPlayers[choice];
                //store the players in a temporary player array and cycle through them
                //whichever number they chose, load and return that player

            } catch (IOException e) {
                System.out.println("IOException");
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFound exception!");
            }



        } else {
            System.out.println("File does not exist");
            System.exit(1);
        }

        //System.exit(2);
        return new Player("TemporaryPlayer","Gender Neutral",new Weapon(), 50);
    }

    public void checkCharacterFiles()
    {
        File characterFiles = new File("characterfiles.dat");
        //Scanner keyboard = new Scanner(System.in);
        //System.out.println("What is the name of the file you want to read in?");
        //String fileName = keyboard.next();


        int count = 0;
        try
        {
            ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(characterFiles));
            while (true)
            {
                Player tempObject = (Player) inFile.readObject();
                System.out.println("Save " + (count+1));
                System.out.println("___________________________");
                System.out.println(tempObject);
                System.out.println("___________________________");
                System.out.println();
                count++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Exception!");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found exception!");
        }
        catch (EOFException e)
        {
            System.out.println("Successfully finished reading from" +
                    " file " + characterFiles);

        }
        catch (IOException e)
        {
            System.out.println("IO Exception");
        }

    }

    public void deleteCharacterFile()
    {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Player> playerArrayList = new ArrayList<>();
        File characterFiles = new File("characterfiles.dat");
        int count = 0;
        try
        {
            ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(characterFiles));
            while (true)
            {
                Player tempObject = (Player) inFile.readObject();
                playerArrayList.add(tempObject);
                System.out.println("Save " + (count+1));
                System.out.println("___________________________");
                System.out.print(tempObject);
                System.out.println("____________________________");
                System.out.println();
                count++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Exception!");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found exception!");
        }
        catch (EOFException e)
        {
            System.out.println("Successfully finished reading from" +
                    " file " + characterFiles);
        }
        catch (IOException e)
        {
            System.out.println("IO Exception");
        }

        System.out.println("Please enter a number for which save file you would like to delete");
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Warning : You are about to delete Save File "+choice);
        System.out.println("This contains :");
        System.out.println(playerArrayList.get(choice-1).toString());
        System.out.println("Are you sure you want to delete this save? (Y/N) ");
        String decision = keyboard.nextLine();
        if (decision.equalsIgnoreCase("y"))
        {
            playerArrayList.remove(choice-1);
            System.out.println("Removed save from file");
            System.out.println("Rewriting file...");
            try {
                ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(characterFiles));
                for (int i = 0; i < playerArrayList.size(); i++)
                {
                    outFile.writeObject(playerArrayList.get(i));
                }
                outFile.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("File Not Found Exception");
            }
            catch (IOException e) {
                System.out.println("IO Exception");
            }


        }
        else if (decision.equalsIgnoreCase("n"))
        {
            System.out.println("Returning");
        }
        else {
            System.out.println("Improper input");
            System.out.println("Aborting deletion of files...");
        }



    }

    public void play(Player currentPlayer)
    {
        System.out.println("We are playing the game");
        System.out.println("With player");
        System.out.println(currentPlayer);
    }

}
