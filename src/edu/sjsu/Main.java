package edu.sjsu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Quick Sort");

        //open the file as a scanner
        Scanner scanner = new Scanner(new File("src/edu/sjsu/MyList-2.txt"));

        //Create an array to store the integers
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        //while loop to add the integers to the array
        while(scanner.hasNextInt()){
            arr2.add(scanner.nextInt());
        }


        //size of the array
        int size = arr2.size();

        int[] intArray = new int[size];
        for (int i = 0; i < size; i++)
            intArray[i] = arr2.get(i);

        //print the unsorted array
        System.out.println("Unsorted: " + Arrays.toString(intArray));

        //mergeSort
        quickSort(intArray, 0, size-1);
        //print the sorted array
        System.out.println("Sorted: " + Arrays.toString(intArray));

    }


    public static int partition(int[] a, int i, int j) {
        int pivot = a[i];
        int m = i;

        for (int k= i+1; k <= j; k++){
            if(a[k]< pivot){
                m++;
                swap(a,k, m);
            }

        }
        swap(a, i, m);

        return m;

    }

    //quick sort
    public static void quickSort(int[] a, int low, int high){
        if(low < high){
            int pivotIndex = partition(a, low, high);
            quickSort(a, low, pivotIndex-1);
            quickSort(a, pivotIndex+1, high);

        }

    }


    //swap function
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}


//output
/*
Quick Sort
Unsorted: [73, 41, 44, 99, 48, 45, 39, 23, 70, 6, 44, 50, 19, 21, 74, 78, 78, 36, 35, 97, 37, 88, 25, 91, 27, 20, 17, 54, 30, 59, 20, 78, 98, 48, 29, 22, 11, 57, 57, 58, 73, 27, 80, 15, 17, 69, 29, 63, 92, 60, 58, 97, 5, 35, 42, 45, 77, 69, 71, 94, 29, 1, 1, 64, 65, 73, 51, 68, 59, 35]
Sorted: [1, 1, 5, 6, 11, 15, 17, 17, 19, 20, 20, 21, 22, 23, 25, 27, 27, 29, 29, 29, 30, 35, 35, 35, 36, 37, 39, 41, 42, 44, 44, 45, 45, 48, 48, 50, 51, 54, 57, 57, 58, 58, 59, 59, 60, 63, 64, 65, 68, 69, 69, 70, 71, 73, 73, 73, 74, 77, 78, 78, 78, 80, 88, 91, 92, 94, 97, 97, 98, 99]

 */
