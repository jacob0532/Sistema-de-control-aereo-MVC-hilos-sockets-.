/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Meih55
 */
    import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class Json
{

    public Json() {
    }
    public static void leerJSON(Aeropuerto aeropuerto){
        JSONParser jsonParser = new JSONParser();
       
        try (FileReader reader = new FileReader("../vuelosInfo.json"))
        {
            Object obj = jsonParser.parse(reader); //leer el archivo
            JSONObject jsonObj = (JSONObject) obj;
            JSONArray avion = (JSONArray) jsonObj.get("Avion");
            JSONArray puerta= (JSONArray)jsonObj.get("Puerta");
            JSONArray pista= (JSONArray)jsonObj.get("Pista");
           
            
            String nombre, tipo, estado,tamano,tiempo;
            int numero,es;
            String tam;
 
            for(int i=0;i<20;i++){
                JSONObject jsonObj1 = (JSONObject) avion.get(i);
                nombre=jsonObj1.get("nombre").toString();
                tipo=jsonObj1.get("tipo").toString();
                estado=jsonObj1.get("estado").toString();
                tamano=jsonObj1.get("tamano").toString();
                tiempo=jsonObj1.get("horas").toString()+":"+jsonObj1.get("minutos").toString();
                Vuelo elVuelo= new Vuelo(nombre,estado,tipo,tamano,tiempo);
                aeropuerto.vuelos.add(elVuelo);
            }
            
            //String [] pistas= new String[]{"Pequeno","Mediano","Grande"};
            for(int i=0;i<3;i++){
                JSONObject jsonObj3 = (JSONObject) puerta.get(i);
                numero= Integer.parseInt(jsonObj3.get("numero").toString());
                es= Integer.parseInt(jsonObj3.get("estado").toString());
                tam= jsonObj3.get("tamano").toString();
                Pista laPista=new Pista(numero,es,tam);
                aeropuerto.pistas.add(laPista);
            }
            
            
            for(int i=0;i<3;i++){
                JSONObject jsonObj2 = (JSONObject) puerta.get(i);
                numero= Integer.parseInt(jsonObj2.get("numero").toString());
                es= Integer.parseInt(jsonObj2.get("estado").toString());
                tam= jsonObj2.get("tamano").toString();
                Puerta laPuerta=new Puerta(numero,es,tam);
                aeropuerto.puertas.add(laPuerta);
            }
            
           
            
 
         
         
        } catch (Exception e) {
            e.toString();
        } 
    }
  }

