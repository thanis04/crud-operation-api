package test.crudoperationapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "test_user")
public class UserDetail  {

    @Id
    private String user_name;
    private String password;
    private String full_name;
    private String mobile_no;
    private String nic;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String created_date;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String updates_date;
}


