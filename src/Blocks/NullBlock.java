package Blocks;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {
    public NullBlock() {
        super();
        this.contenuto = 'N';
        this.blockName = "NULL";
        this.pickable = false;
    }
    public NullBlock smelt() {
        return new NullBlock();
    }
}
