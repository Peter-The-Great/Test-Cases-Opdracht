package org.pjotr;

public class Bank3 {
    public static boolean getToegangVault(boolean isbaas, boolean ismanager, int leeftijd) {
        if(leeftijd >= 18 && leeftijd < 65){
            if(isbaas){
                System.out.println("De baas heeft toegang tot de kluis en kassa");
                return true;
            }else{
                if (ismanager) {
                    if(leeftijd > 18){
                        System.out.println("De manager heeft toegang tot de kluis en kassa");
                        return true;
                    }else{
                        System.out.println("De manager heeft toegang tot de kassa, maar niet de kluis");
                        return false;
                    }
                } else {
                    System.out.println("Klanten krijgen geen toegang tot de kluis of kassa");
                    return false;
                }
            }
        }else{
            System.out.println("Kinderen onder de 16 kunnen niet binnen ons bedrijf komen en zeker niet bij de kluis of kassa");
            return false;
        }
    }
}
