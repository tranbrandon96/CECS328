package cecs328lab6;

import java.util.Random;

//----------------------------------------------------------------------------------------------------------
//Name: Brandon Tran
//Class: CECS 328 (Pouye Sedighian)
//Lab: Programming Assignment #6
//Due Date: Friday, April 16th 11:00pm
//Description:
//		Part A
//			NOTE: You are NOT allowed to define a new array in any part of the code.
//			Create the following functions: build_MaxHeap, max_heapify, heap_sort.
//			1. Request the user to enter a positive integer, and call it n.
//			2. Generate n random integers between -10000 to 10000 and save them in array a.
//			3. Call heap_sort function to sort the array. In order to sort the array using heapsort, you need to follow the
//			below steps:
//			3.1 Build a max-heap (call the function build_Maxheap). In order to build the max-heap follow the below
//			pseudocode:
//			% new_a is the output of the function, if you are using any other programming language, please write % return new_a at the end of your code.
//			a = build_MaxHeap(a)
//			n = length(a);
//			for i=n:-1:1 % i= n, n-1, n-2,.., 1, Can we start from n/2 instead of n? Why????
//			a(1:i) = max_heapify(a,i); % a(1:i) = contains a[1] a[2] ...a[i] (You could have a flag for the i too! (Assume that i is the index of the last element of the array! 😊)
//			end
//			3.2 Keep removing the roots (first element in a) one by one until the tree/array becomes empty.
//			4. Determine the average-running time of heap_sort function for n=1000, and 100 repetitions.
//			5. Compare your answer with the average-running time of selection sort (you need implement it).
//		Part B
//			1. Generate and print a random array of size 10.
//			2. Call heap_sort to sort the numbers.
//			3. Print the result.
//
//---------------------------------------------------------------------------------------------------------- 

import java.util.Scanner;

public class MaxHeap 
{
	
	// Constant variables
	public static final int MAX = 10000;
	public static final int MIN = -10000;
	public static final int ITERATIONS = 100;
	
	
	// --selectionSort-----------------------------------------------------------------------------------------
	//  
	//              
	// --------------------------------------------------------------------------------------------------------
	
	public static void selectionSort(int a[])
	{
		int size = a.length;
		for (int iIndex = 0; iIndex < size - 1; iIndex++)
		{
			int minimumIndex = iIndex;
			for (int jIndex = iIndex + 1; jIndex < size; jIndex++)
			{
				if(a[jIndex] < a[minimumIndex])
					minimumIndex = jIndex;
			}
			int tempValue = a[minimumIndex];
			a[minimumIndex] = a[iIndex];
			a[iIndex] = tempValue; 
		}

	}
	
	// --buildMaxHeap------------------------------------------------------------------------------------------
	//  
	//             
	// --------------------------------------------------------------------------------------------------------
	
	public static void buildMaxHeap(int a[])
	{
		int size = a.length;
		for(int index = size/2 - 1; index >= 0; index--)
		{
			maxHeapify(a, size, index);
		}
	}
	
	public static void maxHeapify(int a[], int size, int index)
	{
		int max = index;
		int leftChild = 2*index + 1;
		int rightChild = 2*index + 2;
		
		
		if(leftChild < size && a[leftChild] > a[max])
			max = leftChild;
		
		
		if(rightChild < size && a[rightChild] > a[max])
			max = rightChild;
		
		
		if ( max != index)
		{
			int tempValue = a[index];
			a[index] = a[max];
			a[max] = tempValue;
			maxHeapify(a,size,max);
		}
	}
	
	public static void heapSort(int a[])
	{
		int size = a.length;
		buildMaxHeap(a);
		
		
		for (int index = size - 1; index >= 0; index--)
		{
			int tempValue = a[0];
			a[0] = a[index];
			a[index] = tempValue;
			
			
			maxHeapify(a,index,0); 
		}
		

	}
	
