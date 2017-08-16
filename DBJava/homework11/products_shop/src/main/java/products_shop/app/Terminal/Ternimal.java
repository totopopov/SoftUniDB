package products_shop.app.Terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import products_shop.app.dto.bind.*;
import products_shop.app.dto.view.*;
import products_shop.app.services.CategoryService;
import products_shop.app.services.ProductService;
import products_shop.app.services.UserService;
import products_shop.app.utils.io.JsonParser;
import products_shop.app.utils.io.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Todor Popov using Lenovo on 3.8.2017 г. at 21:35.
 */

@Component
public class Ternimal implements CommandLineRunner {

    public static final String SRC_MAIN_RESOURCES_FILES_OUT_USERS_AND_PRODUCTS_XML = "/src/main/resources/files/out/users-and-products.xml";
    public static final String SRC_MAIN_RESOURCES_FILES_OUT_CATEGORIES_BY_PRODUCTS_XML = "/src/main/resources/files/out/categories-by-products.xml";
    public static final String SRC_MAIN_RESOURCES_FILES_OUT_USERS_SOLD_PRODUCTS_XML = "/src/main/resources/files/out/users-sold-products.xml";
    public static final String SRC_MAIN_RESOURCES_FILES_OUT_PRODUCTS_IN_RANGE_XML = "/src/main/resources/files/out/products-in-range.xml";
    public static final String FILES_IN_CATEGORIES_XML = "/files/in/categories.xml";
    public static final String FILES_IN_PRODUCTS_XML = "/files/in/products.xml";
    public static final String FILES_IN_USERS_XML = "/files/in/users.xml";
    public static final String SRC_MAIN_RESOURCES_FILES_OUT_USERS_AND_PRODUCTS_JSON = "/src/main/resources/files/out/users-and-products.json";
    public static final String SRC_MAIN_RESOURCES_FILES_OUT_CATEGORIES_BY_PRODUCTS_JSON = "/src/main/resources/files/out/categories-by-products.json";
    public static final String SRC_MAIN_RESOURCES_FILES_OUT_USERS_SOLD_PRODUCTS_JSON = "/src/main/resources/files/out/users-sold-products.json";
    public static final String SRC_MAIN_RESOURCES_FILES_OUT_PRODUCTS_IN_RANGE_JSON = "/src/main/resources/files/out/products-in-range.json";
    public static final String FILES_IN_PRODUCTS_JSON = "/files/in/products.json";
    public static final String FILES_IN_CATEGORIES_JSON = "/files/in/categories.json";
    public static final String FILES_IN_USERS_JSON = "/files/in/users.json";
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    private final JsonParser jsonParser;
    private final XMLParser XMLParser;  // no OOP namings :)

