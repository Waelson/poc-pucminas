package br.pucmg.integracao.comum.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	
	public static final String FILE_FORMAT = "yyyyMMdd_HHmmss";
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
	
	public static String toStringDefaultFormat(Date date) {
		return toString(date, DEFAULT_FORMAT);
	}

}
