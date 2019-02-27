package trial.program.bufferreader;

public class PrintArgs {
	public static void main(String args[]){
		System.out.println("This is a program test about Process, ProcessBuilder, Runtime.exec etc.");
		System.out.println("Now Print the args:");
		for(int i=0;i<args.length;i++){
			System.out.println("	[args-"+i+"]:"+args[i]);
		}
	}
}
