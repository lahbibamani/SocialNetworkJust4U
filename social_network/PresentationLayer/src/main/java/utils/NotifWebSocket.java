package utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import fr.unicaen.am.model.Echange; 
/**
 * Classe de web socket responsable de l'envoi des notifs aux utilisateurs impliqués à un cycle suite à une demande de l'un des utilisateurs
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
@ServerEndpoint(
	    value = "/notifications/{email}")
public class NotifWebSocket {

	 private static final Map<String,Session> sessions = new HashMap<>();
	 private static final Map<String,Boolean> connected = new HashMap<>();
	 
	 @OnMessage
	   public void onMessage(Session session, String msg) {
		 System.out.println(msg);
	     
	   }   

	   
	   @OnOpen
	   public void onOpen(Session session,@PathParam(value = "email") String email) throws IOException, EncodeException { 
		   sessions.remove(email);
		   sessions.put(email,session);
	      System.out.println("connected---------------------------"+email);
	    } 
	   
	   public static void sendNotif(List<Echange> echanges,long id,String email){
		   System.out.println("sendMsg---------------------------");
		   for(Echange echange : echanges)
			try {
				String _email = echange.getOffrant().getEmail();
				if(!_email.equals(email))
				{
					if(sessions.get(_email)!=null)
				sessions.get(_email).getBasicRemote().sendText(email+":"+id);
				} 
			}catch (IOException e) {
				e.printStackTrace();
			}
	   }

	   @OnClose
	   public void onClose(Session session) throws IOException, EncodeException { 
		   System.out.println("closed ------------------------------");
	      //sessions.remove(session); 
	   }
}
