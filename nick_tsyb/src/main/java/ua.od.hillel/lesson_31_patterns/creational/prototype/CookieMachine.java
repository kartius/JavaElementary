package ua.od.hillel.lesson_31_patterns.creational.prototype;

public class CookieMachine {
    private Cookie cookie;

    public CookieMachine(Cookie cookie) {
        this.cookie = cookie;
    }

    public Cookie makeCookie() throws CloneNotSupportedException {
        return (Cookie) this.cookie.clone();
    }

    public static void main(String args[]) throws CloneNotSupportedException {
        Cookie tempCookie = null;
        Cookie prot = new Cookie();
        prot.setWeight(1);
        CookieMachine cm = new CookieMachine(prot);
        tempCookie = cm.makeCookie();
        tempCookie.setWeight(10);
    }
}
