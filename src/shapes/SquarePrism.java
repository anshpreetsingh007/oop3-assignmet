/**
 * @Author Anshpreet Singh
 *
 * SquarePrism represents a prism with a square base.
 * It extends the Prism class and calculates the base
 * area and volume using the side length and height.
 */

package shapes;


public class SquarePrism extends Shape
{
	private double sideLength;
	
	public SquarePrism(double height, double sideLength) 
	{
		super(height);
		this.sideLength = sideLength;
	}
	
	@Override
	public double calcVolume() 
	{
		return sideLength * sideLength * height;
	}
	
	@Override
	public double calcBaseArea() 
	{
		return sideLength * sideLength;
	}
}
