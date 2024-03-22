package com.angelo.authms.domain.dtos;

import com.angelo.authms.domain.entities.user.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}
