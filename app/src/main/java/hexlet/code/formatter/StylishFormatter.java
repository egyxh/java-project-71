package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public class StylishFormatter implements Formatter {
    @Override
    @SuppressWarnings("unchecked")
    public final String format(List<Map<String, Object>> diff) throws IllegalStateException {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> item : diff) {
            String key = (String) item.get("key");
            Object value = item.get("value");
            String status = (String) item.get("status");
            switch (status) {
                case "added" -> result.append("  + ")
                        .append(key)
                        .append(": ")
                        .append(formatValue(value))
                        .append("\n");
                case "removed" -> result.append("  - ")
                        .append(key)
                        .append(": ")
                        .append(formatValue(value))
                        .append("\n");
                case "unchanged" -> result.append("    ")
                        .append(key)
                        .append(": ")
                        .append(formatValue(value))
                        .append("\n");
                case "changed" -> {
                    result.append("  - ")
                            .append(key)
                            .append(": ")
                            .append(formatValue(item.get("oldValue")))
                            .append("\n");
                    result.append("  + ")
                            .append(key)
                            .append(": ")
                            .append(formatValue(item.get("newValue")))
                            .append("\n");
                }
                case "nested" -> {
                    List<Map<String, Object>> subObject = (List<Map<String, Object>>) item.get("subObject");
                    result.append("    ")
                            .append(key)
                            .append(": ")
                            .append(format(subObject))
                            .append("\n");
                }
                default -> throw new IllegalStateException("Unexpected value: " + status);
            }
        }
        result.append("}");
        return result.toString();
    }

    private String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof Map || value instanceof List) {
            return value.toString();
        }
        return value.toString();
    }
}
