package com.example.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // JpaRepository provides basic CRUD operations out of the box
    @Component
    public class BookApp implements CommandLineRunner {

        @Autowired
        private BookRepository bookRepository;

        @Override
        public void run(String... args) throws Exception {
            // Sample data initialization
            Book book = new Book();
            book.setTitle("The Great Gatsby");
            book.setAuthor("F. Scott Fitzgerald");
            book.setPrice(10.99);
            bookRepository.save(book);
            
            // bookRepository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99));
            // bookRepository.save(new Book("To Kill a Mockingbird", "Harper Lee", 8.99));
            // bookRepository.save(new Book("1984", "George Orwell", 9.99));
        }
    }
}