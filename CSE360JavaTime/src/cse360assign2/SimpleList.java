// Author: Yamaan Khan
// Class ID: 439
// Assignment #: 2
// Description: This class creates an array of 10 numbers and can then alter the array
//				by adding and removing values and can display different parts of said array.

package cse360assign2;

/**
 * Creation of the class SimpleList
 * 
 * @author Yamaan Khan
 */
public class SimpleList 
{

	// Instantiating private variables for later use within class
	private int[] list;
	private int count;

	/**
	 * SimpleList constructor
	 */
	public SimpleList() 
	{
		list = new int[10];
		count = 0;
	}
	
	/**
	 * This method will add a specified value to index 0 of the array
	 * Every time a value is added all other values will shift over one space to the right
	 * If more than 10 values are in the array, the last value will be removed from the array
	 * 
	 * @param item  the value that will be added to the beginning of the list
	 */
	public void add(int item) 
	{
		// Will increase list size by 50% if overflow occurs
		if (count == list.length) 
		{
			int oldCount = count - 1;
			int[] newList = new int[count + count / 2];
			
			for (int loop2 = 0; loop2 <= oldCount; loop2++) 
			{
				newList[loop2] = list[loop2];
			}
			list = newList;
		}
		
		// For loop that moves up each value 1 index up
		for (int loop1 = count; loop1 > 0; loop1--) 
		{
			list[loop1] = list[loop1 - 1];
		}
		
		// The inputed value is added to the beginning of the list and count is incremented
		list[0] = item;
		count++;
	}

	/**
	 * Will remove the inputed value whenever it is first observed in the list
	 * If the integer is not in the list, then no value will be removed
	 * 
	 * @param item  the value that will be removed from the list
	 */
	public void remove(int item) 
	{
		int correctIndex = 9;
		
		// Ensures there is no out of bounds exceptions
		if (count == -1) 
		{
			count++;
		}
		
		// Shrinks list if there are more than 25% empty values in the list
		if (count < list.length - list.length / 4) 
		{
			int oldCount = count - 1;
			int [] newList = new int[list.length - list.length / 4];
			
			for (int loop2 = 0; loop2 <= oldCount; loop2++) 
			{
				newList[loop2] = list[loop2];
			}
			
			list = newList;
		}
		
		// For loop that removes specified value if it exists in the array
		// Once removed, inner for loop will move values to the right 
		// of the array will move one over to the left
		for (int loop1 = 0; loop1 < correctIndex; loop1++) 
		{
			if (list[loop1] == item) 
			{
				count--;
				for (int loop2 = loop1; loop2 < list.length - 1; loop2++) 
				{
					list[loop2] = list[loop2 + 1];
					correctIndex = 0;
				}
				
				// The value that wasn't moved over one to the left is set to 0
				list[count] = 0;
			}
		}
	}

	/**
	 * This method shows how many values are currently in list
	 * 
	 * @return count  the total number of values in the list
	 */
	public int count() 
	{
		return count;
	}

	/**
	 * Will display all values in list as a string
	 * Each value will be separated by a space when being printed out 
	 * 
	 * @return fullArray  all the values in the list returned as a string
	 */
	public String toString() 
	{
		String fullArray = "";
		if (count != 0) 
		{
			// Adds the first index to the string
			fullArray += list[0];
			
			// For loop that adds a space and the next value up until the last value in the array to the string
			for (int loop1 = 1; loop1 < count; loop1++) 
			{
				fullArray += " " + list[loop1];
			}
		}
		
		// Returns the string
		return fullArray;
	}

	/**
	 * Will return the index that the inputed value is located at
	 * If the value is not in the list, then -1 will then be returned
	 * 
	 * @param look  value that is being searched for
	 * @return -1  value that is returned when list is empty
	 * @return correctIndex  index value that is returned when look parameter is found
	 */
	public int search(int look) 
	{
		int correctIndex = count;
		int searchCount = 0;
		
		// Goes through the entire loop to see if the value is in the array
		for (int loop1 = 0; loop1 < correctIndex; loop1++) 
		{
			if (list[loop1] == look) 
			{
				correctIndex = searchCount;
			}
			
			searchCount++;
		}
		
		if (correctIndex + 1 > count) 
		{
			// Will return -1 if the specified value is not in the array
			return -1;
		}
		
		// Will return the index of the value if it was found in the array
		return correctIndex;
	}
	
	/**
	 * Function returns the first value in the list
	 * If the list is empty, then the function will return -1
	 * 
	 * @return -1  value returned when list is empty
	 * @return list[0]  the first value in the list
	 */
	public int first() 
	{
		// Return -1 if list is empty
		if (count == 0) 
		{
			return -1;
		}
		
		// Return value in list from index 0
		return list[0];
	}
	
	/**
	 * Returns the possible number of values that can be inputed into list
	 * 
	 * @return list.length  current number of possible locations in list
	 */
	public int size() 
	{
		return list.length;
	}
	
	/**
	 * Function will add inputed value to the end of the list
	 * 
	 * @param item  value that will be added
	 */
	public void append (int item) 
	{
		// Will increase list size by 50% if overflow occurs
		if (count == list.length) 
		{
			// Instantiate variables for the loop
			int oldCount = count - 1;
			int[] newList = new int[count + count / 2];
			
			// Loop adds all values from list into newList 
			for (int loop2 = 0; loop2 <= oldCount; loop2++) 
			{
				newList[loop2] = list[loop2];
			}
			
			// list is updated with a larger size
			list = newList;
		}
		
		// Adds the inputed integer to the end of list and increments count
		list[count] = item;
		count++;
	}
}
