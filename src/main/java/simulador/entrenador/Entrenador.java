package simulador.entrenador;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    private String nombre;
    private List<Pokemon> pokemones;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
    }

    
    public void agregarPokemon(pokemones pokemon) {
        pokemones.add(pokemon);
        System.out.println(pokemon.getNombre() + " ha sido añadido al equipo de " + nombre + ".");
    }

   
    public void entrenarPokemon(int indice) {
        if (indice >= 0 && indice < pokemones.size()) {
            Pokemon pokemon = pokemones.get(indice);
            pokemon.entrenar();
            System.out.println(pokemon.getNombre() + " ha sido entrenado. Nuevas estadísticas: Salud - " + pokemon.getSalud() + ", Ataque - " + pokemon.getPuntosDeAtaque());
        } else {
            System.out.println("Índice inválido. No se puede entrenar el Pokémon.");
        }
    }

   
    public void mostrarPokemones() {
        if (pokemones.isEmpty()) {
            System.out.println(nombre + " no tiene ningún Pokémon en su equipo.");
        } else {
            for (int i = 0; i < pokemones.size(); i++) {
                Pokemon p = pokemones.get(i);
                System.out.println("[" + i + "] " + p.getNombre() + " - Salud: " + p.getSalud() + ", Ataque: " + p.getPuntosDeAtaque() + ", Tipo: " + p.getTipo());
            }
        }
    }

    
    public Pokemon prepararBatalla(int indice) {
        if (indice >= 0 && indice < pokemones.size()) {
            return pokemones.get(indice);
        } else {
            System.out.println("Índice inválido. No se puede seleccionar el Pokémon para la batalla.");
            return null;
        }
    }

    
    public String getNombre() {
        return nombre;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }
}