package sort;

import java.util.Comparator;
import utilities.SortingUtility;

/**
 * Insertion Sort that sorts elements in descending order.
 * 
 * @author Karandeep Singh
 */
public class InsertionSort<T extends Comparable<T>> implements SortingUtility<T>
{

    @Override
    public void sort(T[] array, Comparator<? super T> comparator)
    {
        int n = array.length;

        for (int i = 1; i < n; i++)
        {
            T key = array[i];
            int j = i - 1;

            // shift smaller elements to the right
            while (j >= 0 && comparator.compare(array[j], key) < 0)
            {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }
}