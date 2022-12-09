import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        File file = new File("src/main/resources/movies.json");

        MovieLibrary movieLibrary = objectMapper.readValue(file, MovieLibrary.class);

        System.out.println("1. Podaj dwie daty aby wyświetlić nazwy filmów wydanych pomiędzy tymi datami");
        System.out.println("2. Wyświetl wszystkie informacje o losowym filmie");
        System.out.println("3. Podaj imię i nazwisko aktora aby wyświetlić nazwy filmów w jakich zagrał");

        Scanner sc = new Scanner(System.in);
        String choiceNumber;
        boolean validInput = false;
        while (!validInput) {
            choiceNumber = sc.next();
            switch (choiceNumber) {
                case "1":

                    boolean validYearInput = false;
                    while (!validYearInput) {
                        System.out.println("Podaj datę startową w formacie RRRR : ");

                        String startYear = sc.next();

                        System.out.println("Podaj datę końcową w formacie RRRR : ");
                        String endYear = sc.next();

                        try {
                            movieLibrary.showMoviesTitlesByYear( Integer.parseInt(startYear), Integer.parseInt(endYear));
                            validYearInput = true;
                        } catch (Exception exception) {
                            System.out.println("! Błędna data - wprowadź jeszcze raz obie daty !");
                        }


                    }
                    validInput = true;
                    break;
                case "2":
                    movieLibrary.showRandomMovieData();
                    validInput = true;
                    break;
                case "3":
                    System.out.println("Podaj imię aktora: ");
                    String actorsName = sc.next();
                    System.out.println("Podaj nazwisko aktora: ");
                    String actorsSurname = sc.next();
                    movieLibrary.showMoviesTitlesByActorName(actorsName + " " + actorsSurname);
                    validInput = true;
                    break;
                default:
                    System.out.println("Niepoprawna wartość. Podaj cyfrę 1, 2 lub 3");
            }
        }
        sc.close();
    }

}
