package com.practicalUnitTesting;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class ResultsServiceFourthandFifthTest {
    RaceResultService raceResults = new RaceResultService();
    Message message = mock(Message.class);
    Client clientA = mock(Client.class, "clientA");
    Client clientB = mock(Client.class, "clientB");

    @Test
    void notSubscribedClientShouldNotRecieveMessage() {
        raceResults.send(message);
        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber((clientA));
        raceResults.addSubscriber((clientA));
        raceResults.send(message);
        verify(clientA).receive(message);
    }

    @Test
    void unSubscribedClientStopsReceivingMessaged() {
        raceResults.addSubscriber(clientA);
        raceResults.removeSubscriber(clientA);
        raceResults.send(message);
        verify(clientA, never()).receive(message);
    }
}
