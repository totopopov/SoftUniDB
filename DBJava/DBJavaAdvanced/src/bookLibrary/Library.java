package bookLibrary;

import java.util.*;

public class Library {
   private String name;
   private List<Book> booksList;

    public Library(String name) {
        this.name = name;
        this.booksList=new ArrayList<>();
    }

    public void tsbpba(){
        Map<String,Double> theData= new HashMap<>();

        for (Book book : this.booksList) {
            if (theData.containsKey(book.getAuthor())){
                theData.put(book.getAuthor(),theData.get(book.getAuthor()) + book.getPrice());
            } else {
                theData.put(book.getAuthor(),book.getPrice());
            }
        }

        theData.entrySet().stream().sorted((b1,b2)->b1.getKey().compareTo(b2.getKey()))
                .sorted((b1,b2)->b2.getValue().compareTo(b1.getValue()))
                .forEach(b-> System.out.println(String.format("%s -> %.2f",b.getKey(),b.getValue())));

    }

    public void addbook(Book book){
        this.booksList.add(book);
    }
}
