package data;

public class Block {
    private char contenuto;
    private boolean falls_with_gravity;
    private boolean fall_through;

    public Block(char contenuto) {
        this.contenuto = contenuto;
        this.falls_with_gravity = true;
        this.fall_through = false;
    }

    public Block() {
        this(' ');
        this.falls_with_gravity = false;
        this.fall_through = true;
    }

    public boolean isFall_through() {
        return fall_through;
    }

    public boolean isFalls_with_gravity() {
        return falls_with_gravity;
    }

    public char getContenuto() {
        return contenuto;
    }

    public void display() {
        System.out.print(this.contenuto);
    }
}
