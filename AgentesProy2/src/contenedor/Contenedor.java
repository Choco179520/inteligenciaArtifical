/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedor;

import agentes.Agente1;
import agentes.Agente2;
import agentes.AgenteH;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USRBET
 */
public class Contenedor {

    //variables Agent Controller y agent Container
    AgentContainer mainContenedor;
    AgentController agentController;

    public void inicializarContenedor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        runtime.setCloseVM(true);
        //profile
        Profile profile = new ProfileImpl(null, 1099, null);
        mainContenedor = runtime.createMainContainer(profile);
        inicializarAgentes();
    }

    private void inicializarAgentes() {
        try {
            agentController = mainContenedor.createNewAgent("Agente1", Agente1.class.getName(), null);
            agentController.start();

            mainContenedor.createNewAgent(
                    "Agente2",
                    Agente2.class.getName(),
                    new Object[]{this}).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearHijo(String nickname, Object[] conocimiento) {
        try {
            mainContenedor.createNewAgent(
                    nickname,
                    AgenteH.class.getName(),
                    conocimiento).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
