package sort;

import java.util.Comparator;

import utilities.SortingUtility;

/**
 * @author Alexander Carlson
 * 
 * Quick Sort implementation for sorting objects in descending order using the Median-of-3
 * pivot selection strategy. O(n log n) average time complexity, O(n^2) worst case.
 * Median-of-3 reduces the likelihood of worst-case behaviour on sorted or nearly-sorted data.
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
 * - Shapes2.txt: 2 ms
 * - Shapes3.txt: 710 ms
 * </p>
 * 
 * @param <T> the type of elements in the array, which must implement the <code>Comparable</code> interface.
 */
public class QuickSortMedian3<T extends Comparable<T>> implements SortingUtility<T>
{
	
	public void sort( T[] array, Comparator<? super T> comparator )
	{
		quickSortHelper( array, 0, array.length - 1, comparator );
	}

	// Recursively partitions the array and sorts each partition
	private void quickSortHelper( T[] array, int low, int high, Comparator<? super T> comparator )
	{
		if ( low < high )
		{
			int pivotIndex = partition( array, low, high, comparator );
			quickSortHelper( array, low, pivotIndex - 1, comparator );
			quickSortHelper( array, pivotIndex + 1, high, comparator );
		}
	}

	// Median-of-3 partition: picks median of first, middle, last as pivot to reduce worst-case risk
	private int partition( T[] array, int low, int high, Comparator<? super T> comparator )
	{
		int mid = low + ( high - low ) / 2;

		// Sort low, mid, high so the median value ends up at mid
		if ( comparator.compare( array[low], array[mid] ) < 0 )
		{
			T temp    = array[low];
			array[low] = array[mid];
			array[mid] = temp;
		}
		if ( comparator.compare( array[low], array[high] ) < 0 )
		{
			T temp     = array[low];
			array[low]  = array[high];
			array[high] = temp;
		}
		if ( comparator.compare( array[mid], array[high] ) < 0 )
		{
			T temp     = array[mid];
			array[mid]  = array[high];
			array[high] = temp;
		}

		// place median (now at mid) at high to use as pivot
		T pivot    = array[mid];
		array[mid]  = array[high];
		array[high] = pivot;

		// Partition: elements greater than pivot go left (descending)
		int i = low - 1;
		for ( int j = low; j < high; j++ )
		{
			if ( comparator.compare( array[j], pivot ) > 0 )
			{
				i++;
				T temp    = array[i];
				array[i]  = array[j];
				array[j]  = temp;
			}
		}

		// Place pivot in its final sorted position
		T temp        = array[i + 1];
		array[i + 1]  = array[high];
		array[high]   = temp;

		return i + 1;
	}
}