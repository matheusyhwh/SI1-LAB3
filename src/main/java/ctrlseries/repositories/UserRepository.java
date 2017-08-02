package ctrlseries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ctrlseries.objects.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
