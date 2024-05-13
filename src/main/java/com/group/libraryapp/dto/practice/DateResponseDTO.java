package com.group.libraryapp.dto.practice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateResponseDTO {

    private String dayOfTheWeek;

    public DateResponseDTO(String date){
        LocalDate localDate = LocalDate.parse(date);
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        this.dayOfTheWeek = dayOfWeek.getDisplayName(TextStyle.SHORT,
                Locale.KOREA).toUpperCase();
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
