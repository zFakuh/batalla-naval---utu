public class Barco {
    int tamaño;
    int impactos;

    public Barco(int tamaño) {
        this.tamaño = tamaño;
        this.impactos = 0;
    }

    public void recibirImpacto() {
        impactos++;
        System.out.println("Ataque recibido. Total de impactos: " + impactos);
    }

    public boolean estaHundido() {
        return impactos >= tamaño;
    }
}
