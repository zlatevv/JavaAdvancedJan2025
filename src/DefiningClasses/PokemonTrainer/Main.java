package DefiningClasses.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Tournament")) {
            String[] tokens = command.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).addPokemon(pokemon);

            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        while (!command.equals("End")) {
            String element = command;
            trainers.values().forEach(trainer -> trainer.checkForElement(element));
            command = scanner.nextLine();
        }

        trainers.values()
                .stream()
                .sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .forEach(t -> System.out.println(t.getName() + " " + t.getBadges() + " " + t.getNumberOfPokemon()));
    }
}
