package com.shishakalex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given an array of integers, find the sum of its elements.
 * Function Description
 *
 * Complete the simpleArraySum function in the editor below. It must return the sum of the array elements as an integer.
 *
 * simpleArraySum has the following parameter(s):
 *
 * ar: an array of integers
 *
 * Input Format
 *
 * The first line contains an integer, n, denoting the size of the array.
 * The second line contains n space-separated integers representing the array's elements.
 *
 * Output Format
 *
 * Print the sum of the array's elements as a single integer.
 */

public class SimpleArraySum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer numberOfIntegers = Integer.parseInt(reader.readLine());
        String stringOfIntegers = reader.readLine();
        String[] temps = stringOfIntegers.split(" ");

        if (numberOfIntegers != temps.length){
            throw new IllegalArgumentException("Incorrect input data");
        }

        int[] arrayOfIntegers = new int[numberOfIntegers];
        for (int i = 0; i < temps.length; i++) {
            arrayOfIntegers[i] = Integer.parseInt(temps[i]);
        }

        System.out.println(countSumArrayElements(arrayOfIntegers));
        reader.close();
    }

    public static int countSumArrayElements(int[] array){
        return Arrays.stream(array).sum();
    }
}
