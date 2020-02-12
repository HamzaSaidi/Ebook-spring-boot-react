package hamza.Backend_Ebook.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Book  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String Title;
    private String Description;
    private String Author;

    public Book(String title, String description, String author) {
        Title = title;
        Description = description;
        Author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ID == book.ID &&
                Objects.equals(Title, book.Title) &&
                Objects.equals(Description, book.Description) &&
                Objects.equals(Author, book.Author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Title, Description, Author);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getAuthor() {
        return Author;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}
