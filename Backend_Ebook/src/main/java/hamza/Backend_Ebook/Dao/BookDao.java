package hamza.Backend_Ebook.Dao;

import hamza.Backend_Ebook.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {
    Book getByID(int id);

    List<Book> findAll();

    Book deleteByID(int id);
    Book save(Book book);
}
