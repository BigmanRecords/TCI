package Assignment5Tests;

import Assignment5.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.*;

public class RaceResultsServiceTest {

    //arrange
    @InjectMocks
    private RaceResultsService resultsService = new RaceResultsService();

    @Mock
    private MessageLoggingService messageLoggingService = new MessageLoggingService();

    private Client clientA = mock(Client.class,"Client A");
    private Client clientB = mock(Client.class,"Client B");
    private Message messageA = mock(Message.class,"message A");
    private Message messageB = mock(Message.class,"message B");

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenUserIsSubscribedToCategoryThenUserWillOnlyReceiveMessagesForThatCategory(){

        //act
        resultsService.addSubscriber(clientA, RaceCategory.f1Race);
        resultsService.addSubscriber(clientB, RaceCategory.motoRace);

        when(messageA.getCategory()).thenReturn(RaceCategory.motoRace);
        resultsService.send(messageA);

        //assert
        verifyZeroInteractions(clientA);
        verify(clientB).receive(messageA);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() {

        //act
        resultsService.addSubscriber(clientA, RaceCategory.f1Race);
        resultsService.removeSubscriber(clientA);

        when(messageA.getCategory()).thenReturn(RaceCategory.f1Race);
        resultsService.send(messageA);

        //assert
        verify(clientA, never()).receive(messageA);
    }

    @Test
    public void clientUnsubscribedFromCategoryShouldNotReceiveMessagesForThatCategory(){

        //act
        resultsService.addSubscriber(clientA, RaceCategory.f1Race);
        resultsService.addSubscriber(clientA, RaceCategory.boatRace);

        resultsService.removeSubscriber(clientA, RaceCategory.boatRace);

        when(messageA.getCategory()).thenReturn(RaceCategory.boatRace);
        when(messageB.getCategory()).thenReturn(RaceCategory.f1Race);

        resultsService.send(messageA);
        resultsService.send(messageB);

        //assert
        verify(clientA, never()).receive(messageA);
        verify(clientA).receive(messageB);
    }

    @Test
    public void whenMessageSentByResultsServiceThenMessageIsLogged(){

        //act
        resultsService.addSubscriber(clientA,RaceCategory.boatRace);

        when(messageA.getCategory()).thenReturn(RaceCategory.boatRace);
        resultsService.send(messageA);

        //assert
        verify(messageLoggingService).addMessage(messageA);
    }

    @Test
    public void subscribedClientShouldReceiveMultipleMessages() {

        //act
        resultsService.addSubscriber(clientA,RaceCategory.boatRace);

        when(messageA.getCategory()).thenReturn(RaceCategory.boatRace);

        for(int i = 0; i < 10; i++){
            resultsService.send(messageA);
        }

        //assert
        verify(clientA,times(10)).receive(messageA);
    }

    @Test
    public void allSubscribedClientsShouldReceiveMultipleMessages() {

        //act
        resultsService.addSubscriber(clientA,RaceCategory.boatRace);
        resultsService.addSubscriber(clientB,RaceCategory.boatRace);

        when(messageA.getCategory()).thenReturn(RaceCategory.boatRace);

        for(int i = 0; i < 10; i++){
            resultsService.send(messageA);
        }

        //assert
        verify(clientA,times(10)).receive(messageA);
        verify(clientB,times(10)).receive(messageA);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUnsubscribedClientTriesToUnsubscribeThenThrowException(){

        //act
        resultsService.removeSubscriber(clientA);
    }
}
