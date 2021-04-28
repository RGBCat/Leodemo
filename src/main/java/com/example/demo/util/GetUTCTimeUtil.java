package com.example.demo.util;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Javen
 *
 */
public final class GetUTCTimeUtil {


    /**
     * 得到UTC时间，类型为字符串，格式为"yyyy-MM-dd HH:mm"<br />
     * 如果获取失败，返回null
     * @return
     */
    public static Date getUTCTimeStr() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        StringBuffer UTCTimeBuffer = new StringBuffer();
        // 1、取得本地时间：
        Calendar cal = Calendar.getInstance() ;
        // 2、取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day) ;
        UTCTimeBuffer.append(" ").append(hour).append(":").append(minute).append(":").append(second) ;
        try{
            return format.parse(UTCTimeBuffer.toString()) ;

        }catch(ParseException e)
        {
            e.printStackTrace() ;
        }
        return null ;
    }

//    /**
//     * 将UTC时间转换为东八区时间
//     * @param UTCTime
//     * @return
//     */
//    public static String getLocalTimeFromUTC(String UTCTime){
//        java.util.Date UTCDate = null ;
//        String localTimeStr = null ;
//        try {
//            UTCDate = format.parse(UTCTime);
//            format.setTimeZone(TimeZone.getTimeZone("GMT-8")) ;
//            localTimeStr = format.format(UTCDate) ;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return localTimeStr ;
//    }
    public static  void getGMTtIME() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String gmt = dateFormat.format(new Date()) ;
        System.out.println(gmt);
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat1.parse(gmt);
        System.out.println(new Date());
        System.out.println(date.toString());

    }
    public static  Date getGMTtime() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String gmt = dateFormat.format(new Date()) ;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse(gmt);
        return date;
    }

    /**
     * 根据格林威治时间和城市获取对应城市的时间
     * @param dateGMT
     * @param timeZone
     * @return
     * @throws ParseException
     */

    public static  Date getTimeByCity111(Date dateGMT ,String timeZone) throws Exception {
        if(dateGMT==null){
            throw new RuntimeException("格林威治时间不能为空");
        }
        if(StringUtils.isBlank(timeZone)){
            throw new Exception("timeZone不能为空");
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dateLocal = dateFormat.format(dateGMT) ;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        return  dateFormat.parse(dateLocal);
    }

    /**
     * 获得任意时区的时间
     *
     * @param timeZoneOffset
     * @return
     */
    public static String getFormatedDateString(float timeZoneOffset) {
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }
        int newTime = (int) (timeZoneOffset * 60 * 60 * 1000);
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(newTime);
        if (ids.length == 0) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(newTime, ids[0]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date());

    }
    public static  Date getTimeByCity(Date dateGMT ,String timeZone) throws ParseException {
        if(dateGMT==null){
            throw new RuntimeException("格林威治时间不能为空");
        }
        if(StringUtils.isBlank(timeZone)){
            throw new RuntimeException("timeZone不能为空");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        //获取格林威治时间格式
        String dateLocal = dateFormat.format(dateGMT) ;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        return  dateFormat.parse(dateLocal);
    }
    /**
     * 获取某个时区时间获取对应的格林威治时间
     * @param date 某个时区的时间
     * @param timeZone 时区号 东市区为正数 西时区为负数
     * @return
     * @throws ParseException
     */
    public static  Date getGMTtimeByTimeZone(Date date,int timeZone) throws ParseException {
        if(date==null){
            throw new RuntimeException("格林威治时间不能为空");
        }
        long time = date.getTime();
        //获取秒的时间戳
        long timeSecond= time/1000;
        long gmt = (timeSecond-timeZone*60*60)*1000;
        return new Date(gmt);

    }
    public static  Date getTimeByCity(Date date ,int timeZone) throws ParseException {
        if(date==null){
            throw new RuntimeException("格林威治时间不能为空");
        }
        long gmt = date.getTime()+timeZone*60*60*1000;
        return new Date(gmt);
    }

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.getDefault());
//        Calendar calendar = Calendar.getInstance();
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 设置时区为GMT
//        String dateStr = sdf.format(calendar.getTime());
//        System.out.println("格林威治时间为：" + dateStr);
        System.out.println(getUTCTimeStr().getTime());
        System.out.println(getGMTtimeByTimeZone(new Date(),+8));
        System.out.println(new Date().getTime());
        System.out.println(getTimeByCity(getGMTtimeByTimeZone(new Date(),8),7));
        System.out.println((getUTCTimeStr().getTime() - new Date().getTime())/(1000*60*60));
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
//        String dateLocal = dateFormat.format(new Date()) ;
//        System.out.println(dateLocal);
//        System.out.println(getGMTtime());
//        System.out.println(getTimeByCity(getGMTtime(),"GMT+8"));
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        long time = cal.getTimeInMillis();
        System.out.println(time);
        System.out.println(new Date().getTime());
        Date date = new Date(time);
        System.out.println(date);
    }

}