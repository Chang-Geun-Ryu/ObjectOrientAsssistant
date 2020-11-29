package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;

public class MovieStore implements IRequestHandler {
    private ArrayList<Movie> movies;
    public MovieStore() {
        this.movies = new ArrayList<Movie>();
    }

    public void add(Movie movie) {
        movies.add(movie);
    }

    public boolean remove(int index) {
        if (this.movies == null) {
            return false;
        }

        if (this.movies.size() > index) {
            movies.remove(index);
            return true;
        }

        return false;
    }

    public ResultBase handle(Request request) {
        if (request == null || request.getTitle() == null) {
            return new NotFoundResult();
        }

        Movie movie = null;
        for (Movie m : this.movies) {
            if (m.getTitle().equals(request.getTitle())) {
                movie = m;
                break;
            }
        }

        if (movie != null) {
            return new OkResult(movie);
        } else {
            return new NotFoundResult();
        }
    }
}
