package com.camunda.demo.camunda_BPMN_Communication;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AskTeamSupportForHelp implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		//Mando un mensaje correlacionado con la instancia de proceso con datos de la pregunta
		String question = (String) execution.getVariable("question");
		
		execution.getProcessEngineServices().getRuntimeService()
		.createMessageCorrelation("AskTeamSupport")
		.setVariable("question", question)
		.correlate();

	}

}
