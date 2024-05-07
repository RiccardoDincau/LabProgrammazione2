package UI;

import Blocks.Block;
import Blocks.Furnace;
import Blocks.NullBlock;
import UI.exceptions.*;

public class MainView {
    private final int viewRows = 6;
    private final int viewCols = 6;
    private Map viewMap;
    private Furnace viewFurnace;
    private Inventory inventory;
    public MainView() {
        this.viewMap = new Map(this.viewRows, this.viewCols);
        this.viewFurnace = new Furnace();
        this.inventory = new Inventory();
    }

    public void move_into_furnace(int r, int c) {
        try {
            this.viewFurnace.setInput(this.viewMap.getSmeltableBlock(r, c));
        } catch (BlockErrorException e) {
            System.err.println("Non SmeltableBlock requested for furnace input");
        } catch (FurnaceInputFullException e) {
            System.err.println("Furnace input full");
        }
    }
    public void display_on_out() {
        this.viewMap.display_on_out();
        this.viewFurnace.display_on_out();
        this.inventory.display_on_out();
    }

    public void smelt() {
        try {
            this.viewFurnace.smelt();
        } catch (FurnaceInputEmptyException e) {
            System.err.println("Furnace input is empty");
        } catch (FurnaceOutputFullException e) {
            System.err.println("Furnace output is full");
        }

        try {
            this.inventory.add_block(this.viewFurnace.getOutput());
        } catch (AddedNullBlockException e) {
            System.err.println("Tried adding null block to inventory");
        }
    }

    public void move_into_furnace_from_inventory(int index) {
        try {
            this.viewFurnace.setInput(this.inventory.get_smeltable(index));
        } catch (BlockErrorException e) {
            System.err.println("Non smeltable block required for furnace input");
        } catch (FurnaceInputFullException e) {
            System.err.println("Furnace input full");
        }
    }

    public void move_into_inventory_from_furnace() {
        try {
            this.inventory.add_block(this.viewFurnace.getInput());
        } catch (AddedNullBlockException e) {
            System.err.println("Furnace input empty");
        }
    }
    public void pick_up_block(int r, int c) {
        try {
            this.inventory.add_block(this.viewMap.gimme_pickable(r, c));
        } catch (BlockErrorException e) {
            System.err.println("Not pickable block");
        } catch (AddedNullBlockException e) {
            System.err.println("Added null block");
        }
    }

    public void toggle_inventory_comparator() {
        this.inventory.switch_comparator();
    }

}
