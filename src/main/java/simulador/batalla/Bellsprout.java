
package simulador.batalla;


public class Bellsprout extends Pokemon {
    public Bellsprout(String nombre) {
        super(nombre, 50, 75, TipoPokemon.PLANTA);
    }

    @Override
    public void atacar(Pokemon oponente) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);
        oponente.recibirDaño(daño);
    }
}
