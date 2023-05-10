package org.pjotr;
public class Main {
    /**
     * Main method
     * Hier laat ik een voorbeeld zien van de toegang tot de kluis en kassa check in de bank class
     * @param args
     */
    public static void main(String[] args) {
        Boolean toegang = Bank.getToegangVault(true, false, 9);
        Boolean toegang2 = Bank2.getToegangVault(false, true, 9, 27);
        System.out.println(toegang);
        System.out.println(toegang2);
    }
}