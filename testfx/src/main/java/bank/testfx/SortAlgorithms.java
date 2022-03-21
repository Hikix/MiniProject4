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
        String returnString = "";
        // Only do quicksort for more than three elements
        if ((last - first) > 3) {
            // Sort the first, middle and last elements into their positions
            int mid = first + (last - first) / 2;
            if (a[first] > a[mid]) {
                swapElements(a, first, mid);
                returnString += "Swapping numbers " + a[first] + a[mid] + "\n";
            }
            if (a[mid] > a[last]) {
                swapElements(a, mid, last);
                returnString += "Swapping numbers " + a[mid] + a[last] + "\n";
            }
            if (a[first] > a[mid]) {
                swapElements(a, first, mid);
                returnString += "Swapping numbers " + a[first] + a[mid] + "\n";
            }
            // Move the pivot to the end
            swapElements(a, mid, last - 1);
            int pivotValue = a[last - 1];
            returnString += "Moving pivot to the end by swapping numbers " + a[mid] + a[last - 1] + "\n";
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
                    returnString += "Swapping the left and right indexes " + a[indexFromLeft] + a[indexFromRight] + "\n";
                    indexFromLeft++;
                    indexFromRight--;
                } else {
                    done = true;
                }
            }
            // Once they cross, we swap the pivot into its location
            swapElements(a, last - 1, indexFromLeft);
            returnString += "Swapping numbers " + a[last - 1] + a[indexFromLeft] + "\n";
//            System.out.println(Arrays.toString(a));
            // And then sort each side
            quickSort(a, first, indexFromLeft - 1);
            quickSort(a, indexFromLeft + 1, last);
            returnString += "Array after quicksorting both sides: " + ArrayMethods.printArray(a) + "\n";

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
        String returnString = "";
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
                returnString += "Swapping numbers " + a[iFill] + iFill + "\n";
            }
            // Once we find the right place, put our value into place
            a[iFill + 1] = next;
            // we then print the array so it shows the changes on the label
            returnString += "Array after pass #" + (i + 1) + ": " + ArrayMethods.printArray(a) + "\n";

        }
    }

    public static void selectionSort(int[] a, int first, int last) {
        // Start at the first index
        String returnString = "";
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

                swapElements(a, i, iSmall);
                returnString += "Swapping numbers " + small + iSmall + "\n";
                
            }
            // we then print the array so it shows the changes on the label
            returnString += "Array after pass #" + (i + 1) + ": " + ArrayMethods.printArray(a) + "\n";
        }
    }
    
    
    public static void bubbleSort(int[] a, int length) {
        // setting up the program to know what is the smallest value
        String returnString = "";
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                int jPlus = a[j - 1];
                int small = a[j];
                if (small < jPlus) {
                    swapElements(a, j - 1, j);
                    returnString += "Swapping numbers " + jPlus + small + "\n";
                }
            }
            // we then print the array so it shows the changes on the label
            returnString += "Array after pass #" + (i + 1) + ": " + ArrayMethods.printArray(a) + "\n";
        }
    }
    
}
