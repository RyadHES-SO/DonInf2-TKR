

public class WorldBuilder {
    public static Worldmap buildWorld() {
        Worldmap world = new Worldmap(3, 4);

        // Création des lieux
        Location maison = new Location("Maison", "Ta maison, point de départ du voyage.", true);
        Location foret = new Location("Forêt", "Une forêt verte remplie d'oiseaux.", false);
        Location grotte = new Location("Grotte", "Une grotte sombre, semble verrouillée.", true);
        Location lac = new Location("Lac", "Un lac paisible entouré de roseaux.", false);
        Location montagne = new Location("Montagne", "Une montagne abrupte au sommet enneigé.", false);

        // Placement dans la carte
        world.addLocation(maison, 1, 1);      // centre
        world.addLocation(foret, 1, 2);       // est
        world.addLocation(grotte, 0, 1);      // nord
        world.addLocation(lac, 2, 1);         // sud
        world.addLocation(montagne, 1, 0);    // ouest

        // Position de départ du joueur
        world.setPlayerLocation(1, 1);

        // Création des clés pour les zones verrouillées
        // Création des clés
         // Création des clés
         Key cleForet = new Key("Clé de la forêt", "Une clé avec une feuille gravée, elle semble déverrouiller un lieu naturel.", foret);
         Key cleGrotte = new Key("Clé de la grotte", "Une vieille clé rouillée. Elle semble pouvoir ouvrir la grotte.", grotte);
         Key cleLac = new Key("Clé du lac", "Une clé ornée de vagues, parfaite pour une zone aquatique.", lac);
         Key cleMontagne = new Key("Clé de la montagne", "Une clé lourde et solide, comme taillée dans la roche.", montagne);
 
         // Placement des clés dans les lieux accessibles
         maison.addItem(cleForet);       // Clé pour la forêt
         foret.addItem(cleGrotte);       // Clé pour la grotte
         grotte.addItem(cleLac);         // Clé pour le lac
         lac.addItem(cleMontagne);       // Clé pour la montagne

        
 
        

        return world;
    }
}