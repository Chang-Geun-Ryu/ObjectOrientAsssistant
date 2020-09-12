package academy.pocu.comp2500.assignment1;

import java.util.Collections;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.time.temporal.ChronoField;

public final class BlogHost {
//    private final HashMap<String, ArrayList<Content>> mapContents;
    private final ArrayList<Content> arrContents;
    private ArrayList<String> tags;
//    private final ArrayList<String> authors;
    private SortType sortType;
    private String author;

    public enum SortType {
        DESCENDINGPOST,
        ASCENDINGPOST,
        DESCENDINGMODIFY,
        ASCENDINGMODIFY,
        ASCENDINGTITLE
    }

    public BlogHost() {
//        this.mapContents = new HashMap<>();
        this.arrContents = new ArrayList<>();
        this.tags = new ArrayList<>();
//        this.authors = new ArrayList<>();
        this.sortType = null;
        this.author = null;
    }

    public final void addPost(Content post) {
        this.arrContents.add(post);
//        this.addContent(post);
    }

    public final void setTitle(String authorId, String title, String text) {
        this.arrContents.stream()
                .forEach(e -> {
                   if (e.getAuthorId() == authorId && e.getTitle() == title) {
                       e.modifyPostTitle(text);
                   }
                });
//        try {
//            this.mapContents.get(authorId)
//                    .stream()
//                    .filter(content -> {
//                        return content.getTitle() == title;
//                    }).findFirst()
//                    .orElseThrow()
//                    .modifyPostTitle(text);
//
//
//        } catch (Exception e) {
//            System.out.println(e);
////            assert (true);
//        }
    }

