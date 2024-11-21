package simulador.batalla;

import javax.swing.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
         Entrenador entrenador1 = new Entrenador("Ash");
        Entrenador entrenador2 = new Entrenador("Gary");

        Pokemon growlithe = new Growlithe("Growlithe");
        Pokemon psyduck = new Psyduck("Psyduck");
        Pokemon bellsprout = new Bellsprout("Bellsprout");
        Pokemon voltorb = new Voltorb("Voltorb");
        Pokemon exeggcute = new Exeggcute("Exeggcute");
        Pokemon onix = new Onix("Onix");
        Pokemon zubat = new Zubat("Zubat");
        Pokemon farfetchd = new Farfetchd("Farfetch'd");
        Pokemon hitmonlee = new Hitmonlee("Hitmonlee");
        Pokemon tentacool = new Tentacool("Tentacool");

        String[] opciones = {"Gestionar Entrenador 1 (Ash)", "Gestionar Entrenador 2 (Gary)", "Iniciar Batalla", "Salir"};
        int opcion = -1;

        while (opcion != 3) {
            opcion = JOptionPane.showOptionDialog(null,
                    "Menú Principal", 
                    "Selecciona una opción", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    gestionarEntrenador(entrenador1, growlithe, psyduck, bellsprout, voltorb, tentacool);
                    break;
                case 1:
                    gestionarEntrenador(entrenador2, exeggcute, onix, zubat, farfetchd,hitmonlee);
                    break;
                case 2:
                    iniciarBatalla(entrenador1, entrenador2);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "¡Saliendo del simulador!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, intenta nuevamente.");
            }
        }
    }

    private static void gestionarEntrenador(Entrenador entrenador, Pokemon... pokemonesDisponibles) {
        String[] opciones = {"Agregar Pokémon al equipo", "Entrenar un Pokémon", "Mostrar Pokémones actuales", "Volver al menú principal"};
        int opcion = -1;

        while (opcion != 3) {
            opcion = JOptionPane.showOptionDialog(null,
                    "Gestionar " + entrenador.getNombre(), 
                    "Selecciona una opción", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    agregarPokemon(entrenador, pokemonesDisponibles);
                    break;
                case 1:
                    entrenarPokemon(entrenador);
                    break;
                case 2:
                    mostrarPokemones(entrenador);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private static void agregarPokemon(Entrenador entrenador, Pokemon[] pokemonesDisponibles) {
        String[] pokemonNombres = new String[pokemonesDisponibles.length];
        for (int i = 0; i < pokemonesDisponibles.length; i++) {
            pokemonNombres[i] = pokemonesDisponibles[i].getNombre();
        }

        String seleccion = (String) JOptionPane.showInputDialog(
                null, 
                "Selecciona un Pokémon para agregar:", 
                "Agregar Pokémon", 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                pokemonNombres, 
                pokemonNombres[0]);

        if (seleccion != null) {
            for (Pokemon pokemon : pokemonesDisponibles) {
                if (pokemon.getNombre().equals(seleccion)) {
                    entrenador.agregarPokemon(pokemon);
                    JOptionPane.showMessageDialog(null, pokemon.getNombre() + " ha sido agregado a tu equipo.");
                    break;
                }
            }
        }
    }

    private static void entrenarPokemon(Entrenador entrenador) {
        ArrayList<Pokemon> pokemones = (ArrayList<Pokemon>) entrenador.getPokemones();
        if (pokemones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tienes Pokémones en tu equipo.");
            return;
        }

        String[] pokemonNombres = new String[pokemones.size()];
        for (int i = 0; i < pokemones.size(); i++) {
            pokemonNombres[i] = pokemones.get(i).getNombre();
        }

        String seleccion = (String) JOptionPane.showInputDialog(
                null, 
                "Selecciona el Pokémon que deseas entrenar:", 
                "Entrenar Pokémon", 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                pokemonNombres, 
                pokemonNombres[0]);

        if (seleccion != null) {
            for (int i = 0; i < pokemones.size(); i++) {
                if (pokemones.get(i).getNombre().equals(seleccion)) {
                    entrenador.entrenarPokemon(i);
                    JOptionPane.showMessageDialog(null, "¡" + seleccion + " ha sido entrenado!");
                    break;
                }
            }
        }
    }

    private static void mostrarPokemones(Entrenador entrenador) {
        ArrayList<Pokemon> pokemones = (ArrayList<Pokemon>) entrenador.getPokemones();
        if (pokemones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tienes Pokémones en tu equipo.");
        } else {
            StringBuilder listaPokemones = new StringBuilder("Pokémones actuales:\n");
            for (Pokemon pokemon : pokemones) {
                listaPokemones.append(pokemon.getNombre()).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaPokemones.toString());
        }
    }

    private static void iniciarBatalla(Entrenador entrenador1, Entrenador entrenador2) {
        ArrayList<Pokemon> pokemones1 = (ArrayList<Pokemon>) entrenador1.getPokemones();
        ArrayList<Pokemon> pokemones2 = (ArrayList<Pokemon>) entrenador2.getPokemones();

        if (pokemones1.isEmpty() || pokemones2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ambos entrenadores deben tener al menos un Pokémon.");
            return;
        }

        String[] pokemonNombres1 = new String[pokemones1.size()];
        for (int i = 0; i < pokemones1.size(); i++) {
            pokemonNombres1[i] = pokemones1.get(i).getNombre();
        }

        String[] pokemonNombres2 = new String[pokemones2.size()];
        for (int i = 0; i < pokemones2.size(); i++) {
            pokemonNombres2[i] = pokemones2.get(i).getNombre();
        }

        String seleccion1 = (String) JOptionPane.showInputDialog(
                null, 
                "Selecciona el Pokémon de " + entrenador1.getNombre() + " para la batalla:", 
                "Batalla Pokémon", 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                pokemonNombres1, 
                pokemonNombres1[0]);

        String seleccion2 = (String) JOptionPane.showInputDialog(
                null, 
                "Selecciona el Pokémon de " + entrenador2.getNombre() + " para la batalla:", 
                "Batalla Pokémon", 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                pokemonNombres2, 
                pokemonNombres2[0]);

        if (seleccion1 != null && seleccion2 != null) {
            Pokemon pokemon1 = null;
            Pokemon pokemon2 = null;

            for (Pokemon pokemon : pokemones1) {
                if (pokemon.getNombre().equals(seleccion1)) {
                    pokemon1 = pokemon;
                    break;
                }
            }

            for (Pokemon pokemon : pokemones2) {
                if (pokemon.getNombre().equals(seleccion2)) {
                    pokemon2 = pokemon;
                    break;
                }
            }

            if (pokemon1 != null && pokemon2 != null) {
                Batalla batalla = new Batalla();
                batalla.iniciarBatalla(pokemon1, pokemon2);
            }
        }
    }
}

 

