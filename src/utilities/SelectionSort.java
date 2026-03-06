package utilities;

import java.util.Comparator;

/**
 * @author Alexander Carlson
 * 
 * Selection Sort implementation for sorting objects in descending order. O(n^2) time complexity.
 * Finds the largest remaining element and places it at the current position each pass.
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
public class SelectionSort<T extends Comparable<T>> implements SortingUtility<T>
{
	@Override
	public void sort( T[] array, Comparator<? super T> comparator )
	{
		int n = array.length;

		for ( int i = 0; i < n - 1; i++ )
		{
			int maxIndex = i;

			// find the index of the largest element in the unsorted portion
			for ( int j = i + 1; j < n; j++ )
			{
				if ( comparator.compare( array[j], array[maxIndex] ) > 0 )
				{
					maxIndex = j;
				}
			}

			// swap the largest found element into the current position
			if ( maxIndex != i )
			{
				T temp        = array[i];
				array[i]      = array[maxIndex];
				array[maxIndex] = temp;
			}
		}
	}
}