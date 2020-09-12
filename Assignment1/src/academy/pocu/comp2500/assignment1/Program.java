package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.registry.Registry;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        BlogHost blog = new BlogHost();
        Content post = new Content("1", "body2", "a1");
        Content post2 = new Content("2", "body1", "a1");
        blog.addPost(post);
        blog.addPost(post2);
        Content post3 = new Content("3", "body2", "a2");
        Content post4 = new Content("4", "body1", "a2");
        blog.addPost(post3);
        blog.addPost(post4);

        post.addPostTag("t1");
        post2.addPostTag("t2");
        post3.addPostTag("t1");
        post4.addPostTag("t2");

        blog.getContents().forEach(e-> System.out.println(e.getTitle()));

        System.out.println("------");
        ArrayList<String> tags = new ArrayList<>();

//        tags.add("t1");
        tags.add("t1");
//        tags.add("t2");
        blog.setAuthor("a2");
        blog.setTags(tags);
        blog.getContents().forEach(e-> System.out.println(e.getTitle()));
        System.out.println("------");

        tags.add("t1");
//        tags.add("t2");
        blog.setAuthor(null);
        blog.setTags(null);
        blog.getContents().forEach(e-> System.out.println(e.getTitle()));
        System.out.println("------");
//        tags.add("t1");

        blog.setSortType(BlogHost.SortType.DESCENDINGPOST);
        blog.getContents().forEach(e-> System.out.println(e.getTitle()));
        System.out.println("------");

        blog.setSortType(null);
        blog.setAuthor(null);
        blog.setTags(null);
        blog.getContents().forEach(e-> System.out.println(e.getTitle()));
        System.out.println("------");

        blog.setTitle("a2", "3", "7");
        blog.getContents().forEach(e-> System.out.println(e.getTitle()));
        System.out.println("------");
        blog.setSortType(BlogHost.SortType.ASCENDINGMODIFY);
        blog.getContents().forEach(e-> System.out.println(e.getTitle()));

        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
    }
}
