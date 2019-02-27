package trial.program.compile;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamConsumer extends Thread{
	private InputStream is;
	private IOException exp;
	private StringBuilder output;
	
	
	
	public InputStreamConsumer(InputStream is) {
		this.is = is;
		/*ByteArrayInputStream inputStringStream = new ByteArrayInputStream(new String("1018").getBytes());
		
		System.setIn(inputStringStream);*/
		
		
		
	}

	@Override
	public void run() {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(this.is));
			br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public IOException getExp() {
		return exp;
	}

	public StringBuilder getOutput() {
		return output;
	}
	
}
