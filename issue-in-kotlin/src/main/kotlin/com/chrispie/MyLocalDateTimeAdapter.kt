package com.chrispie

import jakarta.xml.bind.annotation.adapters.XmlAdapter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// Not the best code but the question is not about using this class and not the implementation

class MyLocalDateTimeAdapter : XmlAdapter<String?, LocalDateTime?>() {

    override fun unmarshal(dateString: String?): LocalDateTime? {
        return LocalDateTime.parse(dateString!!, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }

    override fun marshal(dateTime: LocalDateTime?): String? {
        return dateTime?.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }
}

