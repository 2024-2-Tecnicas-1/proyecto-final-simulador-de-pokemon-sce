
package simulador.batalla;


public class Tentacool extends Pokemon {
    public Tentacool(String nombre) {
        super(nombre, 40, 40, TipoPokemon.AGUA);
    }

    
    @Override
    public void atacar(Pokemon oponente) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);
        oponente.recibirDaño(daño);
    }
}

