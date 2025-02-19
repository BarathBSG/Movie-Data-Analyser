import java.io.IOException;

public class MovieTestHarness
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Test1();
        Test2();
        Test3();
        Test4();
    }
    public static void Test1(){
        Movie movie = new Movie();
        String expected = "\"\"" + "," + 0 + "," + "\"\"" + "," + "\"\"" + "," + 0 + "," + 0.0;
        System.out.println("Test 1:");
        System.out.println("Expected: \n" + expected);
        System.out.println("Output: ");
        System.out.println(movie);
    }
    public static void Test2(){
        System.out.println("\nTest 2:");
        String line = "\"Indiana Jones and the Last Crusade\",1989,\"PG-13\",\"Action/Adventure/Fantasy\",127,8.2";
        System.out.println("Expected: \n" +
                "\"Indiana Jones and the Last Crusade\",1989,\"PG-13\",\"Action/Adventure/Fantasy\",127,8.2");
        Movie movie1 = new Movie(line);
        System.out.println("Output: ");
        System.out.println(movie1);
    }
    public static void Test3(){
        String line = "\"Indiana Jones and the Last Crusade\",1989,\"PG-13\",\"Action/Adventure/Fantasy\",127,8.2";
        Movie movie1 = new Movie(line);
        Movie movie = new Movie();
        System.out.println("\nTest 3:");
        System.out.println("Expected: \n" + -1);
        System.out.println("Output: \n" + movie.compareTo(movie1));
    }
    public static void Test4(){
        String line = "\"Indiana Jones and the Last Crusade\",1989,\"PG-13\",\"Action/Adventure/Fantasy\",127,8.2";
        Movie movie1 = new Movie(line);
        System.out.println("\nTest 4:");
        System.out.println("Expected: \n" +
                " Title: \"Indiana Jones and the Last Crusade\"" +
                " Year: 1989" +
                " Age rating: \"PG-13\"" +
                " Genre: \"Action/Adventure/Fantasy\"" +
                " Duration: 127" +
                " IMDB Rating: 8.2");
        System.out.println("Output: \n" +
                " Title: " + movie1.getTitle() +
                " Year: " + movie1.getYear() +
                " Age Rating: " + movie1.getAgeRating() +
                " Genre: " + movie1.getGenre() +
                " Duration: " + movie1.getDuration() +
                " IMDB Rating: " + movie1.getIMDBrating());
    }
}
