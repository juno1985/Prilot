package day1.part1.seven;

public class PhoneCard {

    public String cardNumber;
    public double initMoney;
    public int time;
    public double minMoney;

    public PhoneCard(String cardNumber, double initMoney, int time, double minMoney) {
        this.cardNumber = cardNumber;
        this.initMoney = initMoney;
        this.time = time;
        this.minMoney = minMoney;
    }

    public void balance(){
        System.out.println(this.cardNumber + "余额: " + (initMoney - time * minMoney));
    }
}
