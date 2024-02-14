package org.technous.bloggingApp.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technous.bloggingApp.dto.UserDTO;
import org.technous.bloggingApp.models.User;
import org.technous.bloggingApp.service.UserService;
import org.technous.bloggingApp.util.ApiResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    //POST
    @PostMapping("createuser")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO)
    {
        UserDTO u1=userService.createUser(userDTO);
        return new ResponseEntity<>(u1, HttpStatus.CREATED);
    }
    //GET
    @GetMapping("/getalluser")
    public List<UserDTO> getAllUser()
    {
        List<UserDTO> userDTO=  userService.getAllUser();
        return userDTO;
    }
    //GET by ID
    @GetMapping("getbyid/{userId}")
    public ResponseEntity<UserDTO> getById(@PathVariable("userId") int userId)
    {
        UserDTO u1=userService.getUserById(userId);
        return new ResponseEntity<>(u1,HttpStatus.FOUND);
    }
    //PUT
    @PutMapping("updateuser/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable("userId") int userId)
    {
        UserDTO u1=userService.updateUser(userDTO,userId);
        return new ResponseEntity<>(u1,HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("deletebyid/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId)
    {
            userService.deleteUser(userId);
            return new ResponseEntity(Map.of("message","user deleted succssfully"), HttpStatus.OK);
    }
    //Deleted with response
    @DeleteMapping("delete/{userId}")
    public ApiResponse delete(@PathVariable("userId") int userId)
    {
        userService.deleteUser(userId);
       // return new ResponseEntity<ApiResponse>(new ApiResponse("userdeleted",200,null));
        return new ApiResponse("UserDeleted",true);
    }

}
