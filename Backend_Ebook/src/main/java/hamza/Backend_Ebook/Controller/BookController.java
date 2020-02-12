package hamza.Backend_Ebook.Controller;

import hamza.Backend_Ebook.Dao.BookDao;
import hamza.Backend_Ebook.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookDao bookDao;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> l = bookDao.findAll();
        return new ResponseEntity<List<Book>>(l, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {

        if (bookDao.deleteByID(id) == null) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<Void> addNewBook(@Valid @RequestBody Book book) {

        if (bookDao.save(book) == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
