package example;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class RaceResultServiceTest {

    private RaceResultService raceResultService = new RaceResultService();
    private Message message = mock(Message.class);
    private Client clientA = mock(Client.class, "clientA");
    private Client clientB = mock(Client.class, "clientB");

    @Test
    public void unsubscribedClientShouldNotReceiveMessage() {
        // Act
        raceResultService.send(message);

        // Assert
        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    public void subscriberedClientShouldReceiveMessage() {
        // Act
        raceResultService.addSubscriber(clientA);
        raceResultService.send(message);

        // Assert
        verify(clientA).receive(message);
    }

    @Test
    public void allSubscriberedClientsShouldReceiveMessage() {
        // Act
        raceResultService.addSubscriber(clientA);
        raceResultService.addSubscriber(clientB);
        raceResultService.send(message);

        // Assert
        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        // Arrange
        raceResultService.addSubscriber(clientA);
        raceResultService.addSubscriber(clientA);

        // Act
        raceResultService.send(message);

        // Assert
        verify(clientA).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() {
        // Arrange
        raceResultService.addSubscriber(clientA);
        raceResultService.removeSubscriber(clientA);

        // Act
        raceResultService.send(message);

        // Assert
        verify(clientA, never()).receive(message);
    }
}