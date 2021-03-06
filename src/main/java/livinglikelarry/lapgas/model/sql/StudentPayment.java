package livinglikelarry.lapgas.model.sql;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.DbName;
import org.javalite.activejdbc.annotations.Table;


/**
 * 
 * @author Moch Deden (https://github.com/selesdepselesnul)
 *
 */
@DbName("lapgas")
@Table("student_payments")
@BelongsTo(parent = Course.class, foreignKeyName = "course_number")
public class StudentPayment extends Model {}
