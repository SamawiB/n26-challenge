package com.basem.n26.challenge.util;

import java.util.Calendar;
import java.util.Date;

public abstract class DateUtil {

	public static Date getSecondsAgoDate(int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, -seconds);
		return calendar.getTime();
	}

}
