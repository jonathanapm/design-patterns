package com.curso.chainofresponsability.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressVo {

    String response;

    boolean viaCep = false;

    boolean apiCep = false;

    boolean apiRepublicVirtual = false;
}
