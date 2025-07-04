package com.akgun.guestbook.Entity.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto  {
    private Long id;
    private String username;
    private String surname;
    private String note;

}
