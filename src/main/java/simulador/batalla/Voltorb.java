
package simulador.batalla;


public class Voltorb extends Pokemon {
    public Voltorb (String nombre){
    super(nombre, 40, 30, TipoPokemon.ELECTRICO);
    }
    
    @Override
    public void atacar (Pokemon oponente){
    double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
    int daño = (int) (this.getPuntosDeAtaque()*multiplicador);
    oponente.recibirDaño(daño);
    }
}


