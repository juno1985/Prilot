package integration.program.compile;

import java.io.IOException;
import java.util.List;
import integration.program.model.CaseModel;
import integration.program.model.CompileResult;
import integration.program.model.RunResult;

public interface CompileAndRun {
	
	public CompileResult CompileCode(String codePath) throws IOException, InterruptedException;
	public List<RunResult> RunCode(String codeClazz, List<CaseModel> caseModelList) throws IOException,InterruptedException;

}
