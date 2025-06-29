package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test //Exercise 2 Verifying Interactions
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }

    @Test//Exercise 3 Argument Matching
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.processAndSend("Hello World");

        verify(mockApi).sendData(eq("Hello World"));
    }

    @Test//Exercise 4 Handling Void Methods
    public void testVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.performLogging();

        verify(mockApi).logAction();
    }

    @Test//Exercise 5 Mocking and Stubbing with Multiple Returns
    public void testMultipleReturnValues() {
        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData())
                .thenReturn("First Call")
                .thenReturn("Second Call")
                .thenReturn("Third Call");

        MyService service = new MyService(mockApi);

        assertEquals("First Call", service.fetchData());

        assertEquals("Second Call", service.fetchData());

        assertEquals("Third Call", service.fetchData());
    }

    //Exercise 6 Verifying Interaction Order
    @Test
    public void testVerifyInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.completeProcess("Test Message");

        InOrder inOrder = inOrder(mockApi);

        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).sendData("Test Message");
        inOrder.verify(mockApi).logAction();
    }

    //Exercise 7: Handling Void Methods with Exceptions
    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        
        doThrow(new RuntimeException("Simulated Exception"))
                .when(mockApi).logAction();

        service.performLogging();

        verify(mockApi).logAction();
    }
}
