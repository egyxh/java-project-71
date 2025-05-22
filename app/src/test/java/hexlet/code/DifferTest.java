package hexlet.code;

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
    void testJsonDiffStylish() throws Exception {
        Map<String, Object> data1 = Parser.getData("src/test/resources/file1.json");
        Map<String, Object> data2 = Parser.getData("src/test/resources/file2.json");

        String expectedStylish = readFixture("expected_stylish.txt");
        String actualStylish = Differ.generate(data1, data2, "stylish");

        String expectedJson = readFixture("expected_json.txt");
        String actualJson = Differ.generate(data1, data2, "json");

        String expectedPlain = readFixture("expected_plain.txt");
        String actualPlain = Differ.generate(data1, data2, "plain");

        assertEquals(expectedStylish, actualStylish);
        assertEquals(expectedPlain, actualPlain);
        assertEquals(expectedJson, actualJson);
    }

    @Test
    void testYmlDiffStylish() throws Exception {
        Map<String, Object> data1 = Parser.getData("src/test/resources/file1.yml");
        Map<String, Object> data2 = Parser.getData("src/test/resources/file2.yml");

        String expectedJson = readFixture("expected_json.txt");
        String actualJson = Differ.generate(data1, data2, "json");

        String expectedStylish = readFixture("expected_stylish.txt");
        String actualStylish = Differ.generate(data1, data2, "stylish");

        String expectedPlain = readFixture("expected_plain.txt");
        String actualPlain = Differ.generate(data1, data2, "plain");

        assertEquals(expectedStylish, actualStylish);
        assertEquals(expectedPlain, actualPlain);
        assertEquals(expectedJson, actualJson);
    }

    @Test
    void testYamlDiffStylish() throws Exception {
        Map<String, Object> data1 = Parser.getData("src/test/resources/file1.yaml");
        Map<String, Object> data2 = Parser.getData("src/test/resources/file2.yaml");

        String expectedJson = readFixture("expected_json.txt");
        String actualJson = Differ.generate(data1, data2, "json");

        String expectedStylish = readFixture("expected_stylish.txt");
        String actualStylish = Differ.generate(data1, data2, "stylish");

        String expectedPlain = readFixture("expected_plain.txt");
        String actualPlain = Differ.generate(data1, data2, "plain");

        assertEquals(expectedStylish, actualStylish);
        assertEquals(expectedPlain, actualPlain);
        assertEquals(expectedJson, actualJson);
    }
}
