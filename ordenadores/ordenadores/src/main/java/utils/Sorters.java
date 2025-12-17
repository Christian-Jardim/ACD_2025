package utils;

import java.util.List;
import java.util.ArrayList;

public class Sorters {

    // ---------- QUICK SORT ----------
    static <T extends Comparable<T>> int partition(T[] A, int low, int high) {
        int pivotIndex = low + (int)(Math.random() * (high - low + 1));
        swap(A, pivotIndex, high);

        T pivot = A[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (A[j].compareTo(pivot) < 0) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, high);
        return i + 1;
    }

    static <T extends Comparable<T>> void swap(T[] A, int i, int j) {
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static <T extends Comparable<T>> void quickSort(T[] A, int low, int high) {
        if (low < high) {
            int pi = partition(A, low, high);
            quickSort(A, low, pi - 1);
            quickSort(A, pi + 1, high);
        }
    }

    // ---------- MERGE SORT ----------
    static <T extends Comparable<T>> void merge(T[] A, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        @SuppressWarnings("unchecked")
        T[] L = (T[]) new Comparable[n1];
        @SuppressWarnings("unchecked")
        T[] R = (T[]) new Comparable[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = A[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = A[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0)
                A[k++] = L[i++];
            else
                A[k++] = R[j++];
        }

        while (i < n1) A[k++] = L[i++];
        while (j < n2) A[k++] = R[j++];
    }

    public static <T extends Comparable<T>> void mergeSort(T[] A, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(A, l, m);
            mergeSort(A, m + 1, r);
            merge(A, l, m, r);
        }
    }

    // ---------- HEAP SORT ----------
    static <T extends Comparable<T>> void heapify(T[] A, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && A[l].compareTo(A[largest]) > 0)
            largest = l;
        if (r < n && A[r].compareTo(A[largest]) > 0)
            largest = r;

        if (largest != i) {
            swap(A, i, largest);
            heapify(A, n, largest);
        }
    }

    public static <T extends Comparable<T>> void heapSort(T[] A, int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(A, n, i);
        for (int i = n - 1; i > 0; i--) {
            swap(A, 0, i);
            heapify(A, i, 0);
        }
    }

    // ---------- SHELL SORT ----------
    public static <T extends Comparable<T>> void shellSort(T[] A, int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = A[i];
                int j;
                for (j = i; j >= gap && A[j - gap].compareTo(temp) > 0; j -= gap)
                    A[j] = A[j - gap];
                A[j] = temp;
            }
        }
    }

    // ---------- SELECTION SORT ----------
    public static <T extends Comparable<T>> void selectionSort(T[] A, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (A[j].compareTo(A[min]) < 0)
                    min = j;
            swap(A, i, min);
        }
    }

    // ---------- INSERTION SORT ----------
    public static <T extends Comparable<T>> void insertionSort(T[] A, int n) {
        for (int i = 1; i < n; i++) {
            T key = A[i];
            int j = i - 1;
            while (j >= 0 && A[j].compareTo(key) > 0)
                A[j + 1] = A[j--];
            A[j + 1] = key;
        }
    }

    // ---------- BUBBLE SORT ----------
    public static <T extends Comparable<T>> void bubbleSort(T[] A, int n) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (A[i].compareTo(A[i + 1]) > 0) {
                    swap(A, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // ---------- COUNTING SORT (para Integer) ----------
    public static void countingSort(Integer[] A, int n, int k) {
        Integer[] B = new Integer[n];
        int[] C = new int[k + 1];

        for (int i = 0; i <= k; i++)
            C[i] = 0;

        for (int j = 0; j < n; j++)
            C[A[j]]++;

        for (int i = 1; i <= k; i++)
            C[i] += C[i - 1];

        for (int j = n - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]]--;
        }

        System.arraycopy(B, 0, A, 0, n);
    }

    public static void auxCounting(Integer[] A) {
        int k = 0;
        for (int x : A)
            if (x > k) k = x;
        countingSort(A, A.length, k);
    }

    // ---------- RADIX SORT (para Integer) ----------
    public static void radixSort(Integer[] A, int n, int d) {
        Integer[] B = new Integer[n];
        for (int digito = 1; digito <= d; digito++) {
            int[] C = new int[10];
            for (int i = 0; i < n; i++) {
                int digitoAtual = (A[i] / (int) Math.pow(10, digito - 1)) % 10;
                C[digitoAtual]++;
            }
            for (int i = 1; i < 10; i++)
                C[i] += C[i - 1];
            for (int i = n - 1; i >= 0; i--) {
                int digitoAtual = (A[i] / (int) Math.pow(10, digito - 1)) % 10;
                B[C[digitoAtual] - 1] = A[i];
                C[digitoAtual]--;
            }
            System.arraycopy(B, 0, A, 0, n);
        }
    }

    public static void auxRadix(Integer[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++)
            if (A[i] > max) max = A[i];

        int d = 0, temp = max;
        while (temp > 0) {
            d++;
            temp /= 10;
        }

        radixSort(A, A.length, d);
    }

    // ---------- BUCKET SORT ----------
    public static <T extends Comparable<T>> void bucketSort(T[] A, int n) {
        // criar n buckets/listas
        List<T>[] buckets = new List[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // encontrar o valor máximo e mínimo para normalizar os índices
        T min = getMinValue(A);
        T max = getMaxValue(A);

        // distribuir os elementos
        for (T value : A) {
            int bucketIndex = (int) ((value.compareTo(min)) * (n - 1) / (max.compareTo(min) + 1.0));
            buckets[bucketIndex].add(value);
        }

        // ordenar cada bucket com insertionSort
        int index = 0;
        for (List<T> bucket : buckets) {
            T[] bucketArray = (T[]) bucket.toArray(new Comparable[0]);
            insertionSort(bucketArray, bucketArray.length);
            for (T value : bucketArray) {
                A[index++] = value;
            }
        }
    }

    private static <T extends Comparable<T>> T getMaxValue(T[] A) {
        T max = A[0];
        for (T value : A) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return max;
    }

    private static <T extends Comparable<T>> T getMinValue(T[] A) {
        T min = A[0];
        for (T value : A) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
        }
        return min;
    }

}
