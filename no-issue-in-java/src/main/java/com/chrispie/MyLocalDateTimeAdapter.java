package com.chrispie;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

import java.time.LocalDateTime;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

// Not the best code but the question is not about using this class and not the implementation

public class MyLocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String dateString) {
        return LocalDateTime.parse(dateString);
    }

    @Override
    public String marshal(LocalDateTime dateTime) {
        if (dateTime != null) {
            return dateTime.format(ISO_LOCAL_DATE_TIME);
        }
        return null;
    }

}
