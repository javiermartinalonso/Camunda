package com.camunda.demo.camundaSimpleDemo;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckWeatherDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		
		Random random = new Random();
		
		execution.setVariable("name", "Nialll");
		execution.setVariable("weatherOk", random.nextBoolean());

	}

}
