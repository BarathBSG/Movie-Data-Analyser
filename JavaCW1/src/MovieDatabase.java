import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class MovieDatabase
{
    private ArrayList<Movie> movieArrayList = new ArrayList<Movie>();

    public MovieDatabase(String file) throws IOException
    {
        //read the file
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null){ //enter loop for every non-empty line
                Movie movie = new Movie(line);
                if (movieArrayList != null)
                {
                    movieArrayList.add(movie);//add the line as a movie object to movieArrayList
                }
            }
        }catch (IOException ignored){
        }
    }

    @Override
    public String toString(){
        //loop to print every element
        for (int i = 0; i < movieArrayList.size(); i++)
        {
            Movie currentMovie = movieArrayList.get(i);
            System.out.println(currentMovie.getTitle() + "," + currentMovie.getYear() + "," +
                    currentMovie.getAgeRating() + "," + currentMovie.getGenre() + "," +
                    currentMovie.getDuration() + "," + currentMovie.getIMDBrating());
        }
        return "";
    }

    //lowest rated by genre
    public void lowestRated(String genre){
        ArrayList<Movie> tempArrayList = new ArrayList<>();
        for (int i = 0; i < movieArrayList.size(); i++)
        {
            Movie currentMovie = movieArrayList.get(i);;
            if (currentMovie.getGenre().contains(genre)){
                tempArrayList.add(currentMovie);
            }
        }

        Collections.sort(tempArrayList, new Comparator<Movie>()
        {
            @Override
            public int compare(Movie m1, Movie m2)
            {
                //sorts temp arraylist by ascending IMDB rating
                return Double.compare(m1.getIMDBrating(), m2.getIMDBrating());
            }
        });

        System.out.println("Lowest rated " + genre + " movie is " + tempArrayList.get(0).getTitle()
        + ", with a rating of " + tempArrayList.get(0).getIMDBrating());
    }

    //most recent by age rating and specified rank
    public void mostRecent(String agerating, int rank){
        agerating = "\"" + agerating + "\"";
        ArrayList<Movie> tempArrayList = new ArrayList<>();
        for (int i = 0; i < movieArrayList.size(); i++)
        {
            Movie currentMovie = movieArrayList.get(i);;
            if (currentMovie.getAgeRating().equals(agerating)){
                tempArrayList.add(currentMovie);
            }
        }

        //sorts chronologically, reverses the arraylist for newest movies first
        Collections.sort(tempArrayList, Collections.reverseOrder());

        System.out.println("The number " + rank + " most recent " + agerating + " rated movie is "
                + tempArrayList.get(rank - 1).getTitle() + " from " + tempArrayList.get(rank - 1).getYear());
    }

    //oldest/newest movie overall
    public void oldest(){
        Collections.sort(movieArrayList);
        System.out.println("Oldest movie in database: " + movieArrayList.get(0).getTitle()
        + " from " + movieArrayList.get(0).getYear());
    }

    public void newest(){
        Collections.sort(movieArrayList, Collections.reverseOrder());
        System.out.println("Newest movie in database: " + movieArrayList.get(0).getTitle()
                + " from " + movieArrayList.get(0).getYear());
    }

    //longest movie title
    public void longestMovieTitle(){
        Collections.sort(movieArrayList, new Comparator<Movie>()
        {
            @Override
            public int compare(Movie m1, Movie m2)
            {
                //sorts arraylist descending (m1 & m2 order swapped) by title length
                return Integer.compare(m2.getTitle().length(), m1.getTitle().length());
            }
        });
        System.out.println("The longest movie title is " + movieArrayList.get(0).getTitle()
                + " with a character length of " + (movieArrayList.get(0).getTitle().length() - 2) + " chars");
    }

    //shortest movie title
    public void shortestMovieTitle(){
        Collections.sort(movieArrayList, new Comparator<Movie>()
        {
            @Override
            public int compare(Movie m1, Movie m2)
            {
                return Integer.compare(m2.getTitle().length(), m1.getTitle().length());
            }
        });
        System.out.println(
                "The shortest movie title is " + movieArrayList.get(movieArrayList.size() - 1).getTitle()
                + " with a character length of "
                + (movieArrayList.get(movieArrayList.size() - 1).getTitle().length() - 2) + " char(s)");
    }

    //difference between oldest and newest movie
    public void oldestNewestMovieDiff(){
        Collections.sort(movieArrayList);

        int difference = movieArrayList.get(movieArrayList.size() - 1).getYear() - movieArrayList.get(0).getYear();

        System.out.println("The difference between the oldest and newest movie is " + difference + " years, " +
                "from " + movieArrayList.get(0).getYear() + " to "
                + movieArrayList.get(movieArrayList.size() - 1).getYear());
    }

    //sort by duration
    public void sortDurationDescending(){
        Collections.sort(movieArrayList, new Comparator<Movie>()
        {
            @Override
            public int compare(Movie m1, Movie m2)
            {
                return Integer.compare(m2.getDuration(), m1.getDuration());
            }
        });
    }

    public void sortDurationAscending(){
        Collections.sort(movieArrayList, new Comparator<Movie>()
        {
            @Override
            public int compare(Movie m1, Movie m2)
            {
                return Integer.compare(m1.getDuration(), m2.getDuration());
            }
        });
    }

    //sort by IMDBrating
    public void sortIMDBratingDescending(){
        Collections.sort(movieArrayList, new Comparator<Movie>()
        {
            @Override
            public int compare(Movie m1, Movie m2)
            {
                return Double.compare(m2.getIMDBrating(), m1.getIMDBrating());
            }
        });
    }

    public void sortIMDBratingAscending(){
        Collections.sort(movieArrayList, new Comparator<Movie>()
        {
            @Override
            public int compare(Movie m1, Movie m2)
            {
                return Double.compare(m1.getIMDBrating(), m2.getIMDBrating());
            }
        });
    }

    //sort by title length
    public void sortTitleLengthDescending(){
        Collections.sort(movieArrayList, new Comparator<Movie>()
        {
            @Override
            public int compare(Movie m1, Movie m2)
            {
                return Integer.compare(m2.getTitle().length(), m1.getTitle().length());
            }
        });
    }

    public void sortTitleLengthAscending(){
        Collections.sort(movieArrayList, new Comparator<Movie>()
        {
            @Override
            public int compare(Movie m1, Movie m2)
            {
                return Integer.compare(m1.getTitle().length(), m2.getTitle().length());
            }
        });
    }

    //sort by chronology
    public void sortChrono(){
        for (int i = 0; i < movieArrayList.size() - 1; i++)
        {
            for (int j = 0; j < movieArrayList.size() - 1; j++)
            {
                if (movieArrayList.get(j).compareTo(movieArrayList.get(j + 1)) > 0){
                    Movie temp = movieArrayList.get(j);
                    movieArrayList.set(j, movieArrayList.get(j + 1));
                    movieArrayList.set(j + 1, temp);
                }
            }
        }
        /*could do other functions using this bubble sort but collections.sort is more optimal*/
    }

    public void sortReverseChrono(){
        for (int i = 0; i < movieArrayList.size() - 1; i++)
        {
            for (int j = 0; j < movieArrayList.size() - 1; j++)
            {
                if (movieArrayList.get(j).compareTo(movieArrayList.get(j + 1)) > 0){
                    Movie temp = movieArrayList.get(j);
                    movieArrayList.set(j, movieArrayList.get(j + 1));
                    movieArrayList.set(j + 1, temp);
                }
            }
        }
        Collections.reverse(movieArrayList);
    }

    //for giggles
    public void randomMovieDetails() throws InterruptedException
    {
        Random random = new Random();
        System.out.println("you have scrolled to the bottom and " +
                "have now found this function. Please don't penalise me");
        System.out.println("HIDDEN FUNCTION RUN. CREATING RANDOM MOVIE");
        Thread.sleep(1000);
        System.out.println("...");
        Thread.sleep(1000);
        System.out.println("...");
        Thread.sleep(1000);
        System.out.println("...");
        Thread.sleep(1000);
        System.out.println("Your random movie is: "
                + movieArrayList.get(random.nextInt(movieArrayList.size() - 1)).getTitle()
        + "\nDate aired: " + movieArrayList.get(random.nextInt(movieArrayList.size() - 1)).getYear()
        + "\nAge rating: " + movieArrayList.get(random.nextInt(movieArrayList.size() - 1)).getAgeRating()
        + "\nGenre: " + movieArrayList.get(random.nextInt(movieArrayList.size() - 1)).getGenre()
        + "\nDuration: " + movieArrayList.get(random.nextInt(movieArrayList.size() - 1)).getDuration()
        + "\nIMDB rating: " + movieArrayList.get(random.nextInt(movieArrayList.size() - 1)).getIMDBrating());
        Thread.sleep(1000);
        System.out.println("... imagine how crazy this movie would be!");
    }
}