package com.practicalUnitTesting;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class RaceResultsSendMessagesToSubscribersOnly {
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
}
