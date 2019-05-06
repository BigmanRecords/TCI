package Assignment5;

import java.util.*;

public class RaceResultsService {

    private HashMap<RaceCategory, List<Client>> clients = new HashMap<>();

    public RaceResultsService(){

        for(RaceCategory raceCategory : RaceCategory.values()){
            this.clients.put(raceCategory,new ArrayList<>());
        }
    }

    public void addSubscriber(Client client,RaceCategory category){

        List<Client> temp = this.clients.get(category);

        temp.add(client);

        this.clients.put(category,temp);
    }

    public void send(Message message){

        List<Client> temp = this.clients.get(message.getCategory());

        for (Client c: temp) {
            c.receive(message);
        }
    }

    public void removeSubscriber(Client client){

        for(RaceCategory raceCategory : RaceCategory.values()){

            clients.get(raceCategory).remove(client);
        }
    }

    public void removeSubscriber(Client client, RaceCategory category){

    }
}
