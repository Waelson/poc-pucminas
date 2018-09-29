package br.pucmg.integracao.comum.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	private ObjectMapper mapper;
	private static JsonUtil instance;
	
	private JsonUtil() {
		mapper = new ObjectMapper();
	}
	
	public static JsonUtil getInstance() {
		if(instance == null) {
			instance = new JsonUtil();
		}
		return instance;
	}
	
	
	public Object jsonParaObject(String json, Class<?> clazz) {
		Object result = null;
		try {
			result = mapper.readValue(json, clazz);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public String objetoParaJson(Object object) {
		String json = null;
		try {
			json = mapper.writeValueAsString(object);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return json;
	}

}
