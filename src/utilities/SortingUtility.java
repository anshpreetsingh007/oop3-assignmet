package utilities;

import java.util.Comparator;

/**
 * @Author Alexander Carlson
 * 
 * This interface defines a sorting utility that can be implemented by various sorting algorithms.
 * It provides a method to sort an array of elements based on a specified comparator.
 * 
 * @param <T> the type of elements to be sorted, which must implement the Comparable interface.
 */
public interface SortingUtility<T extends Comparable<T>>
{
	void sort( T[] array, Comparator<? super T> comparator );
}