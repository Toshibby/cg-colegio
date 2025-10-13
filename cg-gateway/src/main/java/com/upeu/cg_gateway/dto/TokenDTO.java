package com.upeu.cg_gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@NoArgsConstructor


@Builder
@AllArgsConstructor
@Data
public class TokenDTO {
    private String token;
}
