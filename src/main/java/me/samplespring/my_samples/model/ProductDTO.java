package me.samplespring.my_samples.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotNull
    private Long Id;

    @NotNull
    private Long productNo;

    @NotNull
    private int productName;
}
