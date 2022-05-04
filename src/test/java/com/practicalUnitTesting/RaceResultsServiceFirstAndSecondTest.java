package com.practicalUnitTesting;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RaceResultsServiceFirstAndSecondTest {
    @Test
    void subscribedClientShouldReceiveMessage() {
        RaceResultService raceResults = new RaceResultService();
        Client client = mock(Client.class);
        Message message = mock(Message.class);
        raceResults.addSubscriber(client);
        raceResults.send(message);
        verify(client).receive(message);
    }

    @Test
    void messageShouldBeSentToAllSubscribedClients() {
        RaceResultService raceResults = new RaceResultService();
        Client clientA = mock(Client.class, "clientA");
        Client clientB = mock(Client.class, "clientB");
        Message message = mock(Message.class);

        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }
}
