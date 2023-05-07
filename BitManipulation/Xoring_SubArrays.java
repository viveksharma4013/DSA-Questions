package BitManipulation;
/*
Given an integer array A of size N.

You need to find the value obtained by XOR-ing the contiguous subarrays, followed by XOR-ing the values thus obtained. Determine and return this value.

For example, if A = [3, 4, 5] :

Subarray    Operation   Result
3        None            3
4        None            4
5        None            5
3,4      3 XOR 4         7
4,5      4 XOR 5         1
3,4,5    3 XOR 4 XOR 5   2
Now we take the resultant values and XOR them together:

3 ⊕ 4 ⊕ 5 ⊕ 7 ⊕ 1⊕ 2 = 6 we will return 6.

Input 1:

 A = [1, 2, 3]
Input 2:

 A = [4, 5, 7, 5]
*/

import java.util.ArrayList;
import java.util.List;

public class Xoring_SubArrays {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(List.of(1, 2, 3));
        System.out.println(xoring(al));
    }

    public static int xoring(ArrayList<Integer> a){
        int n=a.size(), sum=0;
        for(int i=0;i<n;i++){
            //current number is contributing in i+1 arrays behind it and n-i arrays ahead of it
            int contri = (i+1)*(n-i);
            if(contri%2!=0){
                sum=sum^a.get(i);
            }
        }
        return sum;
    }
}
