package day02.movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movies= new ArrayList<>();

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public List<Movie> selectMoviesWithThisActor(String name){
        return movies.stream()
                .filter(m->m.getActors().contains(name))
                .toList();
    }

    public long selectMaxMovieLength(){
        return movies.stream()
                .mapToInt(Movie::getLength)
                .max().orElseThrow(()->new IllegalStateException("List is empty"));
    }
}