	public static void heapSortPrint(int a[])
	{
		int size = a.length;
		buildMaxHeap(a);
		
		
		for (int index = size - 1; index >= 0; index--)
		{
			int tempValue = a[0];
			a[0] = a[index];
			a[index] = tempValue;
			
			
			maxHeapify(a,index,0); 
		}
		
		for (int i = 0; i < size; i++)
		{
			System.out.print(a[i] + " ");
		}
	}
	// --askQuestion-------------------------------------------------------------------------------------------
	//  Description:
	//              Step 1: Request the user to enter a positive integer, and call it n. (n = 1000)
	// --------------------------------------------------------------------------------------------------------
	public static int askQuestion()
	{
		// Scanner variable
		Scanner in = new Scanner(System.in);
		
		// Declare a variable n to store the positive integer the user enters
		int n = 0; 
		
		// Ask the user to enter a positive integer
		System.out.print("Enter a positive integer: ");
		
		// Store the value into n
		n = in.nextInt();
		
		// return n back to main
		return n;
		
	} // end of "askQuestion" method
	
	// --randomIntegers----------------------------------------------------------------------------------------
	// Description:
	//	              Step 2: Generate n random integers between -5000 to 5000 and save them in array a
	//
	// --------------------------------------------------------------------------------------------------------
	public static int [] randomIntegers(int n)
	{
		// Random variable
		Random rng = new Random();
		
		// Create an array object and declare the allocated space with "n"
		int [] array = new int[n];
		
		//Create a for loop to generate "n" random integers between -5000 and 5000
		for (int index = 0; index < array.length; index++) 
		{
			array[index] = rng.nextInt((MAX - MIN) + 1) + MIN;
		}
		
		// Return the populated array
		return array;
	} // end of "randomIntegers" method
	
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		
		// Part A:
		// Step 1: Request the user to enter a positive integer, and call it n.
		int n = askQuestion();
		
		// Step 2: Generate n random integers between -10000 to 10000 and save them in array a.
		/*
		Step 3. Call heap_sort function to sort the array. In order to sort the array using heapsort, you need to follow the
		below steps:
				3.1 Build a max-heap (call the function build_Maxheap). In order to build the max-heap follow the below
				pseudocode:
		
		% new_a is the output of the function, if you are using any other programming language, please write % return new_a at the end of your code.
		a = build_MaxHeap(a)
			n = length(a);
			for i=n:-1:1 % i= n, n-1, n-2,.., 1, Can we start from n/2 instead of n? Why????
				a(1:i) = max_heapify(a,i); % a(1:i) = contains a[1] a[2] ...a[i] (You could have a flag for the i too! (Assume that i is the index of the last element of the array! 😊)
			end
			
			3.2 Keep removing the roots (first element in a) one by one until the tree/array becomes empty.
		*/
		double startTime;
		double endTime;
		double heapSortTime;
		double selectionSortTime;
		double heapSortAverageTime = 0;
		double selectionSortAverageTime = 0;
		
		for(int index = 0; index < ITERATIONS; index++)
		{
			int array[] = randomIntegers(n);
			startTime = System.nanoTime();
			heapSort(array);
			endTime = System.nanoTime();
			heapSortTime = endTime - startTime;
			heapSortAverageTime += heapSortTime;
			
			startTime = System.nanoTime();
			selectionSort(array);
			endTime = System.nanoTime();
			selectionSortTime = endTime - startTime;
			selectionSortAverageTime += selectionSortTime;
			
		}
		
		System.out.println("Part A: ");
		System.out.println("Average-Running Time of Heap Sort: " + heapSortAverageTime / ITERATIONS + " nanoseconds");
		System.out.println("Average-Running Time for Insertion Sort: " + selectionSortAverageTime / ITERATIONS + " nanoseconds\n");
		
		// Part B
		System.out.println("Part B: ");
		int array[] = randomIntegers(10);
		heapSortPrint(array);
		
		
		
	}
}
