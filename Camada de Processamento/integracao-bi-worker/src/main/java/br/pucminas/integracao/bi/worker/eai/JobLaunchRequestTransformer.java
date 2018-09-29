package br.pucminas.integracao.bi.worker.eai;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.integration.launch.JobLaunchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import br.pucminas.integracao.bi.worker.model.MensagemGeracaoArquivo;
import br.pucminas.integracao.bi.worker.util.DateUtil;

public class JobLaunchRequestTransformer {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public JobLaunchRequest convert(MensagemGeracaoArquivo mensagem) {
		String jobName = "JOB_" + mensagem.getTipoArquivo();
		
		if(!applicationContext.containsBean(jobName)) {
			throw new RuntimeException("Job " + jobName + " nao encontrado.");
		}
		
		Job job = (Job) applicationContext.getBean(jobName);
		
		JobParametersBuilder builder = new JobParametersBuilder();
		builder.addString("output.filename", mensagem.getTipoArquivo() + "_" + 
				DateUtil.toString(new Date(), DateUtil.FILE_FORMAT) + ".CSV");
		builder.addString("output.dir", mensagem.getDiretorioSaida());
		
		
		return new JobLaunchRequest(job, builder.toJobParameters());
	}
	
	
}
