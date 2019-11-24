package io.zeebe.zeebe_get_started_java_client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.response.DeploymentEvent;
import io.zeebe.client.api.response.WorkflowInstanceEvent;
import io.zeebe.client.api.worker.JobWorker;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		final ZeebeClient client = ZeebeClient.newClientBuilder()
				// change the contact point if needed
				.brokerContactPoint("127.0.0.1:26500").usePlaintext().build();

		System.out.println("Connected.");

		// ...

		// after the client is connected
		//Desplegar un proceso, se supone que esto se hace solo una vez
/*
		final DeploymentEvent deployment = client.newDeployCommand()
//				.addResourceFromClasspath("order-process.bpmn")
				.addResourceFromClasspath("my_process.bpmn")
				.send()
				.join();

		final int version = deployment.getWorkflows().get(0).getVersion();
		System.out.println("Workflow deployed. Version: " + version);
*/
		// ...
		//Crear una instancia de proceso
	    // after the workflow is deployed

		//Creamos los datos con los que instanciaremos el proceso
		/*
        final Map<String, Object> data = new HashMap<>();
        data.put("orderId", 31243);
        data.put("orderItems", Arrays.asList(435, 182, 376));
        */
        final Map<String, Object> data = new HashMap<>();
        data.put("my_id", 31243);     
        
        

        final WorkflowInstanceEvent wfInstance = client.newCreateInstanceCommand()
//            .bpmnProcessId("order-process")
            .bpmnProcessId("my_process")
            .latestVersion()
            .variables(data)
            .send()
            .join();

        // ...
        //Crear un jobkoerker
        final JobWorker jobWorker = client.newWorker()
            .jobType("payment-service")
            .handler((jobClient, job) ->
            {
                final Map<String, Object> variables = job.getVariablesAsMap();

                System.out.println("Process order: " + variables.get("orderId"));
                double price = 46.50;
                System.out.println("Collect money: $" + price);

                // ...

                final Map<String, Object> result = new HashMap<>();
                result.put("totalPrice", price);

                jobClient.newCompleteCommand(job.getKey())
                    .variables(result)
                    .send()
                    .join();
            })
            .fetchVariables("orderId")
            .open();

        // ...

        // waiting for the jobs
 
        // Don't close, we need to keep polling to get work
        //Pues eso no lo cierres porque sino no va a poder ejecutar los trabajos, hay que darle un tiempo para terminar el trabajo
        // jobWorker.close();
/*
        // ...
        //Cerramos la conexion al broker
		client.close();
		System.out.println("Closed.");
*/
	}
}
