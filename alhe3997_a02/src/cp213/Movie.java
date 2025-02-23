package cp213;

import java.io.PrintStream;

/**
 * Movie class definition.
 *
 * @author Mehdi Al-heloo, 169063997, alhe3997@mylaurier.ca
 * @version 2025-02-13
 */
public class Movie implements Comparable<Movie> {

    // Constants
    /**
     * The first year movies were produced.
     */
    public static final int FIRST_YEAR = 1888;
    /**
     * The names of movie genres.
     */
    public static final String[] GENRES = { "science fiction", "fantasy", "drama", "romance", "comedy", "zombie",
	    "action", "historical", "horror", "war", "mystery" };
    /**
     * The maximum allowed Movie rating.
     */
    public static final double MAX_RATING = 10.0;
    /**
     * The minimum allowed Movie rating.
     */
    public static final double MIN_RATING = 0.0;

    /**
     * Creates a string of movie genres in the format:
     *
     * <pre>
     0: science fiction
     1: fantasy
     2: drama
    ...
    10: mystery
     * </pre>
     *
     * @return A formatted numbered string of Movie genres.
     */
    public static String genresMenu() {

	StringBuilder sb = new StringBuilder();

	for (int i = 0; i < GENRES.length; i++) {
	    sb.append(String.format("%d: %s\n", i, GENRES[i]));
	}
	return sb.toString();
    }

    // Attributes
    private String director = "";
    private int genre = -1;
    private double rating = 0;
    private String title = "";
    private int year = 0;

    /**
     * Instantiates a Movie object.
     *
     * @param title    Movie title.
     * @param year     Year of release.
     * @param director Name of director.
     * @param rating   Rating of 1 - 10 from IMDB.
     * @param genre    Number representing Movie genre.
     */
    public Movie(String title, int year, String director, double rating, int genre) {

	this.title = title;
	this.year = year;
	this.director = director;
	this.rating = Math.max(MIN_RATING, Math.min(rating, MAX_RATING));
	this.genre = (genre >= 0 && genre < GENRES.length) ? genre : -1;

    }

    /**
     * Movies are compared by title, then by year if the titles match. Must ignore
     * case. Ex: Zulu, 1964 precedes Zulu, 2013. Returns:
     * <ul>
     * <li>0 if this equals target</li>
     * <li>&lt; 0 if this precedes target</li>
     * <li>&gt; 0 if this follows target</li>
     * </ul>
     */
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Movie other) {

	int titleComparison = this.title.toLowerCase().compareTo(other.title.toLowerCase());

	return titleComparison != 0 ? titleComparison : this.year - other.year;
    }

    /**
     * Converts a genre integer to a string.
     *
     * @return The string version of the genre number.
     */
    public String genreToName() {

	return (this.genre >= 0 && this.genre < GENRES.length) ? GENRES[this.genre] : "Unknown";

    }

    /**
     * Director getter.
     *
     * @return The director.
     */
    public String getDirector() {

	return this.director;

    }

    /**
     * Genre getter.
     *
     * @return The genre number.
     */
    public int getGenre() {

	return this.genre;

    }

    /**
     * Rating getter.
     *
     * @return The rating.
     */
    public double getRating() {

	return this.rating;

    }

    /**
     * Title getter.
     *
     * @return The title.
     */
    public String getTitle() {
	return this.title;
    }

    /**
     * Year getter.
     *
     * @return The year.
     */
    public int getYear() {
	return this.year;
    }

    /**
     * Creates a formatted string of Movie key data in the format "title, year". Ex:
     * "Zulu, 1964".
     *
     * @return A Movie key as a string.
     */
    public String key() {
	return String.format("%s, %d", this.title, this.year);
    }

    /**
     * Rating setter.
     *
     * @param rating The new rating.
     */
    public void setRating(double rating) {
	this.rating = Math.max(MIN_RATING, Math.min(rating, MAX_RATING));
    }

    /**
     * Returns a string in the format:
     *
     * <pre>
    Title:    title
    Year:     year
    Director: director
    Rating:   rating
    Genre:    genre
     * </pre>
     *
     */
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Creates a formatted string of movie data.
     */
    @Override
    public String toString() {
	return String.format("Title:    %s\nYear:     %d\nDirector: %s\nRating:   %.1f\nGenre:    %s", this.title,
		this.year, this.director, this.rating, this.genreToName());
    }

    /**
     * Writes a single line of movie data to an open PrintStream in the format:
     * title|year|director|rating|genre
     *
     * @param ps Output PrintStream.
     */
    public void write(PrintStream ps) {
	ps.printf("%s|%d|%s|%.1f|%d\n", this.title, this.year, this.director, this.rating, this.genre);
    }

}