    public final void setBody(String authorId, String body, String text) {
        this.arrContents.stream()
                .forEach(e -> {
                    if (e.getAuthorId() == authorId && e.getTitle() == body) {
                        e.modifyPostTitle(text);
                    }
                });
//        try {
//            this.mapContents.get(authorId)
//                    .stream()
//                    .filter(content -> {
//                        return content.getBody() == body;
//                    }).findFirst()
//                    .orElseThrow()
//                    .modifyPostBody(text);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

//    private final void addContent(Content content) {
//        if (this.mapContents.containsKey(content.getAuthorId())) {
//            this.mapContents.get(content.getAuthorId()).add(content);
//        } else {
//            ArrayList<Content> array = new ArrayList<>();
//            array.add(content);
//            this.mapContents.put(content.getAuthorId(), array);
//        }
//    }

    private final int getID() {
        return this.arrContents.size() + 1;
//        return this.mapContents.size() + 1;
    }

//<<<<<<< HEAD
//    public final void setTags(String tag) {
//        if (tag == "" || this.tags == null) {
//            this.tags.clear();
//        }
//        if (this.tags.contains(tag)) {
//            this.tags.remove(tag);
//        } else {
//            this.tags.add(tag);
//        }
////        System.out.println(tags);
//    }
//
//    public final void setAuthors(String authorId) {
//        if (authorId == "" || authorId == null) {
//            this.authors.clear();
//        }
//
//        if (this.authors.contains(authorId)) {
//            this.authors.remove(authorId);
//        } else {
//            this.authors.add(authorId);
//=======
    public final void setTags(ArrayList<String> tags) {
//        if (tag == null) {
//            this.tags.clear();
//        }
//        if (this.tags.contains(tag)) {
//            this.tags.remove(tag);
//        } else {
//            this.tags.add(tag);
//        }
//        this.tags = tags;
//        this.tags.clear();
        this.tags = tags;
    }

    public final void setAuthor(String authorId) {
        if (authorId == null) {
//            this.authors.clear();
//>>>>>>> 8693c9ec7a6251261bc82789e694c263bd77619f
        }
        this.author = authorId;
//        if (this.authors.contains(authorId)) {
//            this.authors.remove(authorId);
//        } else {
//            this.authors.add(authorId);
//        }
    }

    public final void setSortType(SortType type) {
        if (type == null) {
            this.sortType = null;
        }
        if (this.sortType == type) {
            this.sortType = null;
        } else {
            this.sortType = type;
        }
    }

//    public final ArrayList<Content> getContents() {
//        ArrayList<Content> contents;
//
////        if (authors.size() > 0) {
////            contents = getBlogAuthorContents(authors);
//        if (this.author != null) {
//            contents = getBlogAuthorContents(this.author);
//        } else {
//            contents = new ArrayList<Content>(this.mapContents.entrySet()
//                    .stream()
//                    .map(e -> {
//                        return e.getValue();
//                    })
//                    .flatMap(Collection::stream)
//                    .collect(Collectors.toList()));
//        }
//        if (this.tags != null && this.tags.size() > 0) {
//            contents = getTagContents(contents, tags);
//        }
//        if (sortType != null) {
//            contents = getSortContents(contents, sortType);
//        }
//
//        return contents;
//    }

    public final ArrayList<Content> getContents() {
        ArrayList<Content> contents;

        if (this.author != null) {
            contents = (ArrayList<Content>) this.arrContents.stream()
                    .filter(e -> {
                        return e.getAuthorId() == this.author;
                    })
                    .collect(Collectors.toList());
        } else {
            contents = this.arrContents;
        }

        if (this.tags != null && this.tags.size() > 0) {
             contents = (ArrayList<Content>) contents.stream()
                    .filter(e -> {
                        for (String tag: tags) {
                            if (e.getTag().contains(tag)) {
                                return true;
                            }
                        }
                        return false;
                    })
                     .collect(Collectors.toList());
        }

        if (this.sortType != null) {
            contents = getSortContents(contents, this.sortType);
        }
        
        return contents;
    }


    private final ArrayList<Content> getTagContents(ArrayList<Content> contents, ArrayList<String> tags) {
        if (tags == null || tags.size() <= 0) {
            return contents;
        }

        ArrayList<Content> tagContent = new ArrayList<Content>();


        tagContent.addAll(contents.stream()
                .filter(e -> {
                    for (String tag: tags) {
                        if (e.getTag().contains(tag)) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList()));

        return tagContent;
    }
//
//    private final ArrayList<Content> getBlogAuthorContents(ArrayList<String> authorId) {
//    private final ArrayList<Content> getBlogAuthorContents(String authorId) {
//        ArrayList<Content> contents;// = new ArrayList<>();

//        if (authorId == null) {
//            return new ArrayList<Content>();
//        }

//        authorId.forEach(e-> {
//            contents.addAll(this.mapContents.get(e));
//        });
//        contents.addAll(this.mapContents.get(authorId));
//        contents = this.mapContents.get(authorId);

//        if (contents == null) {
//            return new ArrayList<Content>();
//        }
//
//        return contents;
//    }

    private final ArrayList<Content> getSortContents(ArrayList<Content> contents, SortType sortingType) {
        Collections.sort(contents, (lhs, rhs) -> {
            switch (sortingType) {
                case ASCENDINGPOST://DESCENDINGPOST:
                    return Long.compare(lhs.getPostTime().getLong(ChronoField.NANO_OF_DAY), rhs.getPostTime().getLong(ChronoField.NANO_OF_DAY));
                case DESCENDINGPOST://ASCENDINGPOST:
                    return Long.compare(rhs.getPostTime().getLong(ChronoField.NANO_OF_DAY), lhs.getPostTime().getLong(ChronoField.NANO_OF_DAY));
                case ASCENDINGMODIFY://DESCENDINGMODIFY:
                    return Long.compare(lhs.getModifyTime().getLong(ChronoField.NANO_OF_DAY), rhs.getModifyTime().getLong(ChronoField.NANO_OF_DAY));
                case DESCENDINGMODIFY://ASCENDINGMODIFY:
                    return Long.compare(rhs.getModifyTime().getLong(ChronoField.NANO_OF_DAY), lhs.getModifyTime().getLong(ChronoField.NANO_OF_DAY));
                case ASCENDINGTITLE:
                    return lhs.getTitle().compareTo(rhs.getTitle());
                default:
                    return 0;
            }
        });
        if (contents.size() > 0) {
            return contents;
        } else {
            return new ArrayList<Content>();
        }
    }
}
