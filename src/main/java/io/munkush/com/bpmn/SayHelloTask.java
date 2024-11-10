package io.munkush.com.bpmn;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class SayHelloTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("Hello: " + delegateExecution.getVariables().get("name"));
    }
}
