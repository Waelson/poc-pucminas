package br.pucmg.integracao.comum.protocolo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import br.pucmg.integracao.comum.enums.CabecalhoEnum;
import br.pucmg.integracao.comum.enums.TipoMensagemEnum;
import br.pucmg.integracao.comum.util.DataUtil;
import br.pucmg.integracao.comum.util.JsonUtil;
import br.pucmg.integracao.comum.util.RedeUtil;

public class MensagemBuilder {
	
	
	private Map<String, String> cabecalhos = new HashMap<String, String>();
	private String payload;
	private String idCorrelacao;
	private String ipOrigem;

	public MensagemBuilder setFornecedor(String value) {
		cabecalhos.put(CabecalhoEnum.FORNECEDOR.name(), value);
		return this;
	}
	
	public MensagemBuilder setTipoMensagem(TipoMensagemEnum typeMessage) {
		cabecalhos.put(CabecalhoEnum.TIPO_MENSAGEM.name(), typeMessage.name());
		return this;
	}	
	
	public MensagemBuilder setIdCorrelacao(String idCorrelacao) {
		this.idCorrelacao = idCorrelacao;
		return this;
	}
	
	public MensagemBuilder setIpOrigem(String ipOrigem) {
		this.ipOrigem = ipOrigem;
		return this;
	}
	
	public MensagemBuilder comPayload(Object payload) {
		if(payload == null) {
			throw new NullPointerException("Payload nao pode ser nulo.");
		}
		if(payload instanceof String) {
			this.payload = String.class.cast(payload);
		}else {
			this.payload = JsonUtil.getInstance().objetoParaJson(payload);
		}		
		return this;
	}
	
	public Mensagem build() {
		if(idCorrelacao == null || idCorrelacao.trim().isEmpty()) {
			cabecalhos.put(CabecalhoEnum.ID_CORRELACAO.name(), UUID.randomUUID().toString());
		}else {
			cabecalhos.put(CabecalhoEnum.ID_CORRELACAO.name(), idCorrelacao);
		}
		if(ipOrigem == null || ipOrigem.trim().isEmpty()) {
			cabecalhos.put(CabecalhoEnum.IP_ORIGEM.name(), RedeUtil.getIp());
		}else {
			cabecalhos.put(CabecalhoEnum.IP_ORIGEM.name(), ipOrigem);
		}		
		cabecalhos.put(CabecalhoEnum.DATA_HORA_CRIACAO.name(), DataUtil.toStringDefaultFormat(new Date()));		
		Mensagem message = new Mensagem();
		message.setCabecalhos(cabecalhos);
		message.setPayload(payload);
		return message;
	}
}
