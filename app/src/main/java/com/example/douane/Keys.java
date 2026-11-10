package com.example.douane;

// 1 - a partir mn num carte etudiant 
public class Keys {

    // 2 - e5er 4 nwemer )
    public static final String MATRICULE = "9657";

    // 3 - el asemi
    public static final String NOM = "NOM_VOYAGEUR";
    public static final String NAISSANCE = "ANNEE_NAISSANCE";
    public static final String DESTINATION = "ANNEE_DESTINATION";
    public static final String MOTIF = "MOTIF";
    public static final String VERDICT = "VERDICT";

    public static String build(String matricule, String name) {
        return matricule + "_" + name;
    }
}
