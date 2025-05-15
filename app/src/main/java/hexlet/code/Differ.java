package hexlet.code;
import hexlet.code.formatter.Formatter;
import hexlet.code.formatter.StylishFormatter;
import java.util.List;
import java.util.Map;
import hexlet.code.diff.DiffBuilder;
public class Differ {
    public static String generate(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> diff = DiffBuilder.build(map1, map2);
        Formatter formatter = new StylishFormatter();
        return formatter.format(diff);
    }
}
