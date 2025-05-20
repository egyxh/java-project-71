package hexlet.code.formatter;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlainFormatter implements Formatter {
    @Override
    public String format(List<Map<String, Object>> diff) throws IllegalStateException {
        StringBuilder result = new StringBuilder();
        Set<String> processedKeys = new HashSet<>();
        for (Map<String, Object> item : diff) {
            String key = (String) item.get("key");
            Object value = item.get("value");
            String status = (String) item.get("status");
            if (processedKeys.contains(key)) {
                continue;
            }
            processedKeys.add(key);

            switch (status) {
                case "added" -> result.append(formatAdded(key, value));
                case "removed" -> result.append(formatRemoved(key));
                case "changed" -> result.append(formatChanged(key, item.get("oldValue"), item.get("newValue")));
                case "nested" -> {
                    List<Map<String, Object>> nested = safeCastList(item.get("subObject"));
                    String nestedOutput = new PlainFormatter().format(nested);
                    result.append(nestedOutput);
                }
                default -> {
                }
            }
        }
        return result.toString().trim();
    }

    private String formatAdded(String key, Object value) {
        return String.format("Property '%s' was added with value: %s\n", key, toPainValue(value));
    }

    private String formatRemoved(String key) {
        return String.format("Property '%s' was removed\n", key);
    }

    private String formatChanged(String key, Object oldValue, Object newValue) {
        return String.format("Property '%s' was updated. From %s to %s\n", key, toPainValue(oldValue),
                toPainValue(newValue));
    }


    public String toPainValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (!(value instanceof Number || value instanceof Boolean || value instanceof Character)) {
            return "[complex value]";
        } else {
            return value.toString();
        }
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> safeCastList(Object raw) {
        return (List<Map<String, Object>>) raw;
    }
}
