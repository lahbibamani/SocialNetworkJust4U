package bussiness.service_layer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.chat.Message;
import fr.unicaen.am.dao.IMesssageDAO;
import fr.unicaen.am.model.Comment;
import fr.unicaen.am.model.UserService;

/**
 * Classe de service encapsulant les traitements métiers liée à la gestion des commentaires au sein d'une transaction (Bean spring : Service)
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */

@Service
@Transactional
public class CommentServiceImpl implements ICommentService{
	
	@Autowired
	private IMesssageDAO commentDAO;

	@Override
	public boolean addMessage(Message m) {
		try {
			commentDAO.createMessage(m);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}




	@Override
	public boolean editMessage(Message m) {
		try {
			commentDAO.updateMessage(m);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}




	@Override
	public boolean removeMessage(long id) {
		try {
			Comment comment = (Comment) commentDAO.retrieveMessage(id);
			commentDAO.deleteMessage(comment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}




	@Override
	public Message getMessageById(long id) {
		try {
			return commentDAO.retrieveMessage(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}




	@Override
	public List<Message> getAllMessages() {
		try {
			return commentDAO.retrieveAllMessages();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}




	@Override
	public List<Message> getMessagesBySenderAndReceiver(Object sender, Object receiver) {
		try {
			return commentDAO.retrieveBySenderAndReceiver(sender, receiver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Comment> getMessagesBySender(Object sender) {
		try {
			return commentDAO.retrieveBySender(sender);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Comment> getMessagesByReceiver(Object receiver) {
		try {
			return commentDAO.retrieveByReceiver(receiver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}




	@Override
	public List<Comment> getMessagesByUserService(UserService userService) {
		try {
			return commentDAO.retrieveByUserService(userService);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
