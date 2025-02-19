import java.io.IOException;

public class MovieDatabaseTest
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
        Test8();
        Test9();
    }

    public static void Test1() throws IOException
    {
        System.out.println("Test 1\n");
        MovieDatabase movieDatabase = new MovieDatabase("movies.txt");
        System.out.println("Expected to print all movies, unordered");
        System.out.println(movieDatabase);
        System.out.println("Constructor success; ToString success");
    }

    public static void Test2() throws IOException
    {
        System.out.println("Test 2\n");
        MovieDatabase movieDatabase = new MovieDatabase("movies.txt");
        movieDatabase.lowestRated("Action");
        System.out.println("lowest rated: success");
    }

    public static void Test3() throws IOException
    {
        System.out.println("Test 3\n");
        MovieDatabase movieDatabase = new MovieDatabase("movies.txt");
        movieDatabase.mostRecent("NOT RATED", 1);
        System.out.println("most recent: success");
    }

    public static void Test4() throws IOException
    {
        System.out.println("Test 4\n");
        MovieDatabase movieDatabase = new MovieDatabase("movies.txt");
        movieDatabase.oldest();
        movieDatabase.newest();
        movieDatabase.oldestNewestMovieDiff();
        System.out.println("oldest: success; newest: success; OldestNewestDiff: success");
    }

    public static void Test5() throws IOException
    {
        System.out.println("Test 5\n");
        MovieDatabase movieDatabase = new MovieDatabase("movies.txt");
        movieDatabase.longestMovieTitle();
        movieDatabase.shortestMovieTitle();
        System.out.println("longest title: success; shortest title: success");
    }

    public static void Test6() throws IOException
    {
        System.out.println("Test 6\n");
        MovieDatabase movieDatabase = new MovieDatabase("movies.txt");
        movieDatabase.sortDurationAscending();
        System.out.println(movieDatabase);
        movieDatabase.sortDurationDescending();
        System.out.println(movieDatabase);
        System.out.println("Durations sort: success");
    }

    public static void Test7() throws IOException
    {
        System.out.println("Test 7\n");
        MovieDatabase movieDatabase = new MovieDatabase("movies.txt");
        movieDatabase.sortIMDBratingAscending();
        System.out.println(movieDatabase);
        movieDatabase.sortIMDBratingDescending();
        System.out.println(movieDatabase);
        System.out.println("IMDB ratings sort: success");
    }

    public static void Test8() throws IOException
    {
        System.out.println("Test 8\n");
        MovieDatabase movieDatabase = new MovieDatabase("movies.txt");
        movieDatabase.sortTitleLengthAscending();
        System.out.println(movieDatabase);
        movieDatabase.sortTitleLengthDescending();
        System.out.println(movieDatabase);
        System.out.println("title lengths sort: success");
    }

    public static void Test9() throws IOException
    {
        System.out.println("Test 9\n");
        MovieDatabase movieDatabase = new MovieDatabase("movies.txt");
        movieDatabase.sortChrono();
        System.out.println(movieDatabase);
        movieDatabase.sortReverseChrono();
        System.out.println(movieDatabase);
        System.out.println("chronologies sort: success");
    }
}
