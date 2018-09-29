package br.pucmg.integracao.comum;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.pucmg.integracao.comum.enums.TipoMensagemEnum;
import br.pucmg.integracao.comum.protocolo.Mensagem;
import br.pucmg.integracao.comum.protocolo.MensagemBuilder;

public class AppMain {

	
	public static void main(String[] args) {
		try {
			Map<String, String> mapa = new HashMap<String, String>();
			mapa.put("nome", "Deborah");
			
			ObjectMapper mapper = new ObjectMapper();			
			Mensagem message = new MensagemBuilder()
					.setFornecedor("00.000.000/0001-00")
					.setTipoMensagem(TipoMensagemEnum.INCLUIR_PRODUTO)
					.comPayload(mapa)
					.build();
			
			String json = mapper.writeValueAsString(message);
			System.out.println(json);
			System.out.println("----------------");
			Mensagem m = mapper.readValue(json, Mensagem.class);
			System.out.println("Headers: " + m.getCabecalhos().toString());
			System.out.println("Payload: " + m.getPayload());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
