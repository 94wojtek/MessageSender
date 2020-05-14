package sender;

import java.util.List;

public interface FileLinesReader {
    List<String> readAllLines(String filename);
}
