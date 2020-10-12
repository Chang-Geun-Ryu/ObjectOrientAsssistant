package academy.pocu.comp2500.assignment1;
import java.util.ArrayList;

public class Blog {
    private final String author;
    private final ArrayList<Post> posts;

    private SortingTypes sortingType;

    private String authorFilter;
    private ArrayList<String> tagFilters;

    public enum SortingTypes {
        CREATED_DATE_TIME_DESCENDING,
        CREATED_DATE_TIME_ASCENDING,
        MODIFIED_DATE_TIME_DESCENDING,
        MODIFIED_DATE_TIME_ASCENDING,
        TITLE_ASCENDING
    }


    public Blog(String user) {
        this.author = user;
        posts = new ArrayList<>();
        authorFilter = "";
        tagFilters = new ArrayList<>();
        sortingType = SortingTypes.CREATED_DATE_TIME_DESCENDING;
    }

    public String getAuthor() {
        return this.author;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public SortingTypes getSortingType() {
        return this.sortingType;
    }
    public String getAuthorFilter() {
        return this.authorFilter;
    }
    public ArrayList<String> getTagFilters() {
        return this.tagFilters;
    }


    public void setTagFilters(String tag) {
        this.tagFilters.add(tag);
    }
    public void setTagFilters(ArrayList<String> tags) {
        for (String tag : tags) {
            this.tagFilters.add(tag);
        }
    }

    public void setAuthorFilter(String author) {
        this.authorFilter = author;
    }

    public void unsetTagFilters() {
        this.tagFilters = new ArrayList<>();
    }
    public void unsetAuthorFilters() {
        this.authorFilter = "";
    }

    public ArrayList<Post> getPosts() {
        if (this.tagFilters.isEmpty()) {
            if (this.authorFilter.equals("")) {
                return this.posts;
            } else {
                ArrayList<Post> authorFilteredPosts = new ArrayList<>();
                for (Post item_post : this.posts) {
                    if (this.authorFilter.equals(item_post.getAuthor())) {
                        authorFilteredPosts.add(item_post);
                    }
                }
                return authorFilteredPosts;
            }
        } else {
            ArrayList<Post> tagFilteredPosts = new ArrayList<>();
            for (Post item_post : this.posts) {
                if (isNonEmptyInterSection(this.tagFilters, item_post.getTags())) {
                    tagFilteredPosts.add(item_post);
                }
            }
            if (this.authorFilter.equals("")) {
                return tagFilteredPosts;
            } else {
                ArrayList<Post> multiFilteredPosts = new ArrayList<>();
                for (Post item_post : tagFilteredPosts) {
                    if (this.authorFilter.equals(item_post.getAuthor())) {
                        multiFilteredPosts.add(item_post);
                    }
                }
                return multiFilteredPosts;
            }
        }
    }

    private boolean isNonEmptyInterSection(ArrayList<String> Array1, ArrayList<String> Array2) {
        for (String string1 : Array1) {
            for (String string2 : Array2) {
                if (string1.equals(string2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void sort(SortingTypes sortingType) {
        this.sortingType = sortingType;

        Post tmpPost;
        int iterIndex;
        int comparedIndex;
        int tmpIndex;

        for (iterIndex = 0; iterIndex < this.posts.size(); iterIndex++) {
            tmpPost = this.posts.get(iterIndex);
            tmpIndex = iterIndex;
            for (comparedIndex = iterIndex + 1; comparedIndex < this.posts.size(); comparedIndex++) {

                switch (sortingType) {
                    case CREATED_DATE_TIME_DESCENDING:
                        if (tmpPost.isCreatedBefore(this.posts.get(comparedIndex))) {
                            tmpPost = this.posts.get(comparedIndex);
                            tmpIndex = comparedIndex;
                        }
                        break;
                    case CREATED_DATE_TIME_ASCENDING:
                        if (tmpPost.isCreatedAfter(this.posts.get(comparedIndex))) {
                            tmpPost = this.posts.get(comparedIndex);
                            tmpIndex = comparedIndex;
                        }
                        break;
                    case MODIFIED_DATE_TIME_DESCENDING:
                        if (tmpPost.isModifiedBefore(this.posts.get(comparedIndex))) {
                            tmpPost = this.posts.get(comparedIndex);
                            tmpIndex = comparedIndex;
                        }
                        break;
                    case MODIFIED_DATE_TIME_ASCENDING:
                        if (tmpPost.isModifiedAfter(this.posts.get(comparedIndex))) {
                            tmpPost = this.posts.get(comparedIndex);
                            tmpIndex = comparedIndex;
                        }
                        break;
                    case TITLE_ASCENDING:
                        if (tmpPost.compareTitle(this.posts.get(comparedIndex)) == 1) {
                            tmpPost = this.posts.get(comparedIndex);
                            tmpIndex = comparedIndex;
                        }
                        break;
                }
            }
            this.posts.set(tmpIndex, this.posts.get(iterIndex));
            this.posts.set(iterIndex, tmpPost);
        }
    }
}
