package io.zeebe.zeebe_get_started_java_client;

import org.junit.Rule;
import org.junit.Test;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.response.WorkflowInstanceEvent;
import io.zeebe.test.ZeebeTestRule;

/**
 * ATENCION NECESITA JAVA 11 PARA FUNCIONAR LOS TESTS
 * @author javier.martin
 *
 */
public class MyTest {

  @Rule public final ZeebeTestRule testRule = new ZeebeTestRule();

  private ZeebeClient client;

  @Test
  public void test() {
    client = testRule.getClient();

    client
        .newDeployCommand()
        .addResourceFromClasspath("my_process.bpmn")
        .send()
        .join();  	
  
    final WorkflowInstanceEvent workflowInstance =
        client
            .newCreateInstanceCommand()
            .bpmnProcessId("process")
            .latestVersion()
            .send()
            .join();
  }
}
