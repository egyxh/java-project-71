package hexlet.code;

import hexlet.code.diff.DiffBuilder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiffBuilderTest {
    public static final int EXPECTED_DIFF_SIZE = 4;
    public static final int FIRST_LINE = 0;
    public static final int SECOND_LINE = 1;
    public static final int THIRD_LINE = 2;
    public static final int FOURTH_LINE = 3;

    @Test
    void testDiffBuilder() {
        Map<String, Object> mapOne = new HashMap<String, Object>();
        mapOne.put("key1", "value1");
        mapOne.put("key2", "25");
        mapOne.put("key3", true);

        Map<String, Object> mapTwo = new HashMap<String, Object>();
        mapTwo.put("key1", "value1");
        mapTwo.put("key2", "35");
        mapTwo.put("key4", "newkey");

        List<Map<String, Object>> diff = DiffBuilder.build(mapOne, mapTwo);

        assertEquals(EXPECTED_DIFF_SIZE, diff.size());
        assertEquals("key1", diff.get(FIRST_LINE).get("key"));
        assertEquals("unchanged", diff.get(FIRST_LINE).get("status"));
        assertEquals("value1", diff.get(FIRST_LINE).get("value"));

        assertEquals("key2", diff.get(SECOND_LINE).get("key"));
        assertEquals("changed", diff.get(SECOND_LINE).get("status"));
        assertEquals("25", diff.get(SECOND_LINE).get("oldValue"));
        assertEquals("35", diff.get(SECOND_LINE).get("newValue"));

        assertEquals("key3", diff.get(THIRD_LINE).get("key"));
        assertEquals("removed", diff.get(THIRD_LINE).get("status"));
        assertEquals(true, diff.get(THIRD_LINE).get("value"));

        assertEquals("key4", diff.get(FOURTH_LINE).get("key"));
        assertEquals("added", diff.get(FOURTH_LINE).get("status"));
        assertEquals("newkey", diff.get(FOURTH_LINE).get("value"));
    }
}
