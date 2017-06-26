package vn.nguyen.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.nguyen.entity.Role;

public interface IRoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);


}
