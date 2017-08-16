package bookshop.app;

import bookshop.app.models.*;
import bookshop.app.service.api.AuthorService;
import bookshop.app.service.api.BookService;
import bookshop.app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 17:09.
 */

@Component
public class Terminal implements CommandLineRunner{



    private final BookService bookService;

    private final CategoryService categoryService;

    private final AuthorService authorService;

    @Autowired
    public Terminal(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }


    @Override
    public void run(String... strings) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Database connected");

        //TASKS FROM PREVIOUS HOMEWORK

        //task 1 and task 2
        try {
            seedDatabase();
            System.out.println("Database seeded");
        }catch (IOException| ParseException e){
            System.out.println(e.getMessage());
        }

        //task 3
//        task3();

        //task 4
 //       section4();
        //TASKS FROM THIS HOMEWORK

        //gives repeating names cuz they are from different authors :) Putting distinct will solve it, however
        // I wond do it.. well I might just do it.

//       task1Titles(reader);
//
//        task2Titles();  //again the distinct thing

//        task3TitlesAndPrice();

//           task4NotReleasedBooks(reader);  //again the distinct thing


//        task5TitlesByCategories(reader);


//        task6BooksReleasedBEforeDate(reader,df);

//        task7AuthorsSearh(reader);

//        task8TitlesOfBooksContainingGivenString(reader);

//        task9BookTitleSearch(reader);

//        task10CountBooks(reader);

//        task11TotalBookCopies();

//        task12FindProfit();  //profit too big, we are millionaires

//       task13FindAllBooksWithTItles();

       task14ReducedBookInfo(reader);

//         task15IncreaseCopies(reader,df);

//        task16RemovedBooks(reader);
    }

    private void task16RemovedBooks(BufferedReader reader) throws IOException {


        Long copies=Long.parseLong(reader.readLine());

        Integer deletedBooks = this.bookService.deleteAllByCopiesLessThan(copies);

        System.out.println(String.format("%d books were deleted",deletedBooks));

    }

    private void task15IncreaseCopies(BufferedReader reader, DateFormat df) throws IOException, ParseException {

        String dateString=reader.readLine();
        df=new SimpleDateFormat("dd MMM yyyy",Locale.ENGLISH);
        Date date=df.parse(dateString);

        Long copies=Long.parseLong(reader.readLine());

        Integer booksAfter = this.bookService.increseCopiesOfBooksAfter(date, copies);

        System.out.println(booksAfter*copies);
    }

    private void task14ReducedBookInfo(BufferedReader reader) throws IOException {
        String title=reader.readLine();

        List<Object[]> bookByTitle = this.bookService.findBookByTitle(title);

        for (Object[] objects : bookByTitle) {

            System.out.println(String.format("%s %s %s %.2f",
                    objects[0],objects[1],objects[2],
                    (BigDecimal)objects[3]));


        }
    }

    private void task13FindAllBooksWithTItles() {

        List<Category> categories  = this.categoryService.findAllByCategoriesWithBooksMoreThan(35);

        Calendar calendar=Calendar.getInstance();

        for (Category category : categories) {
            System.out.println(String.format("--%s: %d books",category.getName(),category.getBooks().size()));

            category.getBooks().stream().sorted(Comparator.comparing(Book::getReleaseDate).reversed()
                    .thenComparing(Book::getTitle)).limit(3)
                    .forEach(b->{calendar.setTime(b.getReleaseDate());
                            System.out.println(String.format("%s (%s)",
                            b.getTitle(),calendar.get(Calendar.YEAR)
                            ));
                    });

//            category.getBooks().stream().sorted(Comparator.comparing(Book::getReleaseDate).reversed()
//                    .thenComparing(Book::getTitle)).limit(3)
//                    .forEach(b-> System.out.println(String.format("%s (%s)",
//                            b.getTitle(),
//                            b.getReleaseDate().getYear()>99?
//                                    String.format("20%d",b.getReleaseDate().getYear()-100):
//                                    String.format("19%d",b.getReleaseDate().getYear()))));
        }

    }

    private void task12FindProfit() {
        List<String> strings = this.categoryService.printPriceByCategory();

        for (String string : strings) {
            System.out.println(string);
        }
    }

    private void task11TotalBookCopies() {
        List<String> strings = this.authorService.printCopiesByAuthors();

        for (String string : strings) {
            System.out.println(string);
        }
    }

    private void task10CountBooks(BufferedReader reader) throws IOException {

        int size=Integer.parseInt(reader.readLine());

        System.out.println(this.bookService.countBookByLengthTitleGreaterThan(size));

    }

    private void task9BookTitleSearch(BufferedReader reader) throws IOException {
        String authroString=reader.readLine();

        List<Book> books = this.bookService.findAllByAuthorLastNameIgnoreCaseStartingWith(authroString);

        for (Book book : books) {
            System.out.println(String.format("%s (%s %s)",
                    book.getTitle(), book.getAuthor().getFirstName(),book.getAuthor().getLastName()));
        }


    }

    private void task8TitlesOfBooksContainingGivenString(BufferedReader reader) throws IOException {

        String string=reader.readLine();

        List<Book> books = this.bookService.findAllByTitleIgnoreCaseContaining(string);


        for (Book book : books) {
            System.out.println(book.getTitle());
        }

    }

    private void task7AuthorsSearh(BufferedReader reader) throws IOException {

        String author=reader.readLine();

        List<Author> authors = this.authorService.findAllByFirstNameEndingWith(author);

        for (Author currentAuthor : authors) {

            System.out.println(String.format("%s %s",currentAuthor.getFirstName()
                    ,currentAuthor.getLastName()));

        }


    }

    private void task6BooksReleasedBEforeDate(BufferedReader reader, DateFormat df) throws IOException, ParseException {
        String dateString=reader.readLine();

        Date date=df.parse(dateString);

        List<Object[]> allBooksBEforeDate = this.bookService.getAllBooksBeforeDate(date);

        for (Object[] objects : allBooksBEforeDate) {


            System.out.println(String.format("Title: %s%n  Type:%s%n  Price: $%.2f",
                    objects[0], objects[1],(BigDecimal)objects[2]));
        }


    }

    private void task5TitlesByCategories(BufferedReader reader) throws IOException {
    String[] categories=reader.readLine().split("\\s+");
        List<Object> titles=this.bookService.findAllByCateriesList(categories);

        for (Object title : titles) {
            System.out.println(title.toString());
        }


    }

    private void task4NotReleasedBooks(BufferedReader reader) throws IOException {
            int year=Integer.parseInt(reader.readLine());

        List<Object> titles=this.bookService.findAllNotReleasedOn(year);

        for (Object title : titles) {
            System.out.println(title.toString());
        }

    }

    private void task3TitlesAndPrice() {

        BigDecimal low=BigDecimal.valueOf(5);
        BigDecimal high=BigDecimal.valueOf(40);;


        List<Object[]> tokens=this.bookService.findAllBooksByPriceBound(low,high);

        for (Object[] token : tokens) {
            System.out.println(String.format("%s - $%s", token[0].toString(),token[1].toString() ));
        }

    }

    private void task2Titles() {
        String goldenBooks="golD";
        Long copies=5000L;

        EditionType editionType=EditionType.valueOf(goldenBooks.toUpperCase());

        List<Object> titles=this.bookService.findAllBooksByTypeAndCopies(editionType,copies);

        for (Object title : titles) {
            System.out.println(title.toString());
        }


    }

    private void task1Titles(BufferedReader reader) throws IOException {
        String ageRestrictionString=reader.readLine().toLowerCase();
        AgeRestriction ageRestriction=AgeRestriction.valueOf(ageRestrictionString.toUpperCase());
        List<Object> titles=this.bookService.findAllBooksByAgeRestriction(ageRestriction);

        for (Object title : titles) {
            System.out.println(title.toString());
        }

    }

    private void section4() {
        List<Book> books = (List<Book>) bookService.findall();
        List<Book> threeBooks = books.subList(0, 3);

        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(1));
        threeBooks.get(1).getRelatedBooks().add(threeBooks.get(0));
        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(2));
        threeBooks.get(2).getRelatedBooks().add(threeBooks.get(0));

        //save related books to the database

        for (Book book : threeBooks) {
            bookService.register(book);
        }

        for (Book book : threeBooks) {
            System.out.printf("--%s\n", book.getTitle());
            for (Book relatedBook : book.getRelatedBooks()) {
                System.out.println(relatedBook.getTitle());
            }
        }
    }

    private void task3() {
        List<Book> bookByReleaseDateYearAFter = bookService.findBookByReleaseDateYearAFter(2000);
        for (Book book : bookByReleaseDateYearAFter) {
            System.out.println(book.getTitle());
        }

        List<Author> authors=authorService.findAuthorsByReleaseDateBefore(1990);
        for (Author author : authors) {
            System.out.println(String.format("%s %s  with id: %d",author.getFirstName(),
                    author.getLastName(),author.getId()));
        }

        List<Author> authors1ByBook=authorService.findAllOrderByBookCount();
        for (Author author : authors1ByBook) {
            System.out.println(String.format("%s %s %d",author.getFirstName()
            ,author.getLastName(),author.getBooks().size()));
        }

        List<Book> books=bookService.findBooksByAuthorOrdered("George","Powell");

        for (Book book : books) {
            System.out.println(String.format("%s %s %d",book.getTitle(),
                    book.getReleaseDate(),book.getCopies()));
        }
    }

    private void seedDatabase() throws IOException, ParseException {

        List<Author> authors=new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        getAuthors(authors);
        getCategories(categories);
        seedBooks(authors,categories);

    }

    private void seedBooks(List<Author> authors,List<Category> categories) throws IOException, ParseException {
        Random random =new Random();
        StringBuilder sb = new StringBuilder();
        InputStream source=getClass().getResourceAsStream("/books.txt");
        BufferedReader booksReader = new BufferedReader(new InputStreamReader(source));
        String line = booksReader.readLine();
        while((line = booksReader.readLine()) != null){
            String[] data = line.split("\\s+");
            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);

            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            Long copies = Long.parseLong(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            sb.append(title).append(" written by ");
            sb.append(author.getFirstName()).append(" ");
            sb.append(author.getLastName()).append(" targeting");
            sb.append(ageRestriction.name()).append(". The style is ");
            sb.append(editionType.name()).append(". ");
            sb.append(copies).append(" were printed worldwide.");
            book.setDescription(sb.toString());
            sb.setLength(0);

            int categoryNumber = random.nextInt(categories.size());

            int categoryCount=0;

            Set<Category> categorySet = new HashSet<>();
            while (categoryCount<categoryNumber){
                Category category=categories.get(random.nextInt(categoryNumber));
                if (!categorySet.contains(category)){
                    categorySet.add(category);
                    categoryCount++;
                }
            }
            book.setCategories(categorySet);
            bookService.register(book);
        }
    }

    private void getCategories(List<Category> categories) throws IOException {
        InputStream source=getClass().getResourceAsStream("/categories.txt");
        BufferedReader categoryReader = new BufferedReader(new InputStreamReader(source));
        String categoryLIne = categoryReader.readLine();
        while((categoryLIne = categoryReader.readLine()) != null) {
            String[] data = categoryLIne.split("\\s+");

            String categoryName=data[0];

            Category category=new Category(categoryName);
            categories.add(category);
            categoryService.register(category);
        }
    }
    private void getAuthors(List<Author> authors) throws IOException {
        InputStream source=getClass().getResourceAsStream("/authors.txt");
//        BufferedReader authorsReader = new BufferedReader(new FileReader("/authors.txt"));
        BufferedReader authorsReader = new BufferedReader(new InputStreamReader(source));
        String authorLine = authorsReader.readLine();
        while((authorLine = authorsReader.readLine()) != null) {
            String[] data = authorLine.split("\\s+");

            String firstName=null;
            String secondName=null;

            if (data.length==2){
                firstName=data[0];
                secondName=data[1];
            }else {
                secondName=data[0];
            }

            Author author=new Author(firstName,secondName);
            authors.add(author);
            authorService.register(author);
        }
    }
}
