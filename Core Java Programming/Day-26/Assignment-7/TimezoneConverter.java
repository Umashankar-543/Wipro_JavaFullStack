package Day_26;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimezoneConverter {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter24Hour = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		DateTimeFormatter formatter12Hour = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a");
		System.out.print("Enter the date and time (yyyy-MM-dd HH:mm or yyyy-MM-dd h:mm a): ");
		String dateTimeString = scanner.nextLine();
		System.out.print("Enter the source timezone (e.g., America/New_York): ");
		String sourceTimezone = scanner.nextLine();
		System.out.print("Enter the target timezone (e.g., Europe/London): ");
		String targetTimezone = scanner.nextLine();
		LocalDateTime localDateTime;
		try {
			localDateTime = LocalDateTime.parse(dateTimeString, formatter24Hour);
		} catch (Exception e) {
			try {
				localDateTime = LocalDateTime.parse(dateTimeString, formatter12Hour);
			} catch (Exception ex) {
				System.out.println("Invalid date/time format.");
				return;
			}
		}
		ZoneId sourceZoneId = ZoneId.of(sourceTimezone);
		ZoneId targetZoneId = ZoneId.of(targetTimezone);
		ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, sourceZoneId);
		ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZoneId);
		System.out.println("Source time: " + sourceZonedDateTime);
		System.out.println("Converted time: " + targetZonedDateTime);
	}
}