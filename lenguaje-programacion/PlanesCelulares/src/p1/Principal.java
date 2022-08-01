package p1;

import p2.*;
import p3.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);

        int acc, tippln;
        int fin = 0;

        ArrayList<PlanCelular> lista = new ArrayList<>();

        Enlace1MM plan1 = new Enlace1MM();
        Enlace2ECO plan2 = new Enlace2ECO();
        Enlace3M plan3 = new Enlace3M();
        Enlace4MIN plan4 = new Enlace4MIN();

        System.out.println("DATOS PROPIETARIO");
        System.out.println("Nombre:");
        String nombre = entrada.nextLine();
        System.out.println("Cedula:");
        String cedula = entrada.nextLine();
        System.out.println("Ciudad de residencia:");
        String ciudad = entrada.nextLine();
        System.out.println("DATOS CELULAR");
        System.out.println("Marca de celular:");
        String marca = entrada.nextLine();
        System.out.println("Modelo de celular:");
        String modelo = entrada.nextLine();
        System.out.println("Ingrese su numero celular:");
        String numero = entrada.nextLine();

        do {

            System.out.println("INGRESA EL TIPO DE ACCION QUE DESEA REALIZAR");
            System.out.println("1. Ingresar plan");
            System.out.println("2. Mostrar objetos de la base de datos.");
            System.out.println("3. Terminar y mostrar los datos");
            acc = entrada.nextInt();

            if (acc != 1 && acc != 2 && acc != 3) {
                System.out.println("OPCION NO VALIDA");
            } else {
                switch (acc) {
                    case 1: {
                        System.out.println("TIPOS DE PLAN");
                        System.out.println("1. Plan Post Pago Minutos");
                        System.out.println("2. Plan Post Pago Megas");
                        System.out.println("3. Plan Post Pago Minutos Megas");
                        System.out.println("4. Plan Post Pago Minutos Megas Eco");
                        tippln = entrada.nextInt();

                        if (tippln == 1) {
                            entrada.nextLine();
                            System.out.println("HA SELECCIONADO PLAN POST PAGO "
                                    + "MINUTOS");

                            System.out.println("");
                            System.out.println("Minutos nacionales:");
                            int minutosNa = entrada.nextInt();
                            System.out.println("Costo por minuto nacional:");
                            double costoMinNa = entrada.nextDouble();
                            System.out.println("Minutos internacionales:");
                            int minutosInt = entrada.nextInt();
                            System.out.println("Costo por minuto internacional:");
                            double costoMinInt = entrada.nextDouble();
                            PlanPostPagoMinutos p1 = new PlanPostPagoMinutos(
                                    minutosNa, costoMinNa, minutosInt, costoMinInt, nombre,
                                    cedula, ciudad, marca, modelo, numero);
                            lista.add(p1);
                            plan4.insertarPlanPostPagoMinutos(p1);

                        } else {
                            if (tippln == 2) {
                                entrada.nextLine();
                                System.out.println("HA SELECCIONADO PLAN POST "
                                        + "PAGO MEGAS");

                                System.out.println("Tarifa base:");
                                double tarifa = entrada.nextDouble();
                                System.out.println("Numero de Gigas:");
                                int gigas = entrada.nextInt();
                                System.out.println("Costo por Giga:");
                                double costoGigas = entrada.nextDouble();

                                PlanPostPagoMegas p2 = new PlanPostPagoMegas(
                                        gigas, costoGigas, tarifa, nombre,
                                        cedula, ciudad, marca, modelo, numero);

                                lista.add(p2);
                                plan3.insertarPlanPostPagoMegas(p2);

                            } else {
                                if (tippln == 3) {
                                    System.out.println("HA SELECCIONADO PLAN POST "
                                            + "MEGA MINUTOS");

                                    System.out.println("Minutos:");
                                    int min = entrada.nextInt();
                                    System.out.println("Costo por minuto:");
                                    double costoMin = entrada.nextDouble();
                                    System.out.println("Numero de Gigas:");
                                    int gigas = entrada.nextInt();
                                    System.out.println("Costo por Giga:");
                                    double costoGigas = entrada.nextDouble();

                                    PlanPostPagoMinMeg p3 = new PlanPostPagoMinMeg(
                                            min, costoMin, gigas, costoGigas, nombre,
                                            cedula, ciudad, marca, modelo, numero);

                                    lista.add(p3);
                                    plan1.insertarPlanPostPagoMinMeg(p3);

                                } else {
                                    if (tippln == 4) {
                                        System.out.println("HA SELECCIONADO PLAN POST "
                                                + "MEGA MINUTOS ECONOMICO");

                                        System.out.println("Ingrese los minutos:");
                                        int min = entrada.nextInt();
                                        System.out.println("Ingrese el costo por minuto:");
                                        double costoMin = entrada.nextDouble();
                                        System.out.println("Ingrese el numero de Gigas:");
                                        int gigas = entrada.nextInt();
                                        System.out.println("Ingrese el costo por Giga:");
                                        double costoGigas = entrada.nextDouble();
                                        System.out.println("Ingrese el descuento otorgado(%):");
                                        int des = entrada.nextInt();

                                        PlanPostpagoMinMegEco p4 = new PlanPostpagoMinMegEco(
                                                min, costoMin, gigas, costoGigas, des,
                                                nombre, cedula, ciudad, marca, modelo, numero);
                                        lista.add(p4);
                                        plan2.insertarPlanPostPagoMinMegEco(p4);
                                    } else {
                                        if (tippln != 1 && tippln != 2 && tippln != 3
                                                && tippln != 4) {
                                            System.out.println("OPCION NO VALIDA");
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    case 2: {
                        for (int i = 0; i < plan1.obtenerDataPppmm().size(); i++) {
                            System.out.printf("%s\n", plan1.obtenerDataPppmm().get(i));
                        }
                        for (int i = 0; i < plan2.obtenerDataPppmmEco().size(); i++) {
                            System.out.printf("%s\n", plan2.obtenerDataPppmmEco().get(i));
                        }
                        for (int i = 0; i < plan3.obtenerDataPppMegas().size(); i++) {
                            System.out.printf("%s\n", plan3.obtenerDataPppMegas().get(i));
                        }
                        for (int i = 0; i < plan4.obtenerDataPppMinutos().size(); i++) {
                            System.out.printf("%s\n", plan4.obtenerDataPppMinutos().get(i));
                        }
                        break;
                    }

                    case 3: {
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(lista.get(i));
                        }
                        if (acc == 3) {
                            fin = 1;
                        }

                    }

                    default: {
                        break;
                    }
                }
            }

        } while (fin != 1);
    }
}
