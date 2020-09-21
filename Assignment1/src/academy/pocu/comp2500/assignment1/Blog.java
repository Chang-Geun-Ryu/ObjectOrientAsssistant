package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private SortingType sortingType;
    private ArrayList<Post> posts;
    private ArrayList<String> authorFilters;
    private ArrayList<String> tagFilters;

    public Blog() {
        this.sortingType = SortingType.A;
        this.posts = new ArrayList<Post>();
        this.authorFilters = new ArrayList<String>();
        this.tagFilters = new ArrayList<String>();
    }

    public ArrayList<Post> getPosts() {
        ArrayList<Post> list = new ArrayList<Post>();

        if (authorFilters.size() > 0 && tagFilters.size() > 0) {
            for (Post post : this.posts) {
                for (String t : post.getTags()) {
                    for (String i : this.tagFilters) {
                        for (String s : this.authorFilters) {
                            if (t.equals(i) && s.equals(post.getAuthorName())) {
                                list.add(post);
                            }
                        }
                    }
                }
            }
        } else if (tagFilters.size() > 0) {
            for (Post post : this.posts) {
                for (String t : post.getTags()) {
                    for (String i : this.tagFilters) {
                        if (t.equals(i) && !list.contains(post)) {
                            list.add(post);
                        }
                    }
                }
            }
        } else if (authorFilters.size() > 0) {
            for (Post post : this.posts) {
                for (String t : this.authorFilters) {
                    if (post.getAuthorName().equals(t) && !list.contains(post)) {
                        list.add(post);
                    }
                }
            }
        } else {
            list = this.posts;
        }
        switch (sortingType) {
            case A:
                list.sort((a, b) -> b.getCreatedDateTime().compareTo(a.getCreatedDateTime()));
                break;
            case B:
                list.sort((a, b) -> a.getCreatedDateTime().compareTo(b.getCreatedDateTime()));
                break;
            case C:
                list.sort((a, b) -> b.getModifiedDateTime().compareTo(a.getModifiedDateTime()));
                break;
            case D:
                list.sort((a, b) -> a.getModifiedDateTime().compareTo(b.getModifiedDateTime()));
                break;
            case E:
                list.sort((a, b) -> a.getTitle().compareTo(b.getTitle()));
                break;
            default:
                break;
        }
        return list;
    }

    public SortingType getSortingType() {
        return this.sortingType;
    }

    public ArrayList<String> getAuthorFilters() {
        return this.authorFilters;
    }

    public ArrayList<String> getTagFilters() {
        return this.tagFilters;
    }

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void authorFilter(ArrayList<String> authors) {
        this.authorFilters = authors;
    }

    public void tagFilter(ArrayList<String> tags) {
        this.tagFilters = tags;
    }
}