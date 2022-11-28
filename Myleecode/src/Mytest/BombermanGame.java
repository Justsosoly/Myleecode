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

class BombermanGameResult {

	/*
	 * Complete the 'bomberMan' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * following parameters: 1. INTEGER n 2. STRING_ARRAY grid
	 */

	public static List<String> bomberMan(int n, List<String> grid) {
		// Write your code here

		List<String> gridfinal = new ArrayList<String>(grid.size());
		gridfinal = explodeGrid(grid);

		if (n == 1 || n == 0) //一开始的1秒
			return grid;

		if (n % 2 == 0)   //偶数秒都全部是炸弹
			return fillGrid(grid);

		if (n % 4 == 3)  //爆炸1
			return gridfinal;

		if (n % 4 == 1)  //爆炸2 交替循环
			return explodeGrid(gridfinal);

		return null;
	}

	public static List<String> explodeGrid(List<String> grid) {
		List<String> explodegrid = new ArrayList<String>();
		String str = grid.get(0);
		char[][] replacerow_arr = new char[grid.size()][str.length()];

		for (int x = 0; x < grid.size(); x++) {
			String r = grid.get(x);
			for (int y = 0; y < r.length(); y++) {
				replacerow_arr[x][y] = 'O';
			}
		}

		for (int i = 0; i < grid.size(); i++) {
			String row = grid.get(i);

			for (int j = 0; j < row.length(); j++) {
				if (row.charAt(j) == 'O') {
					replacerow_arr[i][j] = '.';
					if ((j + 1) < row.length()) {
						replacerow_arr[i][j + 1] = '.';
					}
					if ((j - 1) >= 0) {
						replacerow_arr[i][j - 1] = '.';
					}

					if ((i + 1) < grid.size()) {

						replacerow_arr[i + 1][j] = '.';

					}
					if ((i - 1) >= 0) {
						replacerow_arr[i - 1][j] = '.';
					}

				}
			} // end for j
		} // end for i

		for (int x = 0; x < grid.size(); x++) {
			String temp = "";
			for (int y = 0; y < str.length(); y++) {
				temp += replacerow_arr[x][y];
			}
			explodegrid.add(temp);
			System.out.println(temp);
		}

		return explodegrid;
	}

	public static List<String> fillGrid(List<String> grid)

	{

		List<String> fillgrid = new ArrayList<String>();
		String str = grid.get(0);
		for (int i = 0; i < grid.size(); i++) {
			String strtemp = "";
			String temp = grid.get(i);

			for (int j = 0; j < temp.length(); j++) {
				strtemp += "O";
			} // end j

			fillgrid.add(strtemp);
		} // end i
		return fillgrid;
	}
}

public class BombermanGame {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int r = Integer.parseInt(firstMultipleInput[0]);

		int c = Integer.parseInt(firstMultipleInput[1]);

		int n = Integer.parseInt(firstMultipleInput[2]);

		List<String> grid = IntStream.range(0, r).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<String> result = BombermanGameResult.bomberMan(n, grid);

		bufferedReader.close();
	}
}
