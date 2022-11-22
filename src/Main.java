import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static User currentUser;
    static ArrayList<User> userList = new ArrayList<>();
    static ArrayList<Patient> patientList = new ArrayList<>();
    static ArrayList<Appointment> appointmentList = new ArrayList<>();
    public static void main(String[] args) {

        // Cargar data de los .txt
        try {
            userList = loadUserData(userList);
            patientList = loadPatientData(patientList);
            appointmentList = loadAppointmentData(appointmentList);
        }catch (Exception e){
            throw e;
        }

        System.out.println(userList);

        // Login
        currentUser = loginMenu();

        if(currentUser.userType == 1){
            showAdminMenu();
        }else{

        }
    }

    public static ArrayList<User> loadUserData(ArrayList<User> users){
        // Cargar información de usuarios
        InputStream userFile = Main.class.getResourceAsStream("db/Usuarios.txt");
        System.out.println(userFile);

        Scanner reader = new Scanner(userFile);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String[] convertedUser = data.split(",");

            User myUser = new User(Integer.parseInt(convertedUser[0]), convertedUser[1],
                    convertedUser[2], Integer.parseInt(convertedUser[3]), convertedUser[4], convertedUser[5]);

            users.add(myUser);
        }

        return users;
    }

    public static ArrayList<Patient> loadPatientData(ArrayList<Patient> patients){
        // Cargar información de pacientes
        InputStream patientFile = Main.class.getResourceAsStream("db/Pacientes.txt");

        Scanner reader = new Scanner(patientFile);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String[] convertedPatient = data.split(",");

            Patient myPatient = new Patient(Integer.parseInt(convertedPatient[0]), convertedPatient[1]);

            patients.add(myPatient);
        }

        return patients;
    }

    public static ArrayList<Appointment> loadAppointmentData(ArrayList<Appointment> appointments){
        // Cargar información de las citas
        InputStream appointmentFile = Main.class.getResourceAsStream("db/Citas.txt");

        Scanner reader = new Scanner(appointmentFile);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String[] convertedAppointment = data.split(",");

            Appointment myAppointment = new Appointment(Integer.parseInt(convertedAppointment[0]), convertedAppointment[1],
                    convertedAppointment[2]);
            appointments.add(myAppointment);
        }

        reader.close();

        return appointments;
    }

    public static User loginMenu(){
        Scanner sc = new Scanner(System.in);
        User userSelected = new User();


        System.out.println("---- LOGIN -----");

        System.out.println("Introduce tu usuario");
        String username = sc.nextLine();
        System.out.println("Introduce tu contraseña");
        String password = sc.nextLine();

        // Revisar si el usuario y contraseña existen
        for (int i = 0; i < userList.size(); i++) {
            userSelected = userList.get(i);

            if(userSelected.username.equals(username) && userSelected.password.equals(password)){
                break;
            }else{
                userSelected = null;
            }
        }

        if(userSelected == null){
            System.out.println("No existe el usuario");
        }else{
            System.out.println("Bienvenido, " + userSelected.name +
                    ". Tu tipo de usuario es: " + userSelected.userType);

        }

        return userSelected;
    }

    public static void showAdminMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("---- ADMIN MENU -----");
        System.out.println("1) Dar de alta un doctor");
        int response = sc.nextInt();

        if(response == 1){
            int id = userList.size() + 1;
            int userType = 0;

            sc.nextLine();
            System.out.println("Ingresa el nombre del doctor: ");
            String name = sc.nextLine();

            System.out.println("Ingresa la especialidad: ");
            String speciality = sc.nextLine();

            System.out.println("Ingresa el nombre de usuario: ");
            String username = sc.nextLine();

            System.out.println("Ingresa la contraseña: ");
            String password = sc.nextLine();

            // Ruta archivo
            String directory = "C:\\Users\\Felipe Perez\\IdeaProjects\\EvidenciaFinal\\src\\db\\Usuarios.txt";
            File myFile = new File(directory);

            try {
                FileWriter myWriter = new FileWriter(myFile, true);
                myWriter.write(System.lineSeparator() + id + "," + name + "," + speciality + ","
                        + userType + "," +  username + "," + password);
                myWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Respuesta invalida");
        }


    }
}