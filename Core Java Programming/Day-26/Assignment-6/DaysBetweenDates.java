package Day_26;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysBetweenDates {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.print("Enter the first date (yyyy-MM-dd): ");
		String firstDateString = scanner.nextLine();
		System.out.print("Enter the second date (yyyy-MM-dd): ");
		String secondDateString = scanner.nextLine();
		LocalDate firstDate = LocalDate.parse(firstDateString, formatter);
		LocalDate secondDate = LocalDate.parse(secondDateString, formatter);
		long daysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);
		System.out.println(
				"Number of days between " + firstDate + " and " + secondDate + " is " + daysBetween + " days.");
	}
}