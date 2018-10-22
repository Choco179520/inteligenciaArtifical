/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author USRBET
 */
public class Agente1 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new ComportamientoAgente1());
    }

    @Override
    protected void takeDown() {

        System.out.println("No quiero morir, ahhhhhhhh");

    }

    class ComportamientoAgente1 extends SimpleBehaviour {

        private boolean bandera = false;

        @Override
        public void action() {
            System.out.println(getName());
            ACLMessage msj = new ACLMessage(ACLMessage.REQUEST);
            AID aid = new AID();
            aid.setLocalName("Agente2");
            msj.addReceiver(aid);//quien Reci.
            msj.setSender(getAID());
            msj.setContent("Hola soy " + getName());
            msj.setConversationId("ag1-ag2");
            msj.setLanguage("Spanish");
            send(msj);

            ACLMessage msj2 = blockingReceive();
            System.out.println(msj2);
            //bandera = true;
            //doDelete();
        }

        @Override
        public boolean done() {
            return bandera;
        }

    }
}
