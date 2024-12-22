package Mytest;


import java.io.*;
import java.util.*;
 
class GFG {
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        if (s.isEmpty() || p.isEmpty())
            return "-1";
 
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int i = 0, j = 0, count = map.size();//count一开始是map的全部大小
        int left = 0, right = 0, min = s.length();
        boolean found = false;
        //首先向右移动j，找出包含pattern里全部都字母
        while (j < s.length()) {
            char endchar = s.charAt(j++);
            if (map.containsKey(endchar)) {
                map.put(endchar, map.get(endchar) - 1);//右移找到则减少map的value
                if (map.get(endchar) == 0)//该字母递减为0，则该字母全部找到，将count减少1
                    count -= 1;
            }
            if (count > 0)//pattern里的全部字母都可以在string里找到
                continue;
            
            //count=0则开始向右移动i，删除字符串左边的字母，找出最小的包含pattern的字符串
            while (count == 0) {
                char strchar = s.charAt(i++);
                if (map.containsKey(strchar)) {
                    map.put(strchar, map.get(strchar) + 1);//右移找到则增加map的value
                    if (map.get(strchar) > 0)//大于0,表明找到一个字母
                        count += 1;
                }
            }
            if ((j - i) < min) {
                left = i - 1;
                right = j;
                min = j - i;
 
                found = true;
            }
        }
        return !found ? "-1" : s.substring(left, right);
    }
    public static void main(String[] args)
    {
        String str = "this is a test string";
        String pat = "tist";
 
        System.out.print(smallestWindow(str, pat));
    }
}
// This code is contributed by Raunak Singh