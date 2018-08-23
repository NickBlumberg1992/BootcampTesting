package de.otto.customer;

import de.otto.article.Article;

import java.lang.reflect.Array;
import java.util.*;

public class Customer {
    private static int customerCount = 0;
    private String name;
    private int age;
    private Creditcard creditcard;
    private Set<String> wishlist;

    private Map<String, List<String>> boughtArticlesPerCategory;

    public Customer(String name, int age, Creditcard creditcard) {
        this.name = name;
        this.age = age;
        this.creditcard = creditcard;
        this.wishlist = new HashSet<>();
        this.boughtArticlesPerCategory = new HashMap<>();

        customerCount++;
    }

    public static void resetCustomerCount() {
        customerCount = 0;
    }

    public static int getCustomerCount() {
        return customerCount;
    }

    public Map<String, List<String>> getBoughtArticlesPerCategory() { return boughtArticlesPerCategory; }

    public int getWishlistSize() {
        return wishlist.size();
    }

    public boolean addToWishlist(String articleNumber) {
        if (wishlist.contains(articleNumber)) {
            return false;
        } else {
            wishlist.add(articleNumber);
            return true;
        }
    }

    public boolean isFullAged() {
        return age >= 18;
    }

    public String getName() {
        return name;
    }

    public boolean buy(Article article) {
        if (boughtArticlesPerCategory.get(article.getCategory()) == null) {
            ArrayList<String> articles = new ArrayList<>();
            articles.add(article.getNumber());
            boughtArticlesPerCategory.put(article.getCategory(), articles);
        } else {
            boughtArticlesPerCategory.get(article.getCategory()).add(article.getNumber());
        }
        return false;
    }

    public boolean isValid() {
        if (isFullAged()) {
            if (creditcard == null || creditcard.getNumber().isEmpty()) {
                return false;
            } else { return true; }}
        else { return false; }
    }
}