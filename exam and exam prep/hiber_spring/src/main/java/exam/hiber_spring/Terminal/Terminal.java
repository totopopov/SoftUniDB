package exam.hiber_spring.Terminal;

import exam.hiber_spring.dto.bind.*;
import exam.hiber_spring.dto.view.*;
import exam.hiber_spring.services.*;
import exam.hiber_spring.utils.ProjectInfo;
import exam.hiber_spring.utils.io.JsonParser;
import exam.hiber_spring.utils.io.XMLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Todor Popov using Lenovo on 13.8.2017 г. at 9:34.
 */

@Component
public class Terminal implements CommandLineRunner {

    private static final String FILES_JSON_INPUT_TOWNS_JSON = "/files/json/input/towns.json";
    private static final String FILES_JSON_INPUT_BRANCHES_JSON = "/files/json/input/branches.json";
    private static final String FILES_JSON_INPUT_EMPLOYEE_CARDS_JSON = "/files/json/input/employee_cards.json";
    private static final String FILES_XML_INPUT_PRODUCTS_XML = "/files/xml/input/products.xml";
    private static final String FILES_XML_INPUT_EMPLOYEES_XML = "/files/xml/input/employees.xml";
    private static final String SRC_MAIN_RESOURCES_FILES_JSON_OUTPUT_FREE_CARDS_JSON = "/src/main/resources/files/json/output/free_cards.json";
    private static final String SRC_MAIN_RESOURCES_FILES_JSON_OUTPUT_PRODUCTIVE_EMPLOYEES_JSON = "/src/main/resources/files/json/output/productive-employees.json";
    private static final String SRC_MAIN_RESOURCES_FILES_XML_OUTPUT_TOWNS_XML = "/src/main/resources/files/xml/output/towns.xml";
    private static final String SRC_MAIN_RESOURCES_FILES_XML_OUTPUT_TOP_BRANCHES_XML = "/src/main/resources/files/xml/output/top-branches.xml";
    private static final String SUCCESSFULLY_EXPORTED_TOP_BRANCHES_XML = "Successfully Exported top-branches.xml";
    private static final String SUCCESSFULLY_EXPORTED_TOWNS_XML = "Successfully Exported towns.xml";
    private static final String SUCCESSFULLY_EXPORTED_PRODUCTIVE_EMPLOYEES_JSON = "Successfully Exported productive-employees.json";
    private static final String SUCCESSFULLY_EXPORTED_FREE_CARDS_JSON = "Successfully Exported free_cards.json";
    private final JsonParser jsonParser;
    private final XMLParser xmlParser;
    private final TownService townService;
    private final BranchService branchService;
    private final EmployeeCardService employeeCardService;
    private final ProductService productService;
    private final EmployeeService employeeService;

    @Autowired
    public Terminal(JsonParser jsonParser, XMLParser xmlParser, TownService townService, BranchService branchService, EmployeeCardService employeeCardService, ProductService productService, EmployeeService employeeService) {
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.townService = townService;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
        this.productService = productService;
        this.employeeService = employeeService;
    }


    @Override
    public void run(String... strings) throws Exception {

/*
  Reasons to use native query:
           Only neccessary information is exctracted from the database.
           No further sorting required.
           It's time efficient.
 */
       // seedDb();

        exportFreeCards();
       exportEmployeeAtBranchWithAtLeastOneProduct();

        exportTownData();
        exportDataBranches();
    }

