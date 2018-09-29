package br.pucminas.integracao.bi.master.eai;

import br.pucminas.integracao.bi.master.model.MensagemGeracaoArquivo;

public interface MensagemGateway {
	
	public void send(MensagemGeracaoArquivo mensagem);

}
