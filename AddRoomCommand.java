public class AddRoomCommand implements Command{

    @Override
    public void execute(Player player) {
        String response = getResponse("what room: ");
        player.getCurrentRoom().addNeighbor(response);
    }
}
