public interface Entity {
     String getName();
     String getDescription();
     void move();
     World.Room getRoom();
}