package hexlet.code;

import hexlet.code.diff.DiffBuilder;
import hexlet.code.formatter.PlainFormatter;
import hexlet.code.formatter.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(Map<String, Object> map1, Map<String, Object> map2, String formatName) {
        try {
            List<Map<String, Object>> diff = DiffBuilder.build(map1, map2);
            return switch (formatName) {
                case "stylish" -> new StylishFormatter().format(diff);
                case "plain" -> new PlainFormatter().format(diff);
                default -> throw new IllegalArgumentException("Unsupported format: " + formatName);

            };
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
