package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    public static String getExtension(Path path) {
        String filename = path.getFileName().toString();
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "";
        }
        return filename.substring(dotIndex + 1);
    }

    public static String getExtension(String filePath) {
        Path path = Paths.get(filePath);
        return getExtension(path);
    }

    public static String readData(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath));
    }
}
