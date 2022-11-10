import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.burlakov.CustomFileReader;
import ru.burlakov.IpToIntConverter;
import ru.burlakov.LineCounter;
import ru.burlakov.LineReader;

class CustomFileReaderTest {
    private final CustomFileReader reader;
    private final LineCounter lineCounter;
    private final IpToIntConverter ipToIntConverter;
    private final String TEST1 = "src/test/resources/test1.txt";
    private final String TEST2 = "src/test/resources/test2.txt";

    public CustomFileReaderTest() {
        this.ipToIntConverter = new IpToIntConverter();
        this.lineCounter = new LineCounter(ipToIntConverter);
        this.reader = new LineReader(lineCounter);

    }

    @Test
    void readCorrectFile() {
        reader.setPath(TEST1);
        reader.read();
        Assertions.assertEquals(4, lineCounter.getResult());
    }

    @Test
    void readFileWithWhiteSpaceLine() {
        reader.setPath(TEST2);
        reader.read();
        Assertions.assertEquals(4, lineCounter.getResult());
    }

}