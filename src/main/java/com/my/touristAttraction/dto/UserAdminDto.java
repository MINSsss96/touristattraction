package com.my.touristAttraction.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAdminDto {
    private Long id;
    private String username;
    private String name;
    private String email;
    private boolean enabled;
}
