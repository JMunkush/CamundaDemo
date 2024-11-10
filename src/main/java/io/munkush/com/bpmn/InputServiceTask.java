package io.munkush.com.bpmn;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class InputServiceTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Input Number: " + delegateExecution.getVariable("number"));

        if (Integer.parseInt(delegateExecution.getVariable("number").toString()) == 0){
            throw new BpmnError("The number is 0");
        }
    }
}
