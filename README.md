# MKS21X-FinalProject
We will be creating a simple java terminal-based MIDI encoder.

## Instructions:
To compile the program, type:
```
javac -cp lanterna.jar:. MIDIEncoder.java
```

To run the program, type:

```
java -cp lanterna.jar:. MIDIEncoder new.txt int[1-100]
```
The new.txt is a file to which your music will be written to.
The integer deptermines the length of the grid and is 1-100 inclusive.

Within the program, use arrow keys to navigate and the "a" key to add notes and "r" to remove. Esc to terminate the program. After your program is complete, the notes you drew in will be written to a text file in Hex code.

## Devlog:
01.03.19
Today we created the repo and put the necessary files in it so that we may begin work tomorrow.

01.04.19
We were both quite sick so no work was done on this day.

01.05.19
- set up Tile class and wrote all the accessor methods
- set up MIDIEncoder file with empty method headers

10.06.19
We were both quite sick so no work was done on this day.

01.07.19
- wrote methods that convert notes to MIDI Raw Hex code
- wrote methods for calculating tracklength and formatting in correct MIDI format
- the program can now output hex code that represents MIDI 

01.08.19
- today we began implementing lanterna and modifying the methods within the demo file to understand how the library works

01.09.19 
- began testing on a tester file attempting to develop the visual grid independently of the encoder class and eventually implemented it into our MIDIEncoder class
- the cursor's coordinates are tracked and the user can urn a note on/off visually

01.10.19
- integrated the lanterna code from the demo file into the MIDIEncoder file
- edited the way the grid and cursor looks in the terminal 
- notes can be changed colour in response to keyboard clicks
- edited the way the keyboard looks on the terminal
- wrote the back-end add and remove note methods 
- fixed the toHex method

01.11.19
- the structure of the MIDIEncoder class was changed
- the program now automatically outputs MIDI Hex code upon exiting the program

01.12.19
- added the functionality of varying note length

01.13.19
- modified the add and remove methods
- added a key tracker and updated the header to directions
- cleaned up the code and got rid of useless methods
- the product of the program now writes to a file that is specified within the parameters upon running


