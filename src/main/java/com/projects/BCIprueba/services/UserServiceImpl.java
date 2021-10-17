package com.projects.BCIprueba.services;

import com.projects.BCIprueba.constants.ProjectConstants;
import com.projects.BCIprueba.data.models.User;
import com.projects.BCIprueba.data.payloads.repositories.PhoneRepository;
import com.projects.BCIprueba.data.payloads.repositories.UserRepository;
import com.projects.BCIprueba.data.payloads.request.UserRequest;
import com.projects.BCIprueba.data.payloads.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        if(!passwordMatch(userRequest.getPassword())) return new UserResponse("La contraseña debe tener 2 numeros y una mayuscula");
        if(!emailMatch(userRequest.getEmail())) return new UserResponse("Debe ingresar un correo valido");
        if (existsMail(userRequest.getEmail())) return new UserResponse("El correo ya se encuentra registrado");

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setApiToken(getNewUUID());
        user.setId(getNewUUID());
        user.setPhones(userRequest.getPhones());
        user.setLastLogin(currTime());
        user.setCreationDate(currTime());
        user.setActive(true);

        userRepository.save(user);


        return new UserResponse(user,"Usuario creado correctamente");
    }

    @Override
    public boolean existsMail(String email) {
        return userRepository.existsByEmail(email);
    }

    private String getNewUUID(){
        return UUID.randomUUID().toString();
    }

    private Date currTime(){
        return new Date(System.currentTimeMillis());
    }

    private boolean passwordMatch(String str){
        int upper = 0, numerics = 0, lower = 0;

        for(int i=0; i<str.length();i++) {
            if(Character.isUpperCase(str.charAt(i))) upper ++;
            if(isNumeric(String.valueOf(str.charAt(i)))) numerics ++;
            if(Character.isLowerCase(str.charAt(i))) lower ++;
        }

        return (upper==1&&numerics==2&&lower>=1)?true:false;
    }

    private boolean isNumeric(String chr){
        return chr.matches(ProjectConstants.VALID_NUMERIC);
    }

    private boolean emailMatch(String str){
        Matcher matcher = ProjectConstants.VALID_EMAIL_ADDRESS_REGEXP.matcher(str);
        return matcher.matches();
    }
}
