package Blocks;

public interface Block {
    void display();
    boolean isFall_through();

    boolean isFalls_with_gravity();
    char getContenuto();
}
