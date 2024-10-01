import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import static java.lang.System.out;

class Book {
    private String id;
    private String title;
    private String author;
    private String year;
    private String genre;
    private String price;
    private String language;
    //private String currency;
    public Book(String id, String title, String author, String year, String genre, String price, String language) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.price = price;
        this.language = language;

        //this.currency = currency;
    }

    @Override
    public String toString(){
        return "Book id:"+id+'\n' +'\t'+"Title:"+title +'\n' +'\t'+"Author:"+author +'\n' +'\t'+"Year:"+year +'\n' +'\t'+"Genre:"+genre +'\n' +'\t'+"Price:"+price +'\n' +'\t'+"Language:"+language +'\n';
    }
}

class Reviews  {//extends Book
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

class Awards  { //extends Reviews
    private String award;

    public Awards(String award) {
        this.award = award;
    }

//    public Awards(String id, String title, String author, String year, String genre, String price, String language, String currency) {
//        super(id, title, author, year, genre, price, language, currency);
//    }
    @Override
    public String toString(){
        return "award:"+award+'\n';
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
        String line,id = "",title = "",author = "",year = "",genre = "",price = "",language = "",user = "",rating = "",comment = "",award = "";

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

                id = line.replaceAll("<book id=\"", "").replaceAll("\">", "");
            } else if (line.contains("<title>")) {
                title = line.replaceAll("<title>", "").replaceAll("</title>", "");
            } else if (line.contains("<author>")) {
                author = line.replaceAll("<author>", "").replaceAll("</author>", "");
            } else if (line.contains("<year>")) {
                year = line.replaceAll("<year>", "").replaceAll("</year>", "");
            } else if (line.contains("<genre>")) {
                genre = line.replaceAll("<genre>", "").replaceAll("</genre>", "");
            } else if (line.contains("<price currency=")) {
                price = line.replaceAll("<price currency=\"[^\"]*\">", "").replaceAll("</price>", "");
            } else if (line.contains("<language>")) {
                language = line.replaceAll("<language>", "").replaceAll("</language>", "");
            } else if (line.contains("<user>")) {
                user = line.replaceAll("<user>", "").replaceAll("</user>", "");
            } else if (line.contains("<rating>")) {
                rating = line.replaceAll("<rating>", "").replaceAll("</rating>", "");
            } else if (line.contains("<comment>")) {
                comment = line.replaceAll("<comment>", "").replaceAll("</comment>", "");
            } else if (line.contains("<award>")) {
                award = line.replaceAll("<award>", "").replaceAll("</award>", "");
            } else if (line.contains("</book>")) {
                Book book = new Book(id, title, author, year, genre, price, language);
                Reviews reviews = new Reviews(user, rating, comment);
                Awards awards = new Awards(award);

                out.println(book);
                if (!user.isEmpty()) out.println(reviews);
                if (!award.isEmpty()) out.println(awards);


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