package trial.program.compile;

import java.io.File;
import java.io.IOException;

public class CompileAndRun {

	public static void main(String[] args) {
		new CompileAndRun();

	}

	public CompileAndRun() {
		try {
			int result = compile("D:\\Temp\\HackRankInput.java");
			System.out.println("javac returned: " + result);
			/*int result01 = run("HackerRank01");
			System.out.println("java returned: " + result01);*/
		}catch(IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	private int compile(String file) throws IOException, InterruptedException{
		ProcessBuilder pb = new ProcessBuilder("javac", file);
		pb.redirectError();
		pb.directory(new File("D:\\Temp"));
		Process p = pb.start();
		InputStreamConsumer consumer = new InputStreamConsumer(p.getInputStream());
		consumer.start();
		int result = p.waitFor();
		consumer.join();
		System.out.println(consumer.getOutput());
		return 0;
	}
	
	private int run(String clazz) throws IOException, InterruptedException{
		ProcessBuilder pb = new ProcessBuilder("java", clazz);
		pb.redirectError();
		pb.directory(new File("D:\\Temp"));
		Process p = pb.start();
		InputStreamConsumer consumer = new InputStreamConsumer(p.getInputStream());
		consumer.start();
		int result = p.waitFor();
		consumer.join();
		System.out.println(consumer.getOutput());
		return 0;
	}
	
	

}
