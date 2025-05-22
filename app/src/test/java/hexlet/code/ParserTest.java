package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    @Test
    void testParseJson() throws Exception {
        String jsonContent = "{\"key\":\"value\", \"number\": 42}";
        Path tempFile = Files.createTempFile("test", ".json");
        Files.writeString(tempFile, jsonContent);

        Map<String, Object> result = Parser.getData(tempFile.toString());

        assertEquals("value", result.get("key"));
        assertEquals(42, result.get("number"));
    }

    @Test
    void testParseYaml() throws Exception {
        String yamlContent = "key: value\nnumber: 42";
        Path tempFile = Files.createTempFile("test", ".yaml");
        Files.writeString(tempFile, yamlContent);

        Map<String, Object> result = Parser.getData(tempFile.toString());

        assertEquals("value", result.get("key"));
        assertEquals(42, result.get("number"));
    }

    @Test
    void testParseYml() throws Exception {
        String ymlContent = "key: value\nnumber: 42";
        Path tempFile = Files.createTempFile("test", ".yaml");
        Files.writeString(tempFile, ymlContent);

        Map<String, Object> result = Parser.getData(tempFile.toString());

        assertEquals("value", result.get("key"));
        assertEquals(42, result.get("number"));
    }
}
