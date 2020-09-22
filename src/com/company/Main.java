package com.company;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int N = 1000;
        int k = 12;
        int d = 8;
        int minV = 65;
        int maxV = 90;

        char[][] charList;
        charList = generateTestList(N, k, minV, maxV );
        String[] list = convert2dCharToStringList(charList);
        System.out.println("Before Sorting");
        printStringList(list);
        //quickSort(list,0, list.length-1);
        //threeWayRadixQSort(updateList,0, updateList.length-1, 0);
        lsd(list, d);
        System.out.println();
        System.out.println("After Sorting");

        printStringList(list);
        boolean sort;

        sort = isSorted(list);
        if(sort == true){
            System.out.println("Generating list of length "+list.length+" , key width of "+k+" Sorted!");
        }

        System.out.println();
        char mymax;
        mymax = max(charList);
        System.out.println("charmax is :" + mymax);


    }


/** Get CPU time in nanoseconds since the program(thread) started. */
    /**
     * from: http://nadeausoftware.com/articles/2008/03/java_tip_how_get_cpu_and_user_time_benchmarking#TimingasinglethreadedtaskusingCPUsystemandusertime
     **/
    public static long getCpuTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ?
                bean.getCurrentThreadCpuTime() : 0L;
    }

    public static void verificationTests()
    {
        int N = 1000;
        int k = 12;
        int d = 8;
        int minV = 65;
        int maxV = 90;

        char[][] charList;
        charList = generateTestList(N, k, minV, maxV );
        String[] list = convert2dCharToStringList(charList);



    }

    public static boolean isSorted(String[] list)
    {
        for ( int i = 0; i < list.length -1; i++)
        {
            if( list[i].compareToIgnoreCase(list[i+1]) > 0)
                return false;
        }
        return true;
    }
    public static void swapStrings(String[] list, int a, int b)
    {
        String temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    public static void printCharList(char[][] list)
    {
        for ( int i = 0; i < list.length; i++)
        {
            for ( int j = 0; j < list[i].length; j++)
            {
                System.out.print(list[i][j]);
            }
            System.out.printf(" ");
        }
        System.out.println();
    }

    public static void printStringList(String[] list)
    {
        for ( int i = 0; i < list.length; i++)
        {
            System.out.print(list[i]+ " ");
        }
        System.out.println();
    }
    /** Generates a random char array of size N ranging from minV to Max V, adds a null terminator at the kth index **/
    public static char[][] generateTestList(int N, int k, int minV, int maxV) {
        char[][] charList = new char[N][k+1];
        Random rand = new Random();

        /** fill a 2d char array with random chars from minV to maxV **/
        for ( int i = 0; i < charList.length; i++)
        {
            for( int j = 0; (charList[i] != null && j < charList[i].length-1); j++)
            {
                /** insert random char from minV to maxV at pos i , j **/
                charList[i][j] = (char) ((char)  rand.nextInt(maxV - minV + 1) + minV);
                /** insert a null character at the end of every charList[i] **/
                if ( j == k + 1) {
                    charList[i][k + 1] = '\0';
                }
            }
        }
        return charList;
    }

    public static String[] convert2dCharToStringList(char[][] list)
    {
        String[] convertedList = new String[list.length];
        // iterate through the char list
        for( int i = 0; i < list.length; i++)
        {   // place the respective string letters into our string list
            convertedList[i] = String.valueOf(list[i]);
        }
        return convertedList;
    }
    public static void insertionSort(String[] list)
    {
        String temp;
        // iterate from 1 to N
        for( int i = 1 ; i < list.length ; i++)
        {
            int j;
            temp = list[i];
            for ( j = i; j > 0; j--)
            {   // when key is < j-1 shift j-1 to the right
                if(temp.compareTo(list[j-1]) < 0)
                {
                    list[j] = list[j -1];
                }
                else
                {   // break inner loop nothing to switch
                    break;
                }
            }   // insert at key
                list[j] = temp;
        }
    }
    public static void mergeSort(String[] list)
    {
        //empty list just return
        if(list == null)
        {
            return;
        }
        // base case: when list of element length is <=1 the list is sorted
        if(list.length > 1)
        {
            int mid = list.length / 2;

            // split left part and copy elements into a new left array
            String[] left = new String[mid];
            for(int i = 0; i < mid; i++)
            {
                left[i] = list[i];
            }

            // split right part and copy elements into a new right array
            String[] right = new String[list.length - mid];
            for(int i = mid; i < list.length; i++)
            {
                right[i - mid] = list[i];
            }
            // divide and conquer perform mergeSort on each side
            mergeSort(left);
            mergeSort(right);

            int i = 0; //left subarray initial index
            int j = 0; //right subarray initial index
            int k = 0; //merged subarray initial index

            // merge left and right arrays while in the appropriate bounds
            while(i < left.length && j < right.length)
            {
                if(left[i].compareToIgnoreCase(right[j]) < 0)
                {
                    list[k] = left[i];
                    // increment i to get the next left element
                    i++;
                }
                else//right[i].compareToIgnoreCase(left[j]) < 0
                {
                    list[k] = right[j];
                    // increment j to get the next right element
                    j++;
                }
                // increment k position for our merged subarray
                k++;
            }
            // collect remaining elements on left side into merged subarray
            while(i < left.length)
            {
                list[k] = left[i];
                // increment left and merged subarray positions
                i++;
                k++;
            }
            // collect remaining elements on right side into merged subarray
            while(j < right.length)
            {
                list[k] = right[j];
                // increment right and merged subarray positions
                j++;
                k++;
            }
        }
    }

    public static void quickSort(String[] list, int low, int high)
    {
        int left = low;
        int right = high;
        // select middle element as pivot
        String pivot = list[left + (right - left) / 2];

        // base case: we will have completed the sort when (right - left <=0)
        while (left <= right) {
            //find element which is less than pivot
            while (list[left].compareToIgnoreCase(pivot) < 0 ){
                // increment position
                left++;
            }
            //find element which is greater than pivot
            while (list[right].compareToIgnoreCase(pivot) > 0 ){
                // decrement position
                right--;
            }
            // when we found the element on the left side which is less than pivot
            // and element on the right side which is greater than pivot (left < pivot && pivot > right)
            // swap them, and increment left and decrement right
            if (left <= right) {
                String temp = list[left];
                list[left] = list[right];
                list[right] = temp;
                left++;
                right--;
            }
        }
        // recurse on left side of pivot
        if (low < right)
        {
            quickSort(list,low, right);
        }
        // recurse on right side of pivot
        if (left < high)
        {
            quickSort(list, left, high);
        }
    }

    public static void threeWayRadixQSort(String list[], int low, int high, int d)
    {
        if ( high - low <= 0)
        {
            return;
        }
        int i = low - 1;
        int j = high;
        int p = low - 1;
        int q = high;
        char v = list[high].charAt(d);
        while (i < j)
        {
            while (list[++i].charAt(d) < v)
            {
                if (i == high) break;
            }
            while (v < list[--j].charAt(d))
            {
                if (j == low) break;
            }
            if (i > j) break;
            swapStrings(list, i, j);
            if (list[i].charAt(d) == v) swapStrings(list, ++p, i);
            if (list[j].charAt(d) == v) swapStrings(list, j, --q);
        }
        if (p == q) //special case for all equals
        {
            if (v != '\0') threeWayRadixQSort(list, low, high, d+1);
            return;
        }
        if (list[i].charAt(d) < v)
        {
            i++;
        }
        for (int k = low; k <= p; k++)
        {
            swapStrings(list, k, j--);
        }
        for (int k = high; k >= q; k--)
        {
            swapStrings(list, k, i++);
        }
        threeWayRadixQSort(list, low, j, d);
        if ((i == high) && (list[i].charAt(d) == v))
        {
            i++;
        }
        if (v != '\0')
        {
            threeWayRadixQSort(list, j+1, i-1, d+1);
        }
        threeWayRadixQSort(list, i, high, d);
    }

    public static void lsd(String[] list, int d)
    {
        int N = list.length;
        String[] output = new String[N];
        // outer loop to iterate by each digit's place starting from the right moving left
        for ( int digit = d-1; digit >= 0; digit--)
        {
            int[] buckets = new int[256];
            // count the frequency of each digit in each string store into bucket array
            for ( int i = 0; i < N; i++)
                buckets[list[i].charAt(digit)+1]++;
            // do a prefix sum on buckets
            for ( int j = 1; j < 256; j++)
                buckets[j] = buckets[j] + buckets[j-1];
            // build the output from our prefix sums
            for (int i = 0; i < N; i++)
                output[buckets[list[i].charAt(digit)]++] = list[i];
            // copy output into our original list
            for ( int i = 0; i < N; i++)
                list[i] = output[i];
        }
    }

    public static char max(char[][] list)
    {
        char max = 0;
        for (int i = 0; i < list.length; i++) {
                if (list[i][0] > max) {
                    max = list[i][0];
                }
        }
        return max;
    }
}
