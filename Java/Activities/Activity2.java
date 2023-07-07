package activities;

public class Activity2 {
    public static void main(String[] args){
        int[] arr = {10, 77, 10, 54, -11, 10};
        int search_num =10;
        int fixed_num = 30;
        System.out.println(sumOf10s(arr,search_num, fixed_num));
    }

    public static boolean sumOf10s(int[] arr, int search_num, int fixed_num){
        int sum =0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]==search_num){
                sum+=arr[i];
            }
        }
        return sum == fixed_num;

    }
}
