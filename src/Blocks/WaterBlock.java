package Blocks;

public class WaterBlock extends AbstractBlock{
    public WaterBlock() {
        this.contenuto = 'W';
        this.falls_with_gravity = true;
        this.fall_through = true;
        this.blockName = "Water";
    }
}
