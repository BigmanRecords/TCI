package Assignment5;

import java.util.*;

public class RaceResultsService {

    private HashMap<RaceCategory, List<Client>> clients = new HashMap<>();
    private MessageLoggingService messageLoggingService = new MessageLoggingService();

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

        messageLoggingService.addMessage(message);

        for (Client c: temp) {
            c.receive(message);
        }
    }

    public void removeSubscriber(Client client){

        boolean check = true;

        for(RaceCategory raceCategory : RaceCategory.values()){

            if(clients.get(raceCategory).remove(client)){
                check = false;
            }
        }

        clientNotFound(check);
    }

    public void removeSubscriber(Client client, RaceCategory category){

        clientNotFound(!clients.get(category).remove(client));
    }

    private void clientNotFound(Boolean check){

        if(check){
            throw new NoSuchElementException("the client was not already subscribed to this service");
        }
    }
}
