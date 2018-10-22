/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author USRBET
 */
public class Agente2 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new ComportamientoAgente2());
    }

    @Override
    protected void takeDown() {

        System.out.println("No quiero morir Agente2, ahhhhhhhh");

    }

    class ComportamientoAgente2 extends SimpleBehaviour {

        private boolean bandera = false;

        @Override
        public void action() {
            System.out.println(getName());
            ACLMessage msj = blockingReceive();
            System.out.println(msj);
            
            
            
            ACLMessage msj2 = new ACLMessage(ACLMessage.INFORM);
            msj2.addReceiver(msj.getSender());//quien Reci.
            msj2.setSender(getAID());
            msj2.setContent("y?");
            msj2.setConversationId("ag2-ag1");
            msj2.setLanguage("Spanish");
            send(msj2);
            
            
            //bandera = true;
           // doDelete();
        }

        @Override
        public boolean done() {
            return bandera;
        }

    }
}
