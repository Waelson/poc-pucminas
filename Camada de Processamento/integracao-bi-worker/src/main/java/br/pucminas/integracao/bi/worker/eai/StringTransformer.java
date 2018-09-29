package br.pucminas.integracao.bi.worker.eai;

import org.springframework.batch.core.JobExecution;

public class StringTransformer {
	
	
	public String transform(JobExecution execution) {
		String dirSaida = execution.getJobParameters().getString("output.dir");
		String filename = execution.getJobParameters().getString("output.filename");
		return dirSaida + "/" + filename;
		
	}

}
