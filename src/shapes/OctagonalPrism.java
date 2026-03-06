package shapes;

/**
 * @Author Alexander Carlson
 * 
 * <p>OctagonalPrism is a class that represents an octagonal prism shape. 
 * It extends the Shape class and provides implementations for calculating the volume and base area of the octagonal prism.</p>
 * </p>
 */

public class OctagonalPrism extends Shape
{
	private double sideLength;
	
	public OctagonalPrism(double height, double sideLength) 
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
		return 2 * (1 + Math.sqrt(2)) * sideLength * sideLength;
	}
}
