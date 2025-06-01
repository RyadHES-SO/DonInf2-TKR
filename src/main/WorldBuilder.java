package main;

public class WorldBuilder {
    public static Worldmap buildWorld() {
        Worldmap world = new Worldmap(4, 4);

        // Création des lieux
        Location maison = new Location("Maison", "Ta maison, point de départ du voyage.", true);
        Location foret = new Location("Forêt", "Une forêt verte remplie d'oiseaux.", false);
        Location grotte = new Location("Grotte", "Une grotte sombre, semble verrouillée.", false);
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
        Key cleDeLaGrotte = new Key(
        "Clé de la grotte",
        "Une vieille clé rouillée. Elle semble pouvoir ouvrir la grotte.", grotte);


        foret.addItem(cleDeLaGrotte); // On place la clé dans la forêt

        return world;
    }
}