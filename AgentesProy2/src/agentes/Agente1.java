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
import java.util.StringTokenizer;

/**
 *
 * @author USRBET
 */
public class Agente1 extends Agent {

    private String aidAgentePadre = "Agente2";

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
            aid.setLocalName(aidAgentePadre);
            msj.addReceiver(aid);//quien Reci.
            msj.setSender(getAID());
            msj.setContent("Hola soy " + getName());
            msj.setConversationId("ag1-ag2");
            msj.setLanguage("Spanish");
            send(msj);

            ACLMessage msj2 = blockingReceive();
            System.out.println(msj2);
            String contenido = msj2.getContent();
            String[] content = contenido.split(" ");
            if (content[0].equalsIgnoreCase("mori")) {
                aidAgentePadre = content[1];
            }
//            for (StringTokenizer stringTokenizer = new StringTokenizer(contenido);
//                    stringTokenizer.hasMoreTokens();) {
//                String token = stringTokenizer.nextToken();
//                
//            }
            //bandera = true;
            //doDelete();
        }

        @Override
        public boolean done() {
            return bandera;
        }

    }
}
