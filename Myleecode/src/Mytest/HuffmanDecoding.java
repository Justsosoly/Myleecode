package Mytest;

import java.util.*;

abstract class HNode implements Comparable<HNode> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  HNode left, right; 
    public HNode(int freq) { 
      frequency = freq; 
    }
 
    // compares on the frequency
    public int compareTo(HNode tree) {
        return frequency - tree.frequency;
    }
}
 
class HuffmanLeaf extends HNode {
    
 
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}
 
class HuffmanNode extends HNode {
    
    public HuffmanNode(HNode l, HNode r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {

/*  
	class HNode
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  HNode left, right;
    
*/ 

	void decode(String s, HNode root) {
        
		
		String decodestr="";
		
		HNode source=root;

		int i=0;
		
		while(i<s.length())
		{
			char temp=s.charAt(i);
			
			if(root.data!='\0')
				root=source;
			
			
			switch (temp)
			{
			case '0':
				while(root.data=='\0'&&root.left!=null)
				{
					root=root.left;
					if(root.data!='\0')
					{
						decodestr+=String.valueOf(root.data) ;
						i++;
						break;
					}
					i++;
					break;
				}
				break;
				
			case '1':
				
				while(root.data=='\0')
				{
					root=root.right;
					if(root.data!='\0')
					{
					decodestr+=String.valueOf(root.data);
					i++;
					break;
					}
					i++;
					break;
				}
				break;
			}// end swtich
			
		}
		
			System.out.println(decodestr);		
       
    }



}

 
public class HuffmanDecoding {
  
    // input is an array of frequencies, indexed by character code
    public static HNode buildTree(int[] charFreqs) {
      
        PriorityQueue<HNode> trees = new PriorityQueue<HNode>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));
 
        assert trees.size() > 0;
      
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            HNode a = trees.poll();
            HNode b = trees.poll();
 
            // put into new HNode and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
      
        return trees.poll();
    }
  
    public static Map<Character,String> mapA=new HashMap<Character ,String>();
  
    public static void printCodes(HNode tree, StringBuffer prefix) {
      
        assert tree != null;
      
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
 
            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data,prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode nHNode= (HuffmanNode)tree;
 
            // traverse left
            prefix.append('0');
            printCodes(nHNode.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);
 
            // traverse right
            prefix.append('1');
            printCodes(nHNode.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        String test= input.next();
 
        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];
      
        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;
 
        // build tree
        HNode tree = buildTree(charFreqs);
  
        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();
      
        for(int i = 0; i < test.length(); i++) {
          	char c = test.charAt(i);
            s.append(mapA.get(c));
        }
      
        //System.out.println(s);
        Decoding d = new Decoding();
        d.decode(s.toString(), tree);

    }
}
