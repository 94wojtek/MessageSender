package sender;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class MessageSender {

    private Map<String, String> contactsMap;
    //private FileInjector fileInjector;
    private String singleMessage;
    private DataRetriever contactRetriever;
    private DataRetriever messageRetriever;

    public MessageSender() {
        this.contactRetriever = new ContactDetailRetriever("contts.txt");
        this.messageRetriever = new MessageRetriever();
    }

    public void sendMessage() {
        singleMessage = messageRetriever.retrieveMessage();
        contactsMap = contactRetriever.retrieveContacts();
        System.out.println(getSingleMessage());

        for (String recipient : contactsMap.keySet()) {
            System.out.println(recipient);
            try {
                //message = " Greetings from Mr. Gupta! Have a nice day!";
                String username = "admin";
                String password = "abc123";
                //String originator = "+440987654321";
                String requestUrl = "http://192.168.0.192:9501/api?action=sendmessage&" +
                        "username=" + URLEncoder.encode(username, "UTF-8") +
                        "&password=" + URLEncoder.encode(password, "UTF-8") +
                        "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
                        "&messagetype=SMS:TEXT" +
                        "&messagedata=" + URLEncoder.encode(getSingleMessage(), "UTF-8") +
                        //"&originator=" + URLEncoder.encode(originator, "UTF-8") +
                        "&serviceprovider=GSMModem1" +
                        "&responseformat=html";

                URL url = new URL(requestUrl);
                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                System.out.println(uc.getResponseMessage());
                System.out.println(uc.getResponseCode());
                uc.disconnect();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public String getSingleMessage() {
        return singleMessage;
    }

    public Map<String, String> getContactsMap() {
        return contactsMap;
    }

    public static void main(String[] args) {
        MessageSender ms = new MessageSender();
        ms.sendMessage();
    }
}

