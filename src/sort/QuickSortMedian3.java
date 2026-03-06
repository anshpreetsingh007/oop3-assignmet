package sort;

import java.util.Comparator;
import utilities.SortingUtility;

/**
 * QuickSort using Median-of-3 pivot selection.
 * Sorts in descending order.
 * 
 * @author Karandeep Singh
 */
public class QuickSortMedian3<T extends Comparable<T>> implements SortingUtility<T>
{

    @Override
    public void sort(T[] array, Comparator<? super T> comparator)
    {
        if (array == null || array.length <= 1)
        {
            return;
        }

        quickSort(array, 0, array.length - 1, comparator);
    }

    private void quickSort(T[] array, int left, int right, Comparator<? super T> comparator)
    {
        if (left >= right)
        {
            return;
        }

        int pivotIndex = partition(array, left, right, comparator);

        quickSort(array, left, pivotIndex - 1, comparator);
        quickSort(array, pivotIndex + 1, right, comparator);
    }

    private int partition(T[] array, int left, int right, Comparator<? super T> comparator)
    {
        int mid = (left + right) / 2;

        // Median-of-3 ordering
        if (comparator.compare(array[left], array[mid]) < 0)
        {
            swap(array, left, mid);
        }

        if (comparator.compare(array[left], array[right]) < 0)
        {
            swap(array, left, right);
        }

        if (comparator.compare(array[mid], array[right]) < 0)
        {
            swap(array, mid, right);
        }

        // Use median as pivot
        swap(array, mid, right);
        T pivot = array[right];

        int i = left - 1;

        for (int j = left; j < right; j++)
        {
            if (comparator.compare(array[j], pivot) > 0)
            {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, right);

        return i + 1;
    }

    private void swap(T[] array, int i, int j)
    {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}