package hexlet;
import java.util.List;
import java.util.Map;
import hexlet.diff.DiffBuilder;
import hexlet.formatter.Formatter;
import hexlet.formatter.StylishFormatter;
public class Differ {
    public static String generate(Map<String, Object> map1, Map<String, Object> map2) {
        try {
            List<Map<String, Object>> diff = DiffBuilder.build(map1, map2);
            Formatter formatter = new StylishFormatter();
            return formatter.format(diff);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
