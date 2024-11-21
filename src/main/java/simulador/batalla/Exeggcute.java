
package simulador.batalla;

    public class Exeggcute extends Pokemon {
    public Exeggcute(String nombre) {
        super(nombre, 60, 40, TipoPokemon.PLANTA);
    }

    @Override
    public void atacar(Pokemon oponente) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);
        oponente.recibirDaño(daño);
    }
}


