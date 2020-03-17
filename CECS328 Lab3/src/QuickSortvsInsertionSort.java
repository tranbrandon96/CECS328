// -----------------------------------------------------------------------------------------------------------
// Name: Brandon Tran
// Date: March 11, 2019
// Due Date: Saturday, March 12th, 12:00am
// Programming Assignment #3
// Description:
//              Implement two functions named quick_sort and insertion_sort
//
// ------------------------------------------------------------------------------------------------------------
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class QuickSortvsInsertionSort 
{
	// Constant variables
	public static final int MAX = 5000;
	public static final int MIN = -5000;
	public static final int ITERATIONS = 100;
	
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
	
	// --partition---------------------------------------------------------------------------------------------
	// Description:
	//	              Use partition for quickSort
	//
	// --------------------------------------------------------------------------------------------------------
	
	public static int partition(int array[], int left, int right)
	{
			// iMarker starts on the previous position of the start of the array
			int iMarker = left - 1;
			
			// Set Pivot Marker to be on the last number of the array
			int pivotMarker = array[right];

			for (int jMarker = left; jMarker < right; jMarker++)
			{
				// This if statement is used for when the pivot value is greater than the jMarker
				if(pivotMarker > array[jMarker])
				{
					iMarker++;
					int temp = array[jMarker];
					array[jMarker] = array[iMarker];
					array[iMarker] = temp;
				}
			}
			
			// After the for loop ends, the pivotValue will be swapped with the iMarker + 1 value to correctly
			// set up the partition of where the value that is less than the pivot will be on the left and the 
			// values that is greater than the pivot will be on the right. 
			int temp = array[iMarker + 1];
			array[iMarker + 1] = array[right];
			array[right] = temp;

			return iMarker + 1;
	}

	
	// --quickSort---------------------------------------------------------------------------------------------
	// Description:
	//	              Call it quickSort function to sort the array
	//
	// --------------------------------------------------------------------------------------------------------
	
	public static void QuickSort(int array[], int left, int right)
	{
		if (left < right)
		{
		    // Get the pivotIndex to consistently use for the recursive function
			int pivotIndex = partition(array, left, right);
		    
			// Utilize a recursive call to divide the array
			QuickSort(array, left, pivotIndex - 1);
		    QuickSort(array, pivotIndex + 1, right);
		}
		else
		{
			return;
		}
	    
	} // end of "quickSort" method
	
	// --insertionSort-----------------------------------------------------------------------------------------
	// Description:
	//	              Call it insertionSort function to sort the array
	//
	// --------------------------------------------------------------------------------------------------------

	public static void InsertionSort(int array[], int n)
	{
		for(int index = 1; index < n; index++)
        {
            // Current value for the current index
			int currentValue  = array[index]; 
			
			// Previous position of the array
            int previousPosition = index - 1;
            
            // Creating a loop to find the index that is equal to the current value
            while((currentValue < array[previousPosition]) && (previousPosition >= 0))
            {
               
            	array[previousPosition + 1] = array[previousPosition];
                previousPosition--;
            }
            
            // Swap the numbers
            array[previousPosition + 1] = currentValue;
            
        }
	} // end of "insertionSort" method

	public static void main(String[]args)
	{
		// Step 1: Request the user to enter a positive integer, and call it n. (n = 1000)
		int n = askQuestion();
	   
	    // Step 2: Generate n random integers between -5000 to 5000 and save them in array a
	    // Step 3: Call it quickSort and insertionSort functions to sort t`he array
	    // Step 4: Repeat steps 2 and 3 for 100 times to determine the average-running time of each function
	    // Step 5: Print the end/finish time for your function. (Note: to be more precise, the time to generate
	    //         a random array in each iteration should be excluded from the result)
		double startTime;
		double endTime;
		double insertionSortTime;
		double quickSortTime;
		double insertionSortAverageTime = 0;
		double quickSortAverageTime = 0;
		
		int left = 0;
		int right = n - 1;
		
		for(int index = 0; index < ITERATIONS; index++)
		{
			int array[] = randomIntegers(n);
			startTime = System.nanoTime();
			QuickSort(array, left, right);
			endTime = System.nanoTime();
			quickSortTime = endTime - startTime;
			quickSortAverageTime += quickSortTime;
			
			startTime = System.nanoTime();
			InsertionSort(array, n);
			endTime = System.nanoTime();
			insertionSortTime = endTime - startTime;
			insertionSortAverageTime += insertionSortTime;
			
		}
		
		System.out.println("Average-Running Time of Quick Sort: " + quickSortAverageTime / ITERATIONS + " nanoseconds");
		System.out.println("Average-Running Time for Insertion Sort: " + insertionSortAverageTime / ITERATIONS + " nanoseconds");
		
		
	    
	    // Step 6: Calculate the growth of each function. (On a scratch paper!)
	    // Step 7: Write a code to calculate how much instructions your machine/laptop can run in a second
	    //         using step 5 and 6 using the insertion sort.
		double singleInsertionStep = insertionSortAverageTime  / (n * n);
		double instructions = 1 / (singleInsertionStep);
		
		System.out.println("Instructions: " + instructions + " nanoseconds");
		
		
	}
}
