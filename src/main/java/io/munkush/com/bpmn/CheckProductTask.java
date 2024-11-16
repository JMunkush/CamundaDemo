package io.munkush.com.bpmn;

import io.munkush.com.dto.OrderRequest;
import io.munkush.com.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CheckProductTask implements JavaDelegate {

    private final ProductRepository productRepository;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        var order = (OrderRequest) delegateExecution.getVariable("order");

        var products = order.getProducts().keySet(); // {"key1":"value1", "key2":"value2"} -> {"key1", "key2"}


        products.forEach(product -> {
            if (!productRepository.existsByName(product)) {
                throw new BpmnError("product exists error");
            }
        });


    }
}
