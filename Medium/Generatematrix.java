package Medium;

import java.util.ArrayList;
import java.util.Collections;

public class Generatematrix {

    public static void main(String[] args) {
        int n=2;
        generateMatrix(n);
    }
    public static void generateMatrix(int n) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            mat.add(new ArrayList<>(n));
            mat.get(i).addAll(Collections.nCopies(n, 0));
        }
        int count=1;
        int startCol = 0, endCol = n-1, startRow=0, endRow=n-1;
        while(startCol<=endCol && startRow<=endRow) {
            for (int i = startCol; i <= endCol; i++) {
                mat.get(startRow).set(i, count++);
            }
            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                mat.get(i).set(endCol, count++);
            }
            endCol--;
            for (int i = endCol; i >= startCol; i--) {
                mat.get(endRow).set(i, count++);
            }
            endRow--;
            for (int i = endRow; i >= startRow; i--) {
                mat.get(i).set(startCol, count++);
            }
            startCol++;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf(mat.get(i).get(j)+" ");
            }
            System.out.println();
        }
//        return mat;
    }
}
