package ex2_2_6;
import java.util.Scanner;
import java.lang.Math; 
public class ex226_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the coefficients for the equation ax^2 + bx + c = 0 :");
		System.out.println("Enter a : ");
		double a = scanner.nextDouble();
		System.out.println("Enter b : ");
		double b = scanner.nextDouble();
		System.out.println("Enter c : ");
		double c = scanner.nextDouble();
		
		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println("The equation has infinite solution.");
				}
				else {
					System.out.println("The equation has no solution.");
				}
			}
			else {
				System.out.println("The equation has a solution: " + (-c/b));
			}
		}
		else {
			double delta = Math.pow(b, 2) - 4*a*c;
			if (delta < 0) {
				System.out.println("The equation has no solution.");
			}
			else if (delta == 0){
				System.out.println("The equation has 1 solution: " + (-b/(2*a)));
			}
			else {
				System.out.println("The equation has 2 solutions: ");
				System.out.println("x1: " + (-b + Math.sqrt(delta))/(2*a));
				System.out.println("x2: " + (-b - Math.sqrt(delta))/(2*a));
			}
		}
	}
}
