package corbaServer;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import service.ConversionImpl;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ConversionServer {// publier l'objet distant
    public static void main(String[] args) {
        try {
            // a init orb,orb:initialiser mon middleware
            ORB orb = ORB.init(args, null);// sna3 automatiquement un poamanager,args:@ip,port
            // b(1) init poamanager

            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));// n3ady reference mt3
            // poamanager,retourne une instance
            // de poa
            // b(2) activation poamanager
            poa.the_POAManager().activate();
            // c configuration jndi
            Context ctx = new InitialContext();// zdna fl jndi les propriétés
            // d. creation du serviteur (objet distant)
            ConversionImpl od = new ConversionImpl();
            // e. rendre l'objet distant disponible sur ,publication de l'od
            ctx.rebind("od", poa.servant_to_reference(od));
            // f. running du ORB
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
