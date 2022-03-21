/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.testfx;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author appuv
 */
public class SortAlgorithms {

    private final static int N = 10;
    private static Random rand = new Random();
    long initial;
    double total;
    int[] a = new int[N];

    public static void quickSort(int[] a, int first, int last) {

        // Only do quicksort for more than three elements
        if ((last - first) > 3) {
            // Sort the first, middle and last elements into their positions
            int mid = first + (last - first) / 2;
            if (a[first] > a[mid]) {
                swapElements(a, first, mid);
            }
            if (a[mid] > a[last]) {
                swapElements(a, mid, last);
            }
            if (a[first] > a[mid]) {
                swapElements(a, first, mid);
            }
//            System.out.println(first + " " + last + " " + mid);
//            System.out.println(Arrays.toString(a));
            // Move the pivot to the end
            swapElements(a, mid, last - 1);
            int pivotValue = a[last - 1];

            // Now start from both sides and work inward
            int indexFromLeft = first + 1;
            int indexFromRight = last - 2;
            boolean done = false;
            while (!done) {
                // Find a place where the left hand side and the right hand
                // side each have a value that doesn't belong and swap them
                while (a[indexFromLeft] < pivotValue) {
                    indexFromLeft++;
                }
                while (a[indexFromRight] > pivotValue) {
                    indexFromRight--;
                }
                // When we're there, swap those elements and
                // keep doing that until the two counters cross
                if (indexFromLeft < indexFromRight) {
                    swapElements(a, indexFromLeft, indexFromRight);
                    indexFromLeft++;
                    indexFromRight--;
                } else {
                    done = true;
                }
            }
            // Once they cross, we swap the pivot into its location
            swapElements(a, last - 1, indexFromLeft);
//            System.out.println(Arrays.toString(a));
            // And then sort each side
            quickSort(a, first, indexFromLeft - 1);
            quickSort(a, indexFromLeft + 1, last);

        } else {
            // Just use a simpler sort if the number of elements is small
            selectionSort(a, first, last + 1);
        }

    }

    public static void swapElements(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void insertionSort(int[] a, int first, int last) {
        // Start at index 1
        for (int i = first + 1; i < last; i++) {
            // Store the value away
            int next = a[i];
            // Start looking one before where the value we want to put is
            int iFill = i - 1;
            // Keep looking until we're at the beginning of the array or
            // we find a value that's smaller than the one we're using
            while (iFill >= 0 && next < a[iFill]) {
                // As long as that's happening, move the element up one
                // to make space
                a[iFill + 1] = a[iFill];
                // And go back one more
                iFill--;
            }
            // Once we find the right place, put our value into place
            a[iFill + 1] = next;
//            int iInsert = 0;
//            for (iInsert = 0; iInsert < i; iInsert++) {
//                if (next < a[iInsert]) {
//                    break;
//                }
//            }
//            for (int j = i - 1; j >= iInsert; j--) {
//                a[j + 1] = a[j];
//            }
//            a[iInsert] = next;
        }
    }

    public static void selectionSort(int[] a, int first, int last) {
        // Start at the first index
        for (int i = first; i < last; i++) {
            // Keep track of the smallest element and the value it's at
            int small = a[i];
            int iSmall = i;
            for (int j = i + 1; j < last; j++) {
                // Loop through to identify the actual smallest element
                if (a[j] < small) {
                    small = a[j];
                    iSmall = j;
                }
            }
            // If the smallest element isn't already in the right place, swap
            // for the next element
            if (i != iSmall) {
//                int temp = a[i];
//                a[i] = a[iSmall];
//                a[iSmall] = temp;
                swapElements(a, i, iSmall);
            }
            // Now everything from first to i has the smallest elements in order
            // so go on to the next one
        }
    }
    
    public static void bubbleSort(int[] a, int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length; j++) {
                int jPlus = a[j + 1];
                int small = a[j];
                if (small > jPlus) {
                    swapElements(a, j, j + 1);
                }
            }
        }
    }
    
}
