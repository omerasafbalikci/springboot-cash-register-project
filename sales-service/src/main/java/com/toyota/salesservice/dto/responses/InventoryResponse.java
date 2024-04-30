package com.toyota.salesservice.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    private String barcodeNumber;
    private String skuCode;
    private String name;
    private Integer quantity;
    private Boolean isInStock;
    private Double unitPrice;
    private Boolean state;
}