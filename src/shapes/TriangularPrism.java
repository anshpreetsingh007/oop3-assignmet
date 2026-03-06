package shapes;
/**
 * @Author: Alexander Carlson
 * 
 * <p>
 * TriangularPrism is a class that extends the Shape class and represents a triangular prism. 
 * It has a sideLength attribute that represents the length of the sides of the equilateral triangle base. 
 * The class implements the calcVolume() method to calculate the volume of the triangular prism using the formula: Volume = Base Area * Height, 
 * where the base area is calculated using the formula for an equilateral triangle: Base Area = (sqrt(3) / 4) * sideLength^2.
 * </p>
 */

public class TriangularPrism extends Shape
{
	// Triangle assumed to be equilateral
	private double sideLength;
	
	public TriangularPrism(double height, double sideLength) 
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
		return (Math.sqrt(3) / 4) * sideLength * sideLength;
	}

}
