import java.io.Serializable;

public class Map implements Serializable
{
    private int xAxis;
    private int yAxis;
    public Map(int xAxis,int yAxis)
    {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public void print()
    {
        System.out.println("");
    }



}
