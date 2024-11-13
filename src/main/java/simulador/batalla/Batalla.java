package simulador.batalla;



public class Batalla {
    
    public void iniciarBatalla (Pokemon pokemon1, Pokemon pokemon2){
        System.out.println("¡Empieza la batalla entre "+pokemon1.getNombre()+" y "+pokemon2.getNombre()+"!");
    
        while(pokemon1.getSalud()>0 && pokemon2.getSalud()>0 ){
        ejecutarTurno(pokemon1, pokemon2);
        if(pokemon2.getSalud()>0){
        ejecutarTurno(pokemon2, pokemon1);
        }
        }
        if(pokemon1.getSalud()>0){
            System.out.println(pokemon1.getNombre()+" ha ganado la batalla");
        }
        else{
            System.out.println(pokemon2.getNombre()+ " ha ganado la batalla");
        }
    }
    
    private void ejecutarTurno (Pokemon atacante, Pokemon defensor){
        System.out.println(atacante.getNombre()+" ataca a "+defensor.getNombre());
        
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(atacante.getTipo(), defensor.getTipo());
        int daño = (int)(atacante.getPuntosDeAtaque()*multiplicador);
        
        defensor.recibirDaño(daño);
        
        System.out.println(defensor.getNombre()+" ha recibido "+ daño + " puntos de daño");
        System.out.println("Salud restante: "+defensor.getSalud());
    }
}
