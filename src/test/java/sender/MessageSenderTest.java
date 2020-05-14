package sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class MessageSenderTest {

    private MessageSender messageSenderTest;
    private FileInjector fileInjectorMock;
    private MessageRetriever messageRetrieverMock;
    private ContactDetailRetriever contactDetailRetrieverMock;

    private final LinkedHashMap<String, String> SAMPLE_CONT_MAP = new LinkedHashMap<>();
    private final ArrayList<String> SAMPLE_MESSAGES_ARR_STRING = new ArrayList<>();
    private final static String REAL_SMS_FILE = "smsMessages.txt";
    private final static String REAL_CONT_FILE = "contacts.txt";

    @BeforeEach
    void setUp() {
        SAMPLE_CONT_MAP.put("111111111", "michal");
        SAMPLE_CONT_MAP.put("222222222", "ola");
        SAMPLE_CONT_MAP.put("333333333", "ela");
        SAMPLE_CONT_MAP.put("444444444", "dizel");

        SAMPLE_MESSAGES_ARR_STRING.add("pupa");
        SAMPLE_MESSAGES_ARR_STRING.add("klawisz");
        SAMPLE_MESSAGES_ARR_STRING.add("mordeczka");
        SAMPLE_MESSAGES_ARR_STRING.add("java");

        messageRetrieverMock = mock(MessageRetriever.class);
        contactDetailRetrieverMock = mock(ContactDetailRetriever.class);
        messageSenderTest = new MessageSender();
    }

    /*
    @Test
    void shouldRetrieveMapOfContacts() {
        LinkedHashMap<String, String> representation = new LinkedHashMap<>();
        representation.put("111111111", "michal");
        representation.put("222222222", "ola");
        representation.put("333333333", "ela");
        representation.put("444444444", "dizel");

        when(fileInjectorMock.buildContactDetailRetriever()).thenReturn(contactDetailRetrieverMock);
        when(contactDetailRetrieverMock.mapOfContact()).thenReturn(SAMPLE_CONT_MAP);
        Map<String, String> contactMap = messageSenderTest.retrieveContacts();
        assertEquals(representation, contactMap);
    }*/
}