Name: Long Nguyen (ltn170130)
Class: CS3345
Section: 004 
Semester: Spring 2019
Project: 3
IDE used: NetBeans
Files: LazyBinarySearchTree.java, Project3.java(Main Class)

Run the program on: NetBeans IDE 8.2

1. Create a project on NetBeans, then put the two files LazyBinarySearchTree.java and Project3.java in the default package of the project

2. In the same working directory (default package of newly created project), create a file serves as input file of project

3. On the top left of NetBeans window, choose File -> Project Properties(project_name)

4. A new window pop up, choose Run Categories, then fillout Arguments and Working Directory:

	- Fillout Arguments with 2 arguments: the first one is input file name, and the second one is output file name, seperated by a whitespace
	- Fillout Working Directory with current directory of the project

5. The program will create a new file with name as passed from the arguments, and results are contained in this file.
(if the file already exist in the working directory (e.g. run the program twice with different content of input file), output file content will be re-wrote)

The program runs perfectly, with all the Exception are caught(including unable to open/read files, not just invalid key arguments)

Insert:98
Insert:67
Insert:55
Insert:45
PrintTree
Delete:84
Delete:45
Contains:45
FindMin
FindMax
PrintTree
Height
Size
Insert:84
Insert:32
Insert:132
PrintTree
Insert:980
Insert
hih

true
true
true
true
98 67 55 45 
false
true
false
55
98
98 67 55 *45 
4
4
true
true
Error in insert: IllegalArgumentException raised
98 67 55 *45 32 84 
Error in insert: IllegalArgumentException raised
Error in line: Insert
Error in line: hih
