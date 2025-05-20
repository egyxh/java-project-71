package hexlet.code.diff;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DiffBuilder {
    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> build(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        List<Map<String, Object>> diff = new ArrayList<>();
        for (String key : keys) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);
            Map<String, Object> entry = new LinkedHashMap<>();
            entry.put("key", key);
            if (value1 instanceof Map && value2 instanceof Map) {
                entry.put("status", "nested");
                entry.put("subObject", build((Map<String, Object>) value1, (Map<String, Object>) value2));
            } else if (!map2.containsKey(key)) {
                entry.put("key", key);
                entry.put("status", "removed");
                entry.put("value", map1.get(key));
            } else if (!map1.containsKey(key)) {
                entry.put("key", key);
                entry.put("status", "added");
                entry.put("value", map2.get(key));
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                entry.put("key", key);
                entry.put("status", "unchanged");
                entry.put("value", map1.get(key));
            } else {
                entry.put("key", key);
                entry.put("status", "changed");
                entry.put("oldValue", map1.get(key));
                entry.put("newValue", map2.get(key));
            }
            diff.add(entry);
        }
        return diff;
    }
}
