
package ja01_trouvelaville;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;
import java.util.Scanner;
 
public class JA01_TrouveLaVille extends JFrame implements ActionListener{

    
    private JButton jbt1,jbt2;
    private JLabel jl1,jl2,jl3,jl4,jl5;
    private JTextField jtf1,jtf2,jtf3;
    
    private JLabel imageLabel = new JLabel();
    
    
    LaVille laVille;//utilise dans actionPerformed() 
    
  
    
    public JA01_TrouveLaVille(){
        this.setTitle("OZEL PENCERE");
        this.setSize(800, 620);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        jl1 = new JLabel("***********************MOTEUR DE RECHERCHE PRIVE***********************");
        jl1.setBounds((int)(this.getWidth()/2)-200,30,(int)(this.getWidth()/2)+300,30);
        this.add(jl1);
        
        jl2 = new JLabel("---Cliquez Sur Le 'Button1' Pour Effectuer La Recherche Avec Le Numero D'une Plaque Et Le 'Button2' Avec Le Nom De La Ville---");
        jl2.setBounds((int)(this.getWidth()/2)-380,80,(int)(this.getWidth()/2)+350,30);
        this.add(jl2);
        
        jl3 = new JLabel("RECHERCHE AVEC LE NUMERO DE LA PLAQUE");
        jl3.setBounds((int)(this.getWidth()/2)-250,140,300,30);
        this.add(jl3);
        jl4 = new JLabel("RECHERCHE AVEC LE NOM DE LA VİLLE");
        jl4.setBounds((int)(this.getWidth()/2)+50,140,300,30);
        this.add(jl4);
        
        jtf1 = new JTextField();
        jtf1.setBounds((int)(this.getWidth()/2)-250,180,200,30);
        this.add(jtf1);
        jtf2 = new JTextField();
        jtf2.setBounds((int)(this.getWidth()/2)+50,180,200,30);
        this.add(jtf2);
        
        jbt1 = new JButton("Button1");
        jbt1.setBounds((int)(this.getWidth()/2)-250,220,150,40);
        jbt1.addActionListener(this);
        this.add(jbt1);
        jbt2 = new JButton("Button2");
        jbt2.setBounds((int)(this.getWidth()/2)+50,220,150,40);
        jbt2.addActionListener(this);
        this.add(jbt2);
        
        jl5 = new JLabel("---------------------------LE RESULTAT DE LA RECHERCHE---------------------------");
        jl5.setBounds((int)(this.getWidth()/4),(int)(this.getHeight()/2)+20,(int)(this.getWidth()/2)+50,40);
        this.add(jl5);
        
        jtf3 = new JTextField();
        jtf3.setBounds((int)(this.getWidth()/4),(int)(this.getHeight()/2)+80,(int)(this.getWidth()/2),(int)(this.getHeight()/4));
        this.add(jtf3);
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        int searchByNum ;
        String searchByString ;
        
        if(actionEvent.getSource().equals(jbt1)){
            searchByNum = Integer.valueOf(jtf1.getText());
            for(int i = 0; i<listPlaqueNum.size() ; i++){
                if(listPlaqueNum.get(i) == searchByNum){
                        this.laVille = new LaVille(listPlaqueNum.get(i),listCouleurs.get(i),listNomDesVille.get(i),listPopulations.get(i),listPositionGeographique.get(i),listUnLieuPopulaire.get(i),listDistanceVilleCapitale.get(i));
                        jtf3.setBackground(laVille.getImageEnCouleur());
                }
            }
        }
        if(actionEvent.getSource().equals(jbt2)){
            searchByString = String.valueOf(jtf2.getText());
            if(searchByString == "NULL"){
                jtf3.setText("Veuillez Verifier Votre Recherche!!!");
            }
            else{
                for(int i = 0; i<listNomDesVille.size() ; i++){
                    if(searchByString.equals(listNomDesVille.get(i))){
                        this.laVille = new LaVille(listPlaqueNum.get(i),listCouleurs.get(i),listNomDesVille.get(i),listPopulations.get(i),listPositionGeographique.get(i),listUnLieuPopulaire.get(i),listDistanceVilleCapitale.get(i));
                        jtf3.setBackground(laVille.getImageEnCouleur());
                    }
                }
            }
            
        }
            
        
        
        if(laVille == null){
            jtf3.setText("AUCUN RESULTAT DISPONIBLE A VOTRE RECHERCHE!!!");
        }
        else{
            jtf3.setText(laVille.toString());
        }
       
    }
    
    
    //Global Variables
    static Random rand = new Random();//Pour generer un nombre aleatoire
    static Scanner input = new Scanner(System.in);
    static final String[] nomDesVilles = {"Adana","Adıyaman","Afyonkarahisar","Ağrı","Amasya","Ankara","Antalya","Artvin","Aydın","Balıkesir","Bilecik","Bingöl",
                "Bitlis","Bolu","Burdur","Bursa","Çanakkale","Çankırı","Çorum","Denizli","Diyarbakır","Edirne","Elâzığ","Erzincan","Erzurum","Eskişehir","Gaziantep",
                "Giresun","Hakkari","Hatay","Isparta","Mersin","İzmir","İstanbul","Kars","Kastamonu","Kayseri","Kırklareli","Kırşehir","Kocaeli","Konya","Kütahya",
                "Malatya","Manisa","Kahramanmaraş","Mardin","Muğla","Muş","Nevşehir","Niğde","Ordu","Rize","Sakarya","Samsun","Siirt","Sinop","Sivas","Tekirdağ",
                "Tokat","Trabzon","Tunceli","Şanlıurfa","Uşak","Van","Yozgat","Zonguldak","Aksaray","Bayburt","Karaman","Kırıkkale","Batman","Şırnak","Bartın",
                "Ardahan","Iğdır","Yalova","Karabük","Kilis","Osmaniye","Düzce","Bane"};
    static final String[] nomDunLieuSymbolique = nomDesVilles;//Le d'un lieu symbolique soit egalement le nom de la ville 
    static int[] numDesPlaques = new int[81];//Varie entre 01-81
    static int[] populations = new int[81];//Des valeurs aleatoires
    static String[] positionGeographique = new String[81];
    static int[] distanceVilleCapitale = new int[81];
    static Color[] imageEnCouleurs = new Color[81];
    
    static Color[] couleurs = {Color.BLUE,Color.CYAN,Color.DARK_GRAY,Color.GRAY,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.YELLOW};
    
    
    static ArrayList<String> listNomDesVille = new ArrayList<String>();
    static ArrayList<String> listUnLieuPopulaire = new ArrayList<String>();
    static ArrayList<String> listPositionGeographique = new ArrayList<String>();
    static ArrayList<Integer> listDistanceVilleCapitale = new ArrayList<Integer>();
    static ArrayList<Integer> listPopulations = new ArrayList<Integer>();
    static ArrayList<Integer> listPlaqueNum = new ArrayList<Integer>();
    static ArrayList<Color> listCouleurs = new ArrayList<Color>();
    
    
        
    
    public static void main(String[] args) {
        
        final String[] positions = {"NORD","SUD","EST","OUEST","CENTRE"};
        for(int i = 0;i<81;i++){
            numDesPlaques[i] = i+1;
            populations[i] = (int)(Math.random()*1000000+10000);//Produit une valeur a partir de 10000
            positionGeographique[i] = positions[rand.nextInt(5)];//La méthode nextInt() de la classe Random permet de générer un entier aléatoire compris entre 0 inclus et l'entier passé en paramètre exclus.
            distanceVilleCapitale[i] = 800 + rand.nextInt(10001);//Genere un nombre aleatoire entre 800 et 10000
            imageEnCouleurs[i] = couleurs[rand.nextInt(couleurs.length)];
            //imageEnCouleurs[i] = couleurs[rand.nextInt(8)];
        }
        for(int i = 0 ;i<81 ; i++){
            listNomDesVille.add(nomDesVilles[i]);
            listUnLieuPopulaire.add(nomDunLieuSymbolique[i]);
            listDistanceVilleCapitale.add(distanceVilleCapitale[i]);
            listPopulations.add(populations[i]);
            listPlaqueNum.add(numDesPlaques[i]);
            listPositionGeographique.add(positionGeographique[i]);
            listCouleurs.add(imageEnCouleurs[i]);
        }
        
        String addVille;
        int nombreDeVille;
        int ouiNon;
        boolean reponse = true;
        while(reponse){
            System.out.print("VOULEZ-VOUS AJOUTER UNE(DES) VILLE(S)? Tapez 1 si 'Oui' et 0 si 'Non': ");

            ouiNon = input.nextInt();
            if(ouiNon == 0){
                System.out.println("Veuillez Passez A La Fenetre Ouverte!!!");
                reponse = false;
                break;
            }
            else{//if true
                System.out.print("COMBIEN DE VILLE VOULEZ-VOUS AJOUTER?: ");
                nombreDeVille = input.nextInt();
                for(int i = 0; i<nombreDeVille ; i++ ){
                    addVille = input.next();
                    listNomDesVille.add(addVille);
                    listUnLieuPopulaire.add(addVille);
                    listDistanceVilleCapitale.add(800 + rand.nextInt(10001));
                    listPopulations.add((int)(Math.random()*1000000+10000));
                    listPlaqueNum.add(82+i);
                    listPositionGeographique.add(positions[rand.nextInt(5)]);
                    listCouleurs.add(couleurs[rand.nextInt(couleurs.length)]);
                }
            }
            
        }
        
      
        JA01_TrouveLaVille newFenetre = new JA01_TrouveLaVille();

       
    }
    
}
 /*String imgUrl="téléchargement (1).jpg";
ImageIcon icone = new ImageIcon(imgUrl);
 //Création de JLable avec un alignement gauche
JLabel jlabel = new JLabel(icone, JLabel.CENTER);
jlabel = new JLabel(icone, JLabel.CENTER);
newFenetre.getContentPane().add(jlabel);
newFenetre.validate();
*/
/*for(int i = 0; i<81 ; i++){
    if(searchByString.equals(nomDesVilles[i])){
        this.laVille = new LaVille(numDesPlaques[i],imageEnCouleurs[i],nomDesVilles[i],populations[i],positionGeographique[i],nomDunLieuSymbolique[i],distanceVilleCapitale[i]);
    }
}*/
        
