package com.like.holiday.domain;

import java.time.LocalDate;
import java.util.List;

public interface HolidayQueryRepository {

	List<Holiday> getHoliday(LocalDate fromDate, LocalDate toDate);
}
