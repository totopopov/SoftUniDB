package bookshop.app.service.impl;

import bookshop.app.models.AgeRestriction;

import bookshop.app.models.Book;
import bookshop.app.models.EditionType;
import bookshop.app.repository.BookRepository;
import bookshop.app.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 25.7.2017 г. at 17:03.
 */

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void register(Book book){
        bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> findBookByReleaseDateYearAFter(int year) {
        return bookRepository.findBookByReleaseDateYearAFter(year);
    }

    @Override
    public List<Book> findBooksByAuthorOrdered(String firstName,String lastName) {
        return this.bookRepository.findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName,lastName);
    }

    @Override
    public List<Book> findall() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Object> findAllBooksByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllBooksByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Object> findAllBooksByTypeAndCopies(EditionType editionType, Long copies) {
        return this.bookRepository.findAllBooksByTypeAndCopies(editionType,copies);
    }

    @Override
    public List<Object[]> findAllBooksByPriceBound(BigDecimal low, BigDecimal high) {
        return this.bookRepository.findAllBooksByPriceBound(low,high);
    }

    @Override
    public List<Object> findAllNotReleasedOn(int yearOfRelease) {
        return this.bookRepository.findAllNotReleasedOn(yearOfRelease);
    }

    @Override
    public List<Object> findAllByCateriesList(String[] categories) {
        return this.bookRepository.findAllByCateriesList(categories);
    }

    @Override
    public List<Object[]> getAllBooksBeforeDate(Date date) {
        return this.bookRepository.getAllBooksBeforeDate(date);
    }

    @Override
    public List<Book> findAllByTitleIgnoreCaseContaining(String title) {
        return this.bookRepository.findAllByTitleIgnoreCaseContaining(title);
    }

    @Override
    public List<Book> findAllByAuthorLastNameIgnoreCaseStartingWith(String author_lastName) {
        return this.bookRepository.findAllByAuthorLastNameIgnoreCaseStartingWith(author_lastName);
    }

    @Override
    public Integer countBookByLengthTitleGreaterThan(Integer lenght) {
        return this.bookRepository.countBookWithTitleGreaterThan(lenght);
    }

    @Override
    public List<Object[]> findBookByTitle(String title) {
        return this.bookRepository.findBookByTitle(title);
    }

    @Override
    public Integer increseCopiesOfBooksAfter(Date date, Long copies) {
        return this.bookRepository.increseCopiesOfBooksAfter(date,copies);
    }

    @Override
    public Integer deleteAllByCopiesLessThan(Long copies) {
        return this.bookRepository.deleteAllByCopiesLessThan(copies);
    }


}
