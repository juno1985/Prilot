package integration.program.compile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import integration.program.model.CaseModel;
import integration.program.model.CompileResult;
import integration.program.model.RunResult;

public class CompileAndRunImpl implements CompileAndRun {

	// 编译的工作目录
	private final String workSpace = "D:\\Temp\\";

	public CompileAndRunImpl() {

	}

	@Override
	public CompileResult CompileCode(String code) throws IOException, InterruptedException {
		ProcessBuilder processBuilder = new ProcessBuilder("javac", workSpace + code);
		processBuilder.redirectErrorStream(true);
		processBuilder.directory(new File(workSpace));
		Process p = processBuilder.start();
		ComplieImplSubThread compileThread = new ComplieImplSubThread(p);

		compileThread.start();
		int result = p.waitFor();
		compileThread.join();
		CompileResult compileResult = new CompileResult();
		compileResult.setResultCode(result);
		compileResult.setResultString(compileThread.getResultString());
		return compileResult;
	}

	@Override
	public List<RunResult> RunCode(String codeClazz, List<CaseModel> caseModelList)
			throws IOException, InterruptedException {
		ProcessBuilder processBuilder = new ProcessBuilder("java", codeClazz);
		processBuilder.redirectErrorStream(true);
		processBuilder.directory(new File(workSpace));

		List<RunResult> runResultList = new ArrayList<RunResult>();

		for (CaseModel caseModel : caseModelList) {
			RunResult runResult = new RunResult();

			Process p = processBuilder.start();

			RunImplSubThread runThread = new RunImplSubThread(p);

			runThread.setInput(caseModel.getInput());
			runThread.start();
			int result = p.waitFor();
			runThread.join();

			runResult.setResultCode(result);
			if (caseModel.getOutput().trim().equals(runThread.getResultString().trim())) {
				runResult.setResultState(true);
			} else {
				runResult.setResultState(false);
			}

			runResultList.add(runResult);

		}
		return runResultList;

	}

}
