package data;

public class Block {
    private char contenuto;
    private boolean falls_with_gravity;
    private boolean fall_through;

    public Block(char contenuto) {
        setContenuto(contenuto);
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

    public void setContenuto(char contenuto) {
        if ((contenuto >= 'A' && contenuto <= 'Z') || contenuto == ' ') {
            this.contenuto = contenuto;
        } else {
            this.contenuto = 'Z';
        }
    }

    public void display() {
        System.out.print(this.contenuto);
    }
}
