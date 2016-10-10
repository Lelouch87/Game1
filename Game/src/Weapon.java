import java.io.Serializable;

public class Weapon implements Serializable
{
    private String name;
    private int damage = 0;
    public Weapon()
    {
        name = "why does it invoke this every time";
        damage = 5;
    }
    public Weapon(String name, int damage)
    {
        this.damage = damage;
        this.name = name;
    }

    public String toString()
    {
        return name;
    }



    public int getDamage()
    {
        return damage;
    }
    public String getName()
    {
        return name;
    }
}
