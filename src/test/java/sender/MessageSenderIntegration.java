package sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageSenderIntegrationTest {

    private MessageSender messageSenderTest;
    private MessageRetriever messageRetrieverTest;
    private ContactDetailRetriever contactDetailRetrieverTest;
    private FileInjector fileInjectorTest;

    private final String SMS_FILE_NAME = "smsMessages.txt";
    private final String CONTACTS_FILE_NAME = "contacts.txt";
    private final ArrayList<String> REPRESENTATION_OF_MESSAGES = new ArrayList<>();
    private final LinkedHashMap<String, String> SAMPLE_CONT_MAP = new LinkedHashMap<>();
    private final ArrayList<String> SAMPLE_CONT_ARR = new ArrayList<>();

    @BeforeEach
    void setUp() {
        messageSenderTest = new MessageSender();
        messageRetrieverTest = new MessageRetriever();
        contactDetailRetrieverTest = new ContactDetailRetriever();
        fileInjectorTest = new FileInjector();

        REPRESENTATION_OF_MESSAGES.add("hej");
        REPRESENTATION_OF_MESSAGES.add("czesc");
        REPRESENTATION_OF_MESSAGES.add("siema");
        REPRESENTATION_OF_MESSAGES.add("elo");
        REPRESENTATION_OF_MESSAGES.add("dzien dobry");
        REPRESENTATION_OF_MESSAGES.add("witaj");

        SAMPLE_CONT_MAP.put("111111111", "michal");
        SAMPLE_CONT_MAP.put("222222222", "ola");
        SAMPLE_CONT_MAP.put("333333333", "ela");
        SAMPLE_CONT_MAP.put("444444444", "dizel");

        SAMPLE_CONT_ARR.add("111111111");
        SAMPLE_CONT_ARR.add("michal");
        SAMPLE_CONT_ARR.add("222222222");
        SAMPLE_CONT_ARR.add("ola");
        SAMPLE_CONT_ARR.add("333333333");
        SAMPLE_CONT_ARR.add("ela");
        SAMPLE_CONT_ARR.add("444444444");
        SAMPLE_CONT_ARR.add("dizel");
    }

    /*
    @Test
    void messageSenderShouldReturnContactsMapFromFile() {
        messageSenderTest.retrieveContactsMap(CONTACTS_FILE_NAME);
        assertEquals(SAMPLE_CONT_MAP, messageSenderTest.getContactsMap());
    }*/

    @Test
    void fileInjectorShouldReturnArrOfMessagesFromFile() {
        assertEquals(REPRESENTATION_OF_MESSAGES, fileInjectorTest.buildMessageRetriever(SMS_FILE_NAME).retrieveMessages());
    }

    @Test
    void fileInjectorShouldReturnArrOfContactsFromFile() {
        assertEquals(SAMPLE_CONT_ARR, fileInjectorTest.buildContactDetailRetriever(CONTACTS_FILE_NAME).retrieveContactDetails());
    }

    @Test
    void messageRetrieverShouldReturnArrOfLinesFromFile() {
        assertEquals(REPRESENTATION_OF_MESSAGES.toString(), messageRetrieverTest.retrieveMessages().toString());
    }

    @Test
    void contactDetailRetrieverShouldRetrieveContactsArrFromFile() {
        assertEquals(SAMPLE_CONT_ARR, contactDetailRetrieverTest.retrieveContactDetails());
    }

    @Test
    void contactDetailRetrieverShouldCreateMapOfContacts() {
        contactDetailRetrieverTest.retrieveContactDetails();
        assertEquals(SAMPLE_CONT_MAP, contactDetailRetrieverTest.mapOfContact());
    }
}
