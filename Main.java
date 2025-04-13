import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Jugador jugador1 = new Jugador("Jugador 1", 5);
        Jugador jugador2 = new Jugador("Jugador 2", 5);

        jugador1.agregarBarco(0, 0, 2);
        jugador1.agregarBarco(1, 1, 3);
        jugador1.agregarBarco(2, 0, 4);

        jugador2.agregarBarco(0, 1, 2);
        jugador2.agregarBarco(2, 2, 3);
        jugador2.agregarBarco(4, 0, 4);

        boolean juegoTerminado = false;
        Jugador atacante = jugador1;
        Jugador defensor = jugador2;

        while (!juegoTerminado) {
            System.out.println(atacante.getNombre() + ", es tu turno.");
            defensor.getTablero().mostrarTablero();

            System.out.print("Ingresá fila: ");
            int fila = input.nextInt();

            System.out.print("Ingresá columna: ");
            int columna = input.nextInt();

            boolean acierto = defensor.recibirDisparo(fila, columna);
            if (acierto) {
                System.out.println("¡Le diste a un barco!");
            } else {
                System.out.println("Agua.");
            }

            if (defensor.todosLosBarcosHundidos()) {
                System.out.println(atacante.getNombre() + " gana");
                juegoTerminado = true;
            } else {
                Jugador temp = atacante;
                atacante = defensor;
                defensor = temp;
            }
        }

        input.close();
    }
}