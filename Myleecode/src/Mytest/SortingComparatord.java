package Mytest;


import java.util.*;

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
	        
	           if(a.score<b.score)
	         {
	             
	             
	             return 1;
	         }
	         else
	         if(a.score==b.score)
	         {
	            String aname=a.name;
	            String bname=b.name;
	             
	            if(aname.compareTo(bname)<0) // the sequence b.compareTo(a)==1  >0
	             return -1;                // a.compareTo(b)=-1 <0
	             else
	             if(aname.compareTo(bname)>0)
	             return 1;   
	             else
	             return 0;     
	         }
	         else
	         return -1;
	      
    }
}


public class SortingComparatord {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}