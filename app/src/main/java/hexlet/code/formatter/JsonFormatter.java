package hexlet.code.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonFormatter implements Formatter {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    @Override
    public String format(List<Map<String, Object>> diff) throws Exception {
        return JSON_MAPPER.writeValueAsString(diff);
    }
}
