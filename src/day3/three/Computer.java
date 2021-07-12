package day3.three;

public class Computer {
	public static void main(String[] args) {
	    BeanFactory bf = new BeanFactory("day3/three/beans.xml");
		Mainboard mb = (Mainboard)bf.getBean("mainboard");
		mb.run();
	}
}
