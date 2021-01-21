README for SE311-Hw2

TASK: Implement KWC indexing of lines using Pipe and Filter Architecture.A KWIC index is formed by sorting and aligning the words within an article title to allow each word (except the stop words) in titles to be searchable alphabetically in the index.[3] It was a useful indexing method for technical manuals before computerized full text search became common.

<br/>Pipe & Filter Arch: Decompose a task that performs complex processing into a series of separate elements that can be reused. This can improve performance, scalability, and reusability by allowing task elements that perform the processing to be deployed and scaled independently.
<br/>1) Main class acts as Client and class to run the program.
<br/>2) test1.txt and test2.txt are the example for testing.
<br/>3) UML.png contains the UML diagram for this homework.
<br/>4) For easy checking of location of Upper Case Converter, logs are printed on console after 
compeletion of each filter. Example is provided below.
<br/>5) The program takes input of location, input method and output file using console from the user.

<br/>Note: Sample generated result files are attatched in the pattern:
test<number>FileResult<location>: 
example, test2FileResult1: result file generated with test2 as input file, and location is 1

<br/>test<number>ConsoleResult<location>:
exmaple, test2ConsoleResult1: result file generated with test2 sentences enetered using console, 
and location is 1

<br/>Note: The console input for sentences allows users to input multiple lines. Press Enter after
every line to input the next line. To Proceed, whenever you entered the last line, just press 
enter again to go to the next line and press enter again to proceed. 

<br/>Note: The UML is the auto-generated so, aggregation/compostion logic is bit fuzzy showing all
these relationships shown as composition. However, these classes can exist own its owns so, 
take these relationships as aggregation.

<br/>Exmaple of Console logs for each checking:

<br/>---- Welcome to KWC ----

<br/>Please Enter the location <1,2,3>:

<br/>3

<br/>Enter the output file name with the extension:

<br/>test1ConsoleResult3.txt

<br/>How would you like to enter the sentences:


<br/>1) By Console
<br/>2) By File

<br/>1

<br/>Enter the sentences:

<br/>Sense and Sensibility.
<br/>Architecture Software.
<br/>Crouching Tiger Hidden Dragon


<br/>--- Input Console Reading Done ---


<br/>--- Circular Shift Done ---


<br/>--- Alphabetizer Done ---


<br/>--- Upper Case Converter Done ---


<br/>--- Output File Writing Done ---
  