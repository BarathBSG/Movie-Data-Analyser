import java.io.IOException;

public class Movie implements Comparable<Movie>
{
    private String title, ageRating, genre;
    private int year, duration;
    private double IMDBrating;
    public Movie(){
        title = "";
        year = 0;
        ageRating = "";
        genre = "";
        duration = 0;
        IMDBrating = 0;
    }
    public Movie(String s){
        //split string into segments in a string array
        /*regex breakdown: looks for commas, checks if the number of speechmarks ahead are even, if it is even,
        * then split the string at the comma (odd implies the comma is within a string itself)*/
        String[] arrSplit = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); //[1],[2]
        this.title = arrSplit[0];
        this.year = Integer.parseInt(arrSplit[1]);
        this.ageRating = arrSplit[2];
        this.genre = arrSplit[3];
        this.duration = Integer.parseInt(arrSplit[4]);
        this.IMDBrating = Double.parseDouble(arrSplit[5]);
    }

    public String getTitle()
    {
        return title;
    }
    public String getAgeRating()
    {
        return ageRating;
    }

    public String getGenre()
    {
        return genre;
    }

    public int getYear()
    {
        return year;
    }

    public int getDuration()
    {
        return duration;
    }

    public double getIMDBrating()
    {
        return IMDBrating;
    }

    @Override
    public String toString(){ //order: title, year, ageRating, genre, duration, IMDBrating
        if (title == "" && ageRating == "" && genre == ""){
            return String.format("\"%s\",%d,\"%s\",\"%s\",%d,%.1f", title, year, ageRating, genre, duration, IMDBrating);
        }
        else {
            return String.format("%s,%d,%s,%s,%d,%.1f", title, year, ageRating, genre, duration, IMDBrating);
        }
    }

    @Override
    public int compareTo(Movie movie) //to sort objects by year, ascending
    {
        return Integer.compare(this.year, movie.year);
    }

    //---------------------TEST HARNESS---------------------
    /*test harness embedded into class but included seperate java file
    * because tests are accessible from Main when implemented here which can
    * lead to security concerns*/

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

    public static void main(String[] args) throws IOException, InterruptedException
    {
        Test1();
        Test2();
        Test3();
        Test4();
    }
}

/**
 * //REFERENCES
 *
 * // [1]
 * //reference website used for regex: https://stackabuse.com/regex-splitting-by-character-unless-in-quotes/
 * //author: Scott Robinson (07/01/2016)
 * // "Regex: Splitting by Character, Unless in Quotes"
 * // accessed: 17/11/2023 20:50
 *
 * // [2]
 * //https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
 * //author: Bart Kiers (18/11/2009),
 * // "Java: splitting a comma separated string but ignoring commas in quotes"
 * // accessed: 17/11/2023 21:00
 *
 */