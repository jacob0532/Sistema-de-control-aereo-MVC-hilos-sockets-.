/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

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
import java.util.Iterator;
import java.util.Map;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class Json
{

    public Json() {
    }
    public static void leerJSON(){
        JSONParser jsonParser = new JSONParser();
       
        try (FileReader reader = new FileReader("vuelosInfo.json"))
        {
            Object obj = jsonParser.parse(reader); //leer el archivo
            JSONObject jsonObj = (JSONObject) obj;
            JSONArray avion = (JSONArray) jsonObj.get("Avion");
            //---------------------------------------------
            
            //JSONArray platoFuerte = (JSONArray) jsonObj1.get("PlatoFuerte"); //separa en arreglos

            //System.out.println(jsonObj1.toString());
            JSONObject jsonObj2;
            String nombre, tipo, estado;
            ArrayList<Vuelo> vuelos= new ArrayList<>();
            for(int i=0;i<20;i++){
                JSONObject jsonObj1 = (JSONObject) avion.get(i);
                nombre=jsonObj1.get("nombre").toString();
                tipo=jsonObj1.get("tipo").toString();
                estado=jsonObj1.get("estado").toString();
                Vuelo elVuelo= new Vuelo(nombre,estado,tipo);
                vuelos.add(elVuelo);
                //System.out.println(jsonObj1.toString());
            }
            
            for(int i=0;i<vuelos.size();i++){
                System.out.println(vuelos.get(i).toString()+"\n");
            }
//      
//            //---------------------------------------------
//            for (int i = 0; i < platoFuerte.size(); i++) {
//                jsonObj2 = (JSONObject) platoFuerte.get(i);
//                nombre = jsonObj2.get("nombre").toString();
//                precio = jsonObj2.get("precio").toString();
//                duracion = jsonObj2.get("duracion").toString();
//                peso = jsonObj2.get("peso").toString();
//                tamano = jsonObj2.get("tamano").toString();
//                PlatoFuerte plato = new PlatoFuerte(
//                        tamano,
//                        nombre,
//                        Float.valueOf(precio),
//                        Integer.parseInt(duracion),
//                        Integer.parseInt(peso)
//                        
//                );
//                menuRestaurante.platillos.add(plato);
//            }
           
            
 
         
         
        } catch (Exception e) {
            e.toString();
        } 
    }
  }

