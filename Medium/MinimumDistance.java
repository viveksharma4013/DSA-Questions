package Medium;
/*
Given a string A which contains only three characters {'x', 'o', '.'}.

Find minimum possible distance between any pair of 'x' and 'o' in the string.

Distance is defined as the absolute difference between the index of 'x' and 'o'.

NOTE: If there is no such pair return -1.

Input 1:

 A = "x...o.x...o"
Input 2:

 A = "xxx...xxx"

 Output 1:

 2
Output 2:

 -1

 */

import java.util.ArrayList;
import java.util.Collections;

public class MinimumDistance {

    public static void main(String[] args) {
        System.out.println(solve("x...o.x...o"));
    }

    public static int solve(String A) {
        int xptr=-1, n =A.length(),minDist=n+1;
        ArrayList<Integer> arr_prefix = new ArrayList<>();
        ArrayList<Integer> arr_suffix = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(A.charAt(i)=='x'){
                xptr = i;
            }
            if(xptr==-1){
                arr_prefix.add(n+1);
            }else{
                arr_prefix.add(i-xptr);
            }
        }
        xptr=-1;
        for(int i=n-1;i>=0;i--){
            if(A.charAt(i)=='x'){
                xptr = i;
            }
            if(xptr==-1){
                arr_suffix.add(n+1);
            }else{
                arr_suffix.add(xptr-i);
            }
        }
        Collections.reverse(arr_suffix);
//        System.out.println(arr_prefix);
//        System.out.println(arr_suffix);
        String pos= "";
        for(int i=0;i<n;i++){
            if(A.charAt(i)=='o'){

                int dist = Math.min(arr_prefix.get(i),arr_suffix.get(i));
                minDist= dist<minDist?dist:minDist;
            }
        }
        return minDist>n?-1:minDist;
    }

}
