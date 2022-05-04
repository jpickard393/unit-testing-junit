package com.practicalUnitTesting;

import java.util.Collection;
import java.util.HashSet;

public class RaceResultService {
    // private Client client;  this failed as there were more than one client
    private Collection<Client> clients = new HashSet<Client>();
    public void addSubscriber(Client client) {
        clients.add(client);
        // this.client = client;
    }

    public void removeSubscriber(Client client){
        clients .remove(client);
    }

    public void send(Message message) {
        // client.receive(message);
        for(Client client : clients){
            client.receive(message);
        }
    }
}
