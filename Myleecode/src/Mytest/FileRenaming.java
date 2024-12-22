package Mytest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class FileRenamingResult {

    /*
     * Complete the 'renameFile' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING newName
     *  2. STRING oldName
     */

    public static int renameFile(String newName, String oldName) {
    // Write your code here
    	int result=0;
    	
    	
    	
    	return result;

    }

}

public class FileRenaming {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String newName = bufferedReader.readLine();

        String oldName = bufferedReader.readLine();

        int result = FileRenamingResult.renameFile(newName, oldName);

        bufferedReader.close();
    }
}
