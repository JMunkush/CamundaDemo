package io.munkush.com.bpmn.v2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class ReceivedSuccessTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("success received: " + delegateExecution.getVariable("message"));
    }
}
