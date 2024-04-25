import java.util.Scanner;

public class ex62 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("What's your name? ");
		String strName = scanner.nextLine();
		System.out.println("How old are you? ");
		int age = scanner.nextInt();
		System.out.println("How tall are you? ");
		double height = scanner.nextDouble();
		
		System.out.println("Mr/Mrs " + strName + ", " + age + " years old, " + height + " meters tall");
	}
}
