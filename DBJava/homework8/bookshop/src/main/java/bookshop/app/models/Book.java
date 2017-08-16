package bookshop.app.models;

import org.omg.CORBA.PERSIST_STORE;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "books")
public class Book {

    private Long id;
    private String title;
    private String description;
    private EditionType editionType;
    private BigDecimal price;
    private Long copies;
    private Date releaseDate;
    private AgeRestriction ageRestriction;
    private Author author;
    private Set<Category> categories;
    private Set<Book> relatedBooks;


    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(columnDefinition = "TEXT(1000)",nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //columnDefinition = "ENUM('NORMAL', 'PROMO', 'GOLD')"
    @Column(name = "edition_type",nullable = false)
    @Enumerated(EnumType.STRING)
    public EditionType getEditionType() {
        return editionType;
    }


    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(nullable = false)
    public Long getCopies() {
        return copies;
    }

    public void setCopies(Long copies) {
        this.copies = copies;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Column(name = "age_restriction",nullable = false)
    @Enumerated(EnumType.STRING)
    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction  ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @ManyToOne()
    @JoinColumn(name = "author_id",referencedColumnName = "author_id",nullable = false)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToMany()
    @JoinTable(name = "books_categories",joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name = "category_id",referencedColumnName = "id"))
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "related_books",
            joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "related_id",referencedColumnName = "id"))
    public Set<Book> getRelatedBooks() {
        return relatedBooks;
    }

    public void setRelatedBooks(Set<Book> relatedBooks) {
        this.relatedBooks = relatedBooks;
    }
}
