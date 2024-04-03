package Blocks;

public class Furnace {
    private SmeltableBlock input;
    private Block output;
    public Furnace() {
        this.input = new NullBlock();
        this.output = new NullBlock();
    }

    public void display_on_out() {
        System.out.println(this.input + " --> " + this.output);
    }
    public void smelt() {
        this.output = this.input.smelt();
        this.input = new NullBlock();
    }

    public void setInput(SmeltableBlock inputBlock) {
        this.input = inputBlock;
    }
}
