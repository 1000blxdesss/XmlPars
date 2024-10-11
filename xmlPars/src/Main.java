import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

class Lib {
    static class Book {

        private String id;
        private String title;
        private String author;
        private String year;
        private String genre;
        private String price;
        private String language;

        private List<Reviews> reviews = new ArrayList<>();
        private List<String> awards = new ArrayList<>();

        public List<Reviews> getReviews() {
            return reviews;
        }

        public void addReviewUser(String user) {
            this.reviews.add(new Reviews());
            this.reviews.get(this.reviews.size() - 1).setUser(user);
        }

        public void addReviewRating(String rating) {
            if (!this.reviews.isEmpty()) {
                this.reviews.get(this.reviews.size() - 1).setRating(rating);
            }
        }

        public void addReviewComment(String comment) {
            if (!this.reviews.isEmpty()) {
                this.reviews.get(this.reviews.size() - 1).setComment(comment);
            }
        }

        public void addAward(String award) {
            this.awards.add(award);
        }

        public List<String> getAwards() {
            return awards;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        @Override
        public String toString() {
            return "Book id:" + id + '\n' +
                    '\t' + "Title:" + title + '\n' +
                    '\t' + "Author:" + author + '\n' +
                    '\t' + "Year:" + year + '\n' +
                    '\t' + "Genre:" + genre + '\n' +
                    '\t' + "Price:" + price + '\n' +
                    '\t' + "Language:" + language + '\n' +
                    '\t' + "Awards:" + awards + '\n' +
                    '\t' + "Reviews:" + reviews + '\n';
        }
    }

    static class Reviews {

        private String user;
        private String rating;
        private String comment;

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        @Override
        public String toString() {
            return "user:" + user + '\n' +
                    "rating:" + rating + '\n' +
                    "comment:" + comment + '\n';
        }
    }
}

public class Main {

    public static String info(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        Lib.Book book2 = new Lib.Book();
        boolean inReview = false;

        while ((line = reader.readLine()) != null) {
            if (line.contains("<book id=")) {
                book2.setId(line.replaceAll("<book id=\"", "").replaceAll("\">", ""));
            } else if (line.contains("<title>")) {
                book2.setTitle(line.replaceAll("<title>", "").replaceAll("</title>", ""));
            } else if (line.contains("<author>")) {
                book2.setAuthor(line.replaceAll("<author>", "").replaceAll("</author>", ""));
            } else if (line.contains("<year>")) {
                book2.setYear(line.replaceAll("<year>", "").replaceAll("</year>", ""));
            } else if (line.contains("<genre>")) {
                book2.setGenre(line.replaceAll("<genre>", "").replaceAll("</genre>", ""));
            } else if (line.contains("<price currency=")) {
                book2.setPrice(line.replaceAll("<price currency=\"[^\"]*\">", "").replaceAll("</price>", ""));
            } else if (line.contains("<language>")) {
                book2.setLanguage(line.replaceAll("<language>", "").replaceAll("</language>", ""));
            } else if (line.contains("<award>")) {
                book2.addAward(line.replaceAll("<award>", "").replaceAll("</award>", ""));
            } else if (line.contains("<reviews>")) {
                inReview = true;
            } else if (line.contains("</reviews>")) {
                inReview = false;
            } else if (inReview) {
                if (line.contains("<user>")) {
                    book2.addReviewUser(line.replaceAll("<user>", "").replaceAll("</user>", ""));
                } else if (line.contains("<rating>")) {
                    book2.addReviewRating(line.replaceAll("<rating>", "").replaceAll("</rating>", ""));
                } else if (line.contains("<comment>")) {
                    book2.addReviewComment(line.replaceAll("<comment>", "").replaceAll("</comment>", ""));
                }
            } else if (line.contains("</book>")) {
                out.println(book2);
            }
        }
        reader.close();
        return "+";
    }

    public static void main(String[] args) throws IOException {
        out.println(info("random_structure_29.xml"));
    }
}
