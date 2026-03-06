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
