package hexlet.code;

import hexlet.code.diff.DiffBuilder;
import hexlet.code.formatter.JsonFormatter;
import hexlet.code.formatter.PlainFormatter;
import hexlet.code.formatter.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> data1 = Parser.getData(filePath1);
        Map<String, Object> data2 = Parser.getData(filePath2);
        return generate(data1, data2, "stylish");

    }

    public static String generate(String filePath1, String filePath2, String style) throws Exception {
        Map<String, Object> data1 = Parser.getData(filePath1);
        Map<String, Object> data2 = Parser.getData(filePath2);
        return generate(data1, data2, style);
    }

    public static String generate(Map<String, Object> map1, Map<String, Object> map2, String formatName) {
        try {
            List<Map<String, Object>> diff = DiffBuilder.build(map1, map2);
            return switch (formatName) {
                case "stylish" -> new StylishFormatter().format(diff);
                case "plain" -> new PlainFormatter().format(diff);
                case "json" -> new JsonFormatter().format(diff);
                default -> throw new IllegalArgumentException("Unsupported format: " + formatName);

            };
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
