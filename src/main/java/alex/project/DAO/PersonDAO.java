package alex.project.DAO;

import alex.project.models.Book;
import alex.project.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("select * from person where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("insert into person(full_name, year_of_birth, photo) values (?, ?, ?)", person.getFullName(), person.getYearOfBirth(), person.getPhoto());
    }


    public void update(int id, Person person) {
        jdbcTemplate.update("update person set full_name = ?, year_of_birth = ?, photo = ? where id = ?", person.getFullName(), person.getYearOfBirth(), person.getPhoto(), id);
    }


    public void delete(int id) {
        jdbcTemplate.update("delete from person where id = ?", id);
    }

    public Optional<Person> getPersonByFullName(String fullName) {
        return jdbcTemplate.query("select * from person where full_name=?", new Object[]{fullName}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public List<Book> getBooksByPersonId(int id){
        return jdbcTemplate.query("select * from book where person_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }
}
