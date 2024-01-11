package org.technous.bloggingApp.service.impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.technous.bloggingApp.dto.UserDTO;
import org.technous.bloggingApp.exception.ResourceNotFoundException;
import org.technous.bloggingApp.models.User;
import org.technous.bloggingApp.repository.UserRepository;
import org.technous.bloggingApp.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    private User dtoToUser(UserDTO userDTO)
    {
       User user=this.modelMapper.map(userDTO,User.class);
//       user.setId(userDTO.getId());
//       user.setName(userDTO.getName());
//       user.setEmail(userDTO.getEmail());
//       user.setPassword(userDTO.getEmail());
//       user.setAbout(userDTO.getAbout());
        return user;
    }
    private UserDTO userToDto(User user)
    {
        UserDTO userDTO=this.modelMapper.map(user,UserDTO.class);
//        userDTO.setId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setAbout(user.getAbout());
//        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User u1=this.dtoToUser(userDTO);
        User save=userRepository.save(u1);
        return userToDto(u1);
    }
    @Override
    public UserDTO updateUser(UserDTO userDTO, int userId) {
        User u1=userRepository.findById(userId)
                .orElseThrow((()->new ResourceNotFoundException("not found","ID",userId)));
        u1.setName(userDTO.getName());
        u1.setEmail(userDTO.getEmail());
        u1.setPassword(userDTO.getPassword());
        u1.setAbout(userDTO.getAbout());
        User updateUser=userRepository.save(u1);
        return userToDto(updateUser);
    }
    @Override
    public UserDTO getUserById(int userId) {
        User u1=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user not found","Id",userId));

        return userToDto(u1);
    }
    @Override
    public List<UserDTO> getAllUser() {
       List<User> users= userRepository.findAll();
       List<UserDTO> u1= users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return u1;
    }
    @Override
    public void deleteUser(int userId) {
        User user=userRepository.findById(userId)
                        .orElseThrow(()->new ResourceNotFoundException("This User Not Here","Id",userId));
        userRepository.delete(user);
    }
}
