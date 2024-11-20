
package simulador.batalla;


public class Onix extends Pokemon {
    public Onix(String nombre){
        super(nombre, 35, 45, TipoPokemon.TIERRA);
    }

    
    @Override
    public void atacar(Pokemon oponente) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);
        oponente.recibirDaño(daño);
    }
}

    
   
