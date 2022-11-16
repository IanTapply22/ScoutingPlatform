package me.iantapply.scoutingPlatform.utilities;

import javax.transaction.Transactional;

import me.iantapply.scoutingPlatform.data.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Integer> {

    boolean existsByUsername(String username);

    UserData findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);

}
