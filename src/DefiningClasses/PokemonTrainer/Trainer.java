package DefiningClasses.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonCollection;
    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemonCollection = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public int getNumberOfPokemon() {
        return pokemonCollection.size();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonCollection.add(pokemon);
    }

    public void checkForElement(String element) {
        boolean hasElement = pokemonCollection.stream().anyMatch(p -> p.getElement().equals(element));
        if (hasElement) {
            badges++;
        } else {
            pokemonCollection.forEach(p -> p.reduceHealth(10));
            pokemonCollection.removeIf(p -> !p.isAlive());
        }
    }
}
