public abstract class GenericEntity implements Entity {
    private final String name, description;
    private World.Room currentRoom;

    public GenericEntity(String name, String description, World.Room currentRoom) {
        this.name = name;
        this.description = description;
        this.currentRoom = currentRoom;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public abstract void move();

    protected void move(World.Room nextRoom){
        this.currentRoom = nextRoom;
    }

    @Override
    public World.Room getRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(World.Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}