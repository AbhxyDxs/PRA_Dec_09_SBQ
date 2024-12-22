import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Book{
	String title;
	String author;
	int pages;
	Book(String t,String a,int p){
		title = t;
		author = a;
		pages = p;
	}
}
class Library{
	String libraryName;
	List<Book> books;
	Library(String ln,List<Book> b){
		libraryName = ln;
		books = b;
	}
}
public class LibraryBooks {
	public static void main(String args[]) {
		Scanner SC = new Scanner(System.in);
		System.out.println("Enter No of Libraries: ");
		int n = SC.nextInt();SC.nextLine();
		List<Library> lib= new ArrayList<>();
		for (int i=0;i<n;i++) {
			System.out.println("Enter Library Name: ");
			String lN = SC.nextLine();
			System.out.println("Enter No of Books: ");
			int nB = SC.nextInt();SC.nextLine();
			List<Book> LBooks = new ArrayList<>();
			for(int j=0;j<nB;j++) {
				System.out.println("Enter Book Title: ");
				String bT = SC.nextLine();
				System.out.println("Enter Author: ");
				String a = SC.nextLine();
				System.out.println("Enter No of Pages: ");
				int p = SC.nextInt();SC.nextLine();
				LBooks.add(new Book(bT,a,p));
			}
			lib.add(new Library(lN,LBooks));
		}
		System.out.println("Enter Author to Search: ");
		String searchAuthor = SC.nextLine();
		System.out.println("Enter Library to Sort: ");
		String sortLib = SC.nextLine();
		List<String >res1 = booksOfAuthor(lib, searchAuthor);
		List<Book> res2 = sortBooksByPages(lib, sortLib);
		if(!res1.isEmpty()) {
			System.out.println("Books of Author : "+searchAuthor);
			System.out.println(String.join(", ", res1));
		}else {
			System.out.println("No Books Found!");
		}
		if(!res2.isEmpty()) {
			System.out.println("Sorted Books");
			for(Book b: res2) {
				System.out.println("Name : "+b.title);
				System.out.println("Pages: "+b.pages);
			}
		}else {
			System.out.println("Nothing to sort!");
		}
	}
	public static List<String> booksOfAuthor(List<Library> lib,String authName){
		List<String> books = new ArrayList<>();
		for(Library L:lib) {
			for(Book B:L.books) {
				if(B.author.equalsIgnoreCase(authName)) {
					books.add(B.title);
				}
			}
		}
		return books;
	}
	public static List<Book> sortBooksByPages(List<Library> lib,String libName){
		List<Book> sortedBooks = new ArrayList<>();
		for(Library L:lib) {
			if(L.libraryName.equalsIgnoreCase(libName)) {
				sortedBooks.addAll(L.books);
			}
		}
		//Sorting using lambda function
		sortedBooks.sort((book1,book2) -> Integer.compare(book1.pages, book2.pages));
		//Sorting using Comparator
//		Collections.sort(sortedBooks,Comparator.comparingInt(book->book.pages));
		return sortedBooks;
	}
}
