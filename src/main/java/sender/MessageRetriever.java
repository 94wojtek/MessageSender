package sender;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class MessageRetriever implements DataRetriever {
    private static final String DEFAULT_FILE_NAME = "smsMessages.txt";
    private final String fileName;
    private final FileLinesReader fileLinesReader;
    private String randomMessage;

    public MessageRetriever() {
        this(DEFAULT_FILE_NAME);
    }

    //Use default file if param file does not exist
    public MessageRetriever(String fileName) {
        this(fileName, new DefaultFileLinesReader(DEFAULT_FILE_NAME));
    }

    //Visible for testing
    public MessageRetriever(String fileName, FileLinesReader fileLinesReader) {
        this.fileName = fileName;
        this.fileLinesReader = fileLinesReader;
    }

    public List<String> retrieveMessages() {
        return fileLinesReader.readAllLines(fileName);
    }

    public Random generateRandom() {
        return new Random();
    }

    //Retrieves random message with use of generateRandom() method.
    //Message is retrieved from list provided by retrieveMessages() method.
    protected String retrieveRandomMessage() {
        List<String> list = retrieveMessages();
        int listSize = list.size();
        return randomMessage = list.get(generateRandom().nextInt(listSize));
    }

    public String getRandomMessage() {
        return randomMessage;
    }

    @Override
    public String retrieveMessage() {
        return retrieveRandomMessage();
    }

    @Override
    public Map<String, String> retrieveContacts() {
        return null;
    }
}
