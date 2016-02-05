package bussiness.service_layer;

import java.util.List;

import domain.chat.Message;
import fr.unicaen.am.model.Comment;
import fr.unicaen.am.model.UserService;

public interface ICommentService {

	boolean addMessage(Message m);
	boolean editMessage(Message m);
	boolean removeMessage(long id);
	Message getMessageById(long id);
	List<Message> getAllMessages();
	List<Message> getMessagesBySenderAndReceiver(Object sender, Object receiver);
	List<Comment> getMessagesByUserService(UserService userService);
	List<Comment> getMessagesByReceiver(Object receiver);
	List<Comment> getMessagesBySender(Object sender);
}
