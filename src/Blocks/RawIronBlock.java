package Blocks;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock{
    public RawIronBlock() {
        super();
        this.contenuto = 'I';
        this.blockName = "Raw Iron Block";
        this.isSmeltable = true;
    }

    public Block smelt() {
        return new IronSwordBlock();
    }
}
