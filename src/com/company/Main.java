package com.company;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int N = 5;
        int k = 4;
        int minV = 66;
        int maxV = 66;
        String string;
        char[] list;
        list = generateTestList(N, k, minV, maxV );

        for ( int i = 0; i <N; i++)
        {
            System.out.println(list[i]);
        }

        string = new String(list);

        System.out.println(list);
        System.out.println("HI\n");
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

    /** Generates a random char array of size N ranging from minV to Max V, adds a null terminator at the kth index **/
    public static char[] generateTestList(int N, int k, int minV, int maxV) {
        char[] charList = new char[N];
        Random rand = new Random();
        /** fill a char array with random chars from minV to maxV **/
        for ( int i = 0; i < N; i++)
        {

            charList[i] = (char) (rand.nextInt( maxV - minV + 1) + minV);

            /** insert a null character at the end of charList **/
            if ( i == k)
            {
                charList[i] = '\0';
            }
        }


        return charList;
    }
}