package Blocks;

public interface Block extends InventoryBlock{
    void display();
    boolean isFall_through();
    boolean isFalls_with_gravity();
    boolean isSmeltable();
    char getContenuto();
}
