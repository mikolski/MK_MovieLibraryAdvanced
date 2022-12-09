import java.util.List;

public class MovieLibrary {
    public MovieLibrary() {
    }

    public MovieLibrary(List<Movie> movies) {
        this.movies = movies;
    }

    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void showMoviesTitlesByYear(int startYear, int endYear) {
        boolean moviesFound = false;
        int counter = 1;

        System.out.println("Lista filmów: ");
        for (Movie movie : getMovies()) {
            if (movie.getYear() >= startYear && movie.getYear() <= endYear) {
                System.out.println(counter + ". " + movie.getTitle());
                counter++;
                moviesFound = true;
            }

        }
        if (!moviesFound) {
            System.out.println("! Nie znaleziono żadnych filmów !");
        }

    }

    public void showRandomMovieData() {
        int moviesNumber = getMovies().size();
        int randomMovieIndex = (int) Math.floor(Math.random() * moviesNumber);
        System.out.println(getMovies().get(randomMovieIndex));
    }

    public void showMoviesTitlesByActorName(String name) {
        boolean moviesFound = false;
        int counter = 1;

        System.out.println("Lista filmów: ");
        for (Movie movie : getMovies()) {
            for (Actor actor : movie.getActors()) {

                if (actor.toString().equals(name)) {
                    System.out.println(counter + ". " + movie.getTitle());
                    counter++;
                    moviesFound = true;
                }
            }
        }
        if (!moviesFound) {
            System.out.println("! Nie znaleziono żadnych filmów !");
        }


    }
}
