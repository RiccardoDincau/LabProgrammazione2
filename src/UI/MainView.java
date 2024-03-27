package UI;

import Blocks.Furnace;
import Main.Main;

public class MainView {
    private final int viewRows = 10;
    private final int viewCols = 30;
    private Map viewMap;
    private Furnace viewFurnace;
    public MainView() {
        this.viewMap = new Map(this.viewRows, this.viewCols);
        this.viewFurnace = new Furnace();
    }

    // TODO
    // private boolean isBlockSmeltable(int r, int c) {}
    public void display_on_out() {
        this.viewMap.display_on_out();
        this.viewFurnace.display_on_out();
    }


}
