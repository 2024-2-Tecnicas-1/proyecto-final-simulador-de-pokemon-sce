
package simulador.batalla;
public class Zubat extends Pokemon {
    public Zubat(String nombre) {
        super(nombre, 40, 45, TipoPokemon.VOLADOR);
    }

    
    @Override
    public void atacar(Pokemon oponente) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);
        oponente.recibirDaño(daño);
    }
}
