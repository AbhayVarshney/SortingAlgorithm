/**
 * P4_Varshney_Abhay
 * Name: Abhay Varshney   Period 4   1/24/16
 * Time Spent: 2:11 PM to
 * Reflection:
 */

import java.util.ArrayList;
import java.util.*;

/**
 *  Driver program for the Sorts class.
 */
class SortStep{
    private Scanner console;
    private ArrayList <Comparable> myArray;
    private P4_Varshney_Abhay_Sort mySorts;
    private String listType;

    /**
     *  Constructor for the SortStep object
     */
    public SortStep(){
        console = new Scanner(System.in);
        mySorts = new P4_Varshney_Abhay_Sort();
        myArray = null;
        listType = "Integer";
    }

    public static void main(String[] args) {
        SortStep s = new SortStep();
        s.sortMenu();
    }

    /**
     *  Asks the user to select a sorting algorithm, fills the array
     *  with an amount of random integer data chosen by the user, calls
     *  the sorting algorithm, and gives an option of printing out the
     *  data after it has been sorted.
     */
    public void sortMenu(){
        String choice;
        String print;

        do{
            System.out.println();
            System.out.println("Sorting algorithm menu");
            System.out.println();
            System.out.println("(1) Bubble sort");
            System.out.println("(2) Selection sort");
            System.out.println("(3) Insertion sort");
            System.out.println("(4) Recursive mergesort");
            System.out.println("(5) Quick sort");
            System.out.println("(6) Fill with Integers");
            System.out.println("(7) Fill with Strings");
            System.out.println("(Q) Quit");
            System.out.println();
            System.out.print("Choice ---> ");
            choice = console.next() + " ";
            if ('1' <= choice.charAt(0) && choice.charAt(0) <= '6'){
                System.out.println();
                long startTime = 0;
                long endTime = 0;
                mySorts.setStepCount(0);

                switch (choice.charAt(0)){
                    case '1':
                        resetArray();
                        startTime= System.currentTimeMillis();
                        mySorts.bubbleSort(myArray);
                        endTime = System.currentTimeMillis();
                        System.out.println("Time taken: " + (endTime - startTime) + "ms");
                        break;
                    case '2':
                        resetArray();
                        startTime = System.currentTimeMillis();
                        mySorts.selectionSort(myArray);
                        endTime = System.currentTimeMillis();
                        System.out.println("Time taken: " + (endTime - startTime) + "ms");
                        break;
                    case '3':
                        resetArray();
                        startTime = System.currentTimeMillis();
                        mySorts.insertionSort(myArray);
                        endTime = System.currentTimeMillis();
                        System.out.println("Time taken: " + (endTime - startTime) + "ms");
                        break;
                    case '4':
                        resetArray();
                        startTime = System.currentTimeMillis();
                        int last = myArray.size() - 1;
                        mySorts.mergeSort(myArray, 0, last);
                        endTime = System.currentTimeMillis();
                        System.out.println("Time taken: " + (endTime - startTime) + "ms");
                        break;
                    case '5':
                        resetArray();
                        startTime = System.currentTimeMillis();
                        mySorts.quickSort(myArray, 0, myArray.size() - 1);
                        endTime = System.currentTimeMillis();
                        System.out.println("Time taken: " + (endTime - startTime) + "ms");
                        break;
                    case '6':
                        listType = "Integer";
                        break;
                    case '7':
                        listType = "String";
                        break;

                }
                if ('1' <= choice.charAt(0) && choice.charAt
                        (0) <= '5'){
                    System.out.println();
                    System.out.println("Array sorted to:");
                    screenOutput();
                    System.out.println();
                    System.out.println("# steps = " + mySorts.getStepCount());
                    System.out.println();
                }
            }
        } while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
    }

    /**
     *  Initializes myArray with random integers in the range
     *  1..largestInt
     *
     * @param  numInts     number of integers to generate (size of
     *      myArray)
     * @param  largestInt  largest possible random integer to create
     */
    private void fillArrayWithInts(){

        System.out.print("How many numbers do you wish to generate? ");
        int numInts = console.nextInt();
        System.out.print("Largest integer to generate? ");
        int largestInt = console.nextInt();

        Random randGen = new Random();
        myArray = new ArrayList <Comparable>();

        for (int loop = 0; loop < numInts; loop++){
            Integer x = new Integer(randGen.nextInt(largestInt) + 1);
            myArray.add(x);
        }
    }

    /**
     *  Initializes myArray with a few hard-coded Strings
     *
     * @param  numInts     number of integers to generate (size of
     *      myArray)
     * @param  largestInt  largest possible random integer to create
     */
    private void fillArrayWithStrings(){
        myArray = new ArrayList <Comparable>();
        myArray.add("eat");
        myArray.add("steaks");
        myArray.add("juicy");
        myArray.add("huge");
        myArray.add("dogs");
        myArray.add("big");
    }

    /**
     *  reset the array for the next sort
     */
    private void resetArray(){
        if (myArray == null || listType.equals("Integer")){
            fillArrayWithInts();
        } else if (listType.equals("String")) {
            fillArrayWithStrings();
        }
        System.out.println();
        System.out.println("Array reset to:");
        screenOutput();
    }

    /**
     *  prints out the contents of the array in tabular form, 12 columns
     */
    private void screenOutput(){
        for (int loop = 0; loop < myArray.size(); loop++){
            if (loop % 12 == 0){
                System.out.println();
            }
            System.out.print(myArray.get(loop) + "  ");
        }
        System.out.println();
    }


}

/**
 * MY ACTUAL CODE.
 */
public class P4_Varshney_Abhay_Sort {
    private long steps;

    public P4_Varshney_Abhay_Sort(){
        steps = 0;
    }

    /**
     *  BUBBLE SORT:
     *  Sorting Algorithm that repeatedly steps through the list to be sorted,
     *  compares each pair of adjacent items and swaps them if they are in
     *  the wrong order.
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(ArrayList <Comparable> list){
        steps += 2; // initializing and ca  lling list.size()
        steps += 1; // check if it falls in the boundary
        for (int i = 0; i < list.size(); i++) {

            steps += 2; // initializing and calling list.size()
            steps += 1; // check if it falls in the boundary
            for (int j = list.size()-1; j > 0; j--) {
                steps += 1; // calculate j-1
                steps += 2; // obtain content using get method
                steps += 1; // compare
                if(list.get(j).compareTo(list.get(j-1)) > 0) {
                    // switch
                    Comparable temp = list.get(j);      steps+= 2; // store # into variable & get method
                    list.set(j, list.get(j-1));         steps+= 3; // calculate j-1, do set method, & get method
                    list.set(j-1, temp);                steps+= 2; // calculate j-1 and do set method
                }
                steps+= 1; // adding variable i
            }
            steps+= 1; // adding variable i
        }
    }

    /**
     *  SELECTION SORT
     *  Sorting algorithm that simply compares 2 values and switches the #s
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(ArrayList <Comparable> list){
        Comparable smallest = 0;        steps += 1; // initialize
        int pos = 0;                    steps += 1; // initialize

        steps += 2; // initializing and calling list.size()
        steps += 1; // check if it falls in the boundary
        for (int i = 0; i < list.size(); i++) {
            // find the index of the smallest value
            smallest = list.get(i);     steps += 2; // calling method and saving into a variable
            pos = i;                    steps += 1; // storing number into variable

            steps += 2; // initializing and list.size()
            steps += 1; // check if it falls in the boundary
            for (int j = i + 1; j < list.size(); j++) {
                steps += 1; // use get method
                steps += 1; // comparison
                if(smallest.compareTo(list.get(j)) > 0) {
                    //must update the smallest number
                    smallest = list.get(j);     steps += 2; // call get method and storing variable
                    pos = j;                    steps += 1; // storing variable
                }
                steps+= 1; // adding variable i
            }

            steps += 1; // check condition
            if(pos != i) { // swapping it.
                Comparable temp = list.get(i);  steps += 2; // calling get method and storing variable
                list.set(i, list.get(pos));     steps += 2; // calling get method and set method
                list.set(pos, temp);            steps += 1; // calling set method
            }

            steps+= 1; // adding variable i
        }
    }

    /**
     *  INSERTION SORT
     *  This algorithm builds the final sorted array (or list) one item at a time
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(ArrayList <Comparable> list){
        Comparable val;     steps += 1; // initialize
        int pos;            steps += 1; // initialize

        steps += 2; // initializing and calling list.size()
        steps += 1; // check if it falls in the boundary
        for (int i = 1; i < list.size(); i++) {
            val = list.get(i);  steps += 2; // calling get method and saving it into a variable
            pos = i;            steps += 1; // storing # into variable

            while(pos > 0 && list.get(pos - 1).compareTo(val) < 0) {
                steps += 1; // subtracting pos by 1
                steps += 1; // check if pos is greater than 0
                steps += 1; // calling get method
                steps += 1; // comparing
                steps += 1; // checking condition
                steps += 1; // && statement

                list.set(pos, list.get(pos-1));     steps += 3; // pos-1, get method, set method
                pos--;                              steps += 1; // decrement value
            }
            list.set(pos, val);     steps += 1; // set method
            steps += 1; // increment
        }
    }

    /**
     * QuickSort puts elements of a list in a certain order.i
     * @param list
     * @param x
     * @param y
     */
    public void quickSort(ArrayList <Comparable> list, int x, int y) {
        int posX = x;   steps += 1; // index positions initializing
        int posY = y;   steps += 1; // index positions initializing

        steps += 1; // saving into variable
        steps += 3; // get method and addition & division
        Comparable pivot = list.get((x + y) / 2); // must stay constant

        steps += 1; // check condition
        while (posX < posY) {
            // make sure that index markers don't cross each other or pivot position
            steps += 2; // check condition and get method
            while (list.get(posX).compareTo(pivot) < 0) { // left side
                posX++;     steps += 1; // increment
            }
            steps += 2; // check condition and get method
            while (list.get(posY).compareTo(pivot) > 0) { // right side
                posY--;     steps += 1; // increment
            }

            steps += 1; // check condition
            if (posX <= posY) {
                swap(list,posX,posY);   steps += 1; // call method
                posX++;                 steps += 1; // increment
                posY--;                 steps += 1; // increment
            }
            steps += 1; // check condition for while loop
            System.out.println(list + " Pivot " + pivot + " , index x -> " + posX + " , index y --> " + posY);

        }

        steps += 1; // check condition
        if (posY > x) {
            quickSort (list,x,posY);    steps += 1; // call method

        }

        steps += 1; // check condition
        if (posX < y) {
            quickSort (list,posX,y);    steps += 1; // call method
        }
    }


    /**
     *  Takes in entire vector, but will merge the following sections
     *  together:  Left sublist from a[first]..a[mid], right sublist from
     *  a[mid+1]..a[last].  Precondition:  each sublist is already in
     *  ascending order
     *
     * @param  a      reference to an array of integers to be sorted
     * @param  first  starting index of range of values to be sorted
     * @param  mid    midpoint index of range of values to be sorted
     * @param  last   last index of range of values to be sorted
     */
    private void merge(ArrayList <Comparable> a, int first, int mid, int last){

        ArrayList <Comparable> array1 = new ArrayList<Comparable>();    steps += 1; // create list
        ArrayList <Comparable> array2 = new ArrayList<Comparable>();    steps += 1; // create list
        ArrayList <Comparable> array3 = new ArrayList<Comparable>();    steps += 1; // create list
        array1.addAll(a.subList(first,mid+1));                          steps += 2; // add using sublist
        array2.addAll(a.subList(mid+1, last+1));                        steps += 2; // add using sublist

        steps += 3; // check conditions and obtain elements
        while (!array1.isEmpty() && !array2.isEmpty()) {
            steps += 2; // obtain elements
            steps += 1; // compare to method
            steps += 1; // check condition
            if ((array1.get(0).compareTo(array2.get(0)) < 0)) {
                array3.add(array1.remove(0));   steps += 2; // remove method and add method
            }
            else {
                array3.add(array2.remove(0));   steps += 2; // remove method and add method
            }
        }

        steps += 1; // check condition
        while(!array1.isEmpty()) {
            // move the remaining elements of a
            array3.add(array1.remove(0));       steps += 2; // remove method and add method
        }

        steps += 1; // check condition
        while(!array2.isEmpty()) {
            // move the remaining elements of b
            array3.add(array2.remove(0));       steps += 2; // remove method and add method
        }

        int counter = 0;                        steps += 1; // intialize variable

        steps += 2; // initialize variable in for loop and check condition
        for(int i = first; i <= last; i++) {
            a.set(i, array3.get(counter));      steps += 2; // get method and set method
            counter++;                          steps += 1; // increment
            steps += 1; // increment
        }
    }

    /**
     *  Recursive mergesort of an array of integers
     *
     * @param  a      reference to an array of integers to be sorted
     * @param  first  starting index of range of values to be sorted
     * @param  last   ending index of range of values to be sorted
     */
    public void mergeSort(ArrayList <Comparable> a, int first, int last){
        int mid;    steps += 1; // initialize variable
        if (first == last){ steps += 1; // check condition
            // do nothing
        } else if (first + 1 == last){  steps += 2; // check condition & add 1 to first variable
            steps += 2; // get method
            steps += 1; // compare to method
            steps += 1; // check condition
            if(a.get(first).compareTo(a.get(last)) > 0) {
                swap(a, first, last);   steps += 1; //method call
            }
        }else{ // recursion, divide list into two halves
            mid = (last+first)/2;       steps += 3; // addition, division, then saving variable
            mergeSort(a, first, mid);   steps += 1; // method call
            mergeSort(a, mid+1, last);  steps += 2; // method call and addition
            merge(a, first, mid, last); steps += 1; // method call
        }
    }


    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount(){
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount){
        steps = stepCount;
    }

    /**
     *  Interchanges two elements in an ArrayList
     *
     * @param  list  reference to an array of integers
     * @param  a     index of integer to be swapped
     * @param  b     index of integer to be swapped
     */
    public void swap(ArrayList <Comparable> list, int a, int b){
        Comparable c = list.get(a);  steps += 2; // obtain a and save it to a variable
        list.set(a, list.get(b));    steps += 2; // set and obtain element
        list.set(b, c);              steps += 1; // set method
    }
}

