package br.pucminas.integracao.bi.master.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static final String DAY_FORMAT = "dd/MM/yyyy"; 
	public static final String DEFAULT_FORMAT = "dd/MM/yyyy HH:mm:ss"; 
	
	public static String toString(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}catch(Exception ex) {
			return null;
		}
	}

}
