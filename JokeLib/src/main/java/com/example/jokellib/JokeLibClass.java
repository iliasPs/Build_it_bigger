package com.example.jokellib;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JokeLibClass {

    private static List<String> jokeList = Arrays.asList(
            "What do you call a fish without eyes? Fsh.",
            "What do you call an alligator detective? An investi-gator.",
            "Why did the scarecrow win an award? Because he was outstanding in his field. ",
            "There are two muffins baking in the oven. One muffin says to the other, 'Phew, is it getting hot in here or is it just me?' The other muffin says, 'AAAAHHH!! A TALKING MUFFIN!'",
            "What lights up a soccer stadium? A soccer match.",
            "Why shouldn’t you write with a broken pencil? Because it’s pointless.",
            "What’s the difference between the bird flu and the swine flu? One requires tweetment and the other an oinkment.",
            "If athletes get athlete’s foot, what do elves get? Mistle-toes. ",
            "What’s brown and sticky? A stick."
    );

    private JokeLibClass() {
    }

    public static String generateJoke() {
        int randomNumber = new Random().nextInt(jokeList.size());
        return jokeList.get(randomNumber);
    }
}
