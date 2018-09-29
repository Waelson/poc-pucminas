package br.pucminas.servico.vendas.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String date2String(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			return sdf.format(date);
		}catch(Exception ex) {
			return null;
		}
	}

}
