package testsorting;

import java.util.Random;
import java.util.Arrays;
/*
 * @Author Tabetha Boushey
 * @ date 4/2/2013
 * @ Inlab 11
 */

public class TestSorting {

    public static void printArray(int[] array) {
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    public static void exchange(int[] array, int i, int j) {
        // exchange values at positions i and j in array
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void selectionSort(int[] array) {
        for (int fill = 0; fill <= array.length - 2; fill++) {
            int minPos = fill;
            for (int j = fill + 1; j < array.length; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            exchange(array, fill, minPos);
        }
    }

    public static boolean isSortedAscending(int[] array) {
        for (int i = 0; i <= array.length - 2; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void bubbleSort(int[] array) {
        for (int last = array.length - 1; last > 0; last--) {
            boolean madeExchange = false;
            for (int i = 0; i < last; i++) {
                if (array[i + 1] < array[i]) {
                    exchange(array, i, i + 1);
                    madeExchange = true;
                    //printArray(array);
                }
            }
            if (!madeExchange) {
                return;
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int nextPos = 1; nextPos < array.length; nextPos++) {
            int nextVal = array[nextPos];
            int curPos = nextPos;
            while (curPos > 0 && array[curPos - 1] > nextVal) {
                array[curPos] = array[curPos - 1];
                curPos--;
            }
            array[curPos] = nextVal;
        }
    }

    public static void shellSort(int[] array) {
        // Gap between adjacent elements.
        int gap = array.length / 2;
        while (gap > 0) {
            for (int nextPos = gap; nextPos < array.length;
                    nextPos++) {
                // Insert element at nextPos in its subarray.
                insert(array, nextPos, gap);
            } // End for.

            // Reset gap for next pass.
            if (gap == 2) {
                gap = 1;
            } else {
                gap = (int) (gap / 2.2);
            }
        } // End while.
    } // End sort.

    private static void insert(int[] array,
            int nextPos,
            int gap) {
        int nextVal = array[nextPos]; // Element to insert.
        // Shift all values > nextVal in subarray down by gap.
        while ((nextPos > gap - 1) // First element not shifted.
                && (array[nextPos - gap] > nextVal)) {
            array[nextPos] = array[nextPos - gap]; // Shift down.
            nextPos -= gap; // Check next position in subarray.
        }
        array[nextPos] = nextVal; // Insert nextVal.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int loop = 0;
        int size = 10;
        int[] A = new int[size];
        int[] B = A;
        int[] C = A;
        int[] D = A;
        Random r = new Random();
        
        for (loop = 0; loop <= 20; loop++) {
            if (loop > 10) {
                for (int i = 0; i < size; i++) {
                    A[i] = r.nextInt(10 * size);
                }

                for (int i = 0; i < size; i++) {
                    B[i] = r.nextInt(10 * size);
                }

                for (int i = 0; i < size; i++) {
                    C[i] = r.nextInt(10 * size);
                }

                for (int i = 0; i < size; i++) {
                    D[i] = r.nextInt(10 * size);
                }

                // Original Array
                long originalTime1 = System.nanoTime();
                System.out.println("Original Array: ");
                printArray(A);
                System.out.println("is sorted? " + isSortedAscending(A));
                long originalTime2 = System.nanoTime();
                long originalTotalTime = originalTime2 - originalTime1;
                System.out.println("Starting time:" + originalTime1);
                System.out.println("Finishing time:" + originalTime2);
                System.out.println("Just-In-Time:" + originalTotalTime);

                // Selection Sort
                long selectionSortTime1 = System.nanoTime();
                selectionSort(A);
                System.out.println("Selection Sort: ");
                printArray(A);
                System.out.println("is sorted? " + isSortedAscending(A));
                long selectionSortTime2 = System.nanoTime();
                long selectionSortTotalTime = selectionSortTime2 - selectionSortTime1;
                System.out.println("Starting time:" + selectionSortTime1);
                System.out.println("Finishing time:" + selectionSortTime2);
                System.out.println("Just-In-Time:" + selectionSortTotalTime);

                //Bubble Sort
                long bubbleSortTime1 = System.nanoTime();
                bubbleSort(B);
                System.out.println("Bubble Sort: ");
                printArray(B);
                System.out.println("is sorted? " + isSortedAscending(B));
                long bubbleSortTime2 = System.nanoTime();
                long bubbleSortTotalTime = bubbleSortTime2 - bubbleSortTime1;
                System.out.println("Starting time:" + bubbleSortTime1);
                System.out.println("Finishing time:" + bubbleSortTime2);
                System.out.println("Just-In-Time:" + bubbleSortTotalTime);

                //Array Sort
                long ArraysSortTime1 = System.nanoTime();
                Arrays.sort(C);
                System.out.println("Arrays Sort: ");
                printArray(C);
                System.out.println("is sorted? " + isSortedAscending(C));
                long ArraysSortTime2 = System.nanoTime();
                long ArraysSortTotalTime = ArraysSortTime2 - ArraysSortTime1;
                System.out.println("Starting time:" + ArraysSortTime1);
                System.out.println("Finishing time:" + ArraysSortTime2);
                System.out.println("Just-In-Time:" + ArraysSortTotalTime);

                //Shell Sort
                long shellSortTime1 = System.nanoTime();
                shellSort(D);
                System.out.println("Shell Sort: ");
                printArray(D);
                System.out.println("is sorted? " + isSortedAscending(A));
                long shellSortTime2 = System.nanoTime();
                long shellSortTotalTime = shellSortTime2 - shellSortTime1;
                System.out.println("Starting time:" + shellSortTime1);
                System.out.println("Finishing time:" + shellSortTime2);
                System.out.println("Just-In-Time:" + shellSortTotalTime);

                }
            }
        }
    }
