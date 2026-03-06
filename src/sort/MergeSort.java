package sort;

import java.util.Comparator;

import utilities.SortingUtility;

/**
 * @author Alexander Carlson
 * 
 * Merge Sort implementation for sorting objects in descending order. O(n log n) time complexity.
 * Recursively divides the array in half, sorts each half, then merges them back together.
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
 * - Shapes2.txt: 4 ms
 * - Shapes3.txt: 650 ms
 * </p>
 * 
 * @param <T> the type of elements in the array, which must implement the <code>Comparable</code> interface.
 */
public class MergeSort<T extends Comparable<T>> implements SortingUtility<T>
{
	
	public void sort( T[] array, Comparator<? super T> comparator )
	{
		if ( array.length <= 1 ) return;
		mergeSortHelper( array, 0, array.length - 1, comparator );
	}

	// recursively splits the array and sorts each half
	private void mergeSortHelper( T[] array, int left, int right, Comparator<? super T> comparator )
	{
		if ( left < right )
		{
			int mid = left + ( right - left ) / 2;
			mergeSortHelper( array, left, mid, comparator );
			mergeSortHelper( array, mid + 1, right, comparator );
			merge( array, left, mid, right, comparator );
		}
	}

	// Merges two sorted subarrays array[left..mid] and array[mid+1..right] in descending order
	@SuppressWarnings( "unchecked" )
	private void merge( T[] array, int left, int mid, int right, Comparator<? super T> comparator )
	{
		int leftSize  = mid - left + 1;
		int rightSize = right - mid;

		// temporary arrays to hold the two halves
		T[] leftArr  = (T[]) new Comparable[leftSize];
		T[] rightArr = (T[]) new Comparable[rightSize];

		for ( int i = 0; i < leftSize; i++ )
			leftArr[i] = array[left + i];
		for ( int j = 0; j < rightSize; j++ )
			rightArr[j] = array[mid + 1 + j];

		int i = 0, j = 0, k = left;

		while ( i < leftSize && j < rightSize )
		{
			// take the larger of the two front elements first (descending)
			if ( comparator.compare( leftArr[i], rightArr[j] ) >= 0 )
			{
				array[k++] = leftArr[i++];
			}
			else
			{
				array[k++] = rightArr[j++];
			}
		}

		while ( i < leftSize )  array[k++] = leftArr[i++];
		while ( j < rightSize ) array[k++] = rightArr[j++];
	}
}