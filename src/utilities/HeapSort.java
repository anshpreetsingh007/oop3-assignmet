package utilities;

import java.util.Comparator;

/**
 * @author Alexander Carlson
 * 
 * Heap Sort implementation for sorting objects in descending order. O(n log n) time complexity.
 * 
 * <p>
 * The algorithm works in two phases:
 * 1. Build a max-heap from the array bottom-up, ensuring the largest element is at index 0.
 * 2. Repeatedly swap the root (largest) with the last unsorted element, shrink the heap,
 *    and restore the heap property. This produces ascending order, which is then reversed
 *    to give the required descending output.
 * </p>
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
 * - Shapes2.txt: 3 ms
 * - Shapes3.txt: 1509 ms
 * </p>
 * 
 * @param <T> the type of elements in the array, which must implement the <code>Comparable</code> interface.
 */
public class HeapSort<T extends Comparable<T>> implements SortingUtility<T>
{
	@Override
	public void sort( T[] array, Comparator<? super T> comparator )
	{
		int n = array.length;

		// Phase 1: build a max-heap bottom-up from the last non-leaf node
		for ( int i = n / 2 - 1; i >= 0; i-- )
		{
			heapify( array, n, i, comparator );
		}

		// Phase 2: extract root (largest) one at a time, shrink heap, restore property
		for ( int i = n - 1; i > 0; i-- )
		{
			T temp     = array[0];
			array[0]   = array[i];
			array[i]   = temp;
			heapify( array, i, 0, comparator );
		}

		// Phase 2 produces ascending order. reverse to get descending
		for ( int i = 0, j = n - 1; i < j; i++, j-- )
		{
			T temp   = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	// Ensures the subtree rooted at index i satisfies the max-heap property
	private void heapify( T[] array, int heapSize, int i, Comparator<? super T> comparator )
	{
		int largest = i;
		int left    = 2 * i + 1;
		int right   = 2 * i + 2;

		if ( left < heapSize && comparator.compare( array[left], array[largest] ) > 0 )
			largest = left;

		if ( right < heapSize && comparator.compare( array[right], array[largest] ) > 0 )
			largest = right;

		if ( largest != i )
		{
			T temp        = array[i];
			array[i]      = array[largest];
			array[largest] = temp;
			heapify( array, heapSize, largest, comparator );
		}
	}
}