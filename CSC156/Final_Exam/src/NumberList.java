/*********************************************************************************************
 * Name: Eric Helfrich                                                              Final Exam
 * Date 7/24/16                                                                     CSC 156 8C1
 *********************************************************************************************/
// java class for keyboard I/O

import java.util.Arrays;
import java.util.Scanner;

// declaration of the class
public class NumberList {
    //array to store the numbers
    private double[] numbers;
    //the number of valid numbers currently in the NumberList
    private int length;

    //default constructor that initializes array to size 100 and initializes all
    //array values to 0, sets length to 10
    public NumberList() {
        numbers = new double[100];
        for (int i = 0; i < 100; ++i) {
            numbers[i] = 0;
        }
        length = 10;
    }

    //outputs the numbers in the NumberList to the
    //standard output screen
    public void print() {
        for (int i = 0; i < length; ++i) {
            System.out.println(numbers[i]);
        }
    }

    //assignment constructor, initializes array to size 100,
    //initializes length to l and sets the first l values of the list to the value n
    NumberList(int l, double n) {
        length = l;
        numbers = new double[100];
        for (int i = 0; i < l; ++i) {
            numbers[i] = n;
        }
    }

    //assignment constructor, initializes array to size 100, takes an array
    //as input and completes a deep copy (element to element copy) from the array
    //parameter to the numbers array
    NumberList(final double a[]) {
        numbers = new double[100];
        for (int i = 0; i < a.length; ++i) {
            numbers[i] = a[i];
        }
        length = a.length;
    }

    //copy constructor, initializes array to size 100,
    //creates a copy of parameter NumberList nl to the calling NumberList
    NumberList(final NumberList nl) {
        numbers = nl.numbers;
        length = nl.length;

    }

    //returns the length of NumberList
    public int length() {
        int arrayLength = length;
        return arrayLength;
    }

    //returns the sum of the numbers in the NumberList
    public double sum() {
        double array_sum = 0;
        for (int i = 0; i < length; ++i) {
            array_sum += numbers[i];
        }
        return array_sum;
    }

    //returns the average value of the numbers in the NumberList
    public double ave() {
        double array_ave = 0;
        double array_sum = 0;
        for (int i = 0; i < length; ++i) {
            array_sum += numbers[i];
        }
        array_ave = array_sum / length;
        return array_ave;
    }

    //returns the largest number in the NumberList
    public double max() {
        double maximum = numbers[0];
        for (int i = 0; i < length; ++i) {
            if (numbers[i] > maximum) {
                maximum = numbers [i];
            }
        }
        return maximum;
    }

    //returns the smallest number in the NumberList
    public double min() {
        double minimum = numbers[0];
        for (int i = 0; i < length; ++i) {
            if (numbers[i] < minimum) {
                minimum = numbers [i];
            }
        }
        return minimum;
    }

    //Linear search that returns true if number is in list, otherwise false
    public boolean isIn(double number) {
        for (int i = 0; i < length; ++i) {
            if (numbers[i] == number) {
                return true;
            }
        }
        return false;
    }

    //adds value to the end of the NumberList, returns true if successful,
    //otherwise if THE NUMBERLIST IS FILLED TO CAPACITY, returns false
    public boolean append(double value) {
        if (length < 100) {
            numbers[length] = value;
            ++length;
            return true;
        }
        else {
            return false;
        }
    }

    //removes last element in the NumberList, returns true if successful,
    //otherwise returns false (THE NUMBERLIST IS EMPTY)
    public boolean removeLastElement() {
        if (length > 0) {
            numbers[length] = 0;
            --length;
            return true;
        }
        else {
            return false;
        }
    }

    //asks the user to enter how many numbers to add and then to
    //enter the actual numbers from the standard input screen
    public void get() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        length = console.nextInt();
        System.out.println("Enter the numbers for the array: ");
        for (int i = 0; i < length; ++i) {
            numbers[i] = console.nextDouble();
        }

    }

    //inserts number in location position and shifts the numbers to the right of
    //position to the right by one. Returns true if successful, otherwise
    //if THE NUMBERLIST IS FILLED TO CAPACITY returns false
    public boolean insert(double number, int position) {
        if (length < 100 && position < length) {
            for (int i = length; i > position; --i) {
                numbers[i] = numbers[i - 1];
            }
            numbers[position] = number;
            ++length;
            return true;
        }
        else {
            return false;
        }
    }

    //sorts the numbers in the list using the SELECTION SORT algorithm.
    //Type is either 'A','a' for ascending, or 'D','d' for descending
    public void sort(char type) {
        if (type == 'd' || type == 'D') {
            int largestIndex;
            double temp;
            for (int i = length - 1; i > 0; --i) {
                largestIndex = 0;
                for (int j = 1; j <= i; ++j) {
                    if (numbers[j] < numbers[largestIndex]) {
                        largestIndex = j;
                    }
                    temp = numbers[largestIndex];
                    numbers[largestIndex] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        else if (type == 'a' || type == 'A') {
            int smallestIndex;
            double temp;
            for (int i = 0; i < length -1; ++i) {
                smallestIndex = i;
                for (int j = i + 1; j < length; ++j) {
                    if (numbers[j] < numbers[smallestIndex]) {
                        smallestIndex = j;
                    }
                    temp = numbers[smallestIndex];
                    numbers[smallestIndex] = numbers[i];
                    numbers[i] = temp;
                }
            }

        }

    }


    //inserts array starting at location position and shifts the numbers to the right of
    //position to the right by the length of the array. Returns true if successful,
    //otherwise if NUMBERLIST IS FILLED OR ARRAY IS TOO LARGE returns false
    public boolean insertArray(int location, double a[]) {
        if (length + a.length < 100 && location < length) {
            for (int i = length + a.length; i >= location + (a.length - 1); --i) {
                numbers[i] = numbers[i - (a.length + 1)];
            }
            for (int i = location; i < location + a.length; ++i) {
                for (int j = 0; j < a.length; ++j) {
                    numbers[i] = a[j];
                }
            }
            length += a.length;
            return true;
        }
        else {
            return false;
        }
    }

    //No main method for use with the Test Driver provided!!!!!
    /*/ declaration of main program
    public static void main(String[] args) {
    } // end of main
*/
} // end of the class 
