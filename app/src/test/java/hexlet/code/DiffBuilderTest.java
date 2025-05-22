package hexlet.code;

import hexlet.code.diff.DiffBuilder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiffBuilderTest {
    @Test
    void testDiffBuilder() {
        Map<String, Object> mapOne = new HashMap<String, Object>();
        mapOne.put("key1", "value1");
        mapOne.put("key2", 25);
        mapOne.put("key3", true);

        Map<String, Object> mapTwo = new HashMap<String, Object>();
        mapTwo.put("key1", "value1");
        mapTwo.put("key2", 35);
        mapTwo.put("key4", "newkey");

        List<Map<String, Object>> diff = DiffBuilder.build(mapOne, mapTwo);

        assertEquals(4, diff.size());
        assertEquals("key1", diff.get(0).get("key"));
        assertEquals("unchanged", diff.get(0).get("status"));
        assertEquals("value1", diff.get(0).get("value"));

        assertEquals("key2", diff.get(1).get("key"));
        assertEquals("changed", diff.get(1).get("status"));
        assertEquals(25, diff.get(1).get("oldValue"));
        assertEquals(35, diff.get(1).get("newValue"));

        assertEquals("key3", diff.get(2).get("key"));
        assertEquals("removed", diff.get(2).get("status"));
        assertEquals(true, diff.get(2).get("value"));

        assertEquals("key4", diff.get(3).get("key"));
        assertEquals("added", diff.get(3).get("status"));
        assertEquals("newkey", diff.get(3).get("value"));
    }
}
