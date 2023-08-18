package test.crudoperationapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.crudoperationapi.entity.UserDetail;


public interface UserRepository extends JpaRepository<UserDetail, String> {

    @Query("select u from UserDetail u where u.user_name = :user_name")
    UserDetail findByUserName(@Param("user_name") String name);
}
