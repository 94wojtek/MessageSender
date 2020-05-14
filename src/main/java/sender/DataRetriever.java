package sender;

import java.util.Map;

public interface DataRetriever {
    String retrieveMessage();
    Map<String, String> retrieveContacts();
}
