package day1;
import java.io.*;
import java.util.*;

public class solution1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day1/input.txt");
        System.out.println("resitev > " + sideBySide(file));
    }

    public static int sideBySide(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        StringBuilder fileContent = new StringBuilder();
        int sum = 0;

        while (sc.hasNextLine())fileContent.append(sc.nextLine()).append(" ");
        String[] array = fileContent.toString().trim().split("\\s+");

        int[] arr1 = new int[array.length/2];int[] arr2 = new int[arr1.length];

        for(int i=0; i<array.length/2; i++){
            arr1[(i)]=Integer.parseInt(array[i*2]);
            arr2[(i)]=Integer.parseInt(array[i*2+1]);
        }
        Arrays.sort(arr1);Arrays.sort(arr2);

        for(int i=0; i<arr1.length;i++) {
            sum += Math.abs(arr1[i] - arr2[i]);
        }

        return sum;
    }
}
