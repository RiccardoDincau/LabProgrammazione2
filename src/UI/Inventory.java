package UI;

import Blocks.Block;
import Blocks.NullBlock;
import Blocks.SmeltableBlock;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
    private ArrayList<Block> inventario;

    public Inventory() {
        this.inventario = new ArrayList<>();
    }
    public void display_on_out() {
        Iterator<Block> iteratoreInventario = this.inventario.iterator();
        while (iteratoreInventario.hasNext()) {
            iteratoreInventario.next().display_in_inventory();
        }
        System.out.println();
    }

    public void add_block(Block b) {
        this.inventario.add(b);
    }
    public boolean is_smeltable(int index) {
        return this.inventario.get(index) instanceof SmeltableBlock;
    }
    public SmeltableBlock get_smeltable(int index) {
        if (is_smeltable(index)) {
            return (SmeltableBlock) this.get_block(index);
        }
        return new NullBlock();
    }
    public Block get_block(int index) {
        return this.inventario.remove(index);
    }
}
