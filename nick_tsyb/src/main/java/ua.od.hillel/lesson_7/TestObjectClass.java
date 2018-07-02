package lesson_7;

public class TestObjectClass {

    private int a;
    private int b;


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public int hashCode() {
        int prime = 32;
        int result = 1;
        result = prime * result + a;
        result = prime * result + b;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TestObjectClass objectClass = (TestObjectClass) obj;
        if (a != objectClass.a) {
            return false;
        }
        if (b != objectClass.b) {
            return false;
        }
        return true;
    }

    public TestObjectClass(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
