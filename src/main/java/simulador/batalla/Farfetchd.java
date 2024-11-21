
package simulador.batalla;

public class Farfetchd extends Pokemon {

    public Farfetchd(String nombre) {
        super(nombre, 52, 90, TipoPokemon.NORMAL);
    }

    @Override
    public void atacar(Pokemon oponente) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);
        oponente.recibirDaño(daño);
    }
}
