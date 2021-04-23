public class Chicken extends GenericEntity{

    public Chicken(String name, World.Room currentRoom) {
        super(name, null, currentRoom);
    }

    @Override
    public void move() {
        int rand = (int) (Math.random() * getRoom().getNeighbors().size());
        move(getRoom().getNeighbors().get(rand));
    }
}
