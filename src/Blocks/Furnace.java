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

    public boolean is_input_empty() {
        return this.input instanceof NullBlock;
    }
    public boolean is_output_empty() {
        return this.output instanceof NullBlock;
    }

    public Block getOutput() {
        Block temp = this.output;
        this.output = new NullBlock();
        return temp;
    }
    public Block getInput() {
        Block temp = this.input;
        this.input = new NullBlock();
        return temp;
    }
    public void setInput(SmeltableBlock inputBlock) {
        if (this.is_input_empty()) {
            this.input = inputBlock;
        }
    }
}
