package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {
    @Test
    void getExtensionTest() {
        assertEquals("json", Utils.getExtension(Paths.get("file.json")));
        assertEquals("yml", Utils.getExtension(Paths.get("file.yml")));
        assertEquals("yaml", Utils.getExtension(Paths.get("file.yaml")));
    }
}
