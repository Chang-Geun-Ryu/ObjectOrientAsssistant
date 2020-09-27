package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Blog {
    private final OffsetDateTime createdDateTime;
    private final OffsetDateTime modifiedDateTime;
    private final HashMap<Integer, Article> articles;
    private SortingType sortingType;
    private String[] tagFilter;
    private String authorFilter;

    public Blog() {
        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = OffsetDateTime.now();
        this.sortingType = SortingType.CREATEDATE_DESC;
        this.articles = new HashMap<>();
        this.tagFilter = new String[0];
        this.authorFilter = "";
    }

    public ArrayList<Article> getArticles() {
        Article[] articleArray = articles.values().toArray(new Article[0]);
        ArrayList<Article> orderedArticles;
        Article tempArticle;
        int max;
        int min = 0;

        switch (this.sortingType) {
            case CREATEDATE_DESC:
                for (int i = 0; i < articleArray.length - 1; i++) {
                    max = i;
                    for (int j = i + 1; j < articleArray.length; j++) {
                        if (articleArray[j].getCreatedDateTime().isAfter(articleArray[max].getCreatedDateTime())) {
                            max = j;
                        }
                    }
                    tempArticle = articleArray[i];
                    articleArray[i] = articleArray[max];
                    articleArray[max] = tempArticle;
                }

                break;
            case CREATEDATE_ASC:
                for (int i = 0; i < articleArray.length - 1; i++) {
                    min = i;
                    for (int j = i + 1; j < articleArray.length; j++) {
                        if (articleArray[j].getCreatedDateTime().isBefore(articleArray[min].getCreatedDateTime())) {
                            min = j;
                        }
                    }
                    tempArticle = articleArray[i];
                    articleArray[i] = articleArray[min];
                    articleArray[min] = tempArticle;
                }
                break;

            case MODIFIEDDATE_DESC:
                for (int i = 0; i < articleArray.length - 1; i++) {
                    max = i;
                    for (int j = i + 1; j < articleArray.length; j++) {
                        if (articleArray[j].getModifiedDateTime().isAfter(articleArray[min].getModifiedDateTime())) {
                            max = j;
                        }
                    }
                    tempArticle = articleArray[i];
                    articleArray[i] = articleArray[max];
                    articleArray[max] = tempArticle;
                }

                break;

            case MODIFIEDDATE_ASC:
                for (int i = 0; i < articleArray.length - 1; i++) {
                    min = i;
                    for (int j = i + 1; j < articleArray.length; j++) {
                        if (articleArray[j].getModifiedDateTime().isBefore(articleArray[min].getModifiedDateTime())) {
                            min = j;
                        }
                    }
                    tempArticle = articleArray[i];
                    articleArray[i] = articleArray[min];
                    articleArray[min] = tempArticle;
                }
                break;

            case TITLE_ASC:
                for (int i = 0; i < articleArray.length - 1; i++) {
                    min = i;
                    for (int j = i + 1; j < articleArray.length; j++) {
                        if (articleArray[j].getTitle().compareTo(articleArray[min].getTitle()) < 0) {
                            min = j;
                        }
                    }
                    tempArticle = articleArray[i];
                    articleArray[i] = articleArray[min];
                    articleArray[min] = tempArticle;
                }
                break;

            default:
                break;
        }

        orderedArticles = new ArrayList<>(Arrays.asList(articleArray));
        if (this.authorFilter != null && !this.authorFilter.equals("")) {
            orderedArticles = filterArticleByAuthor(orderedArticles);
        }
        if (this.tagFilter != null && this.tagFilter.length != 0) {
            orderedArticles = filterArticleByTag(orderedArticles);
        }

        return orderedArticles;
    }

    public void setTagFilter(String... tags) {
        this.tagFilter = tags;
    }

    public void setAuthorFilter(String author) {
        this.authorFilter = author;
    }

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public void addArticle(Article article) {
        int articleId = article.getArticleId();
        articles.put(articleId, article);
    }

    // 동작설명
    // 1. 전체 아티클을 돌면서 수행
    // 2. 아티클이 가지고 있는 tag가 모두 filter tag에 해당하는지 Check
    // 3. filter tag에 모두 해당한다면 추가/
    private ArrayList<Article> filterArticleByTag(ArrayList<Article> articles) {
        ArrayList<Article> filteredArticleListByTag = new ArrayList<>();

        for (Article article : articles) {
            ArrayList<String> articleTags = article.getTags();
            for (String tag : tagFilter) {
                if (articleTags.contains(tag) && !filteredArticleListByTag.contains(article)) {
                    filteredArticleListByTag.add(article);
                }
            }
        }

        return filteredArticleListByTag;
    }

    private ArrayList<Article> filterArticleByAuthor(ArrayList<Article> articles) {
        ArrayList<Article> filteredArticleListByAuthor = new ArrayList<>();

        for (Article article : articles) {
            if (article.getAuthor().equals(authorFilter)) {
                filteredArticleListByAuthor.add(article);
            }
        }

        return filteredArticleListByAuthor;
    }
}
