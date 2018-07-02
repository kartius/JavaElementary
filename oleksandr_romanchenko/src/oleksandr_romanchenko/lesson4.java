package src.oleksandr_romanchenko;

public class lesson4 {
    public static void main(String[] args) {

        lesson4 check = new lesson4();
        check.currencyConverter(26.1, "rub");
    }

    void currencyConverter(double userMoney, String str) {     // uah to usd, eur, rub

        if (str == "usd") {
            userMoney /= 26.1;
            System.out.println(userMoney);
        } else if (str == "eur") {
            userMoney /= 30.2;
            System.out.println(userMoney);
        } else if (str == "rub") {
            userMoney /= 0.37;
            System.out.println(userMoney);
        }
    }
}
