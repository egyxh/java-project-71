package hexlet.diff;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
public class DiffBuilder {
    public static List<Map<String, Object>> build(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        List<Map<String, Object>> diff = new ArrayList<>();
        for (String key : keys) {
            Map<String, Object> entry = new LinkedHashMap<>();
            if (!map2.containsKey(key)) {
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
