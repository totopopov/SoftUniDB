package bookshop.app.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 16:40.
 */

@Entity
@Table(name = "categories")
public class Category {

    private Long id;
    private String name;
    private Set<Book> books;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "categories",targetEntity = Book.class,fetch = FetchType.EAGER)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
