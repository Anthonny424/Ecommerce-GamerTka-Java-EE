
package modelo;


public class Admin {
    private int idAdmin;
    private String AdminUser;
    private String pass;

    public Admin() {
    }

    public Admin(int idAdmin, String AdminUser, String pass) {
        this.idAdmin = idAdmin;
        this.AdminUser = AdminUser;
        this.pass = pass;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getAdminUser() {
        return AdminUser;
    }

    public void setAdminUser(String AdminUser) {
        this.AdminUser = AdminUser;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
