package org.pjotr;
public class Main {
    /**
     * Main method
     * Hier laat ik een voorbeeld zien van de toegang tot de kluis en kassa check in de bank class
     * @param args
     */
    public static void main(String[] args) {
        Boolean toegang = Bank.getToegangVault(true, false, true, 9);
        System.out.println(toegang);
    }
}