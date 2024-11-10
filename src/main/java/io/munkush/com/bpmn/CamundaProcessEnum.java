package io.munkush.com.bpmn;

public enum CamundaProcessEnum {
    SAY_HELLO("Process_SayHello"),
    INPUT("Process_InputService");

    final String processName;

    public String getProcessName() {
        return processName;
    }

    CamundaProcessEnum(String processSayHello) {
        this.processName = processSayHello;
    }
}
