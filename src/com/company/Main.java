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

        //verificationTests();
        //runTimeTestsInsertionSort();
        //runTimeTestsMergeSort();
        //runTimeTestsQuickSort();
        runTimeTestsRadixSort();

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

    public static void runTimeTestsInsertionSort()
    {
        int N;
        int k = 6;
        int d = 1;
        int minV = 1;
        int maxV = 255;
        char[][] charList;
        String [] list;
        int N_Min = 1;
        int N_Max = 1000000000;
        int k_Min = 6;
        int k_Max = 48;
        long maxTime = 10000000;
        long maxTrials = 5;
        long totalTime = 0;
        long trialCount = 0;
        long timeStampBeforeInsertionSort = 0;
        long timeStampAfterInsertionSort = 0;
        long timeMeasureForInsertionSort = 0;
        long averageTimeMeasured = 0;
        double predictedDoublingRatio = 1;
        long k6average = 0;
        long k12average = 0;
        long k24average = 0;
        long k48average = 0;
        double k6double = 0;
        double k12double = 0;
        double k24double = 0;
        double k48double = 0;
        double k6previous = 0;
        double k12previous = 0;
        double k24previous = 0;
        double k48previous = 0;
        /**Print Column Headings**/
        System.out.printf("\n%120s", "Results for Insertion Sort\n");
        System.out.printf("\n%20s %16s %16s %16s %16s %16s %16s %16s %22s %30s\n", "N","k = 6 Time","Doubling Ratio","k = 12 Time", "Doubling Ratio", "k = 24 Time", "Doubling Ratio","k = 48 Time","Doubling Ratio","Predicted Doubling Ratio");
        System.out.printf("%195s\n", "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for ( N = N_Min; N <= N_Max; N = N * 2)
        {


            for( k = k_Min; k <= k_Max; k = k * 2)
            {
                charList = generateTestList(N, k, minV, maxV);
                list = convert2dCharToStringList(charList);
                totalTime = 0;
                trialCount = 0;
                while( totalTime < maxTime && trialCount < maxTrials)
                {
                    timeStampBeforeInsertionSort = getCpuTime();
                    insertionSort(list);
                    timeStampAfterInsertionSort = getCpuTime();
                    timeMeasureForInsertionSort = timeStampAfterInsertionSort - timeStampBeforeInsertionSort;
                    totalTime = totalTime + timeMeasureForInsertionSort;
                    trialCount++;

                }
                averageTimeMeasured = totalTime / trialCount;
                if ( k == 6)
                {
                    k6average = averageTimeMeasured;
                    k6double = (double)averageTimeMeasured / k6previous;
                    k6previous = averageTimeMeasured;

                }
                if ( k == 12)
                {
                    k12average = averageTimeMeasured;
                    k12double = (double)averageTimeMeasured / k12previous;
                    k12previous = averageTimeMeasured;
                }
                if ( k == 24)
                {
                    k24average = averageTimeMeasured;
                    k24double = (double)averageTimeMeasured / k24previous;
                    k24previous = averageTimeMeasured;
                }
                if ( k == 48)
                {
                    k48average = averageTimeMeasured;
                    k48double = (double)averageTimeMeasured / k48previous;
                    k48previous = averageTimeMeasured;
                }

            }
            if ( (N*N/2) == 0){
                predictedDoublingRatio = 2.0;
            }
            else if ( N != N_Min)
            {
                predictedDoublingRatio = (N * N) / (N * N / 2);
            }
            if ( N == 1 )
            {
                String notApplicable = "na";
                System.out.printf("%20s %16s %16s %16s %16s %16s %16s %16s %22s %30s\n", N,k6average,notApplicable,k12average, notApplicable, k24average, notApplicable,k48average,notApplicable,notApplicable);
            } else{
                System.out.printf("%20s %16s %16.2f %16s %16.2f %16s %16.2f %16s %22.2f %30s\n", N,k6average,k6double,k12average, k12double, k24average, k24double,k48average,k48double,predictedDoublingRatio);
            }
        }
    }

    public static void runTimeTestsMergeSort()
    {
        int N;
        int k = 6;
        int d = 1;
        int minV = 1;
        int maxV = 255;
        char[][] charList;
        String [] list;
        int N_Min = 1;
        int N_Max = 1000000000;
        int k_Min = 6;
        int k_Max = 48;
        long maxTime = 10000000;
        long maxTrials = 5;
        long totalTime = 0;
        long trialCount = 0;
        long timeStampBeforeInsertionSort = 0;
        long timeStampAfterInsertionSort = 0;
        long timeMeasureForInsertionSort = 0;
        long averageTimeMeasured = 0;
        double predictedDoublingRatio = 1;
        long k6average = 0;
        long k12average = 0;
        long k24average = 0;
        long k48average = 0;
        double k6double = 0;
        double k12double = 0;
        double k24double = 0;
        double k48double = 0;
        double k6previous = 0;
        double k12previous = 0;
        double k24previous = 0;
        double k48previous = 0;
        /**Print Column Headings**/
        System.out.printf("\n%120s", "Results for Merge Sort\n");
        System.out.printf("\n%20s %16s %16s %16s %16s %16s %16s %16s %22s %30s\n", "N","k = 6 Time","Doubling Ratio","k = 12 Time", "Doubling Ratio", "k = 24 Time", "Doubling Ratio","k = 48 Time","Doubling Ratio","Predicted Doubling Ratio");
        System.out.printf("%195s\n", "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for ( N = N_Min; N <= N_Max; N = N * 2)
        {


            for( k = k_Min; k <= k_Max; k = k * 2)
            {
                charList = generateTestList(N, k, minV, maxV);
                list = convert2dCharToStringList(charList);
                totalTime = 0;
                trialCount = 0;
                while( totalTime < maxTime && trialCount < maxTrials)
                {
                    timeStampBeforeInsertionSort = getCpuTime();
                    mergeSort(list);
                    timeStampAfterInsertionSort = getCpuTime();
                    timeMeasureForInsertionSort = timeStampAfterInsertionSort - timeStampBeforeInsertionSort;
                    totalTime = totalTime + timeMeasureForInsertionSort;
                    trialCount++;

                }
                averageTimeMeasured = totalTime / trialCount;
                if ( k == 6)
                {
                    k6average = averageTimeMeasured;
                    k6double = (double)averageTimeMeasured / k6previous;
                    k6previous = averageTimeMeasured;

                }
                if ( k == 12)
                {
                    k12average = averageTimeMeasured;
                    k12double = (double)averageTimeMeasured / k12previous;
                    k12previous = averageTimeMeasured;
                }
                if ( k == 24)
                {
                    k24average = averageTimeMeasured;
                    k24double = (double)averageTimeMeasured / k24previous;
                    k24previous = averageTimeMeasured;
                }
                if ( k == 48)
                {
                    k48average = averageTimeMeasured;
                    k48double = (double)averageTimeMeasured / k48previous;
                    k48previous = averageTimeMeasured;
                }

            }
            if ( ((N/2)*(log2(N-1))) == 0){
                predictedDoublingRatio = 2.1;
            }
            else if ( N != N_Min)
            {
                predictedDoublingRatio = (N*(log2(N)))/((N/2)*(log2(N-1)));
            }
            if ( N == 1 )
            {
                String notApplicable = "na";
                System.out.printf("%20s %16s %16s %16s %16s %16s %16s %16s %22s %30s\n", N,k6average,notApplicable,k12average, notApplicable, k24average, notApplicable,k48average,notApplicable,notApplicable);
            } else{
                System.out.printf("%20s %16s %16.2f %16s %16.2f %16s %16.2f %16s %22.2f %30s\n", N,k6average,k6double,k12average, k12double, k24average, k24double,k48average,k48double,predictedDoublingRatio);
            }
        }
    }

    public static void runTimeTestsQuickSort()
    {
        int N;
        int k = 6;
        int d = 1;
        int minV = 1;
        int maxV = 255;
        char[][] charList;
        String [] list;
        int N_Min = 1;
        int N_Max = 1000000000;
        int k_Min = 6;
        int k_Max = 48;
        long maxTime = 10000000;
        long maxTrials = 5;
        long totalTime = 0;
        long trialCount = 0;
        long timeStampBeforeInsertionSort = 0;
        long timeStampAfterInsertionSort = 0;
        long timeMeasureForInsertionSort = 0;
        long averageTimeMeasured = 0;
        double predictedDoublingRatio = 1;
        long k6average = 0;
        long k12average = 0;
        long k24average = 0;
        long k48average = 0;
        double k6double = 0;
        double k12double = 0;
        double k24double = 0;
        double k48double = 0;
        double k6previous = 0;
        double k12previous = 0;
        double k24previous = 0;
        double k48previous = 0;
        /**Print Column Headings**/
        System.out.printf("\n%120s", "Results for Quick Sort\n");
        System.out.printf("\n%20s %16s %16s %16s %16s %16s %16s %16s %22s %30s\n", "N","k = 6 Time","Doubling Ratio","k = 12 Time", "Doubling Ratio", "k = 24 Time", "Doubling Ratio","k = 48 Time","Doubling Ratio","Predicted Doubling Ratio");
        System.out.printf("%195s\n", "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for ( N = N_Min; N <= N_Max; N = N * 2)
        {


            for( k = k_Min; k <= k_Max; k = k * 2)
            {
                charList = generateTestList(N, k, minV, maxV);
                list = convert2dCharToStringList(charList);
                totalTime = 0;
                trialCount = 0;
                while( totalTime < maxTime && trialCount < maxTrials)
                {
                    timeStampBeforeInsertionSort = getCpuTime();
                    quickSort(list, 0, list.length-1);
                    timeStampAfterInsertionSort = getCpuTime();
                    timeMeasureForInsertionSort = timeStampAfterInsertionSort - timeStampBeforeInsertionSort;
                    totalTime = totalTime + timeMeasureForInsertionSort;
                    trialCount++;

                }
                averageTimeMeasured = totalTime / trialCount;
                if ( k == 6)
                {
                    k6average = averageTimeMeasured;
                    k6double = (double)averageTimeMeasured / k6previous;
                    k6previous = averageTimeMeasured;

                }
                if ( k == 12)
                {
                    k12average = averageTimeMeasured;
                    k12double = (double)averageTimeMeasured / k12previous;
                    k12previous = averageTimeMeasured;
                }
                if ( k == 24)
                {
                    k24average = averageTimeMeasured;
                    k24double = (double)averageTimeMeasured / k24previous;
                    k24previous = averageTimeMeasured;
                }
                if ( k == 48)
                {
                    k48average = averageTimeMeasured;
                    k48double = (double)averageTimeMeasured / k48previous;
                    k48previous = averageTimeMeasured;
                }

            }
            if ( ((N/2)*(log2(N-1))) == 0){
                predictedDoublingRatio = 2.0;
            }
            else if ( N != N_Min)
            {
                predictedDoublingRatio = (N*(log2(N)))/((N/2)*(log2(N-1)));
            }
            if ( N == 1 )
            {
                String notApplicable = "na";
                System.out.printf("%20s %16s %16s %16s %16s %16s %16s %16s %22s %30s\n", N,k6average,notApplicable,k12average, notApplicable, k24average, notApplicable,k48average,notApplicable,notApplicable);
            } else{
                System.out.printf("%20s %16s %16.2f %16s %16.2f %16s %16.2f %16s %22.2f %30s\n", N,k6average,k6double,k12average, k12double, k24average, k24double,k48average,k48double,predictedDoublingRatio);
            }
        }
    }

    public static void runTimeTestsRadixSort()
    {
        int N;
        int k = 6;
        int d = 8;
        int minV = 1;
        int maxV = 255;
        char[][] charList;
        String [] list;
        int N_Min = 1;
        int N_Max = 1000000000;
        int k_Min = 12;
        int k_Max = 48;
        long maxTime = 10000000;
        long maxTrials = 10000;
        long totalTime = 0;
        long trialCount = 0;
        long timeStampBeforeInsertionSort = 0;
        long timeStampAfterInsertionSort = 0;
        long timeMeasureForInsertionSort = 0;
        long averageTimeMeasured = 0;
        double predictedDoublingRatio = 1;
        long k6average = 0;
        long k12average = 0;
        long k24average = 0;
        long k48average = 0;
        double k6double = 0;
        double k12double = 0;
        double k24double = 0;
        double k48double = 0;
        double k6previous = 0;
        double k12previous = 0;
        double k24previous = 0;
        double k48previous = 0;
        /**Print Column Headings**/
        System.out.printf("\n%120s", "Results for Three Way Radix QSort d = 8\n");
        System.out.printf("\n%20s %16s %16s %16s %16s %16s %16s %16s %22s %30s\n", "N","k = 6 Time","Doubling Ratio","k = 12 Time", "Doubling Ratio", "k = 24 Time", "Doubling Ratio","k = 48 Time","Doubling Ratio","Predicted Doubling Ratio");
        System.out.printf("%195s\n", "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for ( N = N_Min; N <= N_Max; N = N * 2)
        {


            for( k = k_Min; k <= k_Max; k = k * 2)
            {
                charList = generateTestList(N, k, minV, maxV);
                list = convert2dCharToStringList(charList);
                totalTime = 0;
                trialCount = 0;
                while( totalTime < maxTime && trialCount < maxTrials)
                {
                    timeStampBeforeInsertionSort = getCpuTime();
                    threeWayRadixQSort(list,0, list.length-1,d );
                    timeStampAfterInsertionSort = getCpuTime();
                    timeMeasureForInsertionSort = timeStampAfterInsertionSort - timeStampBeforeInsertionSort;
                    totalTime = totalTime + timeMeasureForInsertionSort;
                    trialCount++;

                }
                averageTimeMeasured = totalTime / trialCount;
                if ( k == 6)
                {
                    k6average = averageTimeMeasured;
                    k6double = (double)averageTimeMeasured / k6previous;
                    k6previous = averageTimeMeasured;

                }
                if ( k == 12)
                {
                    k12average = averageTimeMeasured;
                    k12double = (double)averageTimeMeasured / k12previous;
                    k12previous = averageTimeMeasured;
                }
                if ( k == 24)
                {
                    k24average = averageTimeMeasured;
                    k24double = (double)averageTimeMeasured / k24previous;
                    k24previous = averageTimeMeasured;
                }
                if ( k == 48)
                {
                    k48average = averageTimeMeasured;
                    k48double = (double)averageTimeMeasured / k48previous;
                    k48previous = averageTimeMeasured;
                }

            }
            /*if ( (N/(N/2)) == 0){
                predictedDoublingRatio = 2.0;
            }*/
             if ( N != N_Min)
            {
                predictedDoublingRatio = (N/(N/2));
            }
            if ( N == 1 )
            {
                String notApplicable = "na";
                System.out.printf("%20s %16s %16s %16s %16s %16s %16s %16s %22s %30s\n", N,k6average,notApplicable,k12average, notApplicable, k24average, notApplicable,k48average,notApplicable,notApplicable);
            } else{
                System.out.printf("%20s %16s %16.2f %16s %16.2f %16s %16.2f %16s %22.2f %30s\n", N,k6average,k6double,k12average, k12double, k24average, k24double,k48average,k48double,predictedDoublingRatio);
            }
        }
    }

    public static int log2(int x){
        return (int) (Math.log(x) / Math.log(2));
    }

    public static void verificationTests()
    {
        int N = 32;
        int k = 3;
        int d = 3;
        int minV = 65;
        int maxV = 90;
        char[][] charList;
        boolean test;
        String[] list;


        // Verification Test for Insertion Sort
        /*test = false;
        charList = generateTestList(N, k, minV, maxV );
        list = convert2dCharToStringList(charList);
        System.out.println("Before Sorting");
        printStringList(list);
        insertionSort(list);
        System.out.println();
        System.out.println("After Sorting");
        printStringList(list);
        System.out.println();
        test = isSorted(list);
        System.out.println("Generating list of length " + list.length + " , key width of "+ k +":\nTesting on Insertion Sort...");
        if(test == true)
        {
            System.out.println("Boo Yah This list is Sorted!\n");
        }else{
            System.out.println("This list is not in order :( sort it out...\n");
        }

        // Verification Test for Merge Sort
        test = false;
        charList = generateTestList(N, k, minV, maxV );
        list = convert2dCharToStringList(charList);
        System.out.println("Before Sorting");
        printStringList(list);
        mergeSort(list);
        System.out.println();
        System.out.println("After Sorting");
        printStringList(list);
        System.out.println();
        test = isSorted(list);
        System.out.println("Generating list of length " + list.length + " , key width of "+ k +":\nTesting on Merge Sort...");
        if(test == true)
        {
            System.out.println("Boo Yah This list is Sorted!");
        }else{
            System.out.println("This list is not in order :( sort it out...");
        }

        // Verification for Quick Sort
        test = false;
        charList = generateTestList(N, k, minV, maxV );
        list = convert2dCharToStringList(charList);
        System.out.println("Before Sorting");
        printStringList(list);
        quickSort(list, 0 , list.length-1);
        System.out.println();
        System.out.println("After Sorting");
        printStringList(list);
        System.out.println();
        test = isSorted(list);
        System.out.println("Generating list of length " + list.length + " , key width of "+ k +":\nTesting on Quick Sort...");
        if(test == true)
        {
            System.out.println("Boo Yah This list is Sorted!\n");
        }else{
            System.out.println("This list is not in order :( sort it out...\n");
        }
        */
        // Verification for Radix Sort
        N = 128;
        k = 6;
        test = false;
        charList = generateTestList(N, k, minV, maxV );
        list = convert2dCharToStringList(charList);
        System.out.println("Before Sorting");
        printStringList(list);
        radixSort(list, 1 );
        System.out.println();
        System.out.println("After Sorting");
        printStringList(list);
        System.out.println();
        test = isSorted(list);
        System.out.println("Generating list of length " + list.length + " , key width of "+ k +" and d value of "+ d+ ":\nTesting on Radix Sort...");
        if(test == true)
        {
            System.out.println("Boo Yah This list is Sorted!\n");
        }else{
            System.out.println("This list is not in order :( sort it out...\n");
        }

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
    // Generates a random char array of size N ranging from minV to Max V, adds a null terminator at the kth index
    public static char[][] generateTestList(int N, int k, int minV, int maxV) {
        char[][] charList = new char[N][k+1];
        Random rand = new Random();

        // fill a 2d char array with random chars from minV to maxV
        for ( int i = 0; i < charList.length; i++)
        {
            for( int j = 0; (charList[i] != null && j < charList[i].length-1); j++)
            {
                // insert random char from minV to maxV at pos i , j
                charList[i][j] = (char) ((char)  rand.nextInt(maxV - minV + 1) + minV);
                // insert a null character at the end of every charList[i] **/
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

    public static void radixSort(String[] list, int d)
    {
        int N = list.length;
        String[] output = new String[N];
        int R = 256; //range of values we are using
        // outer loop to iterate by each digit's place starting from the right moving left
        for ( int digit = d-1; digit >= 0; digit--)
        {
            int[] buckets = new int[R+1];
            // count the frequency of each digit in each string store into bucket array
            for ( int i = 0; i < N; i++)
                buckets[list[i].charAt(digit)+1]++;
            // do a prefix sum on buckets
            for ( int j = 1; j < R; j++)
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
