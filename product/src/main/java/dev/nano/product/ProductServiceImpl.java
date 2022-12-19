package dev.nano.product;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static dev.nano.product.ProductConstant.PRODUCT_NOT_FOUND_EXCEPTION;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public ProductDTO getProduct(long productId) {
        ProductEntity product = productRepository.findById(productId).orElseThrow(() ->
                new IllegalStateException(PRODUCT_NOT_FOUND_EXCEPTION));

        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts(int page, int limit, String search) {
        if(page > 0) page = page - 1; /* page starts at 1, so we need to subtract 1 because page starts at 0 */

        List<ProductDTO> productDTOList = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<ProductEntity> productDTOPage;

        if(search == null || search.isEmpty()) {
            productDTOPage = productRepository.findAllProducts(pageableRequest);
        } else {
            productDTOPage = productRepository.findAllProductsByCriteria(pageableRequest, search);
        }

        List<ProductEntity> products = productDTOPage.getContent();
        productDTOList.addAll(productMapper.toListDTO(products));

        return productDTOList;
    }

    @Override
    public ProductDTO create(ProductDTO product) {
        return null;
    }

    @Override
    public ProductDTO update(long id, ProductDTO product) {
        return null;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce Quantity {} for Id: {}", quantity,productId);

        ProductEntity product
                = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException(PRODUCT_NOT_FOUND_EXCEPTION));

        if(product.getQuantity() < quantity) {
            throw new IllegalStateException("Product does not have sufficient quantity");
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Quantity reduced successfully");
    }

    @Override
    public void delete(long id) {

    }
}
