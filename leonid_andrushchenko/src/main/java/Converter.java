public class Converter {

    public void convert(String currency, float sum)
    {
        switch (currency)
        {
            case "USD":
                System.out.println(sum*26.45 + " UAH");
                break;
            case "EUR":
                System.out.println(sum*30.5 + " UAH");
                break;
            case "RUB":
                System.out.println(sum*0.41 + " UAH");
               break;
            default:
                System.out.print("Валюты нет в списке");
        }
    }
}
