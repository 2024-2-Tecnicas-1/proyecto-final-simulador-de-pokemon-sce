
package simulador.batalla;


public class Growlithe extends Pokemon {
     public Growlithe(String nombre) {
        super(nombre, 55, 70, TipoPokemon.FUEGO);
    }

    
     @Override
    public void atacar(Pokemon oponente) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);
        oponente.recibirDaño(daño);
    }
}
    

