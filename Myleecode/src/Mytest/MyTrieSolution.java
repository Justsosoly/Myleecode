package Mytest;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

 class MyTrie {
	
	
	TrieNode root=new TrieNode();
	
	public  class TrieNode
	{
	
		int LEN='z'-'a'+1;
		
		boolean leafword;
		
		TrieNode children[];
		
		public TrieNode()
		{
			leafword=false;
			children=new TrieNode[LEN];
			
		}
	}//end for TrieNode	
		public  boolean  insert(String word)
		{
			return insert(word,root);
		}
		
		//插入并查找，有前缀则返回true，无前缀则插入并返回false
		public  boolean  insert(String word,TrieNode root)
		{
			if(word.length()<1||word ==null) return false;//字符串word全部插入完成
			
			int index = word.charAt(0)-'a';
			
		//	TrieNode child=new TrieNode();
			TrieNode child=root.children[index];
			
			//if(child==null)//第一次进入为空则添加
			if(root.children[index]==null)
			{
				child=new TrieNode();     //应该是每次进if的时候都初始化1个新的child给子节点
				root.children[index]=child; 
			}
			else //已经存在,如果连最后一个word字符串也匹配连，则返回true
				if(word.length()==1||root.children[index].leafword==true)
				{
					return true;
				}
			
			if(word.length()==1)//最后一个字符，则修改叶子节点类型为true，并返回没有找到前缀false
			{
				root.children[index].leafword=true;
				return false;
			}
			
			
			return insert(word.substring(1),child);
		}//end insert
		


	

}

public class  MyTrieSolution
{
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
    
    MyTrie mt=new MyTrie();
//    MyTrie.TrieNode tn=mt.new TrieNode();//内部类
//    tn.prefix(words);
    prefix(words); 
    bufferedReader.close();
}
public static  void prefix(List<String> words)
{
	boolean flag=false;
	MyTrie mt=new MyTrie();
	for(int i=0;i<words.size();i++)
	{
		if(mt.insert(words.get(i)))//true 则有前缀 ，false则第一次进入，插入。
			{
			System.out.println("BAD SET");
            System.out.println(words.get(i));
            flag=true;
            break;
			}
		
	}
	if(flag)//无前缀
	System.out.println("GOOD SET");
	
}

}//end class MyTrieSolution
