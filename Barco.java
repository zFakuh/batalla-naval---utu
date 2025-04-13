public class Barco {
    int tamaño;
    int impactos;

    public Barco(int tamaño) {
        this.tamaño = tamaño;
        this.impactos = 0;
    }

    public void recibirImpacto() {
        impactos++;
        System.out.println("¡Impacto recibido! Total impactos: " + impactos);
    }

    public boolean estaHundido() {
        return impactos >= tamaño;
    }
}