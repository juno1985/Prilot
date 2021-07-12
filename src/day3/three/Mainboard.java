package day3.three;

public class Mainboard {
	private CPU cpu;
	private GraphicsCard gCard;
	
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	
	public void setGraphicsCard(GraphicsCard gCard) {
		this.gCard = gCard;
	}
	
	public void run(){
		System.out.println("Starting computer...");
		cpu.calculate();
		gCard.display();
	}
}
