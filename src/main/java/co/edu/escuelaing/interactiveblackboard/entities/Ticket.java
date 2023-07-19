package co.edu.escuelaing.interactiveblackboard.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ticket {
    private static final Ticket instance = new Ticket();
    private List<String> tickets;
    private List<String> ips;
    public Ticket(){
        tickets = new ArrayList<>();
        ips = new ArrayList<>();
    }
    /**
     * 
     * @return
     */
    public static Ticket getInstance() {
        return instance;
    }
    /**
     * 
     * @param message
     * @return
     */
    public boolean checkTicket(String message){
        boolean flag = false;
        if(!(tickets.contains(message))){
            flag = true;
        }
        return flag;
    }
    /**
     * 
     * @return
     */
    public List<String> getTickets() {
        return this.tickets;
    }
    /**
     * 
     * @param ip
     * @return
     */
    public String setPrivateHash(String ip) {
        int cont = tickets.size();
        Random filtro = new Random();
        cont = cont + filtro.hashCode();
        cont++;
        String cadena = "";
        if(!(checkTicket(ip))){
            tickets.add(ip);
            cadena = ""+ cont;   
        }
        return cadena;
    }


}

