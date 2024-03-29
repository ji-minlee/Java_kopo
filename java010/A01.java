﻿package java010;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class A01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String firstTime = getCurrentTime();

		System.out.println(firstTime);

		int firstSecond = timeOnlySecond(firstTime);
		while (true) {
			System.out.println("input second");
			int overTimeSet = sc.nextInt();

			int overTime = firstSecond + overTimeSet;

			String secondTime = getCurrentTime();

			int secondSecond = timeOnlySecond(secondTime);

			timerSetting(overTime, secondSecond);

			String resetTimeFormat = getCurrentTime();

			firstSecond = timeOnlySecond(resetTimeFormat);
		}

	}

	public static int timeOnlySecond(String Time) {
		String[] timeArray = Time.split(":");
		int[] hourMinSec = { 3600, 60, 1 };
		int totalTime = 0;

		for (int i = 0; i < timeArray.length; i++) {
			totalTime += Integer.parseInt(timeArray[i]) * hourMinSec[i];
		}

		return totalTime;
	}

	public static String getCurrentTime() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date time = new Date();
		String Time = format.format(time);
		return Time;
	}

	public static String secondToFormat(int time) {
		String hour = Integer.toString(time / 3600);
		time %= 3600;
		String minute = Integer.toString(time / 60);
		String second = Integer.toString(time % 60);
		String output = hour + ":" + minute + ":" + second;
		return output;

	}

	public static void timerSetting(int settingTime, int secondTime) {
		if (secondTime < settingTime) {
			try {
				Thread.sleep((settingTime - secondTime) * 1000);
				String alertTime = secondToFormat(settingTime);
				System.out.println("time is over (" + alertTime + ")");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			String alreadyTime = secondToFormat(secondTime);
			System.out.println("time is already over (" + alreadyTime + ")");
		}
	}

}
