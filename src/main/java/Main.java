import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, IOException {
        int i = 0, choice;
        Scanner input = new Scanner(System.in);
        while (i == 0) {
            System.out.println("1. OpenCSV Examples\n" +
                    "2. JSON Example\n" +
                    "3. Exit\n" );
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    ThirdPartyLib.CsvParse();
                    break;
                case 2:
                    GsonLib.jsonExample();
                    break;
                case 3:
                    i = 1;
                    break;
                default:
                    System.out.println("Enter Valid Option please...");
            }
        }
    }
}
