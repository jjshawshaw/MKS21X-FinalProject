# MKS21X-FinalProject
We will be creating a simple java terminal-based MIDI encoder. Using our encoder you will be able to draw in simple notes and have them written to a .mid file which you can then play using a MIDI player.

## Instructions:
To compile the program, type:
```
javac -cp lanterna.jar:. MIDIEncoder.java
```

To run the program, type:

```
java -cp lanterna.jar:. MIDIEncoder new.mid int[1-100]
```
The new.mid is a file to which your music will be written to.
The integer deptermines the length of the grid and is 1-100 inclusive.

Within the program, use arrow keys to navigate and the "a" key to add notes and "r" to remove. Esc to terminate the program. After your program is complete, the notes you drew in will be written to a file with the name you specified upon running the program.
We also have two simple sample midi files twinkle.mid and jingle.mid that play tunes written using our encoder.

MIDI Player:
https://qiao.github.io/euphony/#15

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

01.14.19
- no commits on this day, we were researching how to convert to bytes
- worked on implementing screen to stop flickering but it broke everything

01.15.19
- attempting to fix the way the addnote method works
- worked on implementing screen to stop flickering but it broke everything

01.16.19
- attempting to fix the way the addnote method works
- made the program display a grid

01.17.19
- modified toHex method to make it easier to convert to bytes
- wrote algorithm to convert hex code to bytes

01.18.19


01.19.19
- got the code to output to a .mid file :)))
- wrote several sample files
- attempted to improve the toHex algorithm but alas, have given up

01.20.19
- attempted to include an Ubuntu MIDI file player but was not able to test it due to lack of permission to install the software
- wrote a jingle bells demo 

01.21.19
- implemented screen to eliminate flickering
