package Blocks;

public abstract class AbstractBlock implements Block {
    protected char contenuto;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected String blockName;
    protected boolean isSmeltable;

    public boolean isFall_through() {
        return fall_through;
    }
    public boolean isFalls_with_gravity() {
        return falls_with_gravity;
    }

    public boolean isSmeltable() {
        return isSmeltable;
    }

    public void display() {
        System.out.print(this.contenuto);
    }
    public char getContenuto() {return contenuto;}
    public String toString() {
        return blockName;
    }
}
