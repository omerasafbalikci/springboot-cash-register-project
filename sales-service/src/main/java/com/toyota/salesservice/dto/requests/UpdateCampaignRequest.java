package com.toyota.salesservice.dto.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCampaignRequest {
    @NotNull(message = "Id must not be null")
    private Long id;
    private String name;
    private String buyPay;
    @Min(value = 0, message = "Percent must be greater than or equal to 0")
    @Max(value = 100, message = "Percent must be less than or equal to 100")
    private Integer percent;
    @Min(value = 0, message = "Money discount must be greater than or equal to 0")
    private Integer moneyDiscount;
    @NotNull(message = "Campaign type must not be null")
    @Min(value = 1, message = "Percent must be greater than or equal to 1")
    @Max(value = 3, message = "Percent must be less than or equal to 3")
    private Integer campaignType;
    private Boolean state;
    @NotNull(message = "Created by must not be null")
    @NotBlank(message = "Created by must not be blank")
    private String createdBy;
}
