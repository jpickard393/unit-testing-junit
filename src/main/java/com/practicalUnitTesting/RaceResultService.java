package com.practicalUnitTesting;

import java.util.ArrayList;
import java.util.Collection;

public class RaceResultService {
    // private Client client;  this failed as there were more than one client
    private Collection<Client> clients = new ArrayList<Client>();
    public void addSubscriber(Client client) {
        clients.add(client);
        // this.client = client;
    }

    public void send(Message message) {
        // client.receive(message);
        for(Client client : clients){
            client.receive(message);
        }
    }
}
