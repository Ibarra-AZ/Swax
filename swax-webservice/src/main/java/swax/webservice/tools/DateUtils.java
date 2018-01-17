package swax.webservice.tools;
import java.text.DateFormat;import java.text.ParseException;import java.text.SimpleDateFormat;import java.util.Date;
public final class DateUtils {
	public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static Date stringToDate(String strDate){		SimpleDateFormat formatter = new SimpleDateFormat(PATTERN);        try {            return formatter.parse(strDate);        } catch (ParseException e) {            e.printStackTrace();        }        return null;	}
	public static String dateToString(Date date){		DateFormat dateFormat = new SimpleDateFormat(PATTERN);		 return dateFormat.format(date); 	}
}
