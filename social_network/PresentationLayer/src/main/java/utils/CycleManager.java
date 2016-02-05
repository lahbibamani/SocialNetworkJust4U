package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bussiness.service_layer.IUserService;
import domain.service.Service;
import fr.unicaen.am.model.Echange;
import fr.unicaen.am.model.User;
/**
 * Classe respensable de la recherche des cycles d'échange entre plusieurs utilisateur (max 10)
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
public class CycleManager {

	private Map<String, List<Relation>> closedMap;
	private List<User> openQueue;
	private Map<User, List<Service>> demande;

	public CycleManager() {
		closedMap = new HashMap<>();
		demande = new HashMap<>();
		openQueue = new ArrayList<User>();
	}

	public List<List<Echange>> computeCycle(User p1) {
		System.out.println(closedMap);
		List<List<Echange>> listFinale = new ArrayList<>();
		List<Echange> le = new ArrayList<>();
		Relation r = closedMap.get(p1.getEmail()).get(1);
		User succ = r.getUser();
		Service serviceP1 = r.getService();
		List<Relation> lr = closedMap.get(succ.getEmail());
		for (Relation r2 : lr) {
			le = new ArrayList<>();
			le.add(new Echange(p1, succ, serviceP1));
			r.setUser(succ);
			if (r2.getUser() != null) {
				while (!r2.getUser().getEmail().equals(p1.getEmail())) {
					le.add(new Echange(r.getUser(), r2.getUser(), r2.getService()));
					r = r2;
					r2 = closedMap.get(r.getUser().getEmail()).get(0);
				}
				le.add(new Echange(r.getUser(), r2.getUser(), r2.getService()));
				listFinale.add(le);
			}
		}
		System.out.println(listFinale.toString());
		return listFinale;
	}

	public List<List<Echange>> searchCycle(User p1, Service s1, IUserService userService) {
		openQueue.add(p1);

		List<Relation> r = new ArrayList<>();
		r.add(new Relation(0));
		closedMap.put(p1.getEmail(), r);

		List<Service> d = new ArrayList<>();
		d.add(s1);
		demande.put(p1, d);

		while (closedMap.size() != 10 && !openQueue.isEmpty()) {
			User p = openQueue.remove(0);
			int niveauP = closedMap.get(p.getEmail()).get(0).getNiveau();
			if (demande.get(p) == null)
				demande.put(p, userService.getServicesDemande(p.getEmail()));
			for (Service s : demande.get(p)) {
				List<User> listUser = userService.getPersonsOfferingService(s);
				if (listUser != null) {
					for (User u : listUser) {
						if (u.getEmail().equals(p1.getEmail())) {
							closedMap.get(p1.getEmail()).add(new Relation(s, p, 0));
							return computeCycle(p1);
						}
						if (closedMap.get(u.getEmail()) == null) {
							openQueue.add(u);
							r = new ArrayList<>();
							r.add(new Relation(s, p, niveauP + 1));
							closedMap.put(u.getEmail(), r);
						} else if (niveauP + 1 == closedMap.get(u.getEmail()).get(0).getNiveau()) {
							closedMap.get(u.getEmail()).add(new Relation(s, p, niveauP + 1));
						}
					}
				}
			}
		}

		return null;
	}

}
