package org.pjotr;

public class Bank {
    public static String getToegangVault(boolean iswerknemer, boolean isbaas, boolean ismanager, int jareninDienst) {
        if(isbaas){
            return "De baas heeft toegang tot de kluis en kassa";
        }else{
            if (iswerknemer) {
                if(ismanager && jareninDienst > 8){
                    return "De manager heeft toegang tot de kluis en kassa";
                }else if(ismanager && jareninDienst < 8){
                    return "De manager heeft toegang tot de kassa";
                }else{
                    return "De Werknemer heeft toegang tot de kluis";
                }
            } else {
                return "Klanten krijgen geen toegang tot de kluis of kassa";
            }
        }
    }
}
