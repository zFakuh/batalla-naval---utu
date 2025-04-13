import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Tablero tablero;
    private ArrayList<Barco> barcos;

    public Jugador(String nombre, int tamañoTablero) {
        this.nombre = nombre; 
        this.tablero = new Tablero(tamañoTablero);
        this.barcos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void agregarBarco(int fila, int columnaInicio, int tamaño) {
        Barco barco = new Barco(tamaño);
        tablero.colocarBarcoHorizontal(fila, columnaInicio, tamaño);
        barcos.add(barco);
    }

    public boolean recibirDisparo(int fila, int columna) {
        for (Barco b : barcos) {
            if (!b.estaHundido() && tablero.getCasilla(fila, columna).equals("B")) {
                tablero.disparar(fila, columna, b);
                return true;
            }
        }
        tablero.disparar(fila, columna, null); 
        return false;
    }

    public boolean todosLosBarcosHundidos() {
        for (Barco b : barcos) {
            if (!b.estaHundido()) {
                return false;
            }
        }
        return true;
    }
}