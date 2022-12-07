package br.com.unifor.coffeecontrol.services.Impl;

import br.com.unifor.coffeecontrol.controllers.ProductController;
import br.com.unifor.coffeecontrol.dtos.ProductDto;
import br.com.unifor.coffeecontrol.dtos.ProfileDto;
import br.com.unifor.coffeecontrol.forms.ProductForm;
import br.com.unifor.coffeecontrol.forms.UpdatedProductForm;
import br.com.unifor.coffeecontrol.modelos.Product;
import br.com.unifor.coffeecontrol.repositories.ProductRepository;
import br.com.unifor.coffeecontrol.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<ProductDto> listProducts(Pageable paginacao) {
        Page<Product> products = productRepository.findAll(paginacao);
        return ProductDto.convert(products);
    }

    @Override
    public ResponseEntity<ProductDto> signUpProduct(ProductForm productForm, UriComponentsBuilder uriBuilder) {
        Product product = productForm.convert(productRepository);
        productRepository.save(product);

        URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDto(product));
    }

    @Override
    public ProductDto showSpecificProductById(int id) {
        Product product = productRepository.getReferenceById(id);
        return new ProductDto(product);
    }

    @Override
    public ResponseEntity<ProductDto> updateSpecificProductById(int id, UpdatedProductForm form) {
        Product product = form.update(id, productRepository);
        return ResponseEntity.ok(new ProductDto(product));
    }

    @Override
    public ResponseEntity<Product> deleteSpecificProductById(int id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
