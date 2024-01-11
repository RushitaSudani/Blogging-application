package org.technous.bloggingApp.service;
import org.technous.bloggingApp.dto.UserDTO;
import org.technous.bloggingApp.models.User;
import java.util.List;

public interface UserService {
        UserDTO createUser(UserDTO user);
        UserDTO updateUser(UserDTO user,int userId);
        UserDTO getUserById(int userId);
        List<UserDTO> getAllUser();
        void deleteUser(int Userid);
}
