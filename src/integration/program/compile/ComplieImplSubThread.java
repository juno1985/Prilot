package integration.program.compile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ComplieImplSubThread extends Thread {

	private List<String> resultString = new ArrayList<String>();
	// �����̵߳õ����
	private InputStream inputStream;
	// �����̵߳õ�����
	// private OutputStream outputStream;

	public ComplieImplSubThread(Process process) {
		this.inputStream = process.getInputStream();
		// this.outputStream = process.getOutputStream();
	}

	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(this.inputStream));
		String line;
		try {
			while ((line = br.readLine()) != null) {
				this.resultString.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<String> getResultString() {
		return this.resultString;
	}
	
	

}
