package com.toyota.salesservice.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSalesItemsRequest {
    private String skuCode;
    private Integer quantity;
    private Long campaignId;
}