package br.pucmg.integracao.comum.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class RedeUtil {

	public static String getIp() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			return address.getHostAddress();
		} catch (UnknownHostException e) {
			return null;
		}
	}
	
}
