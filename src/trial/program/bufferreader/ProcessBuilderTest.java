package trial.program.bufferreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuilderTest {
	 public static void main(String[] args) {
	        List<String> params = new ArrayList<String>();
	        params.add("java");
	        params.add("HackRankInput");

	        ProcessBuilder processBuilder = new ProcessBuilder(params);
	        processBuilder.directory(new File("D:\\Temp"));
//	        System.out.println(processBuilder.directory());
//	        System.out.println(processBuilder.environment());
//	        processBuilder.redirectErrorStream(true);
	        try {
	            Process process = processBuilder.start();
	            OutputStream outputStream = process.getOutputStream();
	            outputStream.write("123\n".getBytes());
	            outputStream.write("456\n".getBytes());
	            outputStream.write("789\n".getBytes());
	            outputStream.close();
	            
	            long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
	            
	            int exitCode = process.waitFor();
	            
	            long endTime=System.currentTimeMillis(); //��ȡ����ʱ��
	            
	            System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");
	            
	            if(exitCode!=0) {
	            	BufferedReader br_err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		            String line_err;
		            while ((line_err = br_err.readLine()) != null) {
		                System.out.println("--> " + line_err);
		            }
		            return;
	            }
	            
	            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
	            String line;
	            while ((line = br.readLine()) != null) {
	                System.out.println("--> " + line);
	            }
	            
	            System.out.println("exitCode = "+exitCode);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
