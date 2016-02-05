package bussiness.service_layer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.unicaen.am.dao.ICycleDAO;
import fr.unicaen.am.dao.IEchangeDAO;
import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.Echange;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;


/**
 * Classe de service encapsulant les traitements métiers liée à la gestion des cycles (Bean spring : Service)
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
@Service
@Transactional
public class CycleService implements ICycleService{
	
	@Autowired
	private ICycleDAO cycleDao;
	
	@Autowired
	private IEchangeDAO echangeDao;

	@Override
	public boolean addCycle(Cycle cycle, List<Echange> echanges) {
		try {
			Long id = cycleDao.createCycle(cycle);
			cycle.setId(id);
			for(Echange echange : echanges){
				echange.setCycle(cycle);
				echange.setAccepted(false);
				echangeDao.createEchange(echange);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateCycle(Cycle cycle,Echange echange) {
		try {
			//cycleDao.updateCycle(cycle);
			echangeDao.updateEchange(echange);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Cycle getCycleById(long id) {
		try {
			Cycle cycle = cycleDao.retrieveCycle(id);
			List<Echange> echanges = echangeDao.retrieveByCycle(cycle);
			cycle.setEchanges(echanges);
			return cycle;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Cycle> getAllCycles() {
		try {
			return cycleDao.retrieveAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean removeCycle(long id) {
		try {
			echangeDao.deleteEchangeByCycleId(id);
			cycleDao.deleteCycle(id);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Cycle> getByUserServices(UserService userService) {
		List<Cycle> cycles;
		try {
			cycles = cycleDao.retrieveByUserServices(userService);
			for (Cycle cycle : cycles){
				cycle.setEchanges(echangeDao.retrieveByCycle(cycle));
			}
			return cycles;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public List<Cycle> getByOffrant(User user) {
		List<Cycle> cycles;
		try {
			cycles = cycleDao.getByOffrant(user);
			for(Cycle cycle : cycles)
				cycle.setEchanges(echangeDao.retrieveByCycle(cycle));
			return cycles;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Cycle> getByDemandeur(User user) {
		List<Cycle> cycles;
		try {
			cycles = cycleDao.getByDemandeur(user);
			for(Cycle cycle : cycles)
				cycle.setEchanges(echangeDao.retrieveByCycle(cycle));
			return cycles;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*@Override
	public boolean deleteCycleByUserService(long id) {
		
		try {
			echangeDao.deleteEchangeByCycleId(id);
			cycleDao.deleteCycleByUserService(id);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}*/
	
	
	
}
