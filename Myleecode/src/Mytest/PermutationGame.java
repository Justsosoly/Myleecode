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

class PermutationGameResult {

    /*
     * Complete the 'permutationGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
	static Map<String, Boolean> memo = new HashMap<>();

    public static String permutationGame(List<Integer> arr) {
    // Write your code here
    	memo.clear();
    	return findWinner(arr) ? "Bob" : "Alice";
    }
    
    static boolean isIncreasing(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                return false;
        }
    }
    return true;
    }

    static boolean findWinner(List<Integer> arr) {
        String key = arr.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (isIncreasing(arr)) {
            memo.put(key, true);
            return true;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (findWinner(Stream.concat(arr.subList(0, i).stream(),
                arr.subList(i+1, arr.size()).stream())
                .collect(Collectors.toList()))) {
            memo.put(key, false);
            return false;
            }
        }
        memo.put(key, true);
        return true;
    }
}

public class PermutationGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = PermutationGameResult.permutationGame(arr);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
