package com.gik.testsProject.gik.lambda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;

final class CommentUtils {
    /**
     * An example string that fits the format "15-03-2020 10:20:34".
     * Use it to print the comments.
     */
    public static final SimpleDateFormat TEXT_FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private CommentUtils() { }

    /**
     * It processes a given list of comments by removing old comments and shortening the text length
     */
    public static void handleComments(List<Comment> comments, Date thresholdDate, int maxTextLength) {
        // write your code here
        comments.removeIf(n -> n.getCreated().compareTo(thresholdDate) > 0);

       comments.replaceAll(n -> new Comment(n.getCreated(),
               n.getText().substring(0,
                       Math.min(n.getText().length(), maxTextLength))));
    }

    /**
     * It prints each comment in the following format:
     * [14-03-2020 10:20:34] What a beautiful photo! Where is it?
     * [16-03-2020 15:35:18] I do not know, I just found it on the internet!
     * [20-03-2020 19:10:22] Is anyone here?
     * Please, use the formatter above to fit the format.
     */
    public static void printComments(List<Comment> comments) {
        // write your code here
        comments.forEach(
               n -> {
                   try {
                       System.out.println("["+CommentUtils.TEXT_FORMATTER.format(n.getCreated()) + "] " +n.getText());
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
        );
    }
}

class Comment {
    private final Date created;
    private final String text;

    public Comment(Date created, String text) {
        this.created = created;
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public String getText() {
        return text;
    }
}
