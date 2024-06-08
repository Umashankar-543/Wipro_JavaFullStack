package com.java8dateandtime;

import java.time.LocalDate;
import java.time.LocalTime;

public class Example1 {

	public static void main(String[] args) {

		LocalDate date = LocalDate.now();
		System.out.println(date);
		LocalTime time = LocalTime.now();
		System.out.println(time);

		// LocalDate
		LocalDate date1 = LocalDate.now();
		System.out.println(date1);
		int day = date1.getDayOfMonth();
		int month = date1.getMonthValue();
		int year = date1.getYear();
		System.out.println(day + "-" + month + "-" + year);
		System.out.printf("%d-%d-%d", day, month, year);

		// LocalTime
		LocalTime time1 = LocalTime.now();

		System.out.println(time);

		int hour = time1.getHour();
		int min = time1.getMinute();
		int sec = time1.getSecond();
		int nanos = time1.getNano();
		System.out.printf("%d:%d:%d:%d", hour, min, sec, nanos);
	}
}
