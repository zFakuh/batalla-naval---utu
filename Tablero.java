public class Tablero {
    String[][] matriz;

    public Tablero(int tamaño) {
        matriz = new String[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                matriz[i][j] = "~";
            }
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void colocarBarcoHorizontal(int fila, int columnaInicio, int tamaño) {
        for (int i = 0; i < tamaño; i++) {
            matriz[fila][columnaInicio + i] = "B";
        }
    }

    public boolean disparar(int fila, int columna, Barco barco) {
        if (matriz[fila][columna].equals("B")) {
            matriz[fila][columna] = "X";
            barco.recibirImpacto();
            return true;
        } else {
            matriz[fila][columna] = "O";
            return false;
        }
    }

    public String getCasilla(int fila, int columna) {
        return matriz[fila][columna];
    }
}