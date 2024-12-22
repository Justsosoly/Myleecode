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

class BFSShortestReachResult {

	/*
	 * Complete the 'bfs' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER n 2. INTEGER m 3. 2D_INTEGER_ARRAY edges 4.
	 * INTEGER s
	 */

	public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
		// Write your code here n is the number of nodes,m is the edges number
		List<Integer> result = new ArrayList<Integer>();
		LinkedList<Integer> templist = new LinkedList<Integer>();
		Map<Integer, Set> edgesmap = new HashMap<Integer, Set>();
		// System.out.println("the start node is "+s);

		for (int i = 0; i < n; i++) {
			result.add(i, -1);
		}

		for (int i = 0; i < m; i++) {
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);
			Set tempsetv = new HashSet();
			Set tempsetu = new HashSet();
			// System.out.println("the "+i+" edges is: "+u+" "+v);
			tempsetv.add(v);
			tempsetu.add(u);
			if (edgesmap.containsKey(u))// v add to the sets
			{
				edgesmap.get(u).addAll(tempsetv);

			} else// first initial map
			{
				edgesmap.put(u, tempsetv);
			}
			if (edgesmap.containsKey(v)) {
				edgesmap.get(v).addAll(tempsetu);
			} else {
				edgesmap.put(v, tempsetu);
			}

		}

		templist.add(s);
		int hight = 0;
	//	result.set(s - 1, 0);
		while (!templist.isEmpty()) {

			int pop = templist.getFirst();// 取出一个终端端点
			templist.removeFirst();// 删除value这个端点

			if (edgesmap.containsKey(pop)) {
				Set temp = edgesmap.get(pop);

				templist.addAll(temp);
				Iterator it = temp.iterator();
				while (it.hasNext()) {
					int index = (int) it.next();

					if (result.get(index - 1) == -1) {//没有处理过的

						if (result.get(pop - 1) == -1)//出发点的高度，第一层的进来
							hight = 1;
						else
							hight = result.get(pop - 1) / 6 + 1;//第二层以后要更新
						
						result.set(index - 1, hight * 6);
					}
				}
			}
			edgesmap.remove(pop);// 处理完了pop开始的这条边
		} // end for while templist

		result.remove(s - 1);

		return result;

	}

}

public class BFSShortestReach {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, q).forEach(qItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int n = Integer.parseInt(firstMultipleInput[0]);

				int m = Integer.parseInt(firstMultipleInput[1]);

				List<List<Integer>> edges = new ArrayList<>();

				IntStream.range(0, m).forEach(i -> {
					try {
						edges.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
								.map(Integer::parseInt).collect(toList()));
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				});

				int s = Integer.parseInt(bufferedReader.readLine().trim());

				List<Integer> result = BFSShortestReachResult.bfs(n, m, edges, s);

			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}
}
