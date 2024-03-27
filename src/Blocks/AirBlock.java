package Blocks;

public class AirBlock extends AbstractBlock{
    public AirBlock() {
        this.contenuto = ' ';
        this.falls_with_gravity = false;
        this.fall_through = true;
        this.blockName = "Air Block";
    }

    public char getContenuto() {
        return contenuto;
    }
}
