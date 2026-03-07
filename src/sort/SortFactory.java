/**
 * @Author Diego Galvis
 *
 * SortFactory is used to return the correct sorting algorithm
 * based on the option chosen by the user.
 */

package sort;

public class SortFactory {

    @SuppressWarnings("unchecked")
    public static <T> SortStrategy<T> getSortStrategy(char type) {

        switch (Character.toLowerCase(type)) {

            case 'b':
                return (SortStrategy<T>) new BubbleSort<>();

            case 's':
                return (SortStrategy<T>) new SelectionSort<>();

            case 'i':
                return (SortStrategy<T>) new InsertionSort<>();

            case 'm':
                return (SortStrategy<T>) new MergeSort<>();

            case 'q':
                return (SortStrategy<T>) new QuickSortMedian3<>();

            case 'z':
                return (SortStrategy<T>) new HeapSort<>();

            default:
                throw new IllegalArgumentException("Invalid sorting option.");
        }
    }
}