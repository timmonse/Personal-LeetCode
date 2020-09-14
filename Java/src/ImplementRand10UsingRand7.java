import java.util.Random;

public class ImplementRand10UsingRand7 {
    public int rand7() {
        Random rand = new Random();
        return rand.nextInt(7) + 1;
    }

    public int rand10() {
        int factor;
        int num = 50;

        while (num > 40) {
            factor = rand7() - 1;
            num = 7*factor + rand7();
        }
        return num % 10 + 1;
    }
}
