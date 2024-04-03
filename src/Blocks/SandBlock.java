package Blocks;

public class SandBlock extends AbstractBlock implements SmeltableBlock {
    public SandBlock() {
        this.contenuto = 'S';
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.blockName = "Sand";
        this.isSmeltable = true;
    }

    public Block smelt() {
        return new GlassBlock();
    }
}

