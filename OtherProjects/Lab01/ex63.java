import java.util.Scanner;

public class ex63 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = scanner.nextInt();
		
		for (int i = 1; i <= n; i++) {
			for (int j = i; j< n; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j< 2*i-1; j++) {
				System.out.print("*");
			}
			for (int j = i; j< n; j++) {
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
}
