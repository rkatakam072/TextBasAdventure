public class DropItem implements Command {


    @Override
    public void execute(Player player) {
        String response = getResponse("what item do you want to drop: ");
        Item item = player.removeItem(response);
        player.getCurrentRoom().addItem(item);
    }
}
