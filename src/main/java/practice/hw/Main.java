package practice.hw;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("Result: " + getWordByIndex("My name   is    Dmytro    Sukhii", 5));
    }
    public static int getWordByIndex(String s, int idx) {
        s = s.strip();

        int counter = 1;
        int index = 1;

        if (idx == 0) {
            System.out.println("Something went with wrong");
            System.exit(0);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (index > idx) { return counter; }

            if (s.charAt(i+1) == ' ' && s.charAt(i) != ' ') {
                index++;
                continue;
            } else if ( (s.charAt(i) == ' ')) {
                counter = 1;
                continue;
            }
            else { counter++; }
        }

        return counter;
    }
}

