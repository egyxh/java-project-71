package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final YAMLMapper YAML_MAPPER = new YAMLMapper();

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getData(String filePath) throws Exception {
        String content = Files.readString(Paths.get(filePath));
        String fileExtension = Utils.getExtension(Paths.get(filePath));
        switch (fileExtension) {
            case "json":
                return JSON_MAPPER.readValue(content, Map.class);
            case "yml", "yaml":
                return YAML_MAPPER.readValue(content, Map.class);
            default:
                throw new IllegalArgumentException("Unsupported file format: " + filePath);
        }
    }
}
