import java.io.*;
import java.util.Scanner;
public class TestMain implements Serializable
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        File testFile = new File("test.dat");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("About to add player to file");
        Player testPlayer = new Player("chase","boy", new Weapon("wood sword",5),100);
        System.out.println(testPlayer);
        if (testFile.exists()) {
            System.out.println("the file exists");
            AppendObjectOutputStream appendFile = new AppendObjectOutputStream(new FileOutputStream(testFile,true));
            appendFile.writeObject(testPlayer);
            appendFile.close();
            System.out.println("wrote player to file successfully");
        }
        else {
            System.out.println("the file doesn't exist....creating one");
            ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(testFile));
            outFile.writeObject(testPlayer);
            outFile.close();
        }
        System.out.println("About to read from file");
        ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(testFile));

        int count = 0;
        try
        {
            while (true)
            {
                Player tempObject = (Player) inFile.readObject();
                System.out.println("Save " + (count+1) + "\n");
                System.out.println(tempObject);
                count++;
            }
        }
        catch (EOFException e)
        {
            System.out.println("Successfully finished reading from test.dat ");
            inFile.close();

        }


        inFile.close();
    }
}
