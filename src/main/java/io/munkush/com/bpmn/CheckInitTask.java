package io.munkush.com.bpmn;

import io.munkush.com.dto.OrderRequest;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class CheckInitTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {


        var order = (OrderRequest) delegateExecution.getVariable("order");


        if(order.getProducts().size() == 0 ||
                order.getEmail().isEmpty() ||
                order.getEmail().isBlank()){
            throw new BpmnError("validation error");
        }
    }
}
