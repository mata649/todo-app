package com.mata649.todoapp.security;

public class JWTResponseDTO {
    private Long id;
    private String username;
    private String name;
    private String jwt;
    
    public static JWTResponseDTO fromUserDetailsImp(UserDetailsImpl user, String token) {
        JWTResponseDTO jwtResponseDTO = new JWTResponseDTO();
        jwtResponseDTO.setId(user.getId());
        jwtResponseDTO.setJwt(token);
        jwtResponseDTO.setName(user.getName());
        jwtResponseDTO.setUsername(user.getUsername());
        return jwtResponseDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    
}
