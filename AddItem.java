public class AddItem implements Command{
    @Override
    public void execute(Player player) {
        String response = getResponse("itemName: ");
        player.getCurrentRoom().addItem(response);
    }
}
