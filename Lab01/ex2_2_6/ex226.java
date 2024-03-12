package ex2_2_6;
import java.util.Scanner;

public class ex226 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a (non - zero): ");
		double a = scanner.nextDouble();
		while (a==0) {
			System.out.println("a cannot be 0 in the linear equation");
			System.out.println("Enter a (non - zero): ");
			a = scanner.nextDouble();
		}
		System.out.println("Enter b");
		double b = scanner.nextDouble(); 
		
		System.out.println("The solution: " + (-b/a));
		
	}
}
