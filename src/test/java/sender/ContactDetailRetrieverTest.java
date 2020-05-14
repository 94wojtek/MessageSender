package sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContactDetailRetrieverTest {

    private ContactDetailRetriever testSubject;

    @Mock
    private FileLinesReader fileLinesReader;

    @BeforeEach
    void setUp() {
        testSubject = new ContactDetailRetriever("contacts.txt", fileLinesReader);
    }

    @Test
    public void testMapOfContact() {
        when(fileLinesReader.readAllLines("contacts.txt"))
                .thenReturn(Arrays.asList("contactKey1", "contactValue1", "contactKeyA", "contactValueA"));
        Map<String, String> result = testSubject.retrieveContacts();
        assertThat(result.size(), equalTo(2));
        assertThat(result.get("contactKey1"), equalTo("contactValue1"));
        assertThat(result.get("contactKeyA"), equalTo("contactValueA"));
    }
}