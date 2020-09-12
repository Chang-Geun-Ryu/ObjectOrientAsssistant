package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private SortingType sortingType = SortingType.ORDER_DATE_DECREASING;
    private boolean tagFilter = false;
    private boolean authorFilter = false;
    private ArrayList<String> tagListToFilter;
    private ArrayList<String> authorListToFilter;
    private ArrayList<Post> posts;
    private ArrayList<Post> filteredPosts;

    public Blog() {
        posts = new ArrayList<Post>();
        tagListToFilter = new ArrayList<String>();
        authorListToFilter = new ArrayList<String>();
        filteredPosts = new ArrayList<Post>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void setPostOrder(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public ArrayList<Post> getPostList() {
        filteredPosts.clear();
        if (tagFilter && authorFilter) {
            changePostOrder(this.sortingType);
            getPostListByAuthorWithTag(authorListToFilter, tagListToFilter);
        } else if (tagFilter) {
            changePostOrder(this.sortingType);
            getPostListByTag(tagListToFilter);
        } else if (authorFilter) {
            changePostOrder(this.sortingType);
            getPostListByAuthor(authorListToFilter);
        } else {
            changePostOrder(this.sortingType);
            for (Post post : posts
            ) {
                filteredPosts.add(post);
            }
        }
        return filteredPosts;
    }

    private void getPostListByTag(ArrayList<String> tags) {
        for (Post post : posts
        ) {
            if (post.matchTag(tags)) {
                filteredPosts.add(post);
            }
        }
    }

    public void getPostListByAuthor(ArrayList<String> authors) {
        for (Post post : posts
        ) {
            if (authors.contains(post.getAuthor())) {
                filteredPosts.add(post);
            }
        }
    }

    public void getPostListByAuthorWithTag(ArrayList<String> authors, ArrayList<String> tags) {
        for (Post post : posts
        ) {
            if (authors.contains(post.getAuthor()) && post.matchTag(tags)) {
                filteredPosts.add(post);
            }
        }
    }

    //이거 밑에 지워야할 수도 있음
    public void setTagFilter(ArrayList<String> tags) {
        if (tags == null) {
            System.out.println("You have to write tag. And I will reset tag filter.");
            tagFilter = false;
            tagListToFilter.clear();
        } else {
            for (String t : tags
            ) {
                tagFilter = true;
                tagListToFilter.add(t);
            }
        }
    }

    public void setTagFilter(String... tags) {
        for (String tag : tags
        ) {
            if (tag.isBlank()) {
                System.out.println("You have to write tag. And I will reset tag filter.");
                tagFilter = false;
                tagListToFilter.clear();
            } else {
                tagFilter = true;
                tagListToFilter.add(tag);
            }
        }

    }
    /*
    public void setTagFilter(String tag) {
        if (tag.isBlank()) {
            System.out.println("You have to write tag. And I will reset tag filter.");
            tagFilter = false;
            tagListToFilter.clear();
        } else {
            tagFilter = true;
            tagListToFilter.add(tag);
        }
    }
    */

    public void clearTagFilter() {
        tagFilter = false;
        tagListToFilter.clear();
    }

    public void setAuthorFilter(User author) {
        if (author.getNickname().isBlank()) {
            authorFilter = false;
            authorListToFilter.clear();
        } else {
            authorFilter = true;
            authorListToFilter.add(author.getNickname());
        }
    }

    public void clearAuthorFilter() {
        authorFilter = false;
        authorListToFilter.clear();
    }

    public void changePostOrder(SortingType sortingType) {
        switch (sortingType) {
            case ORDER_DATE_INCREASING:
                posts.sort((post1, post2) -> {
                    if (post1.getCreatedDateTime().compareTo(post2.getCreatedDateTime()) < 0) {
                        return -1;
                    } else if (post1.getCreatedDateTime().compareTo(post2.getCreatedDateTime()) > 0) {
                        return 1;
                    }
                    return 0;
                });
                break;
            case ORDER_DATE_DECREASING:
                posts.sort((post1, post2) -> {
                    if (post1.getCreatedDateTime().compareTo(post2.getCreatedDateTime()) < 0) {
                        return 1;
                    } else if (post1.getCreatedDateTime().compareTo(post2.getCreatedDateTime()) > 0) {
                        return -1;
                    }
                    return 0;
                });
                break;
            case ORDER_REVISION_INCREASING:
                posts.sort((post1, post2) -> {
                    if (post1.getModifiedDateTime().compareTo(post2.getModifiedDateTime()) < 0) {
                        return -1;
                    } else if (post1.getModifiedDateTime().compareTo(post2.getModifiedDateTime()) > 0) {
                        return 1;
                    }
                    return 0;
                });
                break;
            case ORDER_REVISION_DECREASING:
                posts.sort((post1, post2) -> {
                    if (post1.getModifiedDateTime().compareTo(post2.getModifiedDateTime()) < 0) {
                        return 1;
                    } else if (post1.getModifiedDateTime().compareTo(post2.getModifiedDateTime()) > 0) {
                        return -1;
                    }
                    return 0;
                });
                break;
            case ORDER_DIC_INCREASING:
                posts.sort((post1, post2) -> {
                    if (post1.getTitle().compareTo(post2.getTitle()) > 0) {
                        return 1;
                    } else if (post1.getTitle().compareTo(post2.getTitle()) < 0) {
                        return -1;
                    }
                    return 0;
                });
                break;
            default:
                assert (false) : "Unrecognized sorting type: " + sortingType;
                break;
        }
    }
}
