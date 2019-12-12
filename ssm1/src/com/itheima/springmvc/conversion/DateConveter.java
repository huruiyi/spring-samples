package com.itheima.springmvc.conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConveter implements Converter<String, Date> {

	public Date convert(String source) {
		try {
			if (null != source) {
				DateFormat df = new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
				return df.parse(source);
			}
		} catch (Exception e) {
		}
		return null;
	}

}
