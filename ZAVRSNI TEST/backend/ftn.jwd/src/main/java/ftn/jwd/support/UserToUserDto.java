package ftn.jwd.support;
import ftn.jwd.model.User;
import ftn.jwd.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserDto implements Converter<User, UserDTO>{


    @Override
    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setEMail(user.getEMail());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setUserName(user.getUserName());

        return userDTO;
    }

    public List<UserDTO> convert(List<User> korisnici){
        List<UserDTO> userDTOS = new ArrayList<>();

        for(User k : korisnici) {
            UserDTO dto = convert(k);
            userDTOS.add(dto);
        }

        return userDTOS;
    }
}
