package sender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultFileLinesReaderTest {

    private static final String FAKE_FILE = "fakeFile";

    private DefaultFileLinesReader defaultFileLinesReaderTest;

    @Mock
    private Files filesMock;

    @BeforeEach
    void setUp() {
        defaultFileLinesReaderTest = new DefaultFileLinesReader(FAKE_FILE);
    }

    @Test
    void shouldUse_getPath() throws IOException {
        when(filesMock.readAllLines(anyString())).thenReturn(Collections.EMPTY_LIST);
        verify(defaultFileLinesReaderTest).getPaths(FAKE_FILE);
    }
}