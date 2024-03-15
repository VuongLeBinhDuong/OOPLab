import java.util.Scanner;
public class ex225 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter 1st number");
		double num1 = keyboard.nextDouble(); 
		System.out.println("Enter 2nd number");
		double num2 = keyboard.nextDouble(); 
		
		double sum = num1 + num2;
		double different = num1 - num2;
		double product = num1 * num2;
		double quotient = num1 / num2;
		
		System.out.println("Sum: " + sum);
		System.out.println("Different: " + different);
		System.out.println("Product: " + product);
		if (num2 != 0) {
			System.out.println("Quotient: " + quotient);
		}
		else{
			System.out.println("There is no quotient since num2 = 0");
		}
	}
}
