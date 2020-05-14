package sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageRetrieverTest {

    private final List<String> SAMPLE_MESSAGES_LIST = new ArrayList<>();
    private static final String DEFAULT_FILE_NAME = "smsMessages.txt";

    private MessageRetriever messageRetriever;
    private MessageRetriever messageRetrieverSpy;

    @Mock
    private FileLinesReader fileLinesReaderMock;

    @BeforeEach
    void setUp() {
        messageRetriever = new MessageRetriever(DEFAULT_FILE_NAME, fileLinesReaderMock);
        messageRetrieverSpy = spy(messageRetriever);
        SAMPLE_MESSAGES_LIST.add("pupa");
        SAMPLE_MESSAGES_LIST.add("klawisz");
        SAMPLE_MESSAGES_LIST.add("mordeczka");
        SAMPLE_MESSAGES_LIST.add("java");
    }

    @Test
    void shouldReturnSingleRandomMessage() {
        Random random = mock(Random.class);
        when(fileLinesReaderMock.readAllLines(anyString())).thenReturn(SAMPLE_MESSAGES_LIST);
        when(messageRetrieverSpy.generateRandom()).thenReturn(random);
        when(random.nextInt(SAMPLE_MESSAGES_LIST.size())).thenReturn(3);
        assertEquals("java", messageRetrieverSpy.retrieveRandomMessage());
    }

    @Test
    void shouldUseDefaultMessagesFile() {
        fileLinesReaderMock.readAllLines(DEFAULT_FILE_NAME);
        verify(fileLinesReaderMock).readAllLines("smsMessages.txt");
    }

    @Test
    void shouldReturnMessagesList() {
        when(fileLinesReaderMock.readAllLines(anyString())).thenReturn(SAMPLE_MESSAGES_LIST);
        assertEquals(SAMPLE_MESSAGES_LIST, messageRetriever.retrieveMessages());
    }

    @Test
    void shouldUseFileLinesReader() {
        when(fileLinesReaderMock.readAllLines(anyString())).thenReturn(SAMPLE_MESSAGES_LIST);
        messageRetriever.retrieveMessage();
        verify(fileLinesReaderMock).readAllLines(any());
    }
}