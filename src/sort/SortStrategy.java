/**
 * @Author Anshpreet Singh
 *
 * SortStrategy is an interface used for sorting shapes.
 * It allows different sorting algorithms to be used in the program.
 */

package sort;

import java.util.Comparator;

public interface SortStrategy<T> {
    void sort(T[] a, Comparator<? super T> c);
    String name();
}