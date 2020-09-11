package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Post> posts;
    private String authorId;

    //AuthorMethod

    public Blog(String userId) {
        this.posts = new ArrayList<>();
        this.authorId = userId;
    }

    public void addPost(String title, String text) {
        posts.add(0, new Post(this.authorId, title, text));
    }

    public void addTag(String tag, int at) {
        if (isSizeOver(posts.size(), at)) {
            posts.get(at).addTag(tag);
        }
    }

    public void renamePostTitle(String title, int at) {
        if (isSizeOver(posts.size(), at)) {
            posts.get(at).setTitle(title);
        }
    }

    public void renamePostText(String text, int at) {
        if (isSizeOver(posts.size(), at)) {
            posts.get(at).setText(text);
        }
    }

    //VisitorMethod

    public ArrayList<Post> getPosts() {
        return this.posts;
    }

    public ArrayList<Post> getPostsByTag(String[] tags) {
        ArrayList<Post> filteredPosts = new ArrayList<>();

        for (Post post : this.posts) {
            for (String tag : tags) {
                if (post.getTags().contains(tag)) {
                    filteredPosts.add(post);
                    break;
                }
            }
        }

        return filteredPosts;
    }

    public ArrayList<Post> getPostsByAuthorId(String id) {
        ArrayList<Post> filteredPosts = new ArrayList<>();

        for (Post post : this.posts) {
            if (post.getAuthorId().equals(id)) {
                filteredPosts.add(post);
            }
        }

        return filteredPosts;
    }

    public ArrayList<Post> getSortPosts(SortingType sortingType) {
        ArrayList<Post> sortPosts = new ArrayList<>(this.posts);

        switch (sortingType) {
            case CREATE_TIME_DESCENDING: {
                sortPosts.sort((o1, o2) -> o1.getCreatedDataTime().compareTo(o2.getCreatedDataTime()) * -1);
                break;
            }
            case CREATE_TIME_ASCENDING: {
                sortPosts.sort((o1, o2) -> o1.getCreatedDataTime().compareTo(o2.getCreatedDataTime()));
                break;
            }
            case MODIFY_TIME_DESCENDING: {
                sortPosts.sort((o1, o2) -> o1.getModifiedDataTime().compareTo(o2.getModifiedDataTime()) * -1);
                break;
            }
            case MODIFY_TIME_ASCENDING: {
                sortPosts.sort((o1, o2) -> o1.getModifiedDataTime().compareTo(o2.getModifiedDataTime()));
                break;
            }
            case TITLE_ASCENDING: {
                sortPosts.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
                break;
            }
            default: {
                assert (false) : "Enum error";
            }
        }

        return sortPosts;
    }

    private boolean isSizeOver(int size, int at) {
        return size > at;
    }
}
