package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    public static final String FIXTURES_PATH = "src/test/resources/";

    private static String readFixture(String fileName) throws Exception {
        return Files.readString(Path.of(FIXTURES_PATH, fileName)).trim();
    }

    @Test
    void testJsonDiff() throws Exception {
        String filePathOne = FIXTURES_PATH + "file1.json";
        String filePathTwo = FIXTURES_PATH + "file2.json";

        String expectedStylish = readFixture("expected_stylish.txt");
        String actualStylish = Differ.generate(filePathOne, filePathTwo, "stylish");

        String expectedJson = readFixture("expected_json.txt");
        String actualJson = Differ.generate(filePathOne, filePathTwo, "json");

        String expectedPlain = readFixture("expected_plain.txt");
        String actualPlain = Differ.generate(filePathOne, filePathTwo, "plain");

        String expectedWithoutFormatting = readFixture("expected_stylish.txt");
        String actualWithoutFormatting = Differ.generate(filePathOne, filePathTwo);

        assertEquals(expectedStylish, actualStylish);
        assertEquals(expectedPlain, actualPlain);
        assertEquals(expectedJson, actualJson);
        assertEquals(expectedWithoutFormatting, actualWithoutFormatting);
    }

    @Test
    void testYmlDiff() throws Exception {
        String filePathOne = FIXTURES_PATH + "file1.yml";
        String filePathTwo = FIXTURES_PATH + "file2.yml";

        String expectedStylish = readFixture("expected_stylish.txt");
        String actualStylish = Differ.generate(filePathOne, filePathTwo, "stylish");

        String expectedJson = readFixture("expected_json.txt");
        String actualJson = Differ.generate(filePathOne, filePathTwo, "json");

        String expectedPlain = readFixture("expected_plain.txt");
        String actualPlain = Differ.generate(filePathOne, filePathTwo, "plain");

        String expectedWithoutFormatting = readFixture("expected_stylish.txt");
        String actualWithoutFormatting = Differ.generate(filePathOne, filePathTwo);

        assertEquals(expectedStylish, actualStylish);
        assertEquals(expectedPlain, actualPlain);
        assertEquals(expectedJson, actualJson);
        assertEquals(expectedWithoutFormatting, actualWithoutFormatting);
    }

    @Test
    void testYamlDiff() throws Exception {
        String filePathOne = FIXTURES_PATH + "file1.yaml";
        String filePathTwo = FIXTURES_PATH + "file2.yaml";

        String expectedStylish = readFixture("expected_stylish.txt");
        String actualStylish = Differ.generate(filePathOne, filePathTwo, "stylish");

        String expectedJson = readFixture("expected_json.txt");
        String actualJson = Differ.generate(filePathOne, filePathTwo, "json");

        String expectedPlain = readFixture("expected_plain.txt");
        String actualPlain = Differ.generate(filePathOne, filePathTwo, "plain");

        String expectedWithoutFormatting = readFixture("expected_stylish.txt");
        String actualWithoutFormatting = Differ.generate(filePathOne, filePathTwo);

        assertEquals(expectedStylish, actualStylish);
        assertEquals(expectedPlain, actualPlain);
        assertEquals(expectedJson, actualJson);
        assertEquals(expectedWithoutFormatting, actualWithoutFormatting);
    }
}
