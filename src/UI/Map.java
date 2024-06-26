package UI;

import Blocks.*;
import UI.exceptions.BlockErrorException;

import java.util.Random;

public class Map {
    private Block[][] mappa;

    private final int righe;
    private final int colonne;
    private final int RANDOM_BLOCKS_TO_ADD = 10;

    public Map(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        this.mappa = new Block[this.righe][this.colonne];
        for (int i = 0; i < this.righe; i++) {
            for (int j = 0; j < this.colonne; j++) {
                this.mappa[i][j] = new AirBlock();
            }
        }

        Random rand = new Random();
        for (int i = 0 ; i < this.RANDOM_BLOCKS_TO_ADD; i++){
            int row = rand.nextInt(this.righe);
            int col = rand.nextInt(this.colonne);
            this.insert_at_coords(row, col,
                    (rand.nextInt(2) == 0) ? 'S' : 'I');
        }

        this.addRiver();
    }

    private boolean validCoords(int r, int c) {
        return (r >= 0 && r < this.righe && c >= 0 && c < this.colonne);
    }

    private boolean isDefaultBolck(int r, int c) {
        return this.mappa[r][c].getContenuto() == ' ';
    }
    private boolean is_smeltable(int r, int c) {
        return this.mappa[r][c].isSmeltable();
    }
    public Block getBlock(int r, int c) {return this.mappa[r][c];}
    public SmeltableBlock getSmeltableBlock(int r, int c) throws BlockErrorException {
        if (is_smeltable(r, c)) {
            return (SmeltableBlock) this.remove_block(r, c);
        }
        throw new BlockErrorException();
    }
    public Block remove_block(int r, int c) {
        Block temp = this.mappa[r][c];
        this.mappa[r][c] = new AirBlock();
        gravity_on_column(c);
        return temp;
    }

    private void gravity_on_column(int c) {
        int maxIt = colonne;
        while (maxIt-- > 0) {
            for (int r = righe - 1; r >= 0; r--) {
                swap(r, c);
            }
        }
    }
    private boolean swap(int r, int c) {
        if (validCoords(r, c) && r < this.righe - 1
                && this.mappa[r + 1][c].isFall_through() && this.mappa[r][c].isFalls_with_gravity()) {
            if (this.mappa[r + 1][c] instanceof TorchBlock &&
            this.mappa[r][c] instanceof DestroyedOnTorch) {
                this.change_cell(r, c, ' ');
            } else {
                Block temp = this.mappa[r][c];
                this.mappa[r][c] = this.mappa[r + 1][c];
                this.mappa[r + 1][c] = temp;
                return true;
            }
        }
        return false;
    }
    private void change_cell(int r, int c, char type) {
        if (!this.validCoords(r, c)) {
            System.out.println("Cordinate non valide");
        } else {
            switch (type) {
                case 'S': {
                    this.mappa[r][c] = new SandBlock();
                    break;
                }
                case 'W': {
                    this.mappa[r][c] = new WaterBlock();
                    break;
                }
                case 'I': {
                    this.mappa[r][c] = new RawIronBlock();
                    break;
                }
                default: {
                    System.out.println("Tipo non valido");
                }
            }
        }
    }
    private void addRowsOfWater() {
        for (int c = 0; c < colonne; c++) {
            insert_at_coords(0, c, 'W');
        }
    }
    public void display_on_out() {
        System.out.println("____________");
        for (Block[] riga : this.mappa) {
            System.out.print("|");

            for (Block blocco : riga) {
                blocco.display();
            }
            System.out.println("|");
        }
        System.out.println("____________");
    }
    public boolean insert_at_coords(int r, int c, char type) {
        if (validCoords(r, c) && isDefaultBolck(r, c)) {
            this.change_cell(r, c, type);
            if (this.mappa[r][c].isFalls_with_gravity()) {
                while (this.swap(r, c)) {
                    r += 1;
                }
            }
            return true;
        }
        return false;
    }
    public void insertInCol(int c, char type) {
        insert_at_coords(0, c, type);
    }
    public void addRiver() {
        addRowsOfWater();
    }
    public void addSea() {
        for (int i = 0; i < 3; i++) {
            addRowsOfWater();
        }
    }
    private boolean is_pickable(int r, int c) {
        return this.mappa[r][c].is_pickable();
    }

    public Block gimme_pickable(int r, int c) throws BlockErrorException{
        if (this.is_pickable(r, c)) {
            return remove_block(r, c);
        }
        throw new BlockErrorException();
    }
}
