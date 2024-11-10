package io.munkush.com.controller;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static io.munkush.com.bpmn.CamundaProcessEnum.SAY_HELLO;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final RuntimeService runtimeService;
    @GetMapping("/say-hello/{name}")
    public String sayHello(@PathVariable String name){
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", name);
        runtimeService.startProcessInstanceByKey(SAY_HELLO.getProcessName(), variables);
        return "called";
    }
}
