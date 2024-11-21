
package simulador.batalla;


public class Hitmonlee extends Pokemon {
    public Hitmonlee (String nombre){
    super(nombre, 50, 120, TipoPokemon.LUCHA);
    }
    
    @Override
    public void atacar (Pokemon oponente){
    double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
    int daño = (int) (this.getPuntosDeAtaque()*multiplicador);
    oponente.recibirDaño(daño);
    }
}
