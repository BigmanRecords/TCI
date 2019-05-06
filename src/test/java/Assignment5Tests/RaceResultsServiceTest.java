package Assignment5Tests;

import Assignment5.Client;
import Assignment5.Message;
import Assignment5.RaceCategory;
import Assignment5.RaceResultsService;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {

    //arrange
    private RaceResultsService resultsService = new RaceResultsService();
    private Client clientA = mock(Client.class,"Client A");
    private Client clientB = mock(Client.class,"Client B");
    private Message message = mock(Message.class,"message");


    @Test
    public void whenUserIsSubscribedToCategoryThenUserWillOnlyReceiveMessagesForThatCategory(){

        //act
        resultsService.addSubscriber(clientA, RaceCategory.f1Race);
        resultsService.addSubscriber(clientB, RaceCategory.motoRace);

        when(message.getCategory()).thenReturn(RaceCategory.motoRace);
        resultsService.send(message);

        //assert
        verifyZeroInteractions(clientA);
        verify(clientB).receive(message);
    }

}
