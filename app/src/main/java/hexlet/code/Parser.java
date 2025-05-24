package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getData(String data, String extension) throws Exception {
        return switch (extension) {
            case "json" -> new ObjectMapper().readValue(data, Map.class);
            case "yml", "yaml" -> new YAMLMapper().readValue(data, Map.class);
            default -> throw new IllegalArgumentException("Invalid extension: " + extension);
        };
    }
}
