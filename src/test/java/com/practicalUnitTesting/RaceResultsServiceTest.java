package com.practicalUnitTesting;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RaceResultsServiceTest {
    @Test
    void subScribedClientShouldReceiveMessage() {
        RaceResultService raceResults = new RaceResultService();
        Client client = mock(Client.class);
        Message message = mock(Message.class);

        raceResults.addSubscriber(client);
        raceResults.send(message);

        verify(client).receive(message);
    }
}

