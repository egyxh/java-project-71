package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;
import java.util.Map;
import java.util.concurrent.Callable;
@Command(
		name = "gendiff",
		mixinStandardHelpOptions = true,
		version = "gendiff 1.0",
		description = "Compares two configuration files and shows a difference."
)
public class App implements Callable<Integer> {
	@Parameters(index = "0", description = "path to first file")
	private String filepath1;
	@Parameters(index = "1", description = "path to second file")
	private String filepath2;
	@Option(names = {"-f", "--format"},description = "output format [default: ${DEFAULT-VALUE}]")
	private String format = "stylish";
	public static void main(String[] args) {
		int exitCode = new CommandLine(new App()).execute(args);
		System.exit(exitCode);
	}
	@Override
	public Integer call(){
		try {
			Map<String, Object> data1 = Parser.getData(filepath1);
			Map<String, Object> data2 = Parser.getData(filepath2);
			String diff = Differ.generate(data1, data2);
			System.out.println(diff);
			return 0;
		} catch (Exception e) {
			System.err.println("Ошибка при чтении или парсинге: " + e.getMessage());
			e.printStackTrace();
			return 1;
		}
	}
}
