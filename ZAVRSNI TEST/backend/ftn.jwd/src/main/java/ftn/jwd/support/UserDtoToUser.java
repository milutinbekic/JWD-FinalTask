package ftn.jwd.support;

import ftn.jwd.model.User;
import ftn.jwd.service.UserService;
import ftn.jwd.web.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserDtoToUser implements Converter<UserDTO, User> {

    @Autowired
    private UserService userService;


    @Override
    public User convert(UserDTO userDTO) {
        User user = null;
        if(userDTO.getId() != null) {
            user = userService.findOne(userDTO.getId()).get();
        }

        if(user == null) {
            user = new User();
        }

        user.setUserName(userDTO.getUserName());
        user.setEMail(userDTO.getEMail());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());

        return user;
    }

}
