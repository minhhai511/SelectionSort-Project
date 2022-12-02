/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

import java.util.Scanner;

/**
 *
 * @author SƠNPC
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input array size
        int size = getArraySize();
        
        //Generate array and enter elements
        int array[] = generateArray(size);
        
        //Display unsorted array
        displayArray(array, "Unsorted array: ");

        //Sort array by bubble sort algorithm
        SelectionSort(array);

        //Display sorted        
        displayArray(array, "Sorted array: ");

    }

    public static int getArraySize() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter number of array:");
            try {
                int size = Integer.parseInt(sc.nextLine());
                //Check if the input size is positive
                if (size > 0) {
                    return size;
                } else {
                    System.out.println("Size of array must be a positive number!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Size of array must be an integer!");
            }
        } while (true);

    }

    private static int[] generateArray(int size) {
        Scanner sc = new Scanner(System.in);
        
        int array[] = new int[size];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter a[" + i + "]: ");
            array[i] = getArrayElement();
        }
        return array;
    }

    public static int getArrayElement() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                int element = Integer.parseInt(sc.nextLine());
                return element;
            } catch (NumberFormatException ex) {
                System.out.println("Elements of array must be an integer!");
                System.out.print("Re-enter: ");
            }
        } while (true);

    }

    private static void displayArray(int[] array, String mes) {
        //Display status of array
        System.out.print(mes);
        System.out.print("[");
        //Loop to traverse each elements of array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //Check position of element to add ","
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    private static void SelectionSort(int[] array) {
        int n = array.length;

        // Loop to traverse each elements of array
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first element 
            // if the first element is larger than the minium element
            if(array[i]!=array[min_idx]){
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;}
        }
    }
}
