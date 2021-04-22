public class GetItem implements Command{
    @Override
    public void execute(Player player) {
        String response = getResponse("What item: ");

        if (player.getCurrentRoom().contains(response)){
            player.addItem(response);
            player.getCurrentRoom().removeItem(response);
        }
    }
}