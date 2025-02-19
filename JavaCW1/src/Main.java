import java.io.File;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        MovieDatabase MovieDatabase = new MovieDatabase("movies.txt");

        MovieDatabase.sortDurationDescending();
        System.out.println(MovieDatabase);

        MovieDatabase.lowestRated("Sci-Fi");

        MovieDatabase.mostRecent("PG", 5);

        MovieDatabase.longestMovieTitle();

        MovieDatabase.oldestNewestMovieDiff();
    }
}