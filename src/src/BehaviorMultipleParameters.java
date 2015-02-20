package src;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BehaviorMultipleParameters implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, Set<String>> p = new HashMap<>();
	private String name;

	public BehaviorMultipleParameters(String name) {
		this.name = name;
	}

	public void addElement(String chave, String elemento) {
		Set<String> temp = (Set<String>) p.get(chave);
		if (temp == null) {
			Set<String> s = new HashSet<String>();
			s.add(elemento);
			p.put(chave, s);
		} else {
			temp.add(elemento);
			p.put(chave, temp);
		}
	}

	public Set<String> getElements(String chave) {
		return p.get(chave);
	}

	public Map<String, Set<String>> getMap() {
		return p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addSetOfElements(String key, Set<String> set) {
		for (String value : set) {
			this.addElement(key, value);
		}
	}

	public void removeElement(String key) {
		p.remove(key);
	}
}
