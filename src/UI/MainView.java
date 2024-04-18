package UI;

import Blocks.Block;
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
        if (this.viewMap.isBlockSmeltable(r, c) && !this.viewFurnace.is_input_empty() && !this.viewFurnace.is_output_empty()) {
            this.viewFurnace.setInput(this.viewMap.getSmeltableBlock(r, c));
            this.viewMap.set_default(r, c);
        } else {
            System.out.println("Non SmeltableBlock requested for furnace input");
        }
    }
    public void map_to_inventory(int r, int c) {
        if (this.viewMap.validCoords(r, c)) {
            this.inventory.add_block(this.viewMap.take_block(r, c));
        }
    }
    public void inventory_to_furnace(int index) {
        if (index >= 0 && index < this.inventory.get_size()
                && this.viewFurnace.is_input_empty()
                && this.viewFurnace.is_output_empty()) {
            this.viewFurnace.setInput(this.inventory.get_smeltable_item(index));
        }
    }
    public void furnace_to_inventory() {
        if (!this.viewFurnace.is_output_empty()) {
            this.inventory.add_block(this.viewFurnace.getOutput());
        }
    }

    public void display_on_out() {
        this.viewMap.display_on_out();
        this.viewFurnace.display_on_out();
        this.inventory.print_inventory();
    }

    public void smelt() {
        this.viewFurnace.smelt();
        this.inventory.add_block(this.viewFurnace.getOutput());
    }


}
