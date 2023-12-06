package 并发.ThreadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xuchengrui
 * @Date: 2023/12/6
 * @Description:simpleFormatDate
 **/
public class ThreadLocalExample3 {
    private static final ThreadLocal<SimpleDateFormat> f = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {
        int i=0;
        while (i<10) {
            new Thread(() -> {
                String dateStr = f.get().format(new Date());
                try {
                    Date parseDate = f.get().parse(dateStr);
                    String dateStrCheck = f.get().format(parseDate);
                    boolean equals = dateStr.equals(dateStrCheck);
                    if (!equals) {
                        System.out.println(equals + " " + dateStr + " " + dateStrCheck);
                    } else {
                        System.out.println(equals);
                    }
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            }).start();
            i++;
        }
    }
}
