package src.oleksandr_romanchenko;

public class lesson3 {

    public static void main(String[] args) {
        lesson3 check = new lesson3();

        check.fibonacci();
        System.out.println();
        check.factorial(4);

    }

    void fibonacci() {                      // Fo = 0, F1 = 1
        // Fn = Fn-1 + Fn-2, n >= 2

        int[] arr = new int[100];
        int Fo = 0;
        int F1 = Fo + 1;
        arr[Fo] = Fo;                        // arr[Fo] = Fo
        arr[F1] = arr[Fo] + F1;              // arr[F1] = F1
        System.out.print(arr[Fo] + ", ");
        System.out.print(arr[F1] + ", ");

        for (int n = 2; n <= 20; n++) {      // n = amount of fibonacci sequence numbers
            int Fn = F1 + Fo;
            System.out.print(Fn + ", ");
            Fo = F1;
            F1 = Fn;
        }
        System.out.println();
    }

    void factorial(int n) {             // 4! = 4 * 3 * 2 * 1 = 24

        int sequenceNumber = 1;         // first number of sequence
        int[] factCells = new int[n];
        int result = 1;

        for (int i = 0; i < factCells.length; i++, sequenceNumber++) {
            factCells[i] = sequenceNumber;
            result *= factCells[i];
        }
        System.out.println(result);
    }
}
