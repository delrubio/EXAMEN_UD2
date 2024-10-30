package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Examen {
    public static void ejercicio1() {
        Random random = new Random(); //definimos el random en el programa
        Scanner entrada = new Scanner(System.in); //definimos para poder coger las entradas del usuario

        int num = random.nextInt(101); //numero aleatorio del 0-100

        try { //comenzamos a comprobar el valor de las variables
            System.out.println("Que número crees que es: "); //primer intento del usuario
            int numero = entrada.nextInt(); //cogemos el intento del usuario

            for (int i = 9; i >= 0; i--) { //creamos un bucle for para llevar el recuento de los intentos de 9 hasta 0
                if (numero == num) { //si acierta pues genial
                    System.out.println("ENHORABUENA! El número era " + num);
                    break; //salimos
                } else if (num > numero) { //comparamos si el número es mayor
                    System.out.println("Te quedan " + i + " intentos"); //le decimos los intentos que le quedan
                    System.out.println("El número es mayor, vuelve a intentarlo "); //le damos al usuario un pista
                    numero = entrada.nextInt(); //cogemos el nuevo intento
                } else if (num < numero) {//comparamos si el número es menor
                    System.out.println("Te quedan " + i + " intentos"); //le decimos los intentos que le quedan
                    System.out.println("El número es menor, vuelve a intentarlo "); //le damos al usuario un pista
                    numero = entrada.nextInt(); //cogemos el nuevo intento
                }
            }
        }catch (InputMismatchException er) { //comprobamos si es válido el valor o no
            System.out.println("ERROR. Introduce un valor válido"); //mostramos el error
        }
    }

    public static void ejercicio2(){
        Scanner entrada = new Scanner(System.in); //definimos para poder coger las entradas del usuario
        LocalDateTime hoy = LocalDateTime.now(); //definimos para poder coger la fecha actual

        int anyo = hoy.getYear(); //metemos el año de hoy
        int i = 0;

        try { //comenzamos a comprobar el valor de las variables
            System.out.println("Escribeme un año "); //pedimos un año
            int anyo_entrada = entrada.nextInt(); //cogemos el año

            while (anyo_entrada > anyo | anyo_entrada < 1900 && i == 0) { //si es mayor al año, menor a 1900 o el contador es 0 vuelvo a preguntar le número porque significa que lo sigue haciendo mal
                System.out.println("Introduce un año entre 1900 y " + anyo);//pedimos el año de nuevo
                anyo_entrada = entrada.nextInt(); //cogemos el año
                while (anyo_entrada <= anyo && anyo_entrada >= 1900) { //si el año es menor que 2024 y no menor a 1900 entramos
                    if (anyo_entrada % 4 == 0) { //miro si es divisible entre 4
                        anyo_entrada = (anyo_entrada + 1); //sumo 1 al año para pasar al año siguiente
                        i++; //sumo el contador de años bisisestos
                    } else if (anyo_entrada % 100 == 0 && anyo_entrada % 400 == 0) { //si es divisible entre 100 y 400 entro
                        anyo_entrada = (anyo_entrada + 1); //sumo 1 al año para pasar al año siguiente
                        i++; //sumo el contador de años bisisestos
                    } else {
                        anyo_entrada = (anyo_entrada + 1); //si no es bisiesto, sumamos 1 de igual manera
                    }
                }
            }System.out.println("Han habido " + i + " años bisiestos"); //decimos los años bisiestos que han pasado
        }catch (InputMismatchException er) { //comprobamos si es válido el valor o no
            System.out.println("ERROR. Introduce un valor válido"); //mostramos el error
        }
    }
}
