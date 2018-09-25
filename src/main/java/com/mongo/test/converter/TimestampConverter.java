package com.mongo.test.converter;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 下午12:07 2018/9/25
 * @Modified By:
 */
public class TimestampConverter implements Converter<Date, Timestamp> {
    public Timestamp convert(Date date){
        if(date != null)
            return new Timestamp(date.getTime());
        return null;
    }
}
