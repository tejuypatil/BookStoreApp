package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.UserLoginRequestDTO;
import com.example.bookstoreproject.dto.UserRegisterRequestDTO;
import com.example.bookstoreproject.email.EmailService;
import com.example.bookstoreproject.entity.UserData;
import com.example.bookstoreproject.exception.UserAlreadyExist;
import com.example.bookstoreproject.exception.UserOrPasswordWrong;
import com.example.bookstoreproject.repository.UserRepository;
import com.example.bookstoreproject.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@Service
public class UserService implements IUserService
{
    @Autowired
    TokenUtility tokenUtility;
    @Autowired
    public UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Override
    public UserData registerUser(UserRegisterRequestDTO userRegisterRequestDTO){
        try {
            UserData userData = new UserData(userRegisterRequestDTO);
            userData = userRepository.save(userData);
            emailService.sendEmail(userData.getEmail(),"User registration successful","Hi "+userData.getFirstName()+" \nYour user successfully registered with BookStore App");
            return userData;
        }
        catch (DataIntegrityViolationException exception) {
            throw new UserAlreadyExist(userRegisterRequestDTO);
        }

    }

    @Override
    public String login(UserLoginRequestDTO userLoginRequestDTO) {
        Optional<UserData> userDataOptional = userRepository.findByLoginId(userLoginRequestDTO.getLoginId());
        if(userDataOptional.isPresent())
        {
            String passwordInDatabase = userDataOptional.get().getPassword();
            String passwordEntered = userLoginRequestDTO.getPassword();
            if (passwordEntered.equals(passwordInDatabase))
            {
                System.out.println("Login Successful");
                String token = tokenUtility.createToken(userDataOptional.get().getUserId());
                return token;
            }
            else
            {
                throw new UserOrPasswordWrong(userLoginRequestDTO.getLoginId());
            }
        }
        else
        {
            throw new UserOrPasswordWrong(userLoginRequestDTO.getLoginId());
        }
    }
}
