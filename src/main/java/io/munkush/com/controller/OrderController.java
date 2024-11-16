package io.munkush.com.controller;

import io.munkush.com.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final RuntimeService runtimeService;
    @PostMapping
    public String submitOrder(@RequestBody OrderRequest request){

        Map<String, Object> variables = new HashMap<>();
        variables.put("order", request);
        runtimeService.startProcessInstanceByKey("Process_Init", variables);

        return null;
    }


}
