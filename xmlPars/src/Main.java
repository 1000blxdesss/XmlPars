import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

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
        //private String currency;

        private List<Reviews> reviews;

        private List<String> awards;


        public Book(String id, String title, String author, String year, String genre, String price, String language, List<String> awards) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.year = year;
            this.genre = genre;
            this.price = price;
            this.language = language;
            this.awards = awards;

            //this.currency = currency;
        }

        public Book() {
        }


        public String getId() {
            return id;
        }

        public void setAwards(List<String> awards) {
            this.awards = awards;
        }

        public List<String> getAwards() {
            return awards;
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
                    '\t' + "Award:" + awards + '\n'
                    ;
        }
    }

    static class Reviews  {
        public Reviews() {

        }//extends Book

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

        private String user;
        private String rating;
        private String comment;

        public Reviews(String user, String rating, String comment) {
            this.user = user;
            this.rating = rating;
            this.comment = comment;
        }

//    public Reviews(String id, String title, String author, String year, String genre, String price, String language, String currency) {
//        super(id, title, author, year, genre, price, language, currency);
//    }

        @Override
        public String toString(){
            return "user:"+user+'\n'+"rating:"+rating+'\n'+"comment:"+comment+'\n';
        }
    }

}



public class Main {

    /**
     * BOOK SECTION
     */

    public static String info(String path) throws IOException{
        //Pattern pattern = Pattern.compile(">(.*?)</");
        //Matcher matcher = pattern.matcher();
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line;
//                id = book2.getId(),
//                title = book2.getTitle(),
//                author = book2.getAuthor(),
//                year = book2.getYear(),
//                genre = book2.getGenre(),
//                price = book2.getPrice(),
//                language = book2.getLanguage(),
//
//
//
//
        Lib.Book book2 = new Lib.Book();
        Lib.Reviews reviews = new Lib.Reviews();
//        while ((line = reader.readLine()) != null) {
//            String temp = line;
//            id = line.contains("id") ? temp.replace("<book id=","").replace(">","") : id; //Pattern.compile("<id>(.*?)</id>").matcher(line)
//            title = line.contains("title") ? temp.replace("<title>","").replace("</title>","") : title;
//            author = line.contains("author") ? temp.replace("<author>","").replace("</author>","") : author;
//            year = line.contains("year") ? temp.replace("<year>","").replace("</year>","") : year;
//            genre = line.contains("genre") ? temp.replace("<genre>","").replace("</genre>","") : genre;
//            price = line.contains("price") ? temp.replace("<price currency=","").replace("</price>","") : price;
//            language = line.contains("language") ? temp.replace("<language>","").replace("</language>","") : language;
//            //*\\
//            ;; user = line.contains("user") ? temp.replace("<user>","").replace("</user>","") : user;
//            ;; rating = line.contains("rating") ? temp.replace("<rating>","").replace("</rating>","") : rating;
//            ;; comment = line.contains("comment") ? temp.replace("<comment>","").replace("</comment>","") : comment;
//            ;; award = line.contains("award") ? temp.replace("<award>","").replace("</award>","") : award;
//            if (line.contains("</book>")) {
//                if (!id.isEmpty()) {
//                    Book book = new Book(id,title,author,year,genre,price,language);
//                    Reviews Reviews = new Reviews(user,rating,comment);
//                    Awards awards = new Awards(award);
//                    out.println(book);
//
//                    if (!user.isEmpty())out.println(Reviews);
//                    if (!award.isEmpty())out.println(awards);
//                }
//            }
//        }


            //currency = line.contains("currency") ? line.replace("<price currency=","").replace("</price>","") : currency;
//            Book book = new Book(id,title,author,year,genre,price,language,currency);
//            out.println(book);
//           String results = switch (line) {
//               case "<library>" ->  line;
//               default -> "";
//           };
//            out.println(results);

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
            } else if (line.contains("<user>")) {
                reviews.setUser(line.replaceAll("<user>", "").replaceAll("</user>", ""));
            } else if (line.contains("<rating>")) {
                reviews.setRating(line.replaceAll("<rating>", "").replaceAll("</rating>", ""));
            } else if (line.contains("<comment>")) {
                reviews.setComment(line.replaceAll("<comment>", "").replaceAll("</comment>", ""));
            } else if (line.contains("<award>")) {
                 book2.setAwards(Collections.singletonList(line.replaceAll("<award>", "").replaceAll("</award>", "")));
            } else if (line.contains("</book>")) {


                out.println(book2);
               out.println(reviews);
               // if (!user.isEmpty()) out.println(reviews);


            }
        }



        reader.close();
    return "+";
    }

    public static void main(String[] args) throws IOException {
        out.println(info("random_structure_29.xml"));

    }
}
//<!DOCTYPE library [
//<!ELEMENT library (book)*>
//<!ELEMENT book (title|author|year|genre|price|language|format|reviews|awards)*>
//<!ATTLIST book
//        id CDATA #REQUIRED>
//<!ELEMENT title (#PCDATA)>
//<!ELEMENT author (#PCDATA)>
//<!ELEMENT year (#PCDATA)>
//<!ELEMENT genre (#PCDATA)>
//<!ELEMENT price (#PCDATA)>
//<!ATTLIST price
//        currency CDATA #REQUIRED>
//<!ELEMENT language (#PCDATA)>
//<!ELEMENT format (#PCDATA)>
//<!ELEMENT reviews (review)*>
//<!ELEMENT review (user|rating|comment)*>
//<!ELEMENT user (#PCDATA)>
//<!ELEMENT rating (#PCDATA)>
//<!ELEMENT comment (#PCDATA)>
//<!ELEMENT awards (award)*>
//<!ELEMENT award (#PCDATA)>
//]>
