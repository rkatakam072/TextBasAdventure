import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends GenericEntity implements ItemContainer {
    private final ArrayList<Item> items;

    public Player(World.Room currentRoom) {
        super("player", null, currentRoom);
        setCurrentRoom(currentRoom);
        items = new ArrayList<>();
    }

    @Override
    public List<Item> getListOfItems() throws Exception {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTrace[2];

        if (element.getClassName().equals("ItemContainer"))
            return items;

        throw new Exception("You can't use getListOfItems, only ItemContainer can use it");
    }

    public World.Room getCurrentRoom() {
        return getRoom();
    }

    public boolean moveToRoom(String name) {
        World.Room neighbor = getRoom().getNeighbor(name);
        if (neighbor != null) {
            setCurrentRoom(neighbor);
            return true;
        }

        return false;
    }

    @Override
    public void move() {
        String response = null;
        Scanner scanner = new Scanner(System.in);

            System.out.println("You are in the " + this.getCurrentRoom().getName());
            System.out.println("what do you want to do");
            response = scanner.nextLine();

            if (response.startsWith("go")) {
                new GoCommand().execute(this);
            } else if (response.equals("look")) {
                new LookCommand().execute(this);
            } else if (response.startsWith("add room")) {
                new AddRoomCommand().execute(this);
            } else if (response.startsWith("add item")) {
                new AddItem().execute(this);
            } else if (response.startsWith("get item")) {
                new GetItem().execute(this);
            } else if (response.startsWith("drop")) {
                new DropItem().execute(this);
            } else if (response.equals("quit"));
            else {
                System.out.println("you can type go, look, add room __name__, and quit");
            }

            if (this.getInventoryString().contains("wumpus")){
                System.out.println("You won");
            }

            scanner.close();
        }
    }