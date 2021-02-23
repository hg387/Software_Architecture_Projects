README for SE311-Hw3

<br/>1) Main class acts as Client and class to run the program.
<br/>2) test1.txt and test2.txt are the example provided in the hw1 documentation.
<br/>3) test1Result.txt and test2Result.txt are the output files generated from test1.txt
and test2.txt respectively.
<br/>4) For the Strategy Pattern, Input and Output are the abstract Strategies.
<br/>5) InputConsoleTasker and InputFileTasker are the concrete Strategies of Input.
<br/>6) Similarly, OutputConsoleTasker and OutputFileTasker are the concrete Strategies of Output.
<br/>7) UML.png contains the UML diagram for this homework.
<br/>8) The abstract subject is ActionHandler class. All the concrete subjects are extending this class.
<br/>9) The Concrete Subjects with their observers lists are the following:
<br/>    Subjects            Observers
<br/>    LineStorage         CircularShift
                        Alphabetizer
                        OutputConsoleTasker

<br/>    CircularShift       LineStorage
                        Alphabetizer

<br/>    Alphabetizer        LineStorage

<br/>    OutputConsoleTasker LineStorage

<br/>10) The Events are defined here as following:
<br/>    "Print": To be called by the LineStorage to notify Alphabetizer to start working.
<br/>    "CircularShiftAdd": To be called by the LineStorage to notify Circular Shift to start working on the added line.
<br/>    "InteractiveTasker": Acts as callback, to be called by many observer to notify LineStorage
                            to ask user for another round of the Interactive task.
<br/>    "OutputNow": To be called by the LineStorage to notify the OutputConsoleTasker to output all the lines.
<br/>    "CallOutput": To be called by the Alphabetizer to notify Line Storage to call OutputConsoleTasker.
<br/>    "CircularShifterAddedLine": To be called by the CircularShift to notify alphabetizer about the added lines.

<br/>11) The sample run for the interactive program is shown below.

<br/>Note: The console input for sentences allows users to input multiple lines. Press Enter after
every line to input the next line. To Proceed, whenever you entered the last line, just press 
enter again to go to the next line and press enter again to proceed. 

<br/>Note: The UML is the auto-generated so, aggregation/composition logic is bit fuzzy showing all
these relationships shown as composition. However, these classes can exist own its owns so, 
take these relationships as aggregation.

<br/>Sample Run:
<br/>---- Welcome to KWC ----

<br/>How would you like to enter the sentences:

1) By Console
2) By File

2

<br/>Enter the file name with the extension:

test1.txt

<br/>--- Welcome to Interactive mode ---


<br/>Add, Delete, Print, Quit:
p
<br/>Here is the Output:

and Sensibility Sense
Architecture Software
Crouching Tiger Hidden Dragon
Dragon Crouching Tiger Hidden
Hidden Dragon Crouching Tiger
Sense and Sensibility
Sensibility Sense and
Software Architecture
Tiger Hidden Dragon Crouching

<br/>Add, Delete, Print, Quit:
a
>
<br/>What is gooder than god

<br/>Add, Delete, Print, Quit:
p
Here is the Output:

and Sensibility Sense
Architecture Software
Crouching Tiger Hidden Dragon
Dragon Crouching Tiger Hidden
god What is gooder than
gooder than god What is
Hidden Dragon Crouching Tiger
is gooder than god What
Sense and Sensibility
Sensibility Sense and
Software Architecture
than god What is gooder
Tiger Hidden Dragon Crouching
What is gooder than god

<br/>Add, Delete, Print, Quit:
q

<br/>--- Exiting Interactive mode ---

<br/>How would you like to get the sentences:

1) By Console
2) By File

2

<br/>Enter the file name with the extension:

test1Result12.txt
<br/>--- Thanks for using ----

<br/>---- Welcome to KWC ----

<br/>How would you like to enter the sentences:

1) By Console
2) By File

1

<br/>Enter the sentences:

What is gooder than god
more evil than the devil
the rich need it
the poor have it


<br/>--- Welcome to Interactive mode ---


<br/>Add, Delete, Print, Quit:
p
<br/>Here is the Output:

devil more evil than the
evil than the devil more
god What is gooder than
gooder than god What is
have it the poor
is gooder than god What
it the poor have
it the rich need
more evil than the devil
need it the rich
poor have it the
rich need it the
than god What is gooder
than the devil more evil
the devil more evil than
the poor have it
the rich need it
What is gooder than god
<br/>
Add, Delete, Print, Quit:
a
>
<br/>if you eat it you will die

<br/>Add, Delete, Print, Quit:
q

<br/>--- Exiting Interactive mode ---

<br/>How would you like to get the sentences:

1) By Console
2) By File

2

<br/>Enter the file name with the extension:

test3Result3.txt
<br/>--- Thanks for using ----