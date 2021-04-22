import java.util.Scanner;

public interface Command {

    void execute(Player player);

    default String getResponse(String string) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("what room: ");
        String response = scanner.nextLine();

        scanner.close();
        return response;
    }
}
