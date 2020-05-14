package sender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactDetailRetriever implements DataRetriever {

    private static final String DEFAULT_FILE_NAME = "contacts.txt";
    private final String fileName;
    private final FileLinesReader fileLinesReader;

    public ContactDetailRetriever() {
        this(DEFAULT_FILE_NAME);
    }

    //Use default file if param file does not exist
    public ContactDetailRetriever(String fileName) {
        this(fileName, new DefaultFileLinesReader(DEFAULT_FILE_NAME));
    }

    // Visible for testing
    ContactDetailRetriever(String fileName, FileLinesReader fileLinesReader) {
        this.fileName = fileName;
        this.fileLinesReader = fileLinesReader;
    }

    public List<String> retrieveContactDetails() {
        return fileLinesReader.readAllLines(fileName);
    }

    protected Map<String, String> mapOfContact() {
        List<String> details = retrieveContactDetails();
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < details.size() - 1; i += 2) {
            result.put(details.get(i), details.get(i + 1));
        }
        return result;
    }

    @Override
    public String retrieveMessage() {
        return null;
    }

    @Override
    public Map<String, String> retrieveContacts() {
        return mapOfContact();
    }
}

