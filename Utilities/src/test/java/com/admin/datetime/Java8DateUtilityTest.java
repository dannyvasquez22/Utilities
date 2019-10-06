package com.admin.datetime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.admin.util.Java8DateUtility;

public class Java8DateUtilityTest {

	@Test
	public void getLocalDateFromClockTest() {
		System.out.println("Current date ::" + Java8DateUtility.getLocalDateFromClock());
		assertEquals(LocalDate.now(), Java8DateUtility.getLocalDateFromClock());
	}

	@Test
	public void getNextDayTest() {
		LocalDate date = Java8DateUtility.getNextDay(LocalDate.now());
		System.out.println("Next Day ::" + date);
		assertNotNull(date);
	}

	@Test
	public void getPreviousDayTest() {
		System.out.println("Get Previous Day :: " + Java8DateUtility.getPreviousDay(LocalDate.now()));
	}

	@Test
	public void getDayOfWeekTest() {
		System.out.println("Get Day Of Week :: " + Java8DateUtility.getDayOfWeek(LocalDate.now()));
	}

	@Test
	public void getFirstDayOfMonthTest() {
		System.out.println("Get First day of Month :: " + Java8DateUtility.getFirstDayOfMonth());
	}

	@Test
	public void getStartOfDayTest() {
		System.out.println("Get start of day :: " + Java8DateUtility.getStartOfDay(LocalDate.now()));
	}

	@Test
	public void printCurrentDayMonthAndYearTest() {
		Java8DateUtility.printCurrentDayMonthAndYear();
	}

	@Test
	public void checkDateEqualsTest() {
		assertTrue(Java8DateUtility.checkDateEquals(LocalDate.now(), LocalDate.now()));
	}

	@Test
	public void getCurrentTime() {
		assertEquals(Java8DateUtility.getCurrentTime(), LocalTime.now());
	}

	@Test
	public void addHoursToTime() {
		System.out.println("Added hours to time :: " + Java8DateUtility.addHoursToTime(1));
	}

	@Test
	public void timeZoneTest() {
		System.out.println("America/Los_Angeles Zone :: " + Java8DateUtility.timeZone("America/Los_Angeles"));
	}

	@Test
	public void checkLeapYear() {
		Java8DateUtility.checkLeapYear();
	}

	@Test
	public void getTimeStamp() {
		System.out.println("get time stamp ::" + Java8DateUtility.getTimeStamp());
	}

	@Test
	public void getZonedDateTime() {
		System.out.println("" + Java8DateUtility.getZonedDateTime(LocalDateTime.now(), ZoneId.of("Europe/Paris")));
	}

	@Test
	public void getDifferenceBetweenDates() {
		System.out.println("Difference between two dates :: "
				+ Java8DateUtility.getDifferenceBetweenDates(LocalTime.now(), LocalTime.now().plusHours(12)));
	}

	@Test
	public void getLocalDateTimeUsingParseMethod() {
		System.out.println("Get local date time using parse method :: "
				+ Java8DateUtility.getLocalDateTimeUsingParseMethod(DateTimeFormatter.BASIC_ISO_DATE.toString()));
	}

	@Test
	public void convertDateToLocalDate() {
		System.out.println("Convert Date to LocalDate :: " + Java8DateUtility.convertDateToLocalDate(new Date()));
	}

	@Test
	public void convertCalenderToLocalDateTest() {
		System.out.println("Convert Calender to LocalDate :: "
				+ Java8DateUtility.convertDateToLocalDate(Calendar.getInstance().getTime()));
	}
}