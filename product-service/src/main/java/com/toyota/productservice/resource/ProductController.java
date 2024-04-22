package com.toyota.productservice.resource;

import com.toyota.productservice.domain.Product;
import com.toyota.productservice.dto.requests.CreateProductRequest;
import com.toyota.productservice.dto.requests.UpdateProductRequest;
import com.toyota.productservice.dto.responses.GetAllProductsResponse;
import com.toyota.productservice.service.abstracts.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@NoArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<TreeMap<String, Object>> getAllProductsPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {
        TreeMap<String, Object> response = productService.getAllProductsPage(page, size, sort);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<TreeMap<String, Object>> findByProductNameContaining(
            @PathVariable("name") String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {
        TreeMap<String, Object> response = productService.findByProductNameContaining(name, page, size, sort);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/state")
    public ResponseEntity<TreeMap<String, Object>> findByProductState(
            @RequestParam(defaultValue = "true") Boolean state,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {
        TreeMap<String, Object> response = productService.findByProductState(state, page, size, sort);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/barcodenumbers/{barcodeNumber}")
    public GetAllProductsResponse getProductByBarcodeNumber(@PathVariable("barcodeNumber") String barcodeNumber) {
        return productService.getProductByBarcodeNumber(barcodeNumber);
    }

    @GetMapping("/{id}")
    public GetAllProductsResponse getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addProduct(@RequestBody @Valid CreateProductRequest createProductRequest) {
        this.productService.addProduct(createProductRequest);
    }

    @PutMapping
    public void updateProduct(@RequestBody() @Valid UpdateProductRequest updateProductRequest) {
        this.productService.updateProduct(updateProductRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productService.deleteProduct(id);
    }

}
