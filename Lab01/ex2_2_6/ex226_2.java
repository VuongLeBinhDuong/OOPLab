package ex2_2_6;
import java.util.Scanner;
public class ex226_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

	    System.out.println("Enter the coefficients for the first equation a1x + b1y = c1:");
	    System.out.println("Enter a1: ");
	    double a1 = scanner.nextDouble();
	    System.out.println("Enter b1: ");
	    double b1 = scanner.nextDouble();
	    System.out.println("Enter c1: ");
	    double c1 = scanner.nextDouble();

	    System.out.println("Enter the coefficients for the second equation a2x + b2y = c2:");
	    System.out.println("Enter a2: ");
	    double a2 = scanner.nextDouble();
	    System.out.println("Enter b2: ");
	    double b2 = scanner.nextDouble();
	    System.out.println("Enter c2: ");
	    double c2 = scanner.nextDouble();

	    // Calculate the determinant
	    double determinant = a1 * b2 - a2 * b1;

	    if (determinant == 0) {
	        System.out.println("The system has no unique solutions.");
	    } else {
	        double x = (c1 * b2 - c2 * b1) / determinant;
	        double y = (a1 * c2 - a2 * c1) / determinant;

	        System.out.println("The solution for the system is:");
	        System.out.println("x = " + x);
	        System.out.println("y = " + y);
	    }
	}

}
