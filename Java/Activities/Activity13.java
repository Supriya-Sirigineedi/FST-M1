package activities;

import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter integers please ");
        for(int i=0; i<5; i++){
            arr[i] = sc.nextInt();
        }
        Random r = new Random();
        int index = r.nextInt(arr.length);
        System.out.println("Index value generated: " + index);
        System.out.println("Value in array at generated index: " +arr[index]);
        sc.close();
    }
}
