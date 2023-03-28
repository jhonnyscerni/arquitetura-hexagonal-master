package com.exemplo.arquiteturahexagonal.adapter.inbound.controller;

import com.exemplo.arquiteturahexagonal.domain.ports.inbound.CreateUserUseCasePort;
import com.exemplo.arquiteturahexagonal.domain.ports.inbound.GetUserByIdUseCasePort;
import com.exemplo.arquiteturahexagonal.adapter.inbound.controller.request.CreateUserRequest;
import com.exemplo.arquiteturahexagonal.adapter.inbound.controller.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCasePort createUserUseCase;
    private final GetUserByIdUseCasePort getUserByIdUseCasePort;

    public UserController(CreateUserUseCasePort createUserUseCase,
                          GetUserByIdUseCasePort getUserByIdUseCasePort) {
        this.createUserUseCase = createUserUseCase;
        this.getUserByIdUseCasePort = getUserByIdUseCasePort;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(UserResponse.fromDomain(getUserByIdUseCasePort.execute(userId)));
    }

    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(UserResponse.fromDomain(createUserUseCase.execute(createUserRequest.toUserDomain())));
    }
}
