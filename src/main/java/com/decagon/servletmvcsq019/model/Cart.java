package com.decagon.servletmvcsq019.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
public class Cart {
    private Long id;
    private Long userId;
    private List<Long> productIds;

}
