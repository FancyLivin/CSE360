//Author: Yamaan Khan
//Class ID: 439
//Assignment #: 2
//Description: This class creates an array of 10 numbers and can then alter the array
//				by adding and removing values and can display different parts of said array.

package cse360assign2;

public class SimpleList {

	//Instantiating private variables for later use within class
	private int[] list;
	private int count;

	//Instantiates the SimpleList constructor with an array of 10 unassigned values and setting count equal to 0
	public SimpleList() {
		list = new int[10];
		count = 0;
	}

	//This method will add a specified value to index 0 of the array
	//Every time a value is added all other values will shift over one space to the right
	//If more than 10 values are in the array, the last value will be removed from the array
	public void add(int item) {
		//A check to make sure there is no out of bounds exception
		if (count == 10) {
			count--;
		}
		//For loop that moves up each value 1 index up
		for (int loop1 = count; loop1 > 0; loop1--) {
			list[loop1] = list[loop1 - 1];
		}
		list[0] = item;
		//Ensures only 10 values can be in the array at max
		if (count != 10) {
			count++;
		}
	}

	//This method will remove a specified value from the list
	public void remove(int item) {
		int correctIndex = 9;
		//Ensures there is no out of bounds exceptions
		if (count == -1) {
			count++;
		}
		//For loop that removes specified value if it exists in the array
		//Once removed, inner for loop will move values to the right 
		//of the array will move one over to the left
		for (int loop1 = 0; loop1 < correctIndex; loop1++) {
			if (list[loop1] == item) {
				count--;
				for (int loop2 = loop1; loop2 < list.length - 1; loop2++) {
					list[loop2] = list[loop2 + 1];
					correctIndex = 0;
				}
				//The value that wasn't moved over one to the left is set to 0
				list[count] = 0;
			}
		}
	}

	//Returns the total number of values that are in the array
	public int count() {
		return count;
	}

	//Prints out all values in the array as a string
	//Will print out the number with a space in between each value
	public String toString() {
		String fullArray = "";
		if (count != 0) {
			//Adds the first index to the string
			fullArray += list[0];
			//For loop that adds a space and the next value up until the last value in the array to the string
			for (int loop1 = 1; loop1 < count; loop1++) {
				fullArray += " " + list[loop1];
			}
		}
		//Returns the string
		return fullArray;
	}

	//Searches for the specified value's index in the array and returns that value
	public int search(int look) {
		int correctIndex = 10;
		int searchCount = 0;
		//Goes through the entire loop to see if the value is in the array
		for (int loop1 = 0; loop1 < correctIndex; loop1++) {
			if (list[loop1] == look) {
				correctIndex = searchCount;
			}
			searchCount++;
		}
		if (correctIndex + 1 > count) {
			//Will return -1 if the specified value is not in the array
			return -1;
		} else {
			//Will return the index of the value if it was found in the array
			return correctIndex;
		}
	}
}
