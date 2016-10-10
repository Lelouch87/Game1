import java.io.Serializable;

public class Player implements Serializable
{
    private int maxHealth;
    private Weapon weapon;
    private String name;
    private int numPotions;
    private int currentHealth;
    private String gender;

    public Player(String name, String gender, Weapon weapon, int health)
    {
        this.currentHealth = 100;
        this.maxHealth = 100;
        this.weapon = weapon;
        this.name = name;
        this.gender = gender;
    }

    public String toString()
    {
        return "Name: "+ name+"\n"+
                "Max Health: " + maxHealth+ "\n"+
                "Current Health: " + currentHealth+ "\n"+
                "Gender: "+ gender+"\n"+
                "Weapon: " + weapon.toString()+"\n"+
                "Number of Potions: "+ numPotions+"\n";
    }

    public boolean equals(Player player)
    {
        if (player.getName().equals((name)) && player.getWeapon().equals(weapon))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getName()
    {
        return name;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public int getNumPotions()
    {
        return numPotions;
    }

    public int getCurrentHealth()
    {
        return currentHealth;
    }

    public void addPotion(int numAddedPotions)
    {
        numPotions += numAddedPotions;
    }

    public void changeWeapon(Weapon newWeapon)
    {
        weapon = newWeapon;
    }

    public boolean isAlive()
    {
        if(currentHealth <= 0 || maxHealth <= 0)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public void changeMaxHealth(int newMaxHealth)
    {
        maxHealth = newMaxHealth;
    }
}
