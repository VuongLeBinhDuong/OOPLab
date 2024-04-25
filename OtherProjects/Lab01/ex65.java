import java.util.Scanner;

public class ex65 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter array size: ");
		int n = scanner.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter array values: ");
		for (int i =0 ; i< n; i++) {
			arr[i] = scanner.nextInt();
		}
		
		int i, key, j;
	    for (i = 1; i < n; i++) {
	        key = arr[i];
	        j = i - 1;
	        while (j >= 0 && arr[j] > key) {
	            arr[j + 1] = arr[j];
	            j = j - 1;
	        }
	        arr[j + 1] = key;
	    }
	    int sum = 0;
	    for (int k=0;k<n;k++) {
	    	sum = sum + arr[k];
	    }
	    System.out.print("Array sorted values: ");
	    for (int k=0;k<n;k++) {
	    	System.out.print(arr[k] + " ");
	    }
	    System.out.print("\n");
	    System.out.println("Sum of array; " + sum);
	    
	    float avg = (float)sum/n;
	    System.out.println("Average value of array: " + avg);
	}
	
}
