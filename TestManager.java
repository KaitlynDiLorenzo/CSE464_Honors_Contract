import java.io.File;
import org.junit.runner.Result;

public class TestManager {
	private static TestManager testManager = null;
	
	private File file;
	private Result result;
	
	private TestManager() {
		file = null;
	}
	
	public File getFile() {
		return file;
	}
	
	public Result getResult() {
		return result;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public void setResult(Result result) {
		this.result = result;
	}
	
	
	public static TestManager TestManager() {
		if(testManager == null) {
			testManager = new TestManager();
		}
		return testManager;
	}
}
