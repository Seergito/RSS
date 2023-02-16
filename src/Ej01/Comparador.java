package Ej01;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Comparator;

public class Comparador implements Comparator<noticiaRSS> {

	@Override
	public int compare(noticiaRSS o1, noticiaRSS o2) {
		try {
			Calendar f1=o1.getFechaPubComoCalendar();
			Calendar f2=o2.getFechaPubComoCalendar();
			return f1.compareTo(f2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}

}
