package io.munkush.com.controller;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/receive")
public class ReceiveController {
    private final RuntimeService runtimeService;

    @GetMapping
    public String submitOrder(){

        runtimeService.startProcessInstanceByKey("Process_ReceiveTask", "bKey");

        return "called";
    }

}
