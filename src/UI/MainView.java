package UI;

import Blocks.Furnace;

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
        if (this.viewMap.isBlockSmeltable(r, c)) {
            this.viewFurnace.setInput(this.viewMap.getSmeltableBlock(r, c));
        } else {
            System.out.println("Non SmeltableBlock requested for furnace input");
        }
    }
    public void display_on_out() {
        this.viewMap.display_on_out();
        this.viewFurnace.display_on_out();
        this.inventory.display_on_out();
    }

    public void smelt() {
        if (!this.viewFurnace.is_input_empty() && this.viewFurnace.is_output_empty()) {
            this.viewFurnace.smelt();
            this.inventory.add_block(this.viewFurnace.getOutput());
        }
    }

    public void move_into_furnace_from_inventory(int index) {
        if (this.viewFurnace.is_input_empty() && this.inventory.is_smeltable(index)) {
            this.viewFurnace.setInput(this.inventory.get_smeltable(index));
        }
    }

    public void move_into_inventory_from_furnace() {
        if (!this.viewFurnace.is_input_empty()) {
            this.inventory.add_block(this.viewFurnace.getInput());
        }
    }
    public void pick_up_block(int r, int c) {
        if (this.viewMap.is_pickable(r, c)) {
            this.inventory.add_block(this.viewMap.gimme_pickable(r, c));
        }
    }

    public void toggle_inventory_comparator() {

    }

}
