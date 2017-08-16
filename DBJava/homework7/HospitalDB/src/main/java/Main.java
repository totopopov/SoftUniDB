import models.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb=new StringBuilder();
        sb.append("Hello Dr. Jakel");
        sb.append(System.lineSeparator());
        sb.append("To add a patient enter 1");
        sb.append(System.lineSeparator());
        sb.append("To search a patient by first and second name 2");
        sb.append(System.lineSeparator());
        sb.append("To search a patient by first name 3");
        sb.append(System.lineSeparator());
        sb.append("To search a patient by last name 4");
        sb.append(System.lineSeparator());
        sb.append("To search a patient by last name 5");
        sb.append(System.lineSeparator());
        sb.append("To quit ---> enter quit or q");
        sb.append(System.lineSeparator());
        sb.append("P.S. For oop code give some more time and money :P");
        sb.append(System.lineSeparator());
        sb.append("Enter command:");
        sb.append(System.lineSeparator());
        System.out.println(sb.toString());


        String comand= reader.readLine();



        while (true){
            if ("quit".equals(comand.toLowerCase()) || "q".equals(comand.toLowerCase())){
                break;
            }

            switch (comand){

                case "1":
                    try {

                        System.out.println("Enter firstName:");
                        String firsName=reader.readLine();
                        System.out.println("Enter lastName");
                        String lastName=reader.readLine();
                        System.out.println("Enter Address");
                        String address=reader.readLine();
                        System.out.println("Enter email");
                        String email=reader.readLine();
                        System.out.println("Enter DateOfBirth in yyyy-MM-dd");
                        Date date=df.parse(reader.readLine());
                        System.out.println("Enter `yes` for medical insurance");
                        Boolean mInsurance= reader.readLine().toLowerCase().equals("yes");

                        Patient patient=new Patient(firsName,lastName,address,email,date,mInsurance);

                        em.getTransaction().begin();
                        em.persist(patient);
                        em.getTransaction().commit();
                        System.out.println("sucess added Patient");
                    } catch (ParseException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":

                    System.out.println("Enter names:");

                    try {
                        String[] names = reader.readLine().trim().split("\\s+");
                        if (names.length!=2){
                            throw new IllegalArgumentException("Name arguemnts incorect!");
                        }
                        getPatient(em,names[0].toLowerCase(),names[1].toLowerCase());

                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    System.out.println("Enter first name:");
                    try {
                        String[] names = reader.readLine().trim().split("\\s+");
                        if (names.length!=1){
                            throw new IllegalArgumentException("First name incorect!");
                        }
                        getPatient(em,names[0].toLowerCase(),"%");

                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case "4":
                    System.out.println("Enter last name:");
                    try {
                        String[] names = reader.readLine().trim().split("\\s+");
                        if (names.length!=1){
                            throw new IllegalArgumentException("Second name incorect!");
                        }
                        getPatient(em,"%",names[0].toLowerCase());

                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    System.out.println("Enter last name:");
                    try {
                        String email = reader.readLine().trim();

                        getPatient(em,email.toLowerCase());

                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "y":
                    System.out.println(sb.toString());
                    break;
                default:
                    System.out.println("Wrong input ! Do you a refresh on your options y/n");
                    break;
            }
            System.out.println("Enter Command:");
            comand= reader.readLine();
        }


        emf.close();
    }

    private static void getPatient(EntityManager em,String firstName,String lastName) {
        Query query = em.createQuery("FROM Patient AS p where lower( p.firstName) like ?1 and lower( p.lastName) like ?2");
        query.setParameter(1,firstName);
        query.setParameter(2,lastName);
        List<Patient> resultList = query.getResultList();
        if (resultList!=null &&resultList.size()>0){
            for (Patient patient : resultList) {
                System.out.println(patient);
            }
        }else {
            System.out.println("No result found");
        }
    }

    private static void getPatient(EntityManager em,String email) {
        Query query = em.createQuery("FROM Patient AS p where lower( p.email) like ?1 ");
        query.setParameter(1,email);
        List<Patient> resultList = query.getResultList();
        if (resultList!=null &&resultList.size()>0){
            for (Patient patient : resultList) {
                System.out.println(patient);
            }
        }else {
            System.out.println("No result found");
        }
    }
}
