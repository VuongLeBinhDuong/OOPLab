import java.util.Scanner;

public class ex66 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter 1st matrix size: ");
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		
		System.out.println("Enter 2nd matrix size: ");
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		
		int[][] matrix1 = new int[x1][y1];

		int[][] matrix2 = new int[x2][y2];
		
		if (x1 != x2 || y1 != y2) {
			System.out.println("Cannot add 2 matrices with different size.");
			return;
		}
		else {
			System.out.println("Enter 1st matrix values: ");
			for (int i=0;i<x1;i++) {
				for (int j=0;j<y1;j++) {
					matrix1[i][j] = scanner.nextInt();
				}
			}
			System.out.println("Enter 2nd matrix values: ");
			for (int i=0;i<x2;i++) {
				for (int j=0;j<y2;j++) {
					matrix2[i][j] = scanner.nextInt();
				}
			}
		}
		
		int[][] matrix3 = new int[x1][y1];
		for (int i=0;i<x2;i++) {
			for (int j=0;j<y2;j++) {
				matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		
		System.out.println("Sum of 2 matrices: ");
		for (int i=0;i<x2;i++) {
			for (int j=0;j<y2;j++) {
				System.out.print(matrix3[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
