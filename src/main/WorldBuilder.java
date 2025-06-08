
public class WorldBuilder {
    public static Worldmap buildWorld() {
        Worldmap world = new Worldmap(3, 4);

        // Création des lieux
        Location home = new Location("Home", "Your home, the starting point of the journey.", true);
        Location forest = new Location("Forest", "A green forest full of birds.", false);
        Location cave = new Location("Cave", "An endless sea of sand under a burning sky.", false);
        Location desert = new Location("Desert", "A mysterious dark cave", false);
        Location abandonedVillage = new Location("Abandoned Village",
                "Silent houses and empty streets, haunted by memories.", true);
        Location swamp = new Location("Swamp", "A murky swamp where danger lurks beneath the surface.", false);
        Location lake = new Location("Lake", "A peaceful lake surrounded by reeds.", false);
        Location volcano = new Location("Volcano", "A fiery peak with lava flowing through cracks in the earth", false);
        Location etherealGarden = new Location("Ethereal Garden",
                "A surreal, floating garden where time seems to slow down.", false);
        Location ancientRuins = new Location("Ancient Ruins", "Crumbling remains of a civilization long gone.", false);
        Location mountain = new Location("Mountain", "A towering mountain that pierces the clouds", true);
        Location watchtower = new Location("Watchtower", "A tall stone structure watching over the land.", false);

        // Placement dans la carte
        world.addLocation(home, 0, 0);
        world.addLocation(forest, 0, 1);
        world.addLocation(cave, 0, 2);
        world.addLocation(desert, 0, 3);
        world.addLocation(abandonedVillage, 1, 0);
        world.addLocation(swamp, 1, 1);
        world.addLocation(lake, 1, 2);
        world.addLocation(volcano, 1, 3);
        world.addLocation(etherealGarden, 2, 0);
        world.addLocation(ancientRuins, 2, 1);
        world.addLocation(mountain, 2, 2);
        world.addLocation(watchtower, 2, 3);

        // Position de départ du joueur
        world.setPlayerLocation(0, 0);

        // Création des clés
        Key forestKey = new Key("Forest Key", "A key with an engraved leaf, it seems to unlock a natural place.",
                forest);
        Key caveKey = new Key("Cave Key", "An old rusty key. It seems to be able to open the cave.",
                cave);
        Key lakeKey = new Key("Lake Key", "A key decorated with waves, perfect for an aquatic area.", lake);
        Key watchTowerKey = new Key("WatchTower Key", "A long, silver key with a spiral motif pointing skyward.",
                watchtower);
        Key ancientRuinsKey = new Key("Ancient Ruins Key", "A chipped stone key, with ancient glyphs etched onto it.",
                ancientRuins);
        Key swampKey = new Key("Swamp Key", "A moss-covered key, with a faint odor of decay", swamp);
        Key desertKey = new Key("Desert Key", "A sun-warmed bronze key, dry and rough to the touch.", desert);
        Key volcanoKey = new Key("Volcano Key", "Hot to the touch, this key glows faintly like molten rock.", volcano);

        // création des énigmes
        Riddle forestRiddle = new Riddle(
                "Rooted and vast, I dance with the breeze. My leaves whisper stories, though I speak no words. What am I?",
                "Tree");
        Riddle caveRiddle = new Riddle(
                "I repeat what you say, Then I fade away. What am I?",
                "Echo");
        Riddle lakeRiddle = new Riddle(
                "I show your face but have no eyes. I am calm or sometimes move. What am I?",
                "Water");
        Riddle watchTowerRiddle = new Riddle(
                "I stand tall, so you can see far. From my top, the world looks small. What am I?",
                "Hill");
        Riddle ancientRuinsRiddle = new Riddle(
                "Once grand and strong, now weathered by time. I hold the tales of knights and kings. What am I??",
                "Castle");
        Riddle swampRiddle = new Riddle(
                "Still water covered with plants, home to creatures you don’t see. What am I?",
                "Marsh");
        Riddle desertRiddle = new Riddle(
                "Endless sands roll beneath the sun. Nights grow cold where no rivers run. What am I?",
                "Dune");
        Riddle volcanoRiddle = new Riddle(
                "I flow but am not water, born from fire, I shape the land.",
                "Lava");

        // création des lettres avec les énigmes dedans
        Letter forestLetter = new Letter(
                "Forest Letter",
                "An old piece of paper with something written on it.", forestRiddle, forestKey);
        Letter caveLetter = new Letter(
                "Cave Letter",
                "A dusty parchment, the writing nearly faded.",
                caveRiddle, caveKey);
        Letter lakeLetter = new Letter(
                "Lake Letter",
                "A damp note with delicate ink strokes.",
                lakeRiddle, lakeKey);
        Letter watchTowerLetter = new Letter(
                "WatchTower Letter",
                "A scroll sealed with a symbol of vision.",
                watchTowerRiddle, watchTowerKey);
        Letter ancientRuinsLetter = new Letter(
                "Ancient Ruins Letter",
                "A brittle document from a forgotten era.",
                ancientRuinsRiddle, ancientRuinsKey);
        Letter swampLetter = new Letter(
                "Swamp Letter",
                "A soggy letter, its scent earthy and old.",
                swampRiddle, swampKey);
        Letter desertLetter = new Letter(
                "Desert Letter",
                "A sand-stained letter, warm to the touch.",
                desertRiddle, desertKey);
        Letter volcanoLetter = new Letter(
                "Volcano Letter",
                "A scorched letter, edges blackened by heat.",
                volcanoRiddle, volcanoKey);

        // Placement des lettres dans chaque location
        home.addItem(forestLetter);
        forest.addItem(caveLetter);
        cave.addItem(lakeLetter);
        desert.addItem(watchTowerLetter);
        swamp.addItem(ancientRuinsLetter);
        lake.addItem(swampLetter);
        ancientRuins.addItem(desertLetter);
        mountain.addItem(volcanoLetter);

        return world;
    }
}