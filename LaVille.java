
package ja01_trouvelaville;

import java.awt.Color;
import java.util.*;

public class LaVille {
    private final int numeroDeLaPlaque;
    private Color imageEnCouleur;
    private final String nomDeLaVille;
    private int laPopulation;  //La population d'une population pouvant varier en fonction du temps on le declare pas "final"
    private final String laPositionGeographique;
    private final String leNomDunLieuSymbolique;
    private final int laDistanceVilleCapitale;
    
    public LaVille(int numeroDeLaPlaque,Color imageEnCouleur, String nomDeLaVille, int laPopulation, String laPositionGeographique, String leNomDunLieuSymbolique, int laDistanceVilleCapitale ){
        this.numeroDeLaPlaque = numeroDeLaPlaque;
        this.imageEnCouleur = imageEnCouleur;
        this.nomDeLaVille = nomDeLaVille;
        this.laPopulation = laPopulation;
        this.laPositionGeographique = laPositionGeographique;
        this.leNomDunLieuSymbolique = leNomDunLieuSymbolique;
        this.laDistanceVilleCapitale = laDistanceVilleCapitale;
    }
    
    public void setLapopulation(int laPopulation){
        this.laPopulation = laPopulation;
    }
    public int getLaPopulation(){
        return this.laPopulation;
    }
    
    public int getNumeroDeLaPlaque(){
        return this.numeroDeLaPlaque;
    }
    public Color getImageEnCouleur(){
        return this.imageEnCouleur;
    }
   
    public String getNomDeLaVille(){
        return this.nomDeLaVille;
    }
    public String getLaPositionGeographique(){
        return this.laPositionGeographique;
    }
    public String getLeNomDunLieuSymbolique(){
        return this.leNomDunLieuSymbolique;
    }
    public int getLaDistanceVilleCapitale(){
        return this.laDistanceVilleCapitale;
    }
    
    @Override
    public String toString(){
        return "Nom: "+ this.getNomDeLaVille()+"  >>>>>  "+"Numero De La Plaque: "+ this.getNumeroDeLaPlaque()+"  >>>>>  "+"La Population : "+ this.getLaPopulation()+
        "  >>>>>  "+"La Position Geographique: "+ this.getLaPositionGeographique()+"  >>>>>  "+"Le Nom D'un Lieu Symbolique: "+ this.getLeNomDunLieuSymbolique()+
        " Merkezi"+"  >>>>>  "+"La Distance entre "+this.getNomDeLaVille()+" et La Capitale: "+ this.getLaDistanceVilleCapitale()+" KM.";
    }
    
        
}
