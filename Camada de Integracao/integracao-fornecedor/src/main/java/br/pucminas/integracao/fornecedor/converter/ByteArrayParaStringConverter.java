package br.pucminas.integracao.fornecedor.converter;

import java.io.UnsupportedEncodingException;

import org.springframework.core.convert.converter.Converter;

public class ByteArrayParaStringConverter implements Converter<byte[], String> {

	private String charSet = "UTF-8";
	
	@Override
	public String convert(byte[] bytes) {
		try {
			return new String(bytes, this.charSet);
		}catch(UnsupportedEncodingException ex) {
			ex.printStackTrace();
			return new String(bytes);
		}
	}

	public String getCharSet() {
		return charSet;
	}
	
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}
}
