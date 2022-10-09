# ioet-JuniorSoftware-ACME

Exercise

The company ACME offers their employees the flexibility to work the hours they want. But due to some external circumstances they need to know what employees have been at the office within the same time frame

The goal of this exercise is to output a table containing pairs of employees and how often they have coincided in the office.

Input: the name of an employee and the schedule they worked, indicating the time and hours. This should be a .txt file with at least five sets of data.

----------------------------------------------------------------------
----------------------------------------------------------------------

This project is coded in Java language, using the SDK Java 19 version and the IntelliJ IDE.

----------------------------------------------------------------------

How To RUN:

After compile and generate the Class folder run the program like:
```
  java.exe -classpath D:\heldigard_Github\ioet-JuniorSoftware-ACME\out\production\TestIOET com.eldi.java.Main input1.txt
```
Noted that the firts argument is the input.txt file with is in the root folder of running, this case: D:\heldigard_Github\ioet-JuniorSoftware-ACME

The Output using the file: input1.txt is:
```
  RENE-ASTRID: 2
  RENE-ANDRES: 2
  ASTRID-ANDRES: 3
```
The Output using the file: input2.txt is:
```
  RENE-ASTRID: 3
```
--------------------------------------------------------------------
--------------------------------------------------------------------

Desing and Architecture Explain:

-- Class Main: 

This Class create an ACME object and load the file input.txt creating the list of objects Employee for every line in the txt file. 
Then after having the Employee list, everyone with the Schedule list, compare every Employee in the list with eachother to find if there is a coincidence is the 
Schedules of two Employees. If there is a coincidence between two Employees, create a Duple object with the names of the Employees and the number of coincidences. After that, print the list of Duple objects.


-- Class ACME:

This class keeps and creates the Employees list and the Duples list.


-- Class Duple:

This class keeps two Employees names and the count of coincides in their Schedules, also verify that an existing pair of Employee dont repeated.


-- Class Employee:

This class keeps the name and the Schedules list for one person. Compare two Schedule list and find how many time they coincide in the office eachother.


-- Class Schedule:

This class keeps the day, the enter Date and the exit Date. Compare its own Dates with other Schedule date if the enter and exit of both coincide in the office.

