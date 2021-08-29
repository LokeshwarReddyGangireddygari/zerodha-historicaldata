package com.lokesh.history.utils;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@ConfigurationPropertiesBinding
public class DateConverter implements Converter<String, Date>  {
    @Override
    public Date convert(String source) {
        if (source == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}