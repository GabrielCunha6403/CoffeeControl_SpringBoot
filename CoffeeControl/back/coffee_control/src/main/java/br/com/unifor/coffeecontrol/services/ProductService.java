package br.com.unifor.coffeecontrol.services;

import br.com.unifor.coffeecontrol.dtos.ProductDto;
import br.com.unifor.coffeecontrol.forms.ProductForm;
import br.com.unifor.coffeecontrol.forms.UpdatedProductForm;
import br.com.unifor.coffeecontrol.modelos.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public interface ProductService{
    Page<ProductDto> listProducts(Pageable paginacao);

    ResponseEntity<ProductDto> signUpProduct(ProductForm productForm, UriComponentsBuilder uriBuilder);

    ProductDto showSpecificProductById(int id);

    ResponseEntity<ProductDto> updateSpecificProductById(int id, UpdatedProductForm form);

    ResponseEntity<Product> deleteSpecificProductById(int id);

}
