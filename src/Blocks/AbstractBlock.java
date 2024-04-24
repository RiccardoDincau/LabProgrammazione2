package Blocks;

public abstract class AbstractBlock implements Block {
    protected char contenuto;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected String blockName;
    protected boolean isSmeltable;
    protected boolean pickable;

    public AbstractBlock() {
        this.pickable = false;
    }

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
    @Override
    public void display_in_inventory() {
        System.out.print("[" + this.contenuto + "]");
    }

    @Override
    public boolean is_pickable() {
        return pickable;
    }
}
