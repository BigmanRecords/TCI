package Assignment5Tests;

import Assignment5.Client;
import Assignment5.Message;
import Assignment5.RaceCategory;
import Assignment5.RaceResultsService;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {

    @Test
    public void whenUserIsSubscribedToCategoryThenUserWillOnlyReceiveMessagesForThatCategory(){

        //arrange
        RaceResultsService resultsService = new RaceResultsService();
        Client clientA = mock(Client.class,"Client A");
        Client clientB = mock(Client.class,"Client B");
        Message message = mock(Message.class,"message");

        //act
        resultsService.addSubscriber(clientA, RaceCategory.f1Race);
        resultsService.addSubscriber(clientB, RaceCategory.motoRace);

        when(message.getCategory()).thenReturn(RaceCategory.motoRace);
        resultsService.send(message);

        //assert
        verifyZeroInteractions(clientA);
        verify(clientB).recieve(message);
    }
}
