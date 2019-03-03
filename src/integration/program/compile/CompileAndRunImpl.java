package integration.program.compile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import integration.program.model.CaseModel;
import integration.program.model.CompileResult;
import integration.program.model.RunResult;

public class CompileAndRunImpl implements CompileAndRun {

	// ����Ĺ���Ŀ¼
	private final String workSpace = "D:\\Temp\\";
	// ����code��ʱʱ�� ��λ:��
	private final long timeout = 5;

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
			//�ȴ�������������߳�die��,�����̲��ܼ���ִ��
			//���ڻ����Ƴ�������ʱ��,�˴�ע�͵�
			//runThread.join();
			
			//�ж��Ƿ�code���г�ʱ
			if(isRunCodeTimeOut(runThread, timeout)) {
				runResult.setResultCode(2);
				runResult.setResultState(false);
			}
			//�ж�code���н���Ƿ�pass
			else {
				String strAnswer = caseModel.getOutput().trim();
				String codeOutput = runThread.getResultString().trim();
				if(isCodeOutputAcceptable(codeOutput, strAnswer)) {
					runResult.setResultCode(0);
					runResult.setResultState(true);
				}
				else {
					runResult.setResultCode(1);
					runResult.setResultState(false);
				}
			}
		

			runResultList.add(runResult);

		}
		return runResultList;

	}
	//�ж�code�����Ƿ�ʱ
	public boolean isRunCodeTimeOut(Thread thread, long timeout) {
		
		try {
			TimeUnit.SECONDS.timedJoin(thread,timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		//��ʱ
		if(thread.isAlive()) {
			
			thread.interrupt();
			/*try {
				throw new TimeoutException("Thread did not finish within time limit");
			} catch (TimeoutException e) {
				e.printStackTrace();
			}*/
			//timeout
			return true;
		}
		//not timeout
		return false;

	}
	//�ж����н���Ƿ���ϴ�
	public boolean isCodeOutputAcceptable(String codeOutput, String strAnswer) {
		//code output accepted
		if (strAnswer.equals(codeOutput)) {
			return true;
		} 
		//code output not acceptable
		else {
			return false;
		}
	}

}
