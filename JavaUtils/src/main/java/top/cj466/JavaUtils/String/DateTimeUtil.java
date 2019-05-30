package top.cj466.JavaUtils.String;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期格式化工具类
 */
public class DateTimeUtil {

    /**
     * 格式 yyyy年MM月dd日 HH:mm:ss
     *
     * @param dateTime
     * @return
     */
    public static String getDateTimeDisplayString(LocalDateTime dateTime) {
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(dateTime);

        return strDate2;
    }

    public static void main(String[] args) {
        Date date = new Date();
        String dateStr =  JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat);
        String dateStr2 =  JSON.toJSONStringWithDateFormat(date, "yy-mm-dd");
        System.out.println(dateStr2);
    }
}
