/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author USRBET
 */
public class AgenteH extends Agent{

    @Override
    protected void setup() {
        addBehaviour(new ComportamientoAgenteH()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void takeDown() {
        super.takeDown(); //To change body of generated methods, choose Tools | Templates.
    }
     class ComportamientoAgenteH extends SimpleBehaviour {

        private boolean bandera = false;

        @Override
        public void action() {
            System.out.println(getName());
            ACLMessage msj = blockingReceive();
            //System.out.println(msj);
            
            ACLMessage msj2 = new ACLMessage(ACLMessage.INFORM);
            msj2.addReceiver(msj.getSender());//quien Reci.
            msj2.setSender(getAID());
            msj2.setContent(getArguments()[0].toString()+" yo soy: "+getName());
            msj2.setConversationId("agh-ag1");
            msj2.setLanguage("Spanish");
            send(msj2);
            
            
            //bandera = true;
            //doDelete();
        }

        @Override
        public boolean done() {
            return bandera;
        }

    }
}
