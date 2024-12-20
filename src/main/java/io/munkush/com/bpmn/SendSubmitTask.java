package io.munkush.com.bpmn;

import io.munkush.com.dto.OrderRequest;
import io.munkush.com.entity.Product;
import io.munkush.com.entity.User;
import io.munkush.com.repo.ProductRepository;
import io.munkush.com.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SendSubmitTask implements JavaDelegate {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        var order = ((OrderRequest) delegateExecution.getVariable("order"));

        var email = order.getEmail();

        var user = userRepository.findByEmail(email);

        var products = order.getProducts().keySet();

        for(String product: products){
            var productFromDb = productRepository.findByName(product);
            user.addPurchasedProduct(productFromDb);
        }

        userRepository.save(user);

        System.out.println("Order Submitted !!!! ");
    }
}
