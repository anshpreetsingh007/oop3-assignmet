package utilities;

import java.util.Comparator;

/**
 * @author Alexander Carlson
 * 
 * Bubble Sort implementation for sorting objects in descending order. O(n^2) time complexity.
 * Repeatedly compares adjacent elements and swaps them if out of order, causing larger values
 * to "bubble" toward the front of the array.
 * 
 * <p>
 * Precondition: The <code>array</code> must not be <code>null</code> and must contain at least one element.
 * </p>
 * <p>
 * Postcondition: The <code>array</code> is sorted in descending order based on the provided <code>comparator</code>.
 * </p>
 * <p>
 * Testing Results:
 * - Shapes1.txt: 0 ms
 * - Shapes2.txt: 19 ms
 * - Shapes3.txt: N/A (too long to run)
 * </p>
 * 
 * @param <T> the type of elements in the array, which must implement the <code>Comparable</code> interface.
 */
public class BubbleSort<T extends Comparable<T>> implements SortingUtility<T>
{
	@Override
	public void sort( T[] array, Comparator<? super T> comparator )
	{
		int n = array.length;

		for ( int i = 0; i < n - 1; i++ )
		{
			for ( int j = 0; j < n - 1 - i; j++ )
			{
				// if left element is less than right, swap (descending)
				if ( comparator.compare( array[j], array[j + 1] ) < 0 )
				{
					T temp      = array[j];
					array[j]    = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
}