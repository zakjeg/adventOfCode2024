package day2;
import java.io.*;
import java.util.*;

public class solution1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day2/input.txt");
        System.out.println("resitev > " + safeReports(file));
    }

    public static int safeReports(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);int sum=0;

        while (sc.hasNextLine()) {
            String[] strArr = sc.nextLine().split(" ");
            int[] intArr = new int[strArr.length];
            for(int i=0; i<strArr.length; i++){intArr[i]=Integer.parseInt(strArr[i]);}
            if(checkIfIsSafe(intArr))sum++;
        }
        return sum;
    }

    public static boolean checkIfIsSafe(int[] arr){
        boolean increasing = arr[0] < arr[arr.length - 1];
        for(int i=0; i<arr.length-1; i++){
            if(increasing ^ arr[i]<arr[i+1] || arr[i]==arr[i+1] || Math.abs(arr[i]-arr[i+1])>3)return false;
        }
        return true;
    }


}
