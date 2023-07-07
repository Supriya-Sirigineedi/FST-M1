package activities;

public class Activity4 {
    public static void main(String[] args){
        int[] arr = {9, 5, 1, 4, 3};
        System.out.println("Array before sorting");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        int temp=0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("");
        System.out.println("Sorted Array in Ascending Order: ");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }

    }
}
