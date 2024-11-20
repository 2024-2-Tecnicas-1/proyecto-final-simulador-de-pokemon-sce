
package simulador.batalla;

public class Psyduck extends Pokemon{
    public Psyduck(String nombre) {
        super(nombre, 50, 52, TipoPokemon.AGUA);
    }

  
    @Override
    public void atacar(Pokemon oponente) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);
        oponente.recibirDaño(daño);
    }
}

 
