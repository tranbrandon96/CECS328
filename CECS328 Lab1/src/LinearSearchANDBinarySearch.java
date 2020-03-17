import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.text.DecimalFormat;

/** LinearSearch and Binary Search Class
 * 
 * @author Brandon Tran
 *
 */
public class LinearSearchANDBinarySearch 
{
	//Using Linear Search to find the key in the array
	public static boolean LinearSearch(int[] a, int key) 
	{
		//Iterate through the whole array to find the key
		for (int index = 0; index < a.length; index++) 
		{
			//Once you find the key, return true to show that you have successfully found the key
			if(a[index] == key) 
			{
				return true; 
			}	
		}
		//If the for loop was unable to find the key, return false to show that you have unsuccessfully found the key
		return false; 
	}
	
	//Using Binary Search to find the key in the array
	//Key Points of using a Binary Search Tree is to start in the middle. 
	//Based on the key value you need to find, you can decide whether you need to go
	//left or right to find the value because when you go left, the value is lower and vice versa.
	public static boolean BinarySearch(int[] a, int key) 
	{
		//Set up initial markers for start and end
		int start = 0;
		int end = a.length - 1;
		
		while (end >= start)
		{
			//Set up middle marker 
			int mid = (start + end) / 2;
			
			//If the middle is the key, return true to show that the key is successfully found
			if(a[mid] == key)
				return true;
			
			//If the key is greater than the mid value, discard the left side of the array
			else if(a[mid] < key)
				start = mid + 1;
				
			//If the mid array value is greater than the key, discard the right side of the array
			else if(a[mid] > key)
				end = mid - 1;
		}
		
		//Return false if the key is unsuccessfully found
		return false;
	}
	
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		Random rng = new Random();
		
		//-------------------------------------------------------------------------------------------//
		//Part A
		//Step 1: Request the user to enter a positive integer and call it n
		
		System.out.println("Part A:");
		//Variable Declaration for Step 1
		int n;
		//Ask the user for a positive integer
		System.out.print("Enter a positive integer: ");
		//Store the value
		n = in.nextInt();
		//Create an array object and declare the allocated space with "n"
		int[] a = new int[n];
		
		//Step 2: Generate n random integers between -1000 to 1000 and save them in array a
		
		//Create a for loop to generate "n" random integers between -1000
		for(int index = 0; index < a.length; index++)
		{
			//Store each random value into "a"
			//Range = ((Maximum - Minimum) + 1) + Minimum
			a[index] = rng.nextInt((1000 + 1000) + 1) - 1000;
			System.out.print(a[index]);
		}
		
		//Step 3: Sort "a" (you can use any sorting algorithm you want.)
		Arrays.sort(a);
		
		//Step 4: Pick a random number in "a" and save it in variable called key
		//Step 5: Call each function separately to search for the key the given array
		//Step 6: To calculate the average-running time, you need to have a timer to repeat step 4
		//		  and 5 for 100 times
		
		//Variable Declarations for Step 4,5,6
		int key;
		double start;
		double end;
		double binarytime = 0;
		double lineartime = 0;
		double binarytotaltime = 0;
		double lineartotaltime = 0;
		
		//Create a for loop to calculate the average running time
		int times = 100;
		for(int index = 0; index < times; index++)
		{
			// Search for the key by setting the key equal to a value in the array
			key = a[rng.nextInt(n)];
		
			//Start timer for Linear Search
			start = System.nanoTime();
			//Call to Linear Search to find the key
			LinearSearch(a, key); 
			//End timer for Linear Search
			end = System.nanoTime();
			//Calculate the linear time through each iteration
			lineartime = end - start;
			//Calculate the total linear time while each iteration is being added together for the average
			lineartotaltime += lineartime;
			
			//Start timer for Binary Search
			start = System.nanoTime();
			//Call to Binary Search to find the key
			BinarySearch(a, key);
			//End timer for Binary Search
			end = System.nanoTime();
			//Calculate the Binary Time through each iteration
			binarytime = end - start;
			//Calculate the total Binary Time while each iteration is being added together for the average
			binarytotaltime += binarytime;
			
		}
		
		//Print out Average Linear Search Time and Average Binary Search TIme
		System.out.println("Average Linear Search Time: " + lineartotaltime / times + " nanoseconds");
		System.out.println("Average Binary Search Time: " + binarytotaltime / times + " nanoseconds\n");
		
		//-------------------------------------------------------------------------------------------------//
		
		//Part B
		System.out.println("Part B:");
		//Step 1: Repeat steps 1 - 3 in part A
		//Ask the user for a positive integer
		System.out.print("Enter a positive integer: ");
		//Store the value into "n"
		n = in.nextInt();
		//Initialize the array object and declare the allocated space with "n"
		a = new int[n];
				
		//Generate n random integers between -1000 to 1000 and save them in array a
				
		//Create a for loop to generate "n" random integers between -1000
		for(int index = 0; index < a.length; index++)
		{
			//Store each random value into "a"
			//Range = ((Maximum - Minimum) + 1) + Minimum
			a[index] = rng.nextInt((1000 + 1000) + 1) - 1000;
		}
				
		//Sort "a" (you can use any sorting algorithm you want.)
		Arrays.sort(a);
		
		//Step 2: Now to have the worse-case scenario, set the value of the key to 5000 to make sure it does not exist in the array
		int newKey = 5000;
		
		//Step 3: Run each function ONLY once to calculate the worst-case running time when n = 10^5
		//Worse Case Scenario for Linear Search 
		
		System.out.println("n = 10^5: ");
		//Start timer for Linear Search
		start = System.nanoTime();
		//Call to Linear Search to find the key
	    LinearSearch(a, newKey); 
	    //End timer for Linear Search
	    end = System.nanoTime();
		//Calculate the linear time through each iteration
	    lineartime = end - start;
	    
	    System.out.println("Worse Case for Linear Search Time: " + lineartime + " nanoseconds");
			
	    //Worse Case Scenario for Binary Search
	    //Start timer for Binary Search
		start = System.nanoTime();
		//Call to Binary Search to find the key
		BinarySearch(a, newKey); 
		//End timer for Binary Search
		end = System.nanoTime();
		//Calculate the Binary Time through each iteration
		binarytime = end - start;
		System.out.println("Worse Case for Binary Search Time: " + binarytime + " nanoseconds");
		
		//Step 4: Calculate how much time your machine takes to run on a single step using your binary 
		//        search function. (Hint: look at HW4)
		
		DecimalFormat DF = new DecimalFormat("####000.00");
		double singleStep = binarytime / Math.log(n) / Math.log(2);
	
		System.out.println("The time your machine takes to run on a single step using binary search:  " + 
				            DF.format(singleStep) + " nanoseconds" );
	
	    //Step 5: Now using the previous step, write a code to calculate the worse-case running
		//        time for every algorithm when n = 10^7
		System.out.println("\nn = 10^7: ");
		
		//Set n = 10^7
		n = 10000000;
		//Worse Case for Linear Search
		double worseCase = singleStep * n;
		System.out.println("Worse Case for Linear Search Time: " + worseCase + " nanoseconds");
		
		//Worse Case for Binary Search
		worseCase = singleStep * (Math.log(n) / Math.log(2));
		System.out.println("Worse Case for Binear Search Time: " + worseCase + " nanoseconds");
		
	}
}
