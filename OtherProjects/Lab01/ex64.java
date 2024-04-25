import java.util.Scanner;

public class ex64 {
	public static boolean check_leap (int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter month: ");
		String month = scanner.nextLine();
		System.out.println("Enter year: ");
		int year = scanner.nextInt();
		
		boolean leap = check_leap(year);
		
		switch (month) {
			case  "January", "Jan.", "Jan", "1":
				System.out.println("This month has: 31 days");
				break;
			case  "February", "Feb.", "Feb", "2":
				if (leap) {
					System.out.println("This month has: 29 days");
				}
				else {
					System.out.println("This month has: 28 days");
				}
				break;
			case  "March", "Mar.", "Mar", "3":
				System.out.println("This month has: 31 days");
				break;
			case  "April", "Apr.", "Apr", "4":
				System.out.println("This month has: 30 days");
				break;
			case  "May", "5":
				System.out.println("This month has: 31 days");
				break;
			case  "June", "Jun", "6":
				System.out.println("This month has: 30 days");
				break;
			case  "July", "Jul", "7":
				System.out.println("This month has: 31 days");
				break;
			case  "August", "Aug.", "Aug", "8":
				System.out.println("This month has: 31 days");
				break;
			case  "September", "Sept.", "Sep", "9":
				System.out.println("This month has: 30 days");
				break;
			case  "October", "Oct.", "Oct", "10":
				System.out.println("This month has: 31 days");
				break;
			case  "November", "Nov.", "Nov", "11":
				System.out.println("This month has: 30 days");
				break;
			case  "December", "Dec.", "Dec", "12":
				System.out.println("This month has: 31 days");
				break;
			
		}
	}
}
