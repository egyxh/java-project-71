package hexlet.code.formatter;

public class FormatSelector {
    public static Formatter selectFormat(String format) throws IllegalArgumentException {
        return switch (format) {
            case "stylish" -> new StylishFormatter();
            case "plain" -> new PlainFormatter();
            case "json" -> new JsonFormatter();
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }
}
