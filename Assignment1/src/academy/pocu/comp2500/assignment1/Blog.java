package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private String userId;
    private ArrayList<Article> articles;
    private SortingType sortingType;
    private ArrayList<String> tagFilter;
    private ArrayList<String> authorFilter;

    public enum SortingType {
        CREATED_AT_DESCENDING,
        CREATED_AT_ASCENDING,
        UPDATED_AT_DESCENDING,
        UPDATED_AT_ASCENDING,
        TITLE_AT_ASCENDING;
    }

    public Blog(String userId) {
        this.userId = userId;
        this.articles = new ArrayList<Article>();
        this.tagFilter = new ArrayList<String>();
        this.authorFilter =  new ArrayList<String>();
    }

    public void createArticle(Article article) {
        this.articles.add(article);
    }

    public ArrayList<Article> getArticles() {
        int numTagsInFilter = this.tagFilter.size();
        int numAuthorsInFilter = this.authorFilter.size();

        ArrayList<Article> filteredArticles = new ArrayList<Article>();
        ArrayList<Article> filteredArticlesByAuthor = new ArrayList<Article>();

        if (numAuthorsInFilter == 0 && numTagsInFilter == 0) {
            filteredArticles = this.articles;
        } else {
            if (numAuthorsInFilter > 0) {
                for (int i = 0; i < numAuthorsInFilter; ++i) {
                    String author = this.authorFilter.get(i);
                    for (int j = 0; j < this.articles.size(); ++i) {
                        Article article = this.articles.get(i);
                        if (author.equals(article.getUserId())) {
                            filteredArticlesByAuthor.add(article);
                        }
                    }
                }
            } else {
                filteredArticlesByAuthor = this.articles;
            }

//            if (numTagsInFilter > 0) {
//                for (int i = 0; i < numTagsInFilter; ++i) {
//                    String tag = this.tagFilter.get(i);
//                    for (int j = 0; j < this.tags.size(); ++i) {
//                        Article article = this.articles.get(i);
//                        if (tag.equals(article.getUserId())) {
//                            filteredArticles.add(article);
//                        }
//                    }
//                }
//            }
            filteredArticles = filteredArticlesByAuthor;
        }

        return filteredArticles;
    }

    // Set arrangement order
    public void setArticleOrder(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public void setAuthorsFilter(String author) {
        for (int i = 0; i < this.authorFilter.size(); ++i) {
            if (author.equals(authorFilter.get(i))) {
                return;
            }
        }

        this.authorFilter.add(author);
    }

    public void setTagsFilter(ArrayList<String> tags) {
        ArrayList<String> newTags = new ArrayList<String>();
        for (int i = 0; i < tags.size(); ++i) {
            String currentTag = tags.get(i);
            for (int j = 0; j < this.tagFilter.size(); ++i) {
                if (currentTag.equals(this.tagFilter.get(i))) {
                    break;
                }
                if (j == this.tagFilter.size() - 1) {
                    newTags.add(currentTag);
                }
            }
        }

        for (int i = 0; i < newTags.size(); ++i) {
            this.tagFilter.add(newTags.get(i));
        }
    }
}
