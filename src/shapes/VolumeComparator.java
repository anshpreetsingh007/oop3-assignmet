
package shapes;

import java.util.Comparator;
/**
 * @Author: Alexander Carlson
 * 
 * <p>
 * VolumeComparator is a comparator class that implements the Comparator interface to compare two Shape objects based on their calculated volume. 
 * It uses the calcVolume() method of the Shape class to retrieve the volume of each shape and compares them using the Double.compare() method, 
 * which returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
 * </p>
 */

public class VolumeComparator implements Comparator<Shape> {
	@Override
	public int compare(Shape s1, Shape s2) {
		return Double.compare(s1.calcVolume(), s2.calcVolume());
	}

}
