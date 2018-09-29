package br.pucminas.integracao.bi.master.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkUtil {

	public static String getIp() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			return address.getHostAddress();
		} catch (UnknownHostException e) {
			return null;
		}
	}
	
}
