public class LookCommand implements Command {

    @Override
    public void execute(Player player) {
        String string = player.getCurrentRoom().getNeighborNames();
        System.out.println(string);

        string= player.getCurrentRoom().getEntitiesNames();
        System.out.println(string);
    }
}
