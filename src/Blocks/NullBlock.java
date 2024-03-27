package Blocks;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {
    public NullBlock() {
        super();
        this.contenuto = 'N';
        this.blockName = "NULL";
    }
    public NullBlock smelt() {
        return new NullBlock();
    }
}
