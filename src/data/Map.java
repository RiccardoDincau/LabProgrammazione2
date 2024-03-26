package data;

public class Map {
    private Block[][] mappa;

    private final int righe = 30;
    private final int colonne = 30;

    public Map() {
        this.mappa = new Block[this.righe][this.colonne];
        for (int i = 0; i < this.righe; i++) {
            for (int j = 0; j < this.colonne; j++) {
                this.mappa[i][j] = new Block();
            }
        }
    }

    public int getRighe() {
        return righe;
    }

    public int getColonne() {
        return colonne;
    }

    private boolean validCoords(int r, int c) {
        return (r >= 0 && r < this.righe && c >= 0 && c < this.colonne);
    }

    private boolean isDefaultBolck(int r, int c) {
        return this.mappa[r][c].getContenuto() == ' ';
    }
    public void display_on_out() {
        for (Block[] riga : this.mappa) {
            for (Block blocco : riga) {
                blocco.display();
            }
            System.out.println();
        }
    }

    public void change_cell(int r, int c, char cont) {
        if (!this.validCoords(r, c)) {
            System.out.println("Cordinate non valide");
        } else {
            this.mappa[r][c] = new Block(cont);
        }
    }

    public void change_cell(int r, int c) {
        change_cell(r, c, 'A');
    }

    private boolean swap(int r, int c) {
        if (validCoords(r, c) && r < this.righe - 1 && this.mappa[r + 1][c].isFall_through()) {
            Block temp = this.mappa[r][c];
            this.mappa[r][c] = this.mappa[r + 1][c];
            this.mappa[r+ 1][c] = temp;
            return true;
        }
        return false;
    }

    public boolean insert_at_coords(int r, int c) {
        if (validCoords(r, c) && isDefaultBolck(r, c)) {
            this.change_cell(r, c);
            if (this.mappa[r][c].isFalls_with_gravity()) {
                while (this.swap(r, c)) {
                    r += 1;
                }
            }

            this.compressColumn(c);
            return true;
        }
        return false;
    }

    public void insertInCol(int c) {
        insert_at_coords(0, c);
    }

    private void compressColumn(int c) {
        int[] columnPressure = new int[this.righe];
        int sum = 0;
        for (int r = 0; r < this.righe; r++) {
            if (this.mappa[r][c].getContenuto() != ' ') {
                sum += (int)this.mappa[r][c].getContenuto();
                columnPressure[r] = sum;
                if (sum >= this.mappa[r][c].getContenuto() * 3) {
                    this.change_cell(r, c, (char)(this.mappa[r][c].getContenuto() + 1));
                }
            }
        }
    }
}
