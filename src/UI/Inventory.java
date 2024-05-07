package UI;

import Blocks.Block;
import Blocks.NullBlock;
import Blocks.SmeltableBlock;
import Blocks.comparators.AlphabeticalBlockComparator;
import Blocks.comparators.BlockComparator;
import UI.exceptions.AddedNullBlockException;
import UI.exceptions.BlockErrorException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Inventory {
    private ArrayList<Block> inventario;
    private Comparator<Block> current_comparator;

    public Inventory() {
        this.inventario = new ArrayList<>();
        this.current_comparator = new AlphabeticalBlockComparator();
    }
    public void display_on_out() {
        Iterator<Block> iteratoreInventario = this.inventario.iterator();
        while (iteratoreInventario.hasNext()) {
            iteratoreInventario.next().display_in_inventory();
        }
        System.out.println();
    }

    public void add_block(Block b) throws AddedNullBlockException {
        if (b instanceof NullBlock) {
            throw new AddedNullBlockException();
        }
        this.inventario.add(b);
        this.order_inventory();
    }
    private boolean is_smeltable(int index) {
        return this.inventario.get(index) instanceof SmeltableBlock;
    }
    public SmeltableBlock get_smeltable(int index) throws BlockErrorException {
        if (is_smeltable(index)) {
            return (SmeltableBlock) this.get_block(index);
        }
        throw new BlockErrorException();
    }
    public Block get_block(int index) {
        return this.inventario.remove(index);
    }
    public void order_inventory() {
        this.inventario.sort(this.current_comparator);
    }
    public void switch_comparator() {
        if (this.current_comparator instanceof AlphabeticalBlockComparator) {
            this.current_comparator = new BlockComparator();
        } else {
            this.current_comparator = new AlphabeticalBlockComparator();
        }
        this.order_inventory();
    }
}
