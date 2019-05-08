/**Student name: Long Nguyen
Class: CS3345
Section: 004 
Semester: Spring 2019
Project: 3
Description: Create a lazy binary search tree
*/

//LazyBinarySearchTree class
/**
 *
 * @author Sorairono
 */
public class LazyBinarySearchTree 
{
	//TreeNode class
    class TreeNode
	{
		int key;
		TreeNode leftChild, rightChild;
		boolean deleted;
		public TreeNode (int data)
		{
			key = data;
			leftChild = rightChild = null;
			deleted = false;
		}
	}
	//Variables for class
	private TreeNode root;
	private int delete = 0;
	//Default constructor
	public LazyBinarySearchTree()
	{
		root = null;
	}
	//Overloaded Constructor
	public LazyBinarySearchTree(TreeNode node)
	{
		root = node;
	}
	//Method to insert a new key to the tree
	public boolean insert(int key) throws IllegalArgumentException
	{	
		//throws IllegalArgumentException if the key is not in range 1-99
		if (key < 1 || key > 99)
		{
			throw new IllegalArgumentException("This key is invalid");
		}
		//Create a TreeNode with given key
		TreeNode x = new TreeNode(key);
		//If the tree is empty, the new created TreeNode becomes root of the tree
		if (root == null)
		{
			root = x;
			return true;
		}
		//Temporary TreeNode to traverse the tree
		TreeNode temp_y = null, temp_z = root;
		while (temp_z != null)
		{
			temp_y = temp_z;
			if (temp_z.key > key)
			{
				temp_z = temp_z.leftChild;
			}
			else if (temp_z.key < key)
			{
				temp_z = temp_z.rightChild;
			}
			//The key given match to an already existed key in the tree
			else
			{
				//If the key is deleted, undelete it
				if (temp_z.deleted == true)
				{
					temp_z.deleted = false;
					delete--;
					return true;
				}
				//The key already exist and not deleted, then do nothing
				else
				{
					return false;
				}
			}
		}
		//Add the TreeNode with new key to the leaf
		if (temp_y.key > key)
		{
			temp_y.leftChild = x;
			return true;
		}
		else 
		{
			temp_y.rightChild = x;
			return true;
		}
	}
	//Method to delete a specific key from the tree
	public boolean delete(int key) throws IllegalArgumentException
	{	
		//throws IllegalArgumentException if the key is not in range 1-99
		if (key < 1 || key > 99)
		{
			throw new IllegalArgumentException("This key is invalid");
		}
		//If the tree is empty, return false
		if (root == null)
		{
			return false;
		}
		//Temporary TreeNode to traverse the tree
		TreeNode temp = root;
		while (temp != null)
		{
			if (temp.key > key)
			{
				temp = temp.leftChild;
			}
			else if (temp.key < key)
			{
				temp = temp.rightChild;
			}
			else
			{
				//Found the key, and delete it
				if (temp.deleted == false)
				{
					temp.deleted = true;
					delete++;
					return true;
				}
				//Found the key, but it is already deleted
				else 
				{
					return false;
				}
			}
		}
		//Given key is not found in the tree
		return false;
	}
	//Method to find minimum key of the tree
	public int findMin()
	{
		if (root == null || delete == size())
		{
			return 0;
		}
		return findMin(root).key;
	}
	//Overload method to find minimum
	public TreeNode findMin(TreeNode node)
	{
		//Go to the left of tree, and if the keys to the left leaf are deleted...
		if (findLeftTree(node) == true)
		{
			return findMin(node.leftChild);
		}
		//Return the current key if it is not deleted...
		else if (node.deleted == false)
		{
			return node;
		}
		//Or go to the right of current node if the right sub tree exists
		else if (findRightTree(node) == true)
		{
			return findMin(node.rightChild);
		}
		else 
		{
			return null;
		}
	}
	//Method to find maximum key of the tree
	public int findMax()
	{
		if (root == null || delete == size())
		{
			return 0;
		}
		return findMax(root).key;
	}
	//Overload method to find maximum key of the tree
	public TreeNode findMax(TreeNode node)
	{	
		//Go to the right of the tree, and if the keys to the right leaf are deleted...
		if (findRightTree(node) == true)
		{
			return findMax(node.rightChild);
		}
		//Return the current node if it is not deleted...
		else if (node.deleted == false)
		{
			return node;
		}
		//Or go to the right subtree of the current node if it exists
		else if (findLeftTree(node) == true)
		{
			return findMax(node.leftChild);
		}
		else
		{
			return null;
		}
	}
	//Find left subtree of a node
	public boolean findLeftTree(TreeNode node)
	{
		if (node == null)
		{
			return false;
		}
		//Exist a node to the left of current node
		else if (node.leftChild != null)
		{
			//This node is not deleted
			if (node.leftChild.deleted == false)
			{
				return true;
			}
			//The left node of current node is deleted; recursive down to the leaf from this left node of current node to see if any node is not deleted
			else if (findLeftTree(node.leftChild) == true || findRightTree(node.leftChild) == true)
			{
				return true;
			}
			//Left subtree doesn't exist
			else
			{
				return false;
			}
		}
		//There is no left node
		else 
		{
			return false;
		}
	}
	//Find right subtree of a node
	public boolean findRightTree(TreeNode node)
	{
		if (node == null)
		{
			return false;
		}
		//Exist a node to the right of current node
		else if (node.rightChild != null)
		{
			//This node is not deleted
			if (node.rightChild.deleted == false)
			{
				return true;
			}
			//The right node of current node is deleted; recursive down to the leaf from this left node of current node to see if any node is not deleted
			else if (findLeftTree(node.rightChild) == true || findRightTree(node.rightChild) == true)
			{
				return true;
			}
			//Right subtree doesn't exist
			else 
			{
				return false;
			}
		}
		//There is no right node
		else 
		{
			return false;
		}
	}
	//Method to check if the tree contains a specific key
	public boolean contains(int key) throws IllegalArgumentException
	{
		//throws IllegalArgumentException if the key is not in range 1-99
		if (key < 1 || key > 99)
		{
			throw new IllegalArgumentException("This key is invalid");
		}
		if (root == null)
		{
			return false;
		}
		//Temporary TreeNode to traverse the tree
		TreeNode temp = root;
		while (temp != null)
		{
			if (temp.key > key)
			{
				temp = temp.leftChild;
			}
			else if (temp.key < key)
			{
				temp = temp.rightChild;
			}
			else
			{
				//Found the key and it is not deleted, return true
				if (temp.deleted == false)
				{
					return true;
				}
				//Found the key but it is deleted, return false
				else 
				{
					return false;
				}
			}
		}
		//The key is not found in the tree
		return false;
	}
	//Method to print the tree pre-order traversal
	public String toString()
	{
		return toString(root);
	}
	//Overload method to print the tree
	public String toString(TreeNode node)
	{
		if (node == null)
		{
			return "";
		}
		String str = "";
		String str1 = "";
		String str2 = "";
		if(node.deleted == false) 
		{
			str = str + node.key + " ";
		} 
		else  //If the node is deleted, add an asterisk before the key value
		{
			str = str + "*" + node.key + " ";
		}
		str1 = toString(node.leftChild);
		str2 = toString(node.rightChild);
		return str + str1 + str2;
	}
	//Method to get height of the tree
	public int height()
	{
		return height(root);
	}
	//Overload method of height
	public int height(TreeNode node)
	{
		if (node == null)
		{
			return 0;
		}
		else
		{
			int leftHeight = height(node.leftChild);
			int rightHeight = height(node.rightChild);
			if (leftHeight > rightHeight)
			{
				return (leftHeight + 1);
			}
			else 
			{
				return (rightHeight + 1);
			}
		}
	}
	//Method to get size of the tree
	public int size()
	{
		return size(root);
	}
	//Overload method of size
	public int size(TreeNode node)
	{
		if (node == null)
		{
			return 0;
		}
		else 
		{
			return (size(node.leftChild) + size(node.rightChild) + 1);
		}
	}
}
