package Blocks;

import UI.exceptions.FurnaceInputEmptyException;
import UI.exceptions.FurnaceInputFullException;
import UI.exceptions.FurnaceOutputFullException;

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
    public void smelt() throws FurnaceInputEmptyException, FurnaceOutputFullException {
        if (!this.is_output_empty()) {
            throw new FurnaceOutputFullException();
        }
        if (this.is_input_empty()) {
            throw new FurnaceInputEmptyException();
        }
        this.output = this.input.smelt();
        this.input = new NullBlock();
    }

    private boolean is_input_empty() {
        return this.input instanceof NullBlock;
    }
    private boolean is_output_empty() {
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
    public void setInput(SmeltableBlock inputBlock) throws FurnaceInputFullException{
        if (this.is_input_empty()) {
            this.input = inputBlock;
        } else {
            throw new FurnaceInputFullException();
        }
    }
}
