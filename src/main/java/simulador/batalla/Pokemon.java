
package simulador.batalla;

public abstract class Pokemon {
    private String nombre;
    private int salud;
    private int puntosDeAtaque;
    private TipoPokemon tipo;
    private String estado;

    public Pokemon(String nombre, int salud, int puntosDeAtaque, TipoPokemon tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = "Normal";
    }

    public abstract void atacar(Pokemon oponente);

    public void recibirDaño(int daño) {
        this.salud -= daño;
        if (this.salud <= 0) {
            this.salud = 0;
            this.estado = "Debilitado";
        }
    }

    public void entrenar() {
        this.puntosDeAtaque += 5;
        this.salud += 5;
    }

    
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getPuntosDeAtaque() { return puntosDeAtaque; }
    public TipoPokemon getTipo() { return tipo; }
}
