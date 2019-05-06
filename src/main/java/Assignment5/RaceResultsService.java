package Assignment5;

import java.util.*;

public class RaceResultsService {

    private HashMap<RaceCategory, List<Client>> clients = new HashMap<>();

    public void addSubscriber(Client client,RaceCategory category){

        List<Client> temp = this.clients.get(category);

        if(temp == null){
            temp = new ArrayList<>();
        }

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

            if(clients.get(raceCategory) != null){
                clients.get(raceCategory).remove(client);
            }
        }
    }
}
