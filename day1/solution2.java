package day1;
import java.io.*;
import java.util.*;

public class solution2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day1/input.txt");
        System.out.println("resitev > " + similarityScore(file));
    }

    public static int similarityScore(File file) throws FileNotFoundException {
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

        HashMap<Integer, Integer> repeating = new HashMap<>();

        for (int i : arr2)repeating.put(i, repeating.getOrDefault(i, 0) + 1);

        for(int i: arr1)if(repeating.containsKey(i)) sum+= i*repeating.get(i);

        return sum;
    }
}
