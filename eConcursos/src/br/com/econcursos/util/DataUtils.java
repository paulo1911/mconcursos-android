package br.com.econcursos.util;


import android.annotation.SuppressLint;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * @author Paulo
 *
 */
public class DataUtils {

	public static Date getDateFromGregorianCalendar(GregorianCalendar gregorianCalendar) {
		if(gregorianCalendar != null) {
			
			return gregorianCalendar.getTime();
		}
		return null;
	}
	
	public static Date getDateFromString(String dateString) {
		if(dateString != null) {
			
			try {
				return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US).parse(dateString);
			} catch (ParseException e) {

			}
		}
		return null;
	}
	
	public static GregorianCalendar getGregorianCalendarFromDate(Date date) {
		
		GregorianCalendar toREturn = null;
		
		if(date != null) {
		
			toREturn = new GregorianCalendar();
			toREturn.setTime(date);
			
			return toREturn;
		}
		return null;
	}

	@SuppressLint("SimpleDateFormat")
	public static String formatDateDiaMesAno(Date dataPublicacao) {

		if(dataPublicacao !=null) {			
			return new SimpleDateFormat("dd/mm/yyyy").format(dataPublicacao);			
		}		
		return null;
	}
}
