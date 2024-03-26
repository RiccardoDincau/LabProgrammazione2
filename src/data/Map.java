package data;

public class Map {
    private Block[][] mappa;

    private final int righe;
    private final int colonne;

    public Map() {
        this.righe = 10;
        this.colonne = 10;
        this.mappa = new Block[this.righe][this.colonne];
        for (int i = 0; i < this.righe; i++) {
            for (int j = 0; j < this.colonne; j++) {
                this.mappa[i][j] = new Block();
            }
        }
    }

    private boolean validCoords(int r, int c) {
        return (r >= 0 && r < this.righe && c >= 0 && c < this.colonne);
    }

    private boolean isDefaultBolck(int r, int c) {
        return this.mappa[r][c].getContenuto() == ' ';
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

    public void change_cell(int r, int c) {
        if (!this.validCoords(r, c)) {
            System.out.println("Cordinate non valide");
        } else {
            this.mappa[r][c] = new Block('A');
        }
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

    public void insert_at_coords(int r, int c) {
        if (validCoords(r, c) && isDefaultBolck(r, c)) {
            this.change_cell(r, c);
            if (this.mappa[r][c].isFalls_with_gravity()) {
                while (this.swap(r, c)) {
                    r += 1;
                }
            }
        } else  {
            System.out.println("Cordinate non valide");
        }
    }

    public void insertInCol(int c) {
        insert_at_coords(0, c);
    }
}
