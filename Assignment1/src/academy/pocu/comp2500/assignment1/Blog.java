package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Post> posts;
    private ArrayList<String> tagFilters;
    private ArrayList<String> authorFilters;
    private SortingType sortingType;


    public Blog() {
        this.posts = new ArrayList<Post>();
        this.tagFilters = new ArrayList<String>();
        this.authorFilters = new ArrayList<String>();
        this.sortingType = SortingType.POST_DATE_DECREASING;
    }


    public ArrayList<Post> getPosts() {

        ArrayList<Post> tagFilterPost = new ArrayList<Post>();
        if (!this.tagFilters.isEmpty()) {
            for (String tag : this.tagFilters) {
                for (Post post : this.posts) {
                    if (post.getTags().contains(tag)) {
                        if (!tagFilterPost.contains(post)) {
                            tagFilterPost.add(post);
                        }
                    }
                }
            }
        } else {
            tagFilterPost = this.posts;
        }

        ArrayList<Post> authorFilterPost = new ArrayList<Post>();
        if (!this.authorFilters.isEmpty()) {
            for (String author : this.authorFilters) {
                for (Post post : this.posts) {
                    if (post.getAuthor().equals(author)) {
                        if (!authorFilterPost.contains(post)) {
                            authorFilterPost.add(post);
                        }
                    }
                }
            }
        } else {
            authorFilterPost = this.posts;
        }

        ArrayList<Post> settingPosts = new ArrayList<Post>();
        for (Post post : tagFilterPost) {
            if (authorFilterPost.contains(post)) {
                if (!settingPosts.contains(post)) {
                    settingPosts.add(post);
                }
            }
        }

        if (this.tagFilters.isEmpty() && this.authorFilters.isEmpty()) {
            settingPosts = this.posts;
        }


        switch (this.sortingType) {
            case POST_DATE_DECREASING:
                settingPosts.sort((o1, o2) -> o2.getPostTime().compareTo(o1.getPostTime()));
                break;
            case POST_DATE_INCREASING:
                settingPosts.sort((o1, o2) -> o1.getPostTime().compareTo(o2.getPostTime()));
                break;
            case MODIFY_DATE_DECREASING:
                settingPosts.sort((o1, o2) -> o2.getModifyTime().compareTo(o1.getModifyTime()));
                break;
            case MODIFY_DATE_INCREASING:
                settingPosts.sort((o1, o2) -> o1.getModifyTime().compareTo(o2.getModifyTime()));
                break;
            case TITLE_INCREASING:
                settingPosts.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
                break;
            default:
                assert (false) : "Unrecognized sorting type: " + this.sortingType;
                break;
        }

        return settingPosts;
    }

    public ArrayList<String> getTagFilter() {
        return this.tagFilters;
    }

    public ArrayList<String> getAuthorFilters() {
        return this.authorFilters;
    }

    public SortingType getSortingType() {
        return this.sortingType;
    }

    public void setTagFilters(ArrayList<String> tags) {
        this.tagFilters = tags;
    }

    public void setAuthorFilters(ArrayList<String> authors) {
        this.authorFilters = authors;
    }

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }


    public void addPost(Post post) {
        this.posts.add(post);
    }


}
