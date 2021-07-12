package day1.part1.seven;

public class Test {

    public static void main(String[] args) {

        IpCard ipCard = new IpCard("ipcard", 30, 5, 0.3);
        TwoZeroOneCard twoZeroOneCard = new TwoZeroOneCard("twoZeroCard", 30, 5, 0.45);

        ipCard.balance();
        twoZeroOneCard.balance();

    }
}
