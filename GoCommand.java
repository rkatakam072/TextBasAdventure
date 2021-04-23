public class GoCommand implements Command {

    @Override
    public void execute(Player player) {
        String room = getResponse("what room: ");
        player.moveToRoom(room);
    }
}
