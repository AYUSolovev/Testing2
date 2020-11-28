package application.model.User;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "adm_users")
public class AdmUser extends User{
    public AdmUser() {
    }
}