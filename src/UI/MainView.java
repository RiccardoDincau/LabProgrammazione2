package UI;

import Blocks.Furnace;
import Blocks.SmeltableBlock;
import Main.Main;

public class MainView {
    private final int viewRows = 6;
    private final int viewCols = 6;
    private Map viewMap;
    private Furnace viewFurnace;
    public MainView() {
        this.viewMap = new Map(this.viewRows, this.viewCols);
        this.viewFurnace = new Furnace();
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
    }

    public void smelt() {
        this.viewFurnace.smelt();
    }


}
