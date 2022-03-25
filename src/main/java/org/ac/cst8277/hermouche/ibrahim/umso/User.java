package org.ac.cst8277.hermouche.ibrahim.umso;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userid;
    private String userfirstname;
    private String userlastname;
    private String useremailaddress;
    private String dateregistered;
    private Integer userrole;
    private Integer userlastseen;

    public Integer getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUserrole(Integer userrole) {
        this.userrole = userrole;
    }

    public void setUserlastseen(Integer userlastseen) {
        this.userlastseen = userlastseen;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    public String getUseremailaddress() {
        return useremailaddress;
    }

    public void setUseremailaddress(String useremailaddress) {
        this.useremailaddress = useremailaddress;
    }

    public String getDateregistered() {
        return dateregistered;
    }

    public void setDateregistered(String dateregistered) {
        this.dateregistered = dateregistered;
    }

    public int getUserrole() {
        return userrole;
    }



}
