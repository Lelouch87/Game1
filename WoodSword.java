import java.io.Serializable;

public class WoodSword extends Weapon implements Serializable
{
    private int damage = 1;
    private String name = "Wood Sword";

    public String getName()
    {
        return name;
    }
}
