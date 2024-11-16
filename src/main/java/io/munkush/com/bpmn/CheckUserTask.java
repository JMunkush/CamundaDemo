package io.munkush.com.bpmn;

import io.munkush.com.dto.OrderRequest;
import io.munkush.com.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckUserTask implements JavaDelegate {
    private final UserRepository userRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        var order = (OrderRequest) delegateExecution.getVariable("order");

        var email = order.getEmail();

        if(userRepository.existsByEmail(email)){

            delegateExecution.setVariable("isUserExists", true);
        } else {
            delegateExecution.setVariable("isUserExists", false);
        }
    }
}
