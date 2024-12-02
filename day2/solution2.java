package day2;
import java.io.*;
import java.util.*;

public class solution2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day2/input.txt");
        System.out.println("resitev > " + safeReport(file));
    }

    public static int safeReport(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);int sum=0;

        while (sc.hasNextLine()) {
            String[] strArr = sc.nextLine().split(" ");
            int[] intArr = new int[strArr.length];
            for(int i=0; i<strArr.length; i++){intArr[i]=Integer.parseInt(strArr[i]);}

            if (checkIfIsSafe(intArr)) {
                sum++;continue;
            }
            if(canBeMadeSafe(intArr)){
                sum++;
            }
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

    public static boolean canBeMadeSafe(int[] arr){
        boolean canBeMadeSafe = false;
        for (int i = 0; i < arr.length; i++) {
            int[] modifiedArr = new int[arr.length - 1];
            for (int j = 0, k = 0; j < arr.length; j++) {
                if (j != i) {modifiedArr[k++] = arr[j];}
            }
            if (checkIfIsSafe(modifiedArr)) {
                canBeMadeSafe = true;break;
            }
        }
        return canBeMadeSafe;
    }

}
