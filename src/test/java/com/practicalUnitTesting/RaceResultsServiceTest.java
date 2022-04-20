package com.practicalUnitTesting;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class RaceResultsServiceTest {
    @Test
    void subScribedClientShouldReceiveMessage() {
        RaceResultService raceResults = new RaceResultService();
        Client client = mock(Client.class);
        Message message = mock(Message.class);
    }
}