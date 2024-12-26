import java.util.*;

public class AuthorAndBook {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int numOfAuthor = sc.nextInt();sc.nextLine();
        List<Book> books = new ArrayList<>();
        for(int i=0;i<numOfAuthor;i++){
            int authorId = sc.nextInt();sc.nextLine();
            String authorName = sc.nextLine();
            Author author = new Author(authorId, authorName);
            int bookId = sc.nextInt();sc.nextLine();
            String title = sc.nextLine();
            String genre = sc.nextLine();
            double price = sc.nextDouble();sc.nextLine();
            books.add(new Book(bookId, title, genre, price, author));
        }
        String genre1 = sc.nextLine();
        String genre2 = sc.nextLine();
        double discount = sc.nextDouble();
        Business b = new Business();
        List<Book> ans1 = b.getBooksBelongingToAGenre(books, genre1);
        if(ans1.isEmpty()){
            System.out.println("Genre is not available in the list");
        }
        else{
            for(Book bk : ans1){
                System.out.println("AuthorName: " + bk.author.authorName + ", Title: " + bk.title);
            }
        }
        System.out.println();
        List<Book> ans2 = b.calculateDiscountedPrice(books, genre2, discount);
        if(ans2.isEmpty()){
            System.out.println("Discounted books are unavailable in the given genre.");
        }
        else{
            System.out.println("Discounted " + genre2 + " Books:");
            for(Book bk : ans2){
                System.out.println("AuthorName: " + bk.author.authorName + ", Title: " + bk.title + ", Updated Price: " + bk.price);
            }
        }
    }
    
    
}
class Business{
    public List<Book> getBooksBelongingToAGenre(List<Book> books, String genre1){
        List<Book> ans1 = new ArrayList<>();
        for(Book b : books){
            if(b.genre.equalsIgnoreCase(genre1)){
                ans1.add(b);
            }
        }
        return ans1;
    }
    public List<Book> calculateDiscountedPrice(List<Book> books, String genre2, double discount){
        List<Book> ans2 = new ArrayList<>();
        for(Book b : books){
            if(b.genre.equalsIgnoreCase(genre2)){
                Double discountPrice = (b.price * (100-discount) / 100);
                b.price = discountPrice;
                ans2.add(b);
            }
        }
        return ans2;
    }
}
class Author{
    int authorId;
    String authorName;
    public Author(int authorId, String authorName){
        this.authorId=authorId;
        this.authorName=authorName;
    }
}
class Book{
    int bookId;
    String title;
    String genre;
    double price;
    Author author;
    public Book(int bookId,String title, String genre, double price, Author author){
        this.bookId=bookId;
        this.title=title;
        this.genre=genre;
        this.price=price;
        this.author=author;
    }
}