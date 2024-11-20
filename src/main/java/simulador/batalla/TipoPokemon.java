package simulador.batalla;


public enum TipoPokemon {
    FUEGO, AGUA, PLANTA, VENENO, ELECTRICO, PSÍQUICO, ROCA, TIERRA, VOLADOR, NORMAL, LUCHA;

    public static double obtenerMultiplicadorDeDaño(TipoPokemon atacante, TipoPokemon defensor) {
        TipoPokemon BICHO = null;
        TipoPokemon HIELO = null;
        TipoPokemon ACERO = null;
        TipoPokemon HADA = null; 
        if (atacante == FUEGO && (defensor == PLANTA || defensor == HIELO || defensor == BICHO)) return 2.0;
        if (atacante == AGUA && (defensor == FUEGO || defensor == ROCA || defensor == TIERRA)) return 2.0;
        if (atacante == PLANTA && (defensor == AGUA || defensor == ROCA || defensor == TIERRA)) return 2.0;
        if (atacante == ELECTRICO && (defensor == AGUA || defensor == VOLADOR)) return 2.0;
        if (atacante == PSÍQUICO && (defensor == VENENO || defensor == LUCHA)) return 2.0;
        if (atacante == ROCA && (defensor == FUEGO || defensor == VOLADOR || defensor == BICHO)) return 2.0;
        if (atacante == TIERRA && (defensor == FUEGO || defensor == ELECTRICO || defensor == ROCA || defensor == VENENO)) return 2.0;
        if (atacante == VOLADOR && (defensor == PLANTA || defensor == LUCHA || defensor == BICHO)) return 2.0;        
        if (atacante == VENENO && (defensor == PLANTA || defensor == HADA)) return 2.0;       
        if (atacante == LUCHA && (defensor == NORMAL || defensor == ROCA || defensor == HIELO || defensor == ACERO)) return 2.0;              
        if (atacante == FUEGO && defensor == AGUA) return 0.5;
        if (atacante == AGUA && defensor == PLANTA) return 0.5;
        if (atacante == PLANTA && defensor == FUEGO) return 0.5;
        if (atacante == ELECTRICO && defensor == TIERRA) return 0.0;
        if (atacante == PSÍQUICO && defensor == PSÍQUICO) return 0.5;
        
        
        return 1.0;
    }
}
