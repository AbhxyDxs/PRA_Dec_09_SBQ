import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Book{
    int bookID;
    String title;
    String author;
    double price;
    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Book(int bookID, String title, String author, double price) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

class Library{
    int libraryID;
    String libraryName;
    ArrayList<Book> books;
    public int getLibraryID() {
        return libraryID;
    }
    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }
    public String getLibraryName() {
        return libraryName;
    }
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    public Library(int libraryID, String libraryName, ArrayList<Book> books) {
        this.libraryID = libraryID;
        this.libraryName = libraryName;
        this.books = books;
    }
}
class LibraryService{
    public ArrayList<String> searchBooksByAuthor(List<Library> L, String aName){
        ArrayList<String> bTitles = new ArrayList<>();
        for(Library Li: L){
        	for(Book b: Li.getBooks()) {
	            if(b.getAuthor().equalsIgnoreCase(aName)){
	                    if(b.getPrice()>500){
	                        bTitles.add(b.getTitle());
	                    }
	                }
	            }
        }
        return bTitles;
    }
    public Map<String,List<Book>> booksByLibrary(List<Library> L){
        TreeMap<String,List<Book>> LB = new TreeMap<>();
        for(Library Li: L){
            if(LB.containsKey(Li.getLibraryName())==false){
                LB.put(Li.getLibraryName(),Li.getBooks());
            }
        }
        return LB;
    }
}

public class LMS{
    public static void main(String args[]){
        Scanner SC = new Scanner(System.in);
        System.out.println("Enter No of Libraries: ");
        int n = SC.nextInt();SC.nextLine();
        ArrayList<Library> L = new ArrayList<>();
        for(int i =0;i<n;i++){
            System.out.println("Enter Library ID: ");
            int id = SC.nextInt(); SC.nextLine();
            System.out.println("Enter Library Name: ");
            String name = SC.nextLine();
            System.out.println("Enter No of Books: ");
            int nb = SC.nextInt();SC.nextLine();
            ArrayList<Book> B = new ArrayList<>();
            for(int j=0;j<nb;j++){
                System.out.println("Enter Book ID: ");
                int bid = SC.nextInt();SC.nextLine();
                System.out.println("Enter Book Title: ");
                String bTitle = SC.nextLine();
                System.out.println("Enter Author's Name: ");
                String aName = SC.nextLine();
                System.out.println("Enter Price: ");
                double price = SC.nextDouble();SC.nextLine();
                Book b = new Book(bid, bTitle, aName, price);
                B.add(b);
            }
            Library l = new Library(id, name, B);
            L.add(l);
        }
        System.out.println("Enter Author to Search: ");
        String sAuthor = SC.nextLine();
        LibraryService LS = new LibraryService();
        ArrayList<String> res1 = LS.searchBooksByAuthor(L, sAuthor);
        Map<String,List<Book>> res2 = LS.booksByLibrary(L);

        if(res1.size()!=0){
            String books = String.join(", ",res1);
            System.out.println("Books by Author "+sAuthor);
            System.out.println(books);
        }else{
            System.out.println("No Books");
        }
        if(res2.size()!=0){
            for(String Li: res2.keySet()){
                System.out.println(Li);
                for(Book Bo: res2.get(Li)){
                    System.out.println(Bo.getTitle()+" : "+Bo.getPrice()+" Rs");
                }
            }
        }else{
            System.out.println("No Libraries and Books");
        }
    }
}