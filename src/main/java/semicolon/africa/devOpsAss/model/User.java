package semicolon.africa.devOpsAss.model;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class User {
    @Id
    private Long id;
    private String email;
    private String password;


}
