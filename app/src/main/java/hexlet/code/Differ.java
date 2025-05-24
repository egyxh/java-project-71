package hexlet.code;

import hexlet.code.diff.DiffBuilder;
import hexlet.code.formatter.JsonFormatter;
import hexlet.code.formatter.PlainFormatter;
import hexlet.code.formatter.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");

    }

    public static String generate(String filePath1, String filePath2, String style) throws Exception {
        String dataOne = Utils.readData(filePath1);
        String dataTwo = Utils.readData(filePath2);
        String extensionOne = Utils.getExtension(filePath1);
        String extensionTwo = Utils.getExtension(filePath2);

        Map<String, Object> data1 = Parser.getData(dataOne, extensionOne);
        Map<String, Object> data2 = Parser.getData(dataTwo, extensionTwo);
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
