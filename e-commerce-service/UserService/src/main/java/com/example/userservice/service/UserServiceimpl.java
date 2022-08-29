package com.example.userservice.service;

import com.example.userservice.controller.dto.UserCreateResponseDto;
import com.example.userservice.controller.dto.UserDto;
import com.example.userservice.domain.UserEntity;
import com.example.userservice.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserCreateResponseDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        userDto.setEncryptedPassword("encrypted password");
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

        log.debug("userEntity : {}", userEntity);

        userRepository.save(userEntity);

        return null;
    }
}
