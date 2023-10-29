package main.middle;

public class test_findsmallestcommonelementinallrows {
    public static void main(String[] args) {
        int[][] a  = new int[][]{{1,2,3},{2,3,4},{2,3,5}};
        System.out.println(new test_findsmallestcommonelementinallrows().smallestCommonElement(a));
    }
    public int smallestCommonElement(int[][] mat) {
        for(int i=0;i<mat[0].length;i++){
            int target = mat[0][i];
            int j = 1;
            for(;j<mat.length;j++){
                if(bin(target,mat[j]) == false){
                    break;
                }

            }
            if(j==mat.length)
                return target;
        }
        return -1;
    }
    public boolean bin(int target,int[] a){
        int i=0,j=a.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(a[mid] == target)
                return true;
            if(target<a[mid])
                j =mid -1;
            else
                i = mid +1;
        }
        return false;
    }
}
