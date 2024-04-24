package Blocks;

public abstract class AbstractSolidBlock extends AbstractBlock{
    public AbstractSolidBlock() {
        super();
        this.fall_through = false;
        this.falls_with_gravity = false;
        this.isSmeltable = false;
        this.pickable = true;
    }
}


