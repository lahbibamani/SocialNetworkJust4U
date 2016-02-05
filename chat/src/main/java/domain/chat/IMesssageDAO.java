package domain.chat;

import java.util.List;

public interface IMesssageDAO {

	void createMessage(Message m) throws Exception;
	void updateMessage(Message m) throws Exception;
	void deleteMessage(Message m) throws Exception;
	Message retrieveMessage(long id) throws Exception;
	List<Message> retrieveAllMessages() throws Exception;
	List<Message> retrieveBySenderAndReceiver(Object sender, Object receiver) throws Exception;
	
}
