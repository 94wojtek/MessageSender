package sender;

public class FileInjector {
    public MessageRetriever buildMessageRetriever(String fileName) {
        return new MessageRetriever(fileName);
    }

    public MessageRetriever buildMessageRetriever() {
        return new MessageRetriever();
    }

    public ContactDetailRetriever buildContactDetailRetriever(String fileName) {
        return new ContactDetailRetriever(fileName);
    }

    public ContactDetailRetriever buildContactDetailRetriever() {
        return new ContactDetailRetriever();
    }
}
