package io.munkush.com.bpmn;

import io.munkush.com.dto.OrderRequest;
import io.munkush.com.entity.User;
import io.munkush.com.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class VerificationTask implements JavaDelegate {
    private final UserRepository userRepository;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        var email = ((OrderRequest) delegateExecution.getVariable("order")).getEmail();

        var user = new User();
        user.setEmail(email);

        userRepository.save(user);

        System.out.println(email + " verification...");
    }
}
