package Mytest;




import java.io.*;

class CaesarCipherResult {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
    String result="";
    k=k%26; //超过26的求余
     for(int i=0;i<s.length();i++)
    {
      char source=s.charAt(i);
       char temp;
       if((source>='a'&&source<='z')||source>='A'&&source<='Z')
       {
       
      if(source>='a'&&source<='z')
      {

       temp=(char)(source+k);
       
       if(temp>'z')
       {
         temp=(char)(temp-26);//超过的部分减去26
       }
       result=result+temp;
      }
      if(source>='A'&&source<='Z')
      {

       temp=(char)(source+k);
       
       if(temp>'Z')
       {
         temp=(char)(temp-26);
       }
       result=result+temp;
      }
      
       }
      else
       result=result+source;
    }
     System.out.println(result);

     return result;
    }

}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = CaesarCipherResult.caesarCipher(s, k);


        bufferedReader.close();
    }
}
