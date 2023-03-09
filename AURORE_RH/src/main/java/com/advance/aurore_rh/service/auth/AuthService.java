package com.advance.aurore_rh.service.auth;


import com.advance.aurore_rh.dto.request.SignInRequestDTO;
import com.advance.aurore_rh.dto.response.SingInResponseDTO;
import com.advance.aurore_rh.model.User;
import com.advance.aurore_rh.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements AuthServiceInter {


    @Autowired
    UserRepository userRepository;

    @Override
    public SingInResponseDTO createUser(SignInRequestDTO signInRequestDTO) {

        User user = userRepository.save(SignInRequestDTO.buildFromDto(signInRequestDTO));
        return SingInResponseDTO.builder().resultat(user.getUsername()).build();
    }

    @Override
    public SingInResponseDTO updateUser(SignInRequestDTO signInRequestDTO) {
        User userToSave = userRepository.findByEmail(signInRequestDTO.getEmail())
                .map(u -> {
                    u.setPassword(signInRequestDTO.getPassword());
                    u.setEmail(signInRequestDTO.getEmail());
                    u.setUsername(signInRequestDTO.getUsername());
                    return userRepository.save(u); }

                ).orElseThrow(()->new RuntimeException("Aucun user trouvé"));

        return SingInResponseDTO.buildFronEntity(userToSave);
    }

    @Override
    public String deleteUser(Long id) {
        return null;
    }


    @Override
    public User findByEmail(String email) {

        return userRepository.findByEmail(email).orElse(null);
    }

    public  boolean existByEmail(String email){
        return userRepository.existsByEmail(email);
    }

}
