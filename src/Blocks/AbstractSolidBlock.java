package Blocks;

public abstract class AbstractSolidBlock extends AbstractBlock{
    public AbstractSolidBlock() {
        this.fall_through = false;
        this.falls_with_gravity = false;
    }
}