    private void exportDataBranches() {
        List<BranchDtoViewInfo> branchesInfo = this.branchService.getBranchesInfo();
        BranchDtoViewInfoWrapper wrapper = new BranchDtoViewInfoWrapper();

        wrapper.setBranches(branchesInfo);

        try {
            this.xmlParser.writeObject(wrapper, SRC_MAIN_RESOURCES_FILES_XML_OUTPUT_TOP_BRANCHES_XML);
            System.out.println(SUCCESSFULLY_EXPORTED_TOP_BRANCHES_XML);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void exportTownData() {

        List<TownDtoViewInfo> townDtoViewInfos = this.townService.townsData();

        TownDtoViewInfoWrapper wrapper = new TownDtoViewInfoWrapper();
        wrapper.setTowns(townDtoViewInfos);

        try {
            this.xmlParser.writeObject(wrapper, SRC_MAIN_RESOURCES_FILES_XML_OUTPUT_TOWNS_XML);
            System.out.println(SUCCESSFULLY_EXPORTED_TOWNS_XML);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void exportEmployeeAtBranchWithAtLeastOneProduct() {
        List<EmployeeDtoViewProjected> employeeDtoViewProjecteds = this.employeeService.employeesAtBranchWihProductsNative();
        try {
            this.jsonParser.writeObject(employeeDtoViewProjecteds, SRC_MAIN_RESOURCES_FILES_JSON_OUTPUT_PRODUCTIVE_EMPLOYEES_JSON);
            System.out.println(SUCCESSFULLY_EXPORTED_PRODUCTIVE_EMPLOYEES_JSON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportFreeCards() {

        List<EmployeeCardDtoView> cardsWithNoEmployee = this.employeeCardService.getCardsWithNoEmployee();

        try {
            this.jsonParser.writeObject(cardsWithNoEmployee, SRC_MAIN_RESOURCES_FILES_JSON_OUTPUT_FREE_CARDS_JSON);
            System.out.println(SUCCESSFULLY_EXPORTED_FREE_CARDS_JSON);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void seedDb() {
        importTowns();
        importBranches();
        importEmployeeCards();
        importProduct();
        importEmployees();
    }

    private void importEmployees() {

        try {
            EmployeeDtoRegisterWrapper employeesWrapped = this.xmlParser.
                    getObject(EmployeeDtoRegisterWrapper.class, FILES_XML_INPUT_EMPLOYEES_XML);

            Set<String> cards = new HashSet<>();

            for (EmployeeDtoRegister employeeDtoRegister : employeesWrapped.getEmployees()) {
                if (cards.contains(employeeDtoRegister.getCardString())) {
                    System.out.println(ProjectInfo.ERROR_INVALID_DATA);
                    continue;
                }
                cards.add(employeeDtoRegister.getCardString());
                System.out.println(this.employeeService.register(employeeDtoRegister));
            }

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void importProduct() {

        try {
            ProductDtoRegisterWrapper productWrapped = this.xmlParser.
                    getObject(ProductDtoRegisterWrapper.class, FILES_XML_INPUT_PRODUCTS_XML);

            for (ProductDtoRegister productDtoRegister : productWrapped.getProducts()) {

                System.out.println(this.productService.register(productDtoRegister));

            }

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void importEmployeeCards() {

        try {
            EmployeeCardDtoRegister[] cards = this.jsonParser.getObject(EmployeeCardDtoRegister[].class, FILES_JSON_INPUT_EMPLOYEE_CARDS_JSON);

            Set<EmployeeCardDtoRegister> uniqueCards = new HashSet<>();

            uniqueCards.addAll(Arrays.stream(cards).collect(Collectors.toList()));
            for (EmployeeCardDtoRegister uniqueCard : uniqueCards) {
                System.out.println(this.employeeCardService.register(uniqueCard));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importBranches() {
        try {
            BranchDtoRegister[] branches = this.jsonParser.getObject(BranchDtoRegister[].class, FILES_JSON_INPUT_BRANCHES_JSON);

            for (BranchDtoRegister branch : branches) {
                System.out.println(this.branchService.register(branch));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importTowns() {


        try {
            TownDtoRegister[] towns = this.jsonParser.getObject(TownDtoRegister[].class, FILES_JSON_INPUT_TOWNS_JSON);
            for (TownDtoRegister town : towns) {
                System.out.println(this.townService.register(town));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
