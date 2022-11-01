package com.example.domain.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: jhlz
 * @since: 2022/10/30 20:32:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String address;
    private String longitude;
    private String latitude;
}