    @Autowired
    public Ternimal(UserService userService, ProductService productService, CategoryService categoryService, JsonParser jsonParser, XMLParser XMLParser) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.jsonParser = jsonParser;
        this.XMLParser = XMLParser;
    }

    @Override
    public void run(String... strings) throws Exception {

        //jsonProcessing();

        xmlProcessing();
    }

    private void xmlProcessing() {
        seedDbXML();
        export1XML();
        export2XML();
        export3XML();
        export4XML();
    }

    private void export4XML() {
        String path = SRC_MAIN_RESOURCES_FILES_OUT_USERS_AND_PRODUCTS_XML;
        UserDtoViewWrapper info = this.userService.findAllUserByAtLeastOneSell();

        try {
            this.XMLParser.writeObject(info,path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void export3XML() {
        String path = SRC_MAIN_RESOURCES_FILES_OUT_CATEGORIES_BY_PRODUCTS_XML;

        List<CategoryDtoView> categoriesAll = this.categoryService.findAllOrderedByProductCount();

        CategoryDtoViewWrapper categories= new CategoryDtoViewWrapper();
        categories.setCategoriesALL(categoriesAll);

        try {
            this.XMLParser.writeObject(categories,path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

    }

    private void export2XML() {
        String path = SRC_MAIN_RESOURCES_FILES_OUT_USERS_SOLD_PRODUCTS_XML;

        List<UserDtoViewSold> usersWithSoldProducts = this.userService.findUsersWithSoldProducts();
        UserDtoViewSoldWrapper users= new UserDtoViewSoldWrapper();
        users.setUsers(usersWithSoldProducts);

        try {
            this.XMLParser.writeObject(users,path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

    }

    private void export1XML() {
        String path = SRC_MAIN_RESOURCES_FILES_OUT_PRODUCTS_IN_RANGE_XML;
        List<ProductDtoView> productsByPrice =
                this.productService.findProductsByPrice(new BigDecimal("500"), new BigDecimal("1000"));
        ProductDtoViewWrapper products= new ProductDtoViewWrapper();
        products.setProducts(productsByPrice);

        try {
            this.XMLParser.writeObject(products,path);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void seedDbXML() {

        importUsersXML();
        importCategoriesXML();
        importProductsXML();

    }

    private void importCategoriesXML() {
        String path = FILES_IN_CATEGORIES_XML;
        try {
            CategoryDtoRegisterWrapper categories = this.XMLParser.getObject(CategoryDtoRegisterWrapper.class, path);
            if (categories.getCategories() != null) {
                for (CategoryDtoRegister category : categories.getCategories()) {
                    this.categoryService.register(category);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void importProductsXML() {
        String path = FILES_IN_PRODUCTS_XML;
        Random random = new Random();
        List<UserDto> allUsers = this.userService.findAll();
        List<CategoryDto> allCategories = this.categoryService.findAll();
        try {
            ProductDtoRegisterWrapper products = this.XMLParser.getObject(ProductDtoRegisterWrapper.class, path);
            for (ProductDtoRegister product : products.getProducts()) {

                populateProducts(random, allUsers, allCategories, product);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    private void populateProducts(Random random, List<UserDto> allUsers, List<CategoryDto> allCategories, ProductDtoRegister product) {
        Set<CategoryDto> categories = new HashSet<>();
        int categoryNumber = random.nextInt(allCategories.size());
        for (int i = 0; i < categoryNumber; i++) {
            CategoryDto categoryDto = allCategories.get(random.nextInt(allCategories.size()));

            categories.add(categoryDto);
        }

        product.setCategories(categories);

        UserDto userSeller = allUsers.get(random.nextInt(allUsers.size()));
        product.setSeller(userSeller);

        int i = random.nextInt(allUsers.size());
        UserDto userBuyer = allUsers.get(i);
        if (i % 7 != 0) {
            product.setBuyer(userBuyer);
        }

        this.productService.register(product);
    }

    private void importUsersXML() {
        String path = FILES_IN_USERS_XML;
        UserDtoRegisterWrapper users = null;
        try {
            users = this.XMLParser.getObject(UserDtoRegisterWrapper.class, path);
            if (users.getUserDtoRegisters() != null) {

                for (UserDtoRegister user : users.getUserDtoRegisters()) {
                    this.userService.registerUser(user);
                }
            } else {
                System.out.println("Error, check UserWrapper");
            }
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void jsonProcessing() {
        seedDB();
        export1();
        export2();
        export3();
        export4();
    }

    private void export4() {
        String path = SRC_MAIN_RESOURCES_FILES_OUT_USERS_AND_PRODUCTS_JSON;
        UserDtoViewWrapper info = this.userService.findAllUserByAtLeastOneSell();

        try {
            this.jsonParser.writeObject(info, path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    private void export3() {
        String path = SRC_MAIN_RESOURCES_FILES_OUT_CATEGORIES_BY_PRODUCTS_JSON;

        List<CategoryDtoView> categories = this.categoryService.findAllOrderedByProductCount();

        try {
            this.jsonParser.writeObject(categories, path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void export2() {
        String path = SRC_MAIN_RESOURCES_FILES_OUT_USERS_SOLD_PRODUCTS_JSON;

        List<UserDtoViewSold> usersWithSoldProducts = this.userService.findUsersWithSoldProducts();

        try {
            this.jsonParser.writeObject(usersWithSoldProducts, path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void export1() {
        String path = SRC_MAIN_RESOURCES_FILES_OUT_PRODUCTS_IN_RANGE_JSON;
        List<ProductDtoView> productsByPrice =
                this.productService.findProductsByPrice(new BigDecimal("500"), new BigDecimal("1000"));

        try {
            this.jsonParser.writeObject(productsByPrice, path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        }

    }

    private void seedDB() {
        importUsers();
        importCategories();
        importProducts();

    }

    private void importProducts() {
        String path = FILES_IN_PRODUCTS_JSON;
        Random random = new Random();
        List<UserDto> allUsers = this.userService.findAll();
        List<CategoryDto> allCategories = this.categoryService.findAll();
        try {
            ProductDtoRegister[] products = this.jsonParser.getObject(ProductDtoRegister[].class, path);
            for (ProductDtoRegister product : products) {

                populateProducts(random, allUsers, allCategories, product);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void importCategories() {
        String path = FILES_IN_CATEGORIES_JSON;
        try {
            CategoryDtoRegister[] categories = this.jsonParser.getObject(CategoryDtoRegister[].class, path);
            for (CategoryDtoRegister category : categories) {
                this.categoryService.register(category);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void importUsers() {
        String path = FILES_IN_USERS_JSON;
        try {
            UserDtoRegister[] users = this.jsonParser.getObject(UserDtoRegister[].class, path);
            for (UserDtoRegister user : users) {
                this.userService.registerUser(user);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
