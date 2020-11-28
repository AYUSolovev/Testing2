package application.model.User;

import javax.persistence.*;

@Entity
@Table(name = "normal_users")
public class NormalUser extends User{
    public NormalUser(){
    }
}
