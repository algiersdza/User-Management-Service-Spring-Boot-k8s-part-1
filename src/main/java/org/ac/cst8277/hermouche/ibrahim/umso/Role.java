package org.ac.cst8277.hermouche.ibrahim.umso;


import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleid;
    private String rolename;
    private String roledescription;


    public int getRoleid(){
        return roleid;
    }

    public  void setRoleid(int roleid){
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledescription() {
        return roledescription;
    }

    public void setRoledescription(String roledescription) {
        this.roledescription = roledescription;
    }


}
