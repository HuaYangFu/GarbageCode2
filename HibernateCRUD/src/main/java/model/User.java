package model;

/**
 * Created by 傅華暘 on 2016/9/26.
 */
import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO) //for autonumber
    private int userid;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date dob;
    @Column
    private String email;
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "User [userid=" + userid + ", firstName=" + firstName
                + ", lastName=" + lastName + ", dob=" + dob + ", email="
                + email + "]";
    }


}
