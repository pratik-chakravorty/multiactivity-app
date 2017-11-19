package com.pratik.cardviews;

/**
 * Created by Pratik on 11/14/2017.
 * This is the movie data java class for storing the movie data that will be used in the second
 * activity
 */

public class MovieData {
    private MovieInfo darkKnight = new MovieInfo("Action/Thriller","With the help of allies Lt. Jim Gordon (Gary Oldman) and DA Harvey Dent (Aaron Eckhart), Batman (Christian Bale) has been able to keep a tight lid on crime in Gotham City. But when a vile young criminal calling himself the Joker (Heath Ledger) suddenly throws the town into chaos, the caped Crusader begins to tread a fine line between heroism and vigilantism.");

    private MovieInfo yourName = new MovieInfo("Animation/Drama","A teenage boy and girl embark on a quest to meet each other for the first time after they magically swap bodies.As beautifully animated as it is emotionally satisfying, Your Name adds another outstanding chapter to writer-director Makoto Shinkai's filmography.");

    private MovieInfo inception = new MovieInfo("Action/Thriller","Dom Cobb (Leonardo DiCaprio) is a thief with the rare ability to enter people's dreams and steal their secrets from their subconscious. His skill has made him a hot commodity in the world of corporate espionage but has also cost him everything he loves. Cobb gets a chance at redemption when he is offered a seemingly impossible task: Plant an idea in someone's mind. If he succeeds, it will be the perfect crime, but a dangerous enemy anticipates Cobb's every move.");

    private MovieInfo johnwick = new MovieInfo("Action","Legendary assassin John Wick (Keanu Reeves) retired from his violent career after marrying the love of his life. Her sudden death leaves John in deep mourning. When sadistic mobster Iosef Tarasov (Alfie Allen) and his thugs steal John's prized car and kill the puppy that was a last gift from his wife, John unleashes the remorseless killing machine within and seeks vengeance. Meanwhile, Iosef's father (Michael Nyqvist) -- John's former colleague -- puts a huge bounty on John's head.");

    private MovieInfo avengers = new MovieInfo("Action/Superhero","When Thor's evil brother, Loki (Tom Hiddleston), gains access to the unlimited power of the energy cube called the Tesseract, Nick Fury (Samuel L. Jackson), director of S.H.I.E.L.D., initiates a superhero recruitment effort to defeat the unprecedented threat to Earth. Joining Fury's \"dream team\" are Iron Man (Robert Downey Jr.), Captain America (Chris Evans), the Hulk (Mark Ruffalo), Thor (Chris Hemsworth), the Black Widow (Scarlett Johansson) and Hawkeye (Jeremy Renner).");

    private MovieInfo starwars = new MovieInfo("Action/Adventure","Thirty years after the defeat of the Galactic Empire, the galaxy faces a new threat from the evil Kylo Ren (Adam Driver) and the First Order. When a defector named Finn (John Boyega) crash-lands on a desert planet, he meets Rey (Daisy Ridley), a tough scavenger whose droid contains a top-secret map. Together, the young duo joins forces with Han Solo (Harrison Ford) to make sure the Resistance receives the intelligence concerning the whereabouts of Luke Skywalker (Mark Hamill), the last of the Jedi Knights.");

    public MovieInfo getInception() {
        return inception;
    }

    public MovieInfo getJohnwick() {
        return johnwick;
    }

    public MovieInfo getAvengers() {
        return avengers;
    }

    public MovieInfo getStarwars() {
        return starwars;
    }

    public MovieInfo getDarkKnight() {
        return darkKnight;
    }

    public MovieInfo getYourName() {
        return yourName;
    }
}
