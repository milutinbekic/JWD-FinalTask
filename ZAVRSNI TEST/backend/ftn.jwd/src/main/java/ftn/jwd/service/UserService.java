package ftn.jwd.service;

import ftn.jwd.model.User;
import ftn.jwd.web.dto.UserChangePasswordDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findOne(Long id);

    List<User> findAll();

    Page<User> findAll(int numberOfPage);

    User save(User user);

    void delete(Long id);

    Optional<User> findbyUserName(String UserName);

    boolean changePassword(Long id, UserChangePasswordDto userChangePasswordDto);
}
