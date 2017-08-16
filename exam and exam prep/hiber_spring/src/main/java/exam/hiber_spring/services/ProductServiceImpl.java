package exam.hiber_spring.services;

import exam.hiber_spring.dto.bind.ProductDtoRegister;
import exam.hiber_spring.entitites.Branch;
import exam.hiber_spring.entitites.Product;
import exam.hiber_spring.repositories.BranchRepository;
import exam.hiber_spring.repositories.ProductRepository;
import exam.hiber_spring.utils.ModelParser;
import exam.hiber_spring.utils.ProjectInfo;
import exam.hiber_spring.utils.valids.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, BranchRepository branchRepository) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return this.productRepository.findOne(id);
    }

    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> multipleCreate(Iterable<Product> products) {
        return this.productRepository.save(products);
    }

    @Override
    public void deleteById(long id) {
        this.productRepository.delete(id);
    }

    @Override
    public String register(ProductDtoRegister productDtoRegister) {
        String branchName = productDtoRegister.getBranchString();
        Product mappedProduct = ModelParser.map(productDtoRegister, Product.class);
        Branch branch = this.branchRepository.findByName(branchName);
        mappedProduct.setBranch(branch);

        String validate = DataValidator.validate(mappedProduct);
        if (validate==null){
            this.productRepository.saveAndFlush(mappedProduct);
            return String.format("Successfully imported Product %s",mappedProduct.getName());
        }

        return ProjectInfo.ERROR_INVALID_DATA;
    }

}
