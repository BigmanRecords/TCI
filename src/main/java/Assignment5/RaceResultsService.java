package Assignment5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class RaceResultsService {

    private Collection<Client> clients = new HashSet<>();

    public void addSubscriber(Client client,RaceCategory category){

        this.clients.add(client);
    }

    public void send(Message message){

        for (Client c: this.clients ) {
            c.recieve(message);
        }
    }

    public void removeSubscriber(Client client){
        this.clients.remove(client);
    }
}
