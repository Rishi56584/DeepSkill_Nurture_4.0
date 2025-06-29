package com.example;

public class MyService {

    //Excersice 1
    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    //Excersice 3
    public void processAndSend(String message) {
        externalApi.sendData(message);
    }

    //Excersice 4
    public void performLogging() {
        try { //Excersice 6 try & catch
            externalApi.logAction();
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
    //Excersice 6
    public void completeProcess(String message) {
        externalApi.getData();
        externalApi.sendData(message);
        externalApi.logAction();
    }
}
