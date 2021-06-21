import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author netosolis
 */
public class HiloServidor implements Runnable{
    //Declaramos las variables que utiliza el hilo para estar recibiendo y mandando mensajes
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    //Lista de los usuarios conectados al servidor
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
    public ArrayList<Puerta> puertas=new ArrayList<>();
    public ArrayList<Pista> pistas=new ArrayList<>();
    
    //Constructor que recibe el socket que atendera el hilo y la lista de usuarios conectados
    public HiloServidor(Socket soc,LinkedList users){
        socket = soc;
        usuarios = users;
    }
    
    
    @Override
    public void run() {
        try {
            //Inicializamos los canales de comunicacion y mandamos un mensaje de bienvenida
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("000-inicio");
            pistas.add(new Pista(1,0,"Pequeña"));
            pistas.add(new Pista(2,0,"Mediana"));
            pistas.add(new Pista(3,0,"Grande"));
            puertas.add(new Puerta(1,0,"Pequeña"));
            puertas.add(new Puerta(2,0,"Mediana"));
            puertas.add(new Puerta(3,0,"Grande"));
            //Ciclo infinito para escuchar por mensajes del cliente
            while(true){
                String recibido = in.readUTF();
                String[] listaMensaje = recibido.split("-");
                
                if("03".equals(listaMensaje[0])){
                    recibido = "04-"+getPistas();
                    for (int i = 0; i < usuarios.size(); i++) {
                        out = new DataOutputStream(usuarios.get(i).getOutputStream());
                        out.writeUTF(recibido);
                    } 
                }
                if("999".equals(listaMensaje[0])){
                    cambiarEstadoPista(listaMensaje[1]);
                    recibido = "05-"+getPuertas()+getPistas();
                    for (int i = 0; i < usuarios.size(); i++) {
                        out = new DataOutputStream(usuarios.get(i).getOutputStream());
                        out.writeUTF(recibido);
                    } 
                }
                if("998".equals(listaMensaje[0])){
                    cambiarEstadoPuerta(listaMensaje[1]);
                    recibido = "05-"+getPistas()+getPuertas();
                    for (int i = 0; i < usuarios.size(); i++) {
                        out = new DataOutputStream(usuarios.get(i).getOutputStream());
                        out.writeUTF(recibido);
                    } 
                }
                else{
                    //System.out.println("Lo que el servidor recibe: "+recibido);
                    //Cuando se recibe un mensaje se envia a todos los usuarios conectados 
                     for (int i = 0; i < usuarios.size(); i++) {
                         out = new DataOutputStream(usuarios.get(i).getOutputStream());
                         out.writeUTF(recibido);
                     }
                }
            }
        } catch (IOException e) {
            //Si ocurre un excepcion lo mas seguro es que sea por que el cliente se desconecto asi que lo quitamos de la lista de conectados
            for (int i = 0; i < usuarios.size(); i++) {
                if(usuarios.get(i) == socket){
                    usuarios.remove(i);
                    break;
                } 
            }
        } 
    }

    public void cambiarEstadoPista(String nombre){
        for (int i = 0; i < pistas.size(); i++) {
            if(pistas.get(i).tamano.equals(nombre)){
                if(pistas.get(i).estado==0){
                    pistas.get(i).estado = 1;
                }
                else{
                    pistas.get(i).estado = 0;
                }
            }
            
        }
        
    }
    public void cambiarEstadoPuerta(String nombre){
        for (int i = 0; i < puertas.size(); i++) {
            if(puertas.get(i).tamano.equals(nombre)){
                if(puertas.get(i).estado==0){
                    puertas.get(i).estado = 1;
                }
                else{
                    puertas.get(i).estado = 0;
                }
            }
            
        }
        
    }
    public String getPistas(){
        String var="";
        for(int i=0;i<pistas.size();i++){
            var+="\n "+pistas.get(i).toString();
        }
        return var;
    }
    
    public String getPuertas(){
        String var="";
        for(int i=0;i<puertas.size();i++){
            var+="\n "+puertas.get(i).toString();
        }
        return var;
    }
}
