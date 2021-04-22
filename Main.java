import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        World g = new World();
        Player player = new Player(g.getRoom("hall"));


        String response = "";
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("You are in the " + player.getCurrentRoom().getName());
            System.out.println("what do you want to do");
            response = scanner.nextLine();

            if (response.startsWith("go")) {
                new GoCommand().execute(player);
            } else if (response.equals("look")) {
                new LookCommand().execute(player);
            } else if (response.startsWith("add room")) {
                new AddRoomCommand().execute(player);
            } else if (response.startsWith("add item")) {
                new AddItem().execute(player);
            } else if (response.startsWith("get item")) {
                new GetItem().execute(player);
            } else if (response.startsWith("drop")) {
                new DropItem().execute(player);
            } else if (response.equals("quit")) break;
            else {
                System.out.println("you can type go, look, add room __name__, and quit");
            }

            if (player.getInventoryString().contains("wumpus")){
                System.out.println("You won");
                break;
            }
        } while (!response.equals("quit"));

        scanner.close();
    }
}