package com.jmc.readonlyprops;

/**
 * Uma classe utilitária para verificar se um número é par.
 */
public class EvenNumUtil {
    /**
     * Verifica se um número é par.
     *
     * @param num O número a ser verificado.
     * @return true se o número for par, false caso contrário.
     */
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
