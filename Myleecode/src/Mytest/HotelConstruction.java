package Mytest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class HotelConstructionResult {

    /*
     * Complete the 'numberOfWays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY roads as parameter.
     */

    public static int numberOfWays(List<List<Integer>> roads) {
    // Write your code here
    	
    	int result=0;
    	
    	
    	
    	
    	return result;

    }

}

public class HotelConstruction {
    public static void main(String[] args) throws IOException {	
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int roadsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int roadsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> roads = new ArrayList<>();

        IntStream.range(0, roadsRows).forEach(i -> {
            try {
                roads.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = HotelConstructionResult.numberOfWays(roads);


        bufferedReader.close();
    }
}
