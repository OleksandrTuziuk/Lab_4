import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        System.out.println("Введіть текст: ");
        final String string = sc.nextLine();
        char l;
        while (true) {
            System.out.print("Введіть символ за яким буде відбуватись сортування: ");
            final String letter = sc.nextLine();
            if (letter.length() > 1) {
                System.out.println("Введено декілька символів");
                continue;
            } else if (letter.isEmpty()) {
                System.out.println("Символ не введений");
                continue;
            }
            l = letter.toCharArray()[0];
            break;
        }

        Text text = new Text(string);
        System.out.println(text);
        System.out.println(text.sort(l));
    }
}
