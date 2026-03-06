package shapes;

/**
 * @Author Alexander Carlson
 * 
 * <p>
 * PentagonalPrism is a class that represents a pentagonal prism shape. 
 * It extends the Shape class and implements the methods to calculate the volume and base area of the pentagonal prism.
 * </p>
 */

public class PentagonalPrism extends Shape
{
	private double sideLength;
	
	public PentagonalPrism(double height, double sideLength) 
	{
		super(height);
		this.sideLength = sideLength;
	}
	
	@Override
	public double calcVolume() 
	{
		return calcBaseArea() * height;
	}
	
	@Override
	public double calcBaseArea() 
	{
		return (5 * sideLength * sideLength * Math.tan(Math.PI / 5)) / 4;
	}
}
