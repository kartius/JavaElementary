package ua.od.hillel.lesson_31_patterns.structural.proxy;

public class ClientProxy implements Person {

    private Client client;

    @Override
    public String getData() {
        if (client == null) {
            client = new Client();
        }
        return client.getData();
    }
}
