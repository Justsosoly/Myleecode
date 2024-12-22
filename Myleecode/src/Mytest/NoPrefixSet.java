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

class NoPrefixSetResult {

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */

   
    
    //输出结果的顺序不能保证是排在前面的单词
    public static void noPrefix2(List<String> words) {
        // Write your code here
           int size=words.size();
        	if(size>=2)
        	{
        	for(int i=0;i<size;i++)
        	{
        		String x=words.get(i);
        	
        		for(int j=0;j<size;j++)
        		{
        			if (i==j) continue;
        			
        			String y=words.get(j);
        			
        			int shorter=Math.min(x.length(), y.length());
        			
        		    if(x.startsWith(y))
        		    {
        		    	System.out.println("BAD SET");
        		    	System.out.println(x);
        		          return;
        		    }
        		}// end for j
        	}//end for i
        	System.out.println("GOOD SET");
        	}//end if
        }//noPrefix function
    
    
    public static void noPrefix(List<String> words) {
        // Write your code here
          Trie trie = new Trie();
            boolean good = true;
            for (String word : words) {
                if (trie.insert(word)) {
                    System.out.println("BAD SET");
                    System.out.println(word);
                    good = false;
                    break;
                }
            }
            if (good)
                System.out.println("GOOD SET");

        }
    
}


class Trie {
    int LEN = 'j' - 'a' + 1;
    Node root = new Node();
    
    class Node {
        Node [] children;
        boolean wordleaf;
        
        Node() {
            children = new Node[LEN];
            wordleaf = false;//默认不是树叶节点
        }
    }
    
    // return true if prefix, otherwise false
    boolean insert(String str) {
        return insert(str, root);    
    }
    
    boolean insert(String str, Node node) {
        if (str == null || str.length() < 1) return false;
        char c = str.charAt(0);
        Node child = node.children[c - 'a'];//从Trie结构里找这个字符
        if (child == null) {//如果在Trie里没有则进行扩展插入
            // extend
            child = new Node();
            node.children[c - 'a'] = child;
        }
        // support both prefix cases, such as (a, ab) and (ab, a)
        else if (child.wordleaf || str.length() == 1) {//如果找到的是叶子节点，则说明有前缀
            return true;
        }
        
        if (str.length() == 1) {
            child.wordleaf = true;//只有1个字符，设置为叶子节点
            return false;    //返回false 表示没有找到前缀
        }
        return insert(str.substring(1), child);
    }
}

public class NoPrefixSet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        NoPrefixSetResult.noPrefix(words);

        bufferedReader.close();
    }
}
