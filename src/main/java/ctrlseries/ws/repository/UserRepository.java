package ctrlseries.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ctrlseries.ws.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
