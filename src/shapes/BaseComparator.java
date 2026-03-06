package shapes;

import java.util.Comparator;
/**
 * @Author: Alexander Carlson
 * 
 * <p>
 * BaseComparator is a comparator class that compares two Shape objects based on their base area. 
 * It implements the Comparator interface and overrides the compare method to compare the base areas of the two shapes.
 * </p>
 */
public class BaseComparator implements Comparator<Shape> {
	@Override
	public int compare(Shape s1, Shape s2) {
		return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
	}

}
