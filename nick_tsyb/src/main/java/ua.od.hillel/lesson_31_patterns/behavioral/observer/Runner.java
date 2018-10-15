package ua.od.hillel.lesson_31_patterns.behavioral.observer;

public class Runner {

    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();

        observable.addObserver(observer);
        observable.setNews("news");
    }
}
