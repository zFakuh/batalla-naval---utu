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
            System.out.println("Es el turno de " + atacante.getNombre());
            defensor.getTablero().mostrarTablero();

            System.out.print("Ingresa la fila: ");
            int fila = input.nextInt();

            System.out.print("Ingresa la columna: ");
            int columna = input.nextInt();

            boolean acierto = defensor.recibirDisparo(fila, columna);
            if (acierto) {
                System.out.println("Le pegaste al barco");
            } else {
                System.out.println("Agua.");
            }

            if (defensor.todosLosBarcosHundidos()) {
               System.out.println("Ganó " + atacante.getNombre());
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
