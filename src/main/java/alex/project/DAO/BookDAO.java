package alex.project.DAO;

import alex.project.models.Book;
import alex.project.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id){
        return jdbcTemplate.query("select * from book where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void save(Book book){
        jdbcTemplate.update("insert into book(title, author, year) values (?,?,?)", book.getTitle(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book book){
        jdbcTemplate.update("update book set title=?, author=?, year=? where id=?", book.getTitle(), book.getAuthor(), book.getYear(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("delete from book where id=?", id);
    }

    public Optional<Person> getBookOwner(int id){
        return jdbcTemplate.query("select person.* from book join person on book.person_id=person.id where book.id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void release(int id){
        jdbcTemplate.update("update book set person_id=null where id=?", id);
    }

    public void assign(int id, Person person){
        jdbcTemplate.update("update book set person_id=? where id=?", person.getId(), id);
    }


}
