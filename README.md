## Sorting Visualizer (with statistics)

### Table of Contents
1. [Motivation](#Motivation)
2. [Features](#Features)
3. [Screenshots](#Screenshots)
4. [Usage](#Usage)
5. [API](#API)
6. [Installation/Contribution](#Can-I-contribute-or-try-it-out)

### Motivation
Like a few of my other projects published on GitHub, I started working on this project while learning about data structures and algorithms <sup>[[1]](#1)</sup>. Part 1 of the course that is referenced, dives into data structures, sorting algorithims and their variations.

After learning about different sorting algorithims and each of their benefits/drawbacks what better way to further understand them, then to visualize them with their real time statistics!


### The Good Stuff
I'll briefly introduce the capabilities of this project, followed by a brief description of its backend and lastly I'll describe how the program can be modified for your own usage with the provided API !

#### Features
- Graphical User Interface
- Statistics 
   - _Number of array accesses_ in real time
   - _Number of compares_ in real time
- Customizable Array Size
- Customizable Sort Speed
- Simple and intuitive API for the easy implementation of more sorting algorithims



#### Demo
![Sorting Visualizer Demo](https://user-images.githubusercontent.com/61364811/103180041-f71e8e80-485f-11eb-8100-f5244bf5324d.gif)
Please note that the GIF is capped to ~11 FPS but forking the repository and running the application will allow the full > 30 FPS.

#### Usage
This application has two main components, the  _interface_ and the _sorting algorithim_.

##### Interface
The interface automatically handles almost all of the features described in the [features section](#Features) such as the graphical representation of the array, statistics, sort speed and array size. 

This is accomplished by storing the array locally and providing an API for external classes that contain the sorting algorithim.

Statistics such as compares, accesses, and array modifications are then automatically updated whenever the provided API is used.

Colors are also automatically maintained. For example,  any entries that were recently switched will be highlighted. This can be manually overwritten using the appropriate [cosmetic methods](#Cosmetic-Operations).

##### Implementing a Sorting Algorithim
Any array sorting algorithim can be easily implemented, the only modifications required are replacing calls that modify or compare local array entries to using the provided API operations. 


#### API
Using the provided API maintains all statistics and graphical representations automatically. For instance, calling the getValue() method will increment the number of array accesses by one.

The graphical representation are automatically maintained, therefore called switchVal(indexA, indexB) will switch the entries and this will be displayed to the user. Additionaly, these methods will automatically highlight recently accessed entries such as indexA and indexB in the case of switchVal. 

It is important to note that the **the algorithim must manually call color resets after each iteration**. See the [cosmetic operations section](#Cosmetic-Operations) for more information.

##### Misc
```java
//size of the current array 
int arrayLength()
```

##### Internal Array Modification
These methods directly access the internal array which is displayed to the user, the bulk of sorting algorithims that do not require an auxilary array will likely utilize these methods the most.

```java
// switch the entries at indexA and indexB
void switchVal(int indexA, int indexB)

// set the entry at index to value
void changeVal(int index, Comparable value)

// get a deep copy of the entry at index
Comparable getValue(int index)
```

##### External Array Modification
These methods are identical to the internal array modification with the exception of requiring an external array to be inputted for modification.

Using these methods even while accessing an auxilary array ensures that the number of array accesses & compares are appropriately incremented and maintained.
```java

 //switch entries at indexA and indexB in an external array 
void switchVal(Comparable[] array, int indexA, Comparable indexB)

//set the entry at index in an external array to value
void changeVal(Comparable[] array, int index, Comparable value)

// get a deep copy of the entry at index A
Comparable getValue(Comparable[] array, int index)
```

##### Entry Comparisons
```java
// return the integer comparison value of comparing A to B.
//  1 -> greater than
//  0 -> equal to
// -1 -> less then
int compareTo(Comparable A, Comparable B)

//is A less then B?
boolean less(Comparable A, Comparable B)
````

##### Cosmetic Operations
```java
// set the color at arrayIndex to rgb(redValue, greenValue, 0)
void setColor(int arrayIndex, int redValue, int greenValue) 

// change the color of the entry at index during a shallow color reset?
void setPermanentColor(int index, boolean value)

// perform a shallow array color reset, set all non-permanent entries to their default value rgb(0, 0, 0)
void resetArrayColor()

// perform a deep array color reset, set all permanent and non-permanent entries to their default value rgb(0, 0, 0)
void deepResetArrayColor()
```

#### Can I contribute or try it out?
Of course!  
* Fork the repository
* Open up your favorite IDE 
* Compile and run "GUIJFrame.java" to start the application
* Feel free to submit a pull request with any optimizations or suggestions!

<a id="1">[1]</a> I'd highly recommend checking out [Princeton's Algorithms](https://www.coursera.org/learn/algorithms-part1) courses in combination with their textbook, they are very well versed! 
