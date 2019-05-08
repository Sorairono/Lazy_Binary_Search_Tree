/**Student name: Long Nguyen
Class: CS3345
Section: 004 
Semester: Spring 2019
Project: 3
Description: Create a lazy binary search tree
*/

//Main class
/**
 *
 * @author Sorairono
 */
import java.util.*;
import java.io.*;
public class Project3 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) 
	{
		//Execute the main part of program if exactly 2 arguments are passed 
	    if (args.length == 2)
	    {
		    //Create a binary search tree
			LazyBinarySearchTree tree = new LazyBinarySearchTree();
			//Main part of main class
			try
			{
				//Scanner for input file
				Scanner inputFile = new Scanner(new File(args[0]));
				//Create a new file for output
				File file = new File(args[1]);
				file.createNewFile();
				//PrintWriter for output file
				PrintWriter outputFile = new PrintWriter(file);
				//Run through input file till end of it
				while (inputFile.hasNextLine())
				{
					//Get the line command
					String input = inputFile.nextLine().trim();
					//Array to store command
					String[] method = new String[2];
					//If the command is Insert, Delete, or Contains and have a number in it, split the command and the number
					if (input.contains(":") == true)
					{
						method = input.split(":");
					}
					//If the command is PrintTree, findMin, findMax, Height, Size
					else
					{
						method[0] = input;
					}
					//Switch case to do the appropriate command
					switch(method[0])
					{
						//Insert case: check if there is also a key in the command, call the insert method and throws IllegalArgumentException if key is invalid
						case "Insert":
							if (method[1] == null)
							{
								outputFile.println("Error in line: Insert");
							}
							else 
							{
								try
								{
									int number = Integer.parseInt(method[1]);
									boolean insert = tree.insert(number);
									outputFile.println(insert);
								}
								catch (IllegalArgumentException ex)
								{
									outputFile.println("Error in insert: IllegalArgumentException raised");
								}
							}
							break;
						//Delete case: check if there is also a key in the command, call the delete method and throws IllegalArgumentException if key is invalid
						case "Delete":
							if (method[1] == null)
							{
								outputFile.println("Error in line: Delete");
							}
							else 
							{
								try
								{
									int number = Integer.parseInt(method[1]);
									boolean delete = tree.delete(number);
									outputFile.println(delete);
								}
								catch (IllegalArgumentException ex)
								{
									outputFile.println("Error in delete: IllegalArgumentException raised");
								}
							}
							break;
						//FindMin case: find the minimum key of the tree, but return a message if the tree is empty
						case "FindMin":
							int min = tree.findMin();
							if (min == 0)
							{
								outputFile.println("The tree is empty or fully deleted");
							}
						    else
						    {
								outputFile.println(min);
						    }
							break;
						//FindMax case: find the maximum key of the tree, but return a message if the tree is empty
						case "FindMax":
							int max = tree.findMax();
							if (max == 0)
						  	{
								outputFile.println("The tree is empty or fully deleted");
						  	}
						  	else
						  	{
								outputFile.println(max);
						  	}
							break;
						//Contains case: check if there is also a key in the command, call the contains method and throws IllegalArgumentException if key is invalid
						case "Contains":
							if (method[1] == null)
							{
								outputFile.println("Error in line: Contains");
							}
							else
							{
								try
								{
									int number = Integer.parseInt(method[1]);
									boolean contain = tree.contains(number);
									outputFile.println(contain);
								}
								catch (IllegalArgumentException ex)
								{	
									outputFile.println("Error in contains: IllegalArgumentException raised");
								}
							}
							break;
						//PrintTree case: call the toString method to print the tree in pre-order traversal
						case "PrintTree":
							String str = tree.toString();
							outputFile.println(str);
							break;
						//Height case: call the height method to return the height of the tree
						case "Height":
							int height = tree.height();
							outputFile.println(height);
							break;
						//Size case: call the size method to return the size of the tree
						case "Size":
							int size = tree.size();
							outputFile.println(size);
							break;
						//Default case: Print out an error message indicating the command is invalid
						default:
							outputFile.println("Error in line: " + method[0]);
					}
				}
				//Close the files
				inputFile.close();
				outputFile.close();
			}
			//Catch exception of being unable to find input file or open file
			catch (Exception ex)
			{
				System.out.println("File is not found");
			}
	    }
	    //If less or more than 2 arguments is passed into the program
	    else
	    {
			System.out.println("Please give valid arguments to the command line.");
	    }
	}
	
}
