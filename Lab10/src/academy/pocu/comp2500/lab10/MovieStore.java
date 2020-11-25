package academy.pocu.comp2500.lab10;


import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;

public class MovieStore implements IRequestHandler {
    private ArrayList<Movie> store = new ArrayList<>();

    public void add(Movie movie) {
        if (movie == null || movie.getTitle() == null) {
            return;
        }

        if (isCompare(movie) == false) {
            store.add(movie);
        }
    }
    
    public boolean remove(int index) {
        if (store.size() > index) {
            store.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public ResultBase handle(Request request) {
        if (request == null || request.getTitle() == null) {
            return new NotFoundResult();
        }

        Movie movie = getMovie(request.getTitle());

        if (movie != null) {
            return new OkResult(movie);
        } else {
            return new NotFoundResult();
        }
    }

    private Movie getMovie(String title) {
        for (Movie movie : this.store) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }

    private boolean isCompare(Movie movie) {
        for (Movie m : this.store) {
            if (m.getTitle().equals(movie.getTitle())) {// && m.getPlayTime() == movie.getPlayTime() && m.getRating() == movie.getRating()) {
                return true;
            }
        }

        return false;
    }
}