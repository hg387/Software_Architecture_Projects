README for SE311-Hw2

1) Main class acts as Client and class to run the program.
2) test1.txt and test2.txt are the example for testing.
3) UML.png contains the UML diagram for this homework.
4) For easy checking of location of Upper Case Converter, logs are printed on console after 
compeletion of each filter. Example is provided below.
5) The program takes input of location, input method and output file using console from the user.

Note: Sample generated result files are attatched in the pattern:
test<number>FileResult<location>: 
example, test2FileResult1: result file generated with test2 as input file, and location is 1

test<number>ConsoleResult<location>:
exmaple, test2ConsoleResult1: result file generated with test2 sentences enetered using console, 
and location is 1

Note: The console input for sentences allows users to input multiple lines. Press Enter after
every line to input the next line. To Proceed, whenever you entered the last line, just press 
enter again to go to the next line and press enter again to proceed. 

Note: The UML is the auto-generated so, aggregation/compostion logic is bit fuzzy showing all
these relationships shown as composition. However, these classes can exist own its owns so, 
take these relationships as aggregation.

Exmaple of Console logs for each checking:

---- Welcome to KWC ----

Please Enter the location <1,2,3>:

3

Enter the output file name with the extension:

test1ConsoleResult3.txt

How would you like to enter the sentences:


1) By Console
2) By File

1

Enter the sentences:

Sense and Sensibility.
Architecture Software.
Crouching Tiger Hidden Dragon


--- Input Console Reading Done ---


--- Circular Shift Done ---


--- Alphabetizer Done ---


--- Upper Case Converter Done ---


--- Output File Writing Done ---
  