package br.pucminas.integracao.fornecedor.converter;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.serializer.Deserializer;

public class JsonSerializer implements Deserializer<String>{

	@Override
	public String deserialize(InputStream inputStream) throws IOException {
		StringBuffer bf = new StringBuffer();
		int c;
		for(int i = 0; i < inputStream.available(); i++) {
			c = inputStream.read();
			if(c < 0) {
				throw new RuntimeException("Socket was closed during building message.");
			}
			bf.append((char) c);
		}
		return bf.toString();
	}

	

}
