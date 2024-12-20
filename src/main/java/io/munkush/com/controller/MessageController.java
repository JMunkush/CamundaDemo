package io.munkush.com.controller;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/message")
public class MessageController {
    private final RuntimeService runtimeService;
    @PostMapping
    public String submitOrder(@RequestBody String message){


        this.runtimeService
                .createMessageCorrelation("Message_FromClient")
                .processInstanceBusinessKey("bKey")
                .setVariable("message", message)
                .correlateWithResult();


        return "sent";
    }

}
