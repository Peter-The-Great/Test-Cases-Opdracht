package org.pjotr;

public class Bank {
    public static boolean getToegangVault(boolean isbaas, boolean ismanager, int jareninDienst) {
        if(isbaas){
            System.out.println("De baas heeft toegang tot de kluis en kassa");
            return true;
        }else{
            if (ismanager) {
                if(jareninDienst > 8){
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
    }
}
