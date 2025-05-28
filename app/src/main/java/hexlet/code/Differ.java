package hexlet.code;

import hexlet.code.diff.DiffBuilder;
import hexlet.code.formatter.FormatSelector;

import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2) {
        return generate(filePath1, filePath2, "stylish");

    }

    public static String generate(String filePath1, String filePath2, String style) throws IllegalArgumentException {
        try {
            String dataOne = Utils.readData(filePath1);
            String dataTwo = Utils.readData(filePath2);
            String extensionOne = Utils.getExtension(filePath1);
            String extensionTwo = Utils.getExtension(filePath2);

            Map<String, Object> data1 = Parser.getData(dataOne, extensionOne);
            Map<String, Object> data2 = Parser.getData(dataTwo, extensionTwo);
            List<Map<String, Object>> diff = DiffBuilder.build(data1, data2);
            return FormatSelector.selectFormat(style).format(diff);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
