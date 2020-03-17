package cecs328lab2;

import java.util.Scanner;
public class BinarySearch 
{
	// --------------------------------------------------------------------------------------------------------------------------------
	// Question 1. Implementing the square root function: Write a function that asks a user to enter an integer N and returns [n^1/2]
	// Note: You are NOT allowed to use the predefined sqrt function in the programming language you are using. 
	//
	// --------------------------------------------------------------------------------------------------------------------------------
	
	// --squareRoot--------------------------------------------------------------------------------------------------------------------
	//
	// --------------------------------------------------------------------------------------------------------------------------------
	public static int squareRoot()
	{
		// Include Scanner
		Scanner in = new Scanner(System.in);
		
		// Create a variable to store the N integer for the user
		int N = 0;
		
		// Ask the user to enter an integer N
		System.out.print("Enter an integer N: ");
		
		// Store the value into usersInt
		N = in.nextInt();
		
		// Create the markers to use for the Binary Search Theorem
		double start = 1;
		double end = N;
		int middle = 0;
		int answer = 0;
		
		// Slightly modified algorithm of Binary Search Theorem
		while (start <= end)
		{
			// Math.ceil needs to be type casted to int because the original method deals with a double 
			// or else it will give us a compiler error.
			middle = (int) Math.ceil((start + end) / 2);
			
			// We can update the answer when middle * middle is greater than N.
			// This will enable us to solve for the ceiling number.
			if (middle * middle > N)
			{
				end = middle - 1;
				answer = middle;
			}
			
			// If middle * middle is greater than N
			else if (middle * middle < N)
				start = middle + 1;
			
			// If N is a perfect square
			else if (middle * middle == N)
				return middle;
				
		}
		
		// Return the answer to the user for what the square root of their value is 
		return answer;
	}
	// -----------------------------------------------------------------------------------------------------------------------------------
	
	// -----------------------------------------------------------------------------------------------------------------------------------
	// Question2. Ask the user to enter a random binary array having the first K numbers equal to 0 and the rest equal to 1. Write a 
	//            a function to find the position of K that splits the 0s and 1s.
	// Example: input a = [0 0 0 1 1 ] -> output: K = 3
	//
	// -----------------------------------------------------------------------------------------------------------------------------------
	
	// --binarySearch---------------------------------------------------------------------------------------------------------------------
	//
	// -----------------------------------------------------------------------------------------------------------------------------------
	
	public static int binarySearch()
	{
		// Include Scanner
		Scanner in = new Scanner(System.in);
		
		// Ask the user to enter a random binary array
		System.out.print("Enter a random binary array having the first K numbers equal to 0 and the rest equal to 1: ");
		
		// Store the binary array into a String
		String binaryArray = in.nextLine();
		
		// Create an array of integers and allocate space of what the user entered in for the random binary array
		int array[] = new int[binaryArray.length()];
		
		// Take the random binary array from the user and store each individual integer into an array of integer
		// Character.getNumericValue works as using "charAt(index)" to get the char ASCII value and turning it into their 
		// corresponding integer values. For example: the char ASCII value for "0" will turn into an integer of "0". 
		// Same as the char ASCII value for "1" will turn into an integer of "1"
		for(int index = 0; index < binaryArray.length(); index++) 
		{
			array[index] = Character.getNumericValue(binaryArray.charAt(index));		
		}
		
		// Create the markers to use for the Binary Search Theorem
		int start = 0;
		int end = array.length - 1;
		int middle = 0;
		
		// Slightly modified Binary Search Algorithm
		while (start <= end) 
		{
			// Obtain your middle by dividing the array by 2
			middle = (start + end) / 2;
			
			// If the middle array is equal to 0
			if (array[middle] == 0) 
			{
				// This case will work out for a binary array when the first number on the right of the middle array is 0
				// EX: [00001] -> K = 4
				// When your start gets updated, your middle will get updated as well. This will increment the middle 
				// as well as continue to check every first number on the right of the middle array is 1 before it returns
				// when the index of the split is.
				if(array[middle + 1] == 0)
					start = middle + 1;
				
				// This case will work out for binary array when the first number on the right of the middle array is 1
				// EX: [00011] -> K = 3
				// This will easily return the the split because the number "1" was found on the right side of the middle array
				else if (array[middle + 1] == 1) 
					return middle+1;
				
			}
			
			// If the middle array is equal to 1
			else if (array[middle] == 1) 
			{
				// This case will work out for a binary array when the first number on the left of the middle array is 1
				// EX: [01111] -> K = 1
				// When your end gets updated, your middle will get updated as well. This will decrement the middle as well 
				// as continue to check every first number on the right of the middle array is 1 before it returns when the index
				// of the split is. 
				if( array[middle - 1] == 1) 
					end = middle -1;
				
				// This case will work out for binary array when the first number on the left of the middle array is 0
				// EX: [00111] -> K = 2
				// This will easily return the split because the number "0" was found on the left side of the middle array
				else if( array[middle - 1] == 0) 
					return middle;
			}
		}
		
		// Return -1 to show that the split was not found
		return -1;

	}
	
	// ------------------------------------------------------------------------------------------------------------------------------
	
	// --main------------------------------------------------------------------------------------------------------------------------
	//
	// ------------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args)
	{
		// Print out result for the square root
		System.out.println("The ceiling square root of your number is: " + squareRoot());
		
		// Run the Binary Search Method to ask the user for a random binary array and find the split.
		// Store the answer into split
		int split = binarySearch();
		
		// If split is "-1", the split was not found
		if (split == -1)
			System.out.println("K is not found in the binary array");
		
		// If split is any other number except "-1", the split was found
		else
			System.out.println("K is found in the Binary Array at: Index " + split);
		
	}
	
	// ------------------------------------------------------------------------------------------------------------------------------
}
