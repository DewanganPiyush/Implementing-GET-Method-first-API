package com.scaler.piyush.firstapi27june.service;

import com.scaler.piyush.firstapi27june.dtos.FakeStoreProductDto;
import com.scaler.piyush.firstapi27june.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    // RestTemplate
    // allows to send https requests to external URLs
    // and work with responses

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getSingleproduct(Long productId) {
        FakeStoreProductDto fakeStoreProduct = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class);
        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }
}

