package org.example.mapper;
import lombok.experimental.UtilityClass;
import org.example.controller.dto.UserProfileDto;
import org.example.controller.dto.UserRegisterDto;
import org.example.domain.User;

@UtilityClass
public class UserMapper {

    public User toUserEntity(UserProfileDto userProfileDto) {

        return User.builder()
                .id(userProfileDto.getId())
                .username(userProfileDto.getUsername())
                .email(userProfileDto.getEmail())
                .photoUrl(userProfileDto.getPhotoUrl())
                .build();
    }

    public User toUserEntity(UserRegisterDto userRegistrationDto) {

        User user = User.builder()
                .username(userRegistrationDto.getUsername())
                .password(userRegistrationDto.getPassword())
                .email(userRegistrationDto.getEmail())
                .build();

        if (userRegistrationDto.getId() != null) user.setId(userRegistrationDto.getId());

        return user;
    }

    public UserRegisterDto toUserRegisterDto(User user) {

        return UserRegisterDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getPassword())
                .build();
    }

    public UserProfileDto toUserProfileDto(User user) {

        return UserProfileDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .photoUrl(user.getPhotoUrl())
                .build();
    }
}