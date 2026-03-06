
package sort;

import java.util.Comparator;

import utilities.SortingUtility;

/**
 * @author Alexander Carlson
 * 
 * Insertion Sort implementation for sorting objects in descending order. O(n^2) time complexity.
 * Builds a sorted portion one element at a time by inserting each new element into its correct
 * position among the already-sorted elements.
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
 * - Shapes2.txt: 12 ms
 * - Shapes3.txt: N/A (too long to run)
 * </p>
 * 
 * @param <T> the type of elements in the array, which must implement the <code>Comparable</code> interface.
 */
public class InsertionSort<T extends Comparable<T>> implements SortingUtility<T>
{
	
	public void sort( T[] array, Comparator<? super T> comparator )
	{
		int n = array.length;

		for ( int i = 1; i < n; i++ )
		{
			T key = array[i];
			int j = i - 1;

			// shift elements that are less than key one position to the right (descending)
			while ( j >= 0 && comparator.compare( array[j], key ) < 0 )
			{
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}
}