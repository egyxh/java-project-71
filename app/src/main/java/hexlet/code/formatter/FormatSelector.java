package hexlet.code.formatter;

public class FormatSelector {
    public static Formatter selectFormat(String format) throws IllegalArgumentException {
        try {
            return switch (format) {
                case "stylish" -> new StylishFormatter();
                case "plain" -> new PlainFormatter();
                case "json" -> new JsonFormatter();
                default -> throw new IllegalArgumentException("Unsupported format: " + format);
            };
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
