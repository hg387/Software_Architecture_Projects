HW4

<br/>Implement a GUI Calc utilizing a MVC Pattern.<br/>
Model–view–controller (usually known as MVC) is a software design pattern[1] commonly used for developing user interfaces that divide the related program logic into three interconnected elements. This is done to separate internal representations of information from the ways information is presented to and accepted from the user.[2][3]

Traditionally used for desktop graphical user interfaces (GUIs), this pattern has become popular for designing web applications.[4] Popular programming languages have MVC frameworks that facilitate implementation of the pattern.

<br/>README:
<br/>1) List of the subject and observers.
<br/>Subject -> Observer 		  -> event
<br/>State   -> CalculatorDisplay  -> "state change"<br/>
		-> CalculatorDisplay  -> "display intermediate"<br/>
		-> CalculatorDisplay  -> "error dialog"<br/>

2) The client and server is listening on 8081 so make sure nothing else occupies it.
<br/>3) The Client is opened on the 127.0.0.1 (localhost).
<br/>4) The error dialog box make system exist if none of the options are selected.
<br/>5) The extra credit is implemented on the server side with output file stored as "Output.txt".
   The example of the sample output file is shown below.
<br/>6) The Client/GUI is in HW4 and program can be run through either via Main or via CalculatorDisplay. 
<br/>7) The Server is in CalcServer and program can be run through the Main class.  

<br/>Added Equation: 1+6*2-7=7.0

-<br/>
| \<br/>
*  7<br/>
| \<br/>
+  2<br/>
| \<br/>
<br/>1  6
<br/>Total Number of Equations :1


<br/>Added Equation: 7+3*6=60.0

<br/>*<br/>
| \<br/>
+  6<br/>
| \
<br/>7  3
<br/>Total Number of Equations :2


<br/>Added Equation: 2+3-1*5=20.0

<br/>*
<br/>| \
<br/>-  5
<br/>| \
<br/>+  1
<br/>| \
<br/>2  3
<br/>Total Number of Equations :3




