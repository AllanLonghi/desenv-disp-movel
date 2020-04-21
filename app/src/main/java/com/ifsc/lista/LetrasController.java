package com.ifsc.lista;

import java.util.HashMap;

public class LetrasController {

    public final Letra[] LETRAS = {A, B, C};
    public final HashMap<String, Letra> LETRAS_MAP = new HashMap<>();

    public LetrasController() {
        for (Letra letra : LETRAS) {
            LETRAS_MAP.put(String.valueOf(letra.getId()), letra);
        }
    }

    public static final Letra A = new Letra("A", "Letra A", "Primeira letra do alfabeto romano", 1);
    public static final Letra B = new Letra("B", "Letra B", "Segunda letra do alfabeto romano", 2);
    public static final Letra C = new Letra("C", "Letra C", "Terceira letra do alfabeto romano", 3);
}
