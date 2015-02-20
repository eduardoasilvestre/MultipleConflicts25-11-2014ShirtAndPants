package src;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class ConflictCheckerMultipleNorms {
	
	private List<List<Norm>> groupNorms  = null;
	private Map<String,Set<String>> mapOfParameters = null;
	
	public final static String GARMENT_SET = "GARMENT_SET";
	public final static String EQUAL = "A";
	public final static String DIFF = "!A";
	
	public ConflictCheckerMultipleNorms() {
		groupNorms = new ArrayList<List<Norm>>();
		
		mapOfParameters = new HashMap<String, Set<String>>();
		mapOfParameters.put("garment", SetUtil.GARMENT_SET_ELEMENTS);
		mapOfParameters.put("color", SetUtil.COLOR_ELEMENTS);
		mapOfParameters.put("ironingtype", SetUtil.IRONING_ELEMENTS);
		mapOfParameters.put("picture", SetUtil.PICTURE_ELEMENTS);
		
	}
	
	public void verifyMultipleConflict() {
		List<List<Norm>> conflicts  = new ArrayList<List<Norm>>();
		
		List<List<Norm>> groupNormsCopy  = new ArrayList<List<Norm>>();
		
		for (List<Norm> norms : groupNorms) {
			groupNormsCopy.add(norms);
		}
		
		for(int i = 0; i < groupNormsCopy.size(); i++) {
			List<Norm> normsTemp = groupNormsCopy.get(i);	
			if (normsTemp.size() < 2) {
				continue;
			}
			//change the parameter j to change the length of analysis
			for (int j = 2; j <= normsTemp.size();j++) {
				List<List<Norm>> normsNtoN = this.generateAllCombinations(normsTemp, j);
				List<List<Norm>> normsRet = this.verifyConflicts(normsNtoN);
				conflicts.addAll(normsRet);
				normsNtoN.clear();
			}
		}
		System.out.println("THE FOLLOWING NORMS ARE IN CONFLICT:");
		this.printNorms(conflicts);
		
	}
	
	private List<List<Norm>> verifyConflicts(List<List<Norm>> norms) {
		List<List<Norm>> normsRet  = new ArrayList<List<Norm>>();
		for (int i = 0; i < norms.size(); i++) {
			List<Norm> normsTemp = norms.get(i);
			if (!isTherePossibilityOfConflict(normsTemp)) {
				continue;
			}
			List<Norm> normsPerm = this.convertNormsToPermitted(normsTemp);
			
			if (this.isThereConflict(normsPerm)) {
				normsRet.add(normsTemp);
			}
		}
		return normsRet;
	}
	
	
	private boolean isTherePossibilityOfConflict(List<Norm> norms) {
		//CASE 1 - (verified previously) - it's necessary at least 2 norms
		List<Norm> normsCopy  = new ArrayList<Norm>();
		
		for (Norm norm : norms) {
			normsCopy.add((Norm)this.deepClone(norm));
		}
		
		//CASE 2
		//verify the norm set in the case that all norms are permissions. Conflicts with only permission happens if:
		//1 - has variable; 2 - has not. Another cases don't have conflicts
		//in this version is not considered the expression of NOT
		int normsCounter = 0;
		for (int i = 0; i < norms.size(); i++) {
			if (norms.get(i).getDeonticConcept().equals(DeonticConcept.PERMISSION)) {
				normsCounter++;
			}
		}
		boolean variableOrNot = false;
		if (normsCounter == norms.size()) {
			for (int i = 0; i < norms.size(); i++) {
				Set<String> x = norms.get(i).getBehavior().getElements("garment");
				if (SetUtil.hasOneElement(x) && (/*NORMASPERM[i].color == hasNOT ||*/x.contains(GARMENT_SET))) {
					variableOrNot = true;
					break;
				}
			}
			//if there is not NOT and don't have variable its is impossible to have conflict
			if (!variableOrNot) {
				return false;
			}
		}
		
		//CASE 3
		//if the set of norms are two it is not permitted to have variables
		if (norms.size() == 2) {
			for (int i = 0; i < norms.size(); i++) {
				Set<String> x = norms.get(i).getBehavior().getElements("garment");
				if (SetUtil.hasOneElement(x) && x.contains(GARMENT_SET)) {
					return false;
				}
			}
		}
		
		boolean flagPant = false;
		boolean flagShirt = false;
		boolean flagGarmentSet = false;
		for (Norm extern : norms) {
			Set<String> x = extern.getBehavior().getElements("garment");
			if (SetUtil.hasOneElement(x) && x.contains(GARMENT_SET)) {
				flagGarmentSet = true;
				for (Norm intern : normsCopy) {
					Set<String> y = intern.getBehavior().getElements("garment");
					if (SetUtil.hasOneElement(y) && y.contains("pant")) {
						flagPant = true;
					}
					Set<String> z = intern.getBehavior().getElements("garment");
					if (SetUtil.hasOneElement(z) && z.contains("shirt")) {
						flagShirt = true;
					}
				}
			}
		}
		if(flagGarmentSet && !(flagPant && flagShirt)) {
			return false;
		}
		
		//CASE 5
		//it is permitted to have only ONE variable (equal or different)
		boolean flagGarment = false;
		for (int i = 0; i < norms.size(); i++) {
			Set<String> x = norms.get(i).getBehavior().getElements("garment");
			if (SetUtil.hasOneElement(x) && x.contains(GARMENT_SET)) {
				if (flagGarment) {
					return false;
				}
				flagGarment = true;
			}
		}
		return true;
	}
	
	private List<Norm> convertNormsToPermitted(List<Norm> norms) {
		List<Norm> normsCopy  = new ArrayList<Norm>(); //contains a clone of list norms
		
		List<Norm> normsPermTemp  = new ArrayList<Norm>();
		
		for (Norm norm : norms) {
			normsCopy.add((Norm)this.deepClone(norm));
		}
		
		for (Norm norm : normsCopy) {
			if (norm.getDeonticConcept().equals(DeonticConcept.PERMISSION) || norm.getDeonticConcept().equals(DeonticConcept.OBLIGATION)) {
				Set<String> x = norm.getBehavior().getElements("garment");
				if (SetUtil.hasOneElement(x) && x.contains(GARMENT_SET)) {
					
					Iterator<String> it = SetUtil.GARMENT_SET_ELEMENTS.iterator();
					boolean flagFirst = true;
					Set<String> y = norm.getBehavior().getElements("color");
					while(it.hasNext()) {
						String garmentTemp = it.next();
						
						Norm newNorm = null;
						if (SetUtil.hasOneElement(y) && y.contains(EQUAL)) {
							BehaviorMultipleParameters behavior = new BehaviorMultipleParameters(norm.getBehavior().getName());
							behavior.addElement("garment", garmentTemp);
							behavior.addElement("color", EQUAL);
							
							newNorm = new Norm(-1, DeonticConcept.PERMISSION, norm.getContext(), norm.getEntity(), behavior, norm.getActivationConstraint(), norm.getDeactivationConstraint(), norm.getState());
						} else if (SetUtil.hasOneElement(y) && y.contains(DIFF)) {
							if (flagFirst) {
								flagFirst = false; //after the first execution this if-case cannot be executed anymore
								
								BehaviorMultipleParameters behavior = new BehaviorMultipleParameters(norm.getBehavior().getName());
								behavior.addElement("garment", garmentTemp);
								behavior.addElement("color", EQUAL);
								
								newNorm = new Norm(-1, DeonticConcept.PERMISSION, norm.getContext(), norm.getEntity(), behavior, norm.getActivationConstraint(), norm.getDeactivationConstraint(), norm.getState());
							} else {
								BehaviorMultipleParameters behavior = new BehaviorMultipleParameters(norm.getBehavior().getName());
								behavior.addElement("garment", garmentTemp);
								behavior.addElement("color", DIFF);
								
								newNorm = new Norm(-1, DeonticConcept.PERMISSION, norm.getContext(), norm.getEntity(), behavior, norm.getActivationConstraint(), norm.getDeactivationConstraint(), norm.getState());
							}
						}
						normsPermTemp.add(newNorm);
					}
				} else {		
					//at this moment can be prohition or obligation
					norm.setDeonticConcept(DeonticConcept.PERMISSION);
					normsPermTemp.add(norm);
				}
			} else if (norm.getDeonticConcept().equals(DeonticConcept.PROHIBITION)) {
				Set<String> x = norm.getBehavior().getElements("garment");
				if (SetUtil.hasOneElement(x) && x.contains(GARMENT_SET)) {
					
					Iterator<String> it = SetUtil.GARMENT_SET_ELEMENTS.iterator();
					boolean flagFirst = true;
					Set<String> y = norm.getBehavior().getElements("color");
					while(it.hasNext()) {
						String garmentTemp = it.next();
						
						Norm newNorm = null;
						if (SetUtil.hasOneElement(y) && y.contains(DIFF)) {
							BehaviorMultipleParameters behavior = new BehaviorMultipleParameters(norm.getBehavior().getName());
							behavior.addElement("garment", garmentTemp);
							behavior.addElement("color", EQUAL);
							
							newNorm = new Norm(-1, DeonticConcept.PERMISSION, norm.getContext(), norm.getEntity(), behavior, norm.getActivationConstraint(), norm.getDeactivationConstraint(), norm.getState());
						} else if (SetUtil.hasOneElement(y) && y.contains(EQUAL)) {
							if (flagFirst) {
								flagFirst = false; //after the first execution this if-case cannot be executed anymore
								
								BehaviorMultipleParameters behavior = new BehaviorMultipleParameters(norm.getBehavior().getName());
								behavior.addElement("garment", garmentTemp);
								behavior.addElement("color", EQUAL);
								
								newNorm = new Norm(-1, DeonticConcept.PERMISSION, norm.getContext(), norm.getEntity(), behavior, norm.getActivationConstraint(), norm.getDeactivationConstraint(), norm.getState());
							} else {
								BehaviorMultipleParameters behavior = new BehaviorMultipleParameters(norm.getBehavior().getName());
								behavior.addElement("garment", garmentTemp);
								behavior.addElement("color", DIFF);
								
								newNorm = new Norm(-1, DeonticConcept.PERMISSION, norm.getContext(), norm.getEntity(), behavior, norm.getActivationConstraint(), norm.getDeactivationConstraint(), norm.getState());
							}
						}
						Map<String,Set<String>> mapParameters = norm.getBehavior().getMap();
						BehaviorMultipleParameters bTemp = new BehaviorMultipleParameters(norm.getBehavior().getName());
						
						for (Map.Entry<String,Set<String>> entry : mapParameters.entrySet()) {
					  		String key = entry.getKey();
					  		if ("garment".equals(key)) {
					  			bTemp.addSetOfElements("garment", newNorm.getBehavior().getElements("garment"));
					  			continue;
					  		} if ("color".equals(key)) { 
					  			bTemp.addSetOfElements("color", newNorm.getBehavior().getElements("color"));
					  			continue;
					  		}
					  			
					  		Set<String> notElement = SetUtil.difference(mapOfParameters.get(key), norm.getBehavior().getElements(key));
					  		bTemp.addSetOfElements(key, notElement);
						}
						newNorm.setBehavior(bTemp);
						
						normsPermTemp.add(newNorm);
					}
				} else {
					Map<String,Set<String>> mapParameters = norm.getBehavior().getMap();
					
					Norm newNorm = new Norm(-1, DeonticConcept.PERMISSION, norm.getContext(), norm.getEntity(), norm.getBehavior(), norm.getActivationConstraint(), norm.getDeactivationConstraint(), norm.getState());
					
					BehaviorMultipleParameters bTemp = new BehaviorMultipleParameters(norm.getBehavior().getName());
					
					for (Map.Entry<String,Set<String>> entry : mapParameters.entrySet()) {
				  		String key = entry.getKey();
				  		if ("garment".equals(key)) {
				  			bTemp.addSetOfElements("garment", entry.getValue());	
				  			continue;
				  		}
				  		Set<String> notElement = SetUtil.difference(mapOfParameters.get(key), norm.getBehavior().getElements(key));
				  		bTemp.addSetOfElements(key, notElement);				
					}
					
					newNorm.setBehavior(bTemp);
					normsPermTemp.add(newNorm);
				}
			}
		}
		return normsPermTemp;
	}

	private boolean isThereConflict(List<Norm> norms) {
		Map<String,Set<String>> mapParameters = norms.get(0).getBehavior().getMap();
		
		String parameterEqualDiff = "garment";
		String parameterColor = "color";
		Set<String> normsParameters = SetUtil.GARMENT_SET_ELEMENTS; //quantity of parameterEqualDiff
		
		Set<String> normsParametersUsed = new TreeSet<String>(); //norms parameters used
		
		//stores a copy of a norm that have equal or diff
		Norm normEqualDiff = null;
		
		//creates a clone of the initial set of norms
		List<Norm> normsCopy  = new ArrayList<Norm>();
		for (Norm norm : norms) {
			normsCopy.add((Norm)this.deepClone(norm));
		}
		
		//stores the value of EQUAL,DIFF or null in the variable resultEqualDiff
		//To safely remove from a collection while iterating over it you should use an Iterator.
		Set<String> resultEqualDiff = null;
		Iterator<Norm> iterator = normsCopy.iterator();
		while(iterator.hasNext()) {
			Norm ned = iterator.next();
			Map<String,Set<String>> mapTemp = ned.getBehavior().getMap();
	    	Set<String> values = mapTemp.get(parameterColor);
			
	    	if (SetUtil.hasOneElement(values) && (values.contains(EQUAL) || values.contains(DIFF))) {
	    		if (resultEqualDiff == null) {
	    			resultEqualDiff = values;
	    		} else if (SetUtil.hasOneElement(values) && values.contains(DIFF)) {
	    			resultEqualDiff = values;
	    		}
				if (normEqualDiff == null) {
	    			normEqualDiff = (Norm)deepClone(ned);
	    		}
	    		
	    		iterator.remove(); //remove the norm that has EQUAL or DIFF from normsCopy
	    	}
		}
		//this for prepares the data for the intersections
		Map<String,Set<String>> mapEqualDiff = new HashMap<>();
		if (resultEqualDiff != null) {
			for (Map.Entry<String,Set<String>> entry : mapParameters.entrySet()) {
				String keyEqualDiff = entry.getKey();
				
				if ("garment".equals(keyEqualDiff) || "color".equals(keyEqualDiff) ) {
		  			continue;
		  		}
				mapEqualDiff.put(keyEqualDiff, normEqualDiff.getBehavior().getElements(keyEqualDiff));
			}
		}
		
		Map<String,Integer> mapCounter = new HashMap<String,Integer>();
		Map<String,Map<String,Set<String>>> intersections = new HashMap<String, Map<String,Set<String>>>();

		//iterates over each parameter. In this case the parameters are: pant and shirt
		Iterator<String> it = normsParameters.iterator();
	    while (it.hasNext()) {
	    	String parameter = it.next();
	    	
	    	//inserts in normTemp each norm that has 'parameter'
	    	List<Norm> normsTemp  = new ArrayList<>();
	    	for (Norm normTemp: normsCopy)  {
	    		Set<String> normsParametersTemp = normTemp.getBehavior().getMap().get(parameterEqualDiff);
	    		if (SetUtil.hasOneElement(normsParametersTemp) && normsParametersTemp.contains(parameter)) {
	    			normsTemp.add(normTemp);
	    		}
	    	}
	    	//if the normsTemp for a specified parameter has at least one element
	    	if (normsTemp.size() > 0) {
	    		Map<String,Set<String>> mapTemp = this.createIntersections(normsTemp,parameterEqualDiff); 
	    		intersections.put(parameter, mapTemp);
	    		normsParametersUsed.add(parameter);//stores the norms parameters used
	    		
	    		//stores the quantity of norms tha interaction was done
	    		int normsTempSize = normsTemp.size();
	    		mapCounter.put(parameter, normsTempSize);
	    	}
	    }
	    
	    Set<String> intersectionParameter = new TreeSet<String>();
	    Map<String,Integer> countParametersFinal = this.initializeCounterOfParameters(mapParameters);

	    //this variable marks if some partial set is different of 1. This case is necessary for the analysis of DIFF
	  	boolean varDiffIntersection = true;
	  	int continueCounter = 0;
	  	//iteraction over all parameters: garment, color, ironing, picture, ...
	  	for (Map.Entry<String,Set<String>> entry : mapParameters.entrySet()) {
	  		String key = entry.getKey();
	  		if (parameterEqualDiff.equals(key)) {
	  			continue;
	  		}
	  		//iteraction over the valores of the parameter garment: pant, shirt, ...
	  		for (Map.Entry<String,Map<String,Set<String>>> entryParameterEqualDiff : intersections.entrySet()) {
	  			String keyParameterEqualDiff = entryParameterEqualDiff.getKey();
		  		Map<String,Set<String>> interTemp = entryParameterEqualDiff.getValue();
		  		
		  		//it is not permitted with one norm and don't have equal of diff
				if (mapCounter.get(keyParameterEqualDiff) == 1 && resultEqualDiff == null) {
					continueCounter++;
					continue;
				}
				
				Set<String> values = interTemp.get(key);

	  			if (!SetUtil.hasOneElement(values)) {
					varDiffIntersection = false;
				}
	  			
	  			if (SetUtil.isFirstInter(key, countParametersFinal)) {
		    		intersectionParameter = SetUtil.union(intersectionParameter, values);
		    		countParametersFinal = SetUtil.addValue(key, countParametersFinal);
		  			
		    		if (resultEqualDiff != null && !"garment".equals(key)  && !"color".equals(key)) {
		  				Set<String> set = mapEqualDiff.get(key);
		  				intersectionParameter = SetUtil.intersection(intersectionParameter, set);
		  			}
		    	} else {
		    		intersectionParameter = SetUtil.intersection(intersectionParameter, values);
		    		//countParametersFinal = SetUtil.addValue(key, countParametersFinal);
		    	}
	  		}
	  		//if has only one norm of each garment parameter 
	  		if (continueCounter == mapCounter.size()) {
	  			return false;
	  		}
	  		
	  		//CASE 1: NO VARIABLE; CASE 2: VARIABLE EQUAL; CASE 3: VARIABLE DIFF (if: CASE 3, else if: CASE 1 and CASE 2)
	  		if (parameterColor.equals(key) && resultEqualDiff != null) {
	  			boolean conditionDiff = SetUtil.hasOneElement(resultEqualDiff) && resultEqualDiff.contains(DIFF);
				if (conditionDiff && SetUtil.hasOneElement(intersectionParameter) && varDiffIntersection) {
					return true;
				} else if (!conditionDiff && SetUtil.isEmpty(intersectionParameter)) {
					return true;
				}
			} else if (SetUtil.isEmpty(intersectionParameter)) {
				return true;
			}

			varDiffIntersection = true;
			intersectionParameter = SetUtil.cleanSet(intersectionParameter);
	  	}
		return false;
	}

	//Makes all intersections
	private Map<String,Set<String>> createIntersections(List<Norm> norms, String excludeParameter) {
		
		//all the norms have the same parameters. Thus, this maps has a reference for all parameters
		Map<String,Set<String>> mapParameters = norms.get(0).getBehavior().getMap();
		Set<String> intersectionParameter = new TreeSet<String>();
		int countParameters = 0;
		
		Map<String,Set<String>> intersections = new HashMap<String, Set<String>>();
		
		for (Map.Entry<String,Set<String>> entry : mapParameters.entrySet()) { //runs map of parameters
		    String key = entry.getKey(); //take a parameter
		    
		    if (excludeParameter.equals(key)) {
		    	continue;
		    }
		    for (Norm n: norms) {
		    	Map<String,Set<String>> mapTemp = n.getBehavior().getMap();
		    	Set<String> values = mapTemp.get(key); //take the set with parameter name 'key'
		    	
		    	//realizes the intersection between the values of a specific parameter
		    	if (countParameters++ == 0) {
		    		intersectionParameter = SetUtil.union(intersectionParameter, values);
		    	} else {
		    		intersectionParameter = SetUtil.intersection(intersectionParameter, values);
		    	}
		    }
		    Set<String> copy = new TreeSet<String>();
		    Iterator<String> it = intersectionParameter.iterator();
		    while (it.hasNext()) {
		    	copy.add((String)this.deepClone(it.next()));
		    }
		    intersections.put(key, copy);
		    countParameters = 0;
		    intersectionParameter = SetUtil.cleanSet(intersectionParameter);
		}	
		return intersections;
	}
	
	private Map<String,Integer> initializeCounterOfParameters(Map<String, Set<String>> mapParameters) {
		Map<String,Integer> countParameters = new HashMap<String,Integer>();
		
		for (Map.Entry<String,Set<String>> entry : mapParameters.entrySet()) { //runs map of parameters
		    String key = entry.getKey(); //take a parameter
		    countParameters.put(key, 0);
		}
		return countParameters;
	}
		
	private List<List<Norm>> generateAllCombinations(List<Norm> norms, int i) {
		//System.out.println("Análise será feita com  o seguinte número de normas: " + i);
		ICombinatoricsVector<Norm> initialVector = Factory.createVector(norms);
		   
		Generator<Norm> gen = Factory.createSimpleCombinationGenerator(initialVector, i);
		
		List<List<Norm>> r = new ArrayList<List<Norm>>();
		
		for (ICombinatoricsVector<Norm> combination : gen) {
			r.add(combination.getVector());
		}
		return r;
	}

	public void insertAndClassifyAllNorms (List<Norm> normSet) {
		for (Norm norm: normSet) {
			this.separateNormsInSetsByInsertion(norm);
		}
	}
	
	private void separateNormsInSetsByInsertion(Norm norm) {
		int n = groupNorms.size();
		if (n == 0) {
			List<Norm> temp = new ArrayList<Norm>();
			temp.add(norm);
			groupNorms.add(temp);
			return;
		}
		
		for (int i = 0; i < groupNorms.size(); i++) {
			List<Norm> temp = groupNorms.get(i);
			if (this.isThereEquivalenceBetweenNorms(temp.get(0), norm)) {
				groupNorms.get(i).add(norm);
				return;
			}
		}
		
		//there is no equivalence previously
		List<Norm> temp = new ArrayList<Norm>();
		temp.add(norm);
		groupNorms.add(temp);
	}

	boolean isThereEquivalenceBetweenNorms(Norm norm1, Norm norm2) {
		// returns true if the state of the norms are both NONE
		boolean normState = stateChecker(norm1, norm2);
		if (!normState) {
			return false;
		}

		// returns true if the context of the norms are the same
		boolean conflictContext = contextChecker(norm1, norm2);
		if (!conflictContext) {
			return false;
		}

		// returns true if the if the entities are the same OR one is ALL
		boolean conflictEntity = entityChecker(norm1, norm2);
		if (!conflictEntity) {
			return false;
		}

		// returns true if there is not conflict between activation and deactivation constraint
		boolean conflictConstraint = constraintChecker(norm1, norm2);
		if (!conflictConstraint) {
			return false;
		}

		// returns true if the action are the same
		boolean conflictAction = actionChecker(norm1, norm2);
		if (!conflictAction) {
			return false;
		}

		// at this moment all conditions are valid and the norms are in conflict
		return true;
	}
	
	public boolean stateChecker(Norm norm1, Norm norm2) {
		State s1 = norm1.getState();
		State s2 = norm2.getState();

		if (s1 == null) {
			norm1.setState(State.NONE);
		}

		if (s2 == null) {
			norm2.setState(State.NONE);
		}
		if (s1.equals(State.NONE) && s2.equals(State.NONE)) {
			return true;
		}
		return false;
	}
	
	public boolean contextChecker(Norm norm1, Norm norm2) {
		Context c1 = norm1.getContext();
		Context c2 = norm2.getContext();

		if (c1 == null || c1.getName() == null || c1.getContextType() == null) {
			c1 = new Context("context", ContextType.ORGANIZATION);
			norm1.setContext(c1);
		}

		if (c2 == null || c2.getName() == null || c2.getContextType() == null) {
			c2 = new Context("context", ContextType.ORGANIZATION);
			norm2.setContext(c2);
		}

		if (norm1.getContext().equals(norm2.getContext())) {
			return true;
		}
		return false;
	}
	
	public boolean entityChecker(Norm norm1, Norm norm2) {

		Entity e1 = norm1.getEntity();
		Entity e2 = norm2.getEntity();
		//it is implementation is different from the last version. Here
		//we consider if the entity is null it can be modified
		
		boolean flag1 = false;
		boolean flag2 = false;

		if (e1 == null || e1.getName() == null || e1.getEntityType() == null) {
			e1 = new Entity("entity", EntityType.ALL);
			norm1.setEntity(e1);
			flag1 = true;
		}
		if (e2 == null || e2.getName() == null || e2.getEntityType() == null) {
			e2 = new Entity("entity", EntityType.ALL);
			norm1.setEntity(e1);
			flag2 = true;
		}
		
		if (flag1 && flag2) {
			return true;
		}
		//if flag's are false
		// if the execution arrived here means that all fields are filled
		if (e1.getEntityType().equals(EntityType.ALL)) {
			e1.setEntityType(e2.getEntityType());
			norm2.setEntity(e2);
		}
		if (e2.getEntityType().equals(EntityType.ALL)) {
			e2.setEntityType(e1.getEntityType());
			norm2.setEntity(e2);
		}

		// if the entities are equal
		if (norm1.getEntity().equals(norm2.getEntity())) {
			return true;
		}

		return false;
	}

	public boolean actionChecker(Norm norm1, Norm norm2) {
		//its implementation was changed from the last version
		if (norm1.getBehavior() == null || norm2.getBehavior() == null) {
			return false;
		}
		String actionName1 = norm1.getBehavior().getName();
		String actionName2 = norm2.getBehavior().getName();
		
		if (actionName1.equals(actionName2)) {
			return true;
		}
		return false;
		//its missing new cases for new behaviors
	}
	
	public boolean constraintChecker(Norm norm1, Norm norm2) {
		
		//for realize the comparisons all the fields must be filled, if one field is null then we don't have problem
		if (norm1.getActivationConstraint() == null || norm1.getDeactivationConstraint() == null ||
			norm2.getActivationConstraint() == null || norm2.getDeactivationConstraint() == null) {
			
			norm1.setActivationConstraint(null);
			norm2.setActivationConstraint(null);
			norm1.setDeactivationConstraint(null);
			norm2.setDeactivationConstraint(null);
			
			return true;
		}
		
		ConstraintType na1 = norm1.getActivationConstraint().getConstraintType();
		ConstraintType nd1 = norm1.getDeactivationConstraint().getConstraintType();
		
		ConstraintType na2 = norm2.getActivationConstraint().getConstraintType();
		ConstraintType nd2 = norm2.getDeactivationConstraint().getConstraintType();
		
		//it is necessary only 3 tests
		if (!na1.equals(nd1) || !na2.equals(nd2) || !na1.equals(na2)) {
			norm1.setActivationConstraint(null);
			norm2.setActivationConstraint(null);
			norm1.setDeactivationConstraint(null);
			norm2.setDeactivationConstraint(null);
			
			return true;
		}
		
		// If the activation conditions are actions
		if (norm1.getActivationConstraint().getConstraintType().equals(ConstraintType.ACTIONTYPE)
				&& norm1.getActivationConstraint().getConstraintType().equals(ConstraintType.ACTIONTYPE)) {

			//todo...o tratamento vai ser realizado no futuro, caso necessário
				
			return true;
		}
		
		//
		//at this moment the constrainttype are both DATETYPE, so it is not necessary more comparisons
		//
		
		DateTime d1Begin = ((ConstraintDate) norm1.getActivationConstraint()).getDate();
		DateTime d1End = ((ConstraintDate) norm1.getDeactivationConstraint()).getDate();
		DateTime d2Begin = ((ConstraintDate) norm2.getActivationConstraint()).getDate();
		DateTime d2End = ((ConstraintDate) norm2.getDeactivationConstraint()).getDate();
		
		boolean r = this.compareDateIntervals(d1Begin, d1End, d2Begin, d2End);
		return r;
	}

	
	public boolean compareDateIntervals(DateTime d1Begin, DateTime d1End, DateTime d2Begin, DateTime d2End){
		Interval i1 = new Interval(d1Begin,d1End);
		Interval i2 = new Interval(d2Begin,d2End);
		return i1.overlaps(i2);
		//http://stackoverflow.com/questions/17106670/how-to-check-a-timeperiod-is-overlapping-another-time-period-in-java
	}
	
	public void printNorms() {
		for(List<Norm> list: groupNorms) {
			for(Norm norm: list) {
				System.out.println(norm.toString());
			}
			System.out.println();
		}
	}
	
	public void printNorms(List<List<Norm>> norms) {
		for(List<Norm> list: norms) {
			for(Norm norm: list) {
				System.out.println(norm.toString());
			}
			System.out.println();
		}
	}
	
	private Object deepClone(Object object) {
	    try {
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      ObjectOutputStream oos = new ObjectOutputStream(baos);
	      oos.writeObject(object);
	      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
	      ObjectInputStream ois = new ObjectInputStream(bais);
	      return ois.readObject();
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	      return null;
	    }
	}
}
