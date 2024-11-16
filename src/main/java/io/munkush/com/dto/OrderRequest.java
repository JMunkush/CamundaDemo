package io.munkush.com.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class OrderRequest implements Serializable {
    private Map<String, Integer> products;
    private String email;

}
