import Classes.Moneda;
import Classes.ResponsePair;
import Operation.Operations;
import conexion.ComunicationApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ComunicationApi api = new ComunicationApi();
        Operations op = new Operations();
        List<Moneda> listaMonedas = new ArrayList<>();
        Scanner lectura = new Scanner(System.in);
        List<ResponsePair> listaConsultas = new ArrayList<>();

        while(true){
            try{
                var result = api.getExchangeRate();
                var responseTransform = op.ConvertResponse(result);
                listaMonedas = responseTransform.getConversionRates();

                String menu = """
                   ##########################################################
                   Bienvenido al conversor de Monedas - Exchange Worly
                   
                   1 - Ver monedas.
                   2 - Convertir monto.
                   3 - Guardar mis consultas.
                   4 - Salir.
                   ##########################################################
                   """;
                System.out.println(menu);
                var opcion = lectura.nextLine();

                if (opcion.equalsIgnoreCase("4")){
                    break;
                }

                switch (opcion){
                    case "1":
                        //System.out.println("hiola");
                        op.printCountrys(listaMonedas);
                        break;
                    case "2":
                        // mostrar paises
                        op.printCountrys(listaMonedas);
                        System.out.println("Ingrese el número del país de moneda base: ");
                        // pedir el numero del primer pais
                        var primeraEleccionPais = Integer.parseInt(lectura.nextLine());
                        var countryBase = listaMonedas.get(primeraEleccionPais - 1);

                        // mostrar paises
                        op.printCountrys(listaMonedas);
                        System.out.println("Ingrese el número del país de moneda de destino: ");

                        // pedir el numero del segundo pais
                        var segundaEleccionPais = Integer.parseInt(lectura.nextLine());
                        var countryTarget = listaMonedas.get(segundaEleccionPais - 1);

                        // pedir el monto a transformar
                        System.out.println("Ingrese el monto a transformar: ");
                        var monto = Double.parseDouble(lectura.nextLine());

                        // enviar solciitud a la api
                        var sendPair = api.Conversion(countryBase.getCodigoPais(), countryTarget.getCodigoPais(), monto);
                        var pair = op.ExchangePair(sendPair);
                        // mostrar resultado o error
                        if (pair.getResult().equalsIgnoreCase("success")){
                            listaConsultas.add(pair);
                        }
                        pair.printPair();
                        break;
                    case "3":
                        var guardar = op.SaveData(listaConsultas);
                        System.out.println(guardar);
                        break;
                    default:
                        System.out.println("Error. Ingrese una opción valida del menu!");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Ha ingresado un valor incorrecto. Se esperaba un número. Intentelo nuevamente");
            } catch (IOException | InterruptedException | RuntimeException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Ha ocurrido un error inesperado!");
            } finally {
                System.out.println("Saliendo de Exchange Worly. Vuelve Pronto :)");
            }
        }
    }
}
