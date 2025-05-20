package hexlet.code;

import hexlet.Differ;
import hexlet.Parser;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private static String readFixture(String fileName) throws Exception {
        return Files.readString(Path.of("src/test/resources", fileName)).trim();
    }

    @Test
    void testFlatJsonDiffStylish() throws Exception {
        Map<String, Object> data1 = Parser.getData("src/test/resources/file1.json");
        Map<String, Object> data2 = Parser.getData("src/test/resources/file2.json");
        String expected = readFixture("expected_stylish.txt");
        String actual = Differ.generate(data1, data2);
        assertEquals(expected, actual);
    }
}
