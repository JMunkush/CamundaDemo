package io.munkush.com.controller;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static io.munkush.com.bpmn.CamundaProcessEnum.INPUT;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final RuntimeService runtimeService;
    @GetMapping("/input/{number}")
    public String sayHello(@PathVariable String number){
        Map<String, Object> variables = new HashMap<>();
        variables.put("number", number);

        runtimeService.startProcessInstanceByKey(INPUT.getProcessName(), variables);
        return "called";
    }
}
