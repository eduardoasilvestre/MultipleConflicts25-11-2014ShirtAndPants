package test;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import src.BehaviorMultipleParameters;
import src.ConflictCheckerMultipleNorms;
import src.Constraint;
import src.Context;
import src.ContextType;
import src.DeonticConcept;
import src.Entity;
import src.EntityType;
import src.Norm;
import src.State;

public class TestMultipleConflicts {
	public static void main(String[] args) {
		ConflictCheckerMultipleNorms c = new ConflictCheckerMultipleNorms();
		
		List<Norm> normSet = buildSomeNorms();

		//inserting all norms and calling the algorithm
		c.insertAndClassifyAllNorms(normSet);
		
		//print the norms
		c.printNorms();
		
		//realizes the analysis of the conflicts
		c.verifyMultipleConflict();
	}
	
	/**
	 * This method builds a set of norms por the analysis of conflicts
	 * @author eduardo.silvestre
	 */
	private static List<Norm> buildSomeNorms() {
		List<Norm> normSet = new ArrayList<>();
		
		Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color","blue");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);

		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment","pant");
		action3.addElement("color","black");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);
	
		/*Context context4 = new Context("home", ContextType.ORGANIZATION);
		Entity entity4 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action4 = new BehaviorMultipleParameters("study");
		action4.addElement("disciplina","portugues");
		action4.addElement("dia","21/10/2014");
		action4.addElement("periodo","3");
		Constraint aConstraint4 = null; 
		Constraint dConstraint4 = null; 
		Norm norm4 = new Norm(4, DeonticConcept.PERMISSION, context4, entity4, action4, aConstraint4, dConstraint4, State.NONE);
		normSet.add(norm4);
		
		Context context5 = new Context("home", ContextType.ORGANIZATION);
		Entity entity5 = new Entity ("dog", EntityType.ROLE);
		BehaviorMultipleParameters action5 = new BehaviorMultipleParameters("dress");
		action5.addElement("garment","pant");
		action5.addElement("color","red");
		action5.addElement("color","blue");
		action5.addElement("color","black");
		action5.addElement("color","lilac");
		Constraint aConstraint5 = null; 
		Constraint dConstraint5 = null; 
		Norm norm5 = new Norm(5, DeonticConcept.PROHIBITION, context5, entity5, action5, aConstraint5, dConstraint5, State.NONE);
		normSet.add(norm5);*/
		
		Context context6 = new Context("home", ContextType.ORGANIZATION);
		Entity entity6 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action6 = new BehaviorMultipleParameters("dress");
		action6.addElement("garment",ConflictCheckerMultipleNorms.GARMENT_SET);
		action6.addElement("color", ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint6 = null; 
		Constraint dConstraint6 = null; 
		Norm norm6 = new Norm(6, DeonticConcept.OBLIGATION, context6, entity6, action6, aConstraint6, dConstraint6, State.NONE);
		normSet.add(norm6);
		
		/*Context context7 = new Context("company", ContextType.ORGANIZATION);
		Entity entity7 = new Entity ("secretary", EntityType.ROLE);
		BehaviorMultipleParameters action7 = new BehaviorMultipleParameters("dress");
		action7.addElement("garment","shirt");
		action7.addElement("color","white");
		Constraint aConstraint7 = null; 
		Constraint dConstraint7 = null; 
		Norm norm7 = new Norm(7, DeonticConcept.OBLIGATION, context7, entity7, action7, aConstraint7, dConstraint7, State.NONE);
		normSet.add(norm7);
	
		Context context8 = new Context("company", ContextType.ORGANIZATION);
		Entity entity8 = new Entity ("secretary", EntityType.ROLE);
		BehaviorMultipleParameters action8 = new BehaviorMultipleParameters("dress");
		action8.addElement("garment","shirt");
		action8.addElement("color","red");
		Constraint aConstraint8 = null; 
		Constraint dConstraint8 = null; 
		Norm norm8 = new Norm(8, DeonticConcept.OBLIGATION, context8, entity8, action8, aConstraint8, dConstraint8, State.NONE);
		normSet.add(norm8);
	
		Context context9 = new Context("university", ContextType.ORGANIZATION);
		Entity entity9 = new Entity ("teacher", EntityType.ROLE);
		BehaviorMultipleParameters action9 = new BehaviorMultipleParameters("dress");
		action9.addElement("garment","shirt");
		action9.addElement("color","white");
		Constraint aConstraint9 = null; 
		Constraint dConstraint9 = null; 
		Norm norm9 = new Norm(9, DeonticConcept.PROHIBITION, context9, entity9, action9, aConstraint9, dConstraint9, State.NONE);
		normSet.add(norm9);
	
		Context context10 = new Context("university", ContextType.ORGANIZATION);
		Entity entity10 = new Entity ("teacher", EntityType.ROLE);
		BehaviorMultipleParameters action10 = new BehaviorMultipleParameters("dress");
		action10.addElement("garment","shirt");
		action10.addElement("color","white");
		Constraint aConstraint10 = null; 
		Constraint dConstraint10 = null; 
		Norm norm10 = new Norm(10, DeonticConcept.OBLIGATION, context10, entity10, action10, aConstraint10, dConstraint10, State.NONE);
		normSet.add(norm10);
	
		Context context11 = new Context("field", ContextType.ORGANIZATION);
		Entity entity11 = new Entity ("player", EntityType.ROLE);
		BehaviorMultipleParameters action11 = new BehaviorMultipleParameters("dress");
		action11.addElement("garment","chuteira");
		action11.addElement("part","pe");
		Constraint aConstraint11 = null; 
		Constraint dConstraint11 = null; 
		Norm norm11 = new Norm(11, DeonticConcept.OBLIGATION, context11, entity11, action11, aConstraint11, dConstraint11, State.NONE);
		normSet.add(norm11);
	
		Context context12 = new Context("field", ContextType.ORGANIZATION);
		Entity entity12 = new Entity ("player", EntityType.ROLE);
		BehaviorMultipleParameters action12 = new BehaviorMultipleParameters("chuta");
		action12.addElement("bola","branca");
		Constraint aConstraint12 = null; 
		Constraint dConstraint12 = null; 
		Norm norm12 = new Norm(12, DeonticConcept.PERMISSION, context12, entity12, action12, aConstraint12, dConstraint12, State.NONE);
		normSet.add(norm12);
	
		Context context13 = new Context("field", ContextType.ORGANIZATION);
		Entity entity13 = new Entity ("judge", EntityType.ROLE);
		BehaviorMultipleParameters action13 = new BehaviorMultipleParameters("use");
		action13.addElement("acessorio","apito");
		action13.addElement("lugar","boca");
		Constraint aConstraint13 = null; 
		Constraint dConstraint13 = null; 
		Norm norm13 = new Norm(13, DeonticConcept.OBLIGATION, context13, entity13, action13, aConstraint13, dConstraint13, State.NONE);
		normSet.add(norm13);
	
		Context context14 = new Context("field", ContextType.ORGANIZATION);
		Entity entity14 = new Entity ("judge", EntityType.ROLE);
		BehaviorMultipleParameters action14 = new BehaviorMultipleParameters("use");
		action14.addElement("acessorio","cartao");
		action14.addElement("cor","amarelo");
		Constraint aConstraint14 = null; 
		Constraint dConstraint14 = null; 
		Norm norm14 = new Norm(14, DeonticConcept.PERMISSION, context14, entity14, action14, aConstraint14, dConstraint14, State.NONE);
		normSet.add(norm14);*/
		
		/*
		PERMITIDO vestir(camisa,branca,passada,lisa)
		PERMITIDO vestir(camisa,branca,passada,lisa)*/
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype", "ironing");
		action1.addElement("picture", "smooth");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color","white");
		action2.addElement("ironingtype", "ironing");
		action2.addElement("picture", "smooth");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);*/
		
		/*
		OBRIGADO vestir(camisa,branca,passada,lisa)
		OBRIGADO vestir(camisa,branca,passada,lisa)*/
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype", "ironing");
		action1.addElement("picture", "smooth");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color","white");
		action2.addElement("ironingtype", "ironing");
		action2.addElement("picture", "smooth");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);*/
		
		/*
		PROIBIDO vestir(camisa,branca,passada,lisa)
		PROIBIDO vestir(camisa,branca,passada,lisa)*/
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype", "ironing");
		action1.addElement("picture", "smooth");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color","white");
		action2.addElement("ironingtype", "ironing");
		action2.addElement("picture", "smooth");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);*/
		
		
		
		/*
		OBRIGADO vestir(camisa,branca,passada,lisa) 	PERMITIDO {passada}
		OBRIGADO vestir(camisa,branca,amarrotada,lisa)  PERMITIDO {amarrotada} Interseção é vazia
		*/
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype", "ironing");
		action1.addElement("picture", "smooth");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color","white");
		action2.addElement("ironingtype", "crumpled");
		action2.addElement("picture", "smooth");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);*/
		
		
		/*
		OBRIGADO vestir(camisa,branca,passada,lisa) 	PERMITIDO {branca}
		OBRIGADO vestir(camisa,preta,amarrotada,lisa)	PERMITIDO {preta} Interseção é vazia*/
		
		/*	Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype", "ironing");
		action1.addElement("picture", "smooth");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color","black");
		action2.addElement("ironingtype", "crumpled");
		action2.addElement("picture", "smooth");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		 */
		
		/*
		OBRIGADO vestir(camisa,branca,passada,lisa) 	PERMITIDO {branca}
		OBRIGADO vestir(camisa,preta,amarrotada,lisa)	PERMITIDO {preta} 
		OBRIGADO vestir(camisa,preta,amarrotada,lisa)	PERMITIDO {preta} Interseção é vazia*/
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype", "ironing");
		action1.addElement("picture", "smooth");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color","black");
		action2.addElement("ironingtype", "crumpled");
		action2.addElement("picture", "smooth");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment","shirt");
		action3.addElement("color","black");
		action3.addElement("ironingtype", "crumpled");
		action3.addElement("picture", "smooth");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		OBRIGADO vestir(camisa,A,passada,lisa)
		OBRIGADO vestir(calça,A,amarrotada,lisa)*/	
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);*/
		
		/*
		PERMITIDO vestir(camisa,branca,passada,lisa)
		OBRIGADO vestir(camisa,branca,passada,lisa)*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype", "ironing");
		action1.addElement("picture", "smooth");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color","white");
		action2.addElement("ironingtype", "ironing");
		action2.addElement("picture", "smooth");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);*/
		
		/*PERMITIDO vestir(camisa,branca,passada,lisa) 	PERMITIDO {branca}
		PROIBIDO vestir(camisa,branca,passada,lisa)		PERMITIDO {preta, vermelha, azul, lilás}  Interseção é vazia
		PROIBIDO vestir(camisa,azul,passada,lisa)		PERMITIDO {branca, preta, vermelha, lilás}  Interseção é vazia*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype", "ironing");
		action1.addElement("picture", "smooth");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color","white");
		action2.addElement("ironingtype", "ironing");
		action2.addElement("picture", "smooth");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment","shirt");
		action3.addElement("color","blue");
		action3.addElement("ironingtype", "ironing");
		action3.addElement("picture", "smooth");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		
		/*
		OBRIGADO vestir(camisa,branca,passada,lisa)			--{branca}
		PROIBIDO vestir(camisa,branca,passada,lisa)			--{!branca}*/
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype", "ironing");
		action1.addElement("picture", "smooth");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color","white");
		action2.addElement("ironingtype", "ironing");
		action2.addElement("picture", "smooth");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);*/

/*
		PERMITIDO vestir(camisa,branca,passada,lisa) 		PERMITIDO {camisa} {branca} {passada} {lisa}
		PROIBIDO vestir(camisa,preta,passada,lisa)			PERMITIDO {camisa} {branca, vermelha, azul, lilás} {amarrotada} {horizontal,  vertical, rajada}
		PROIBIDO vestir(camisa,azul,passada,lisa)			PERMITIDO {camisa} {branca, preta, vermelha, lilás} {amarrotada} {horizontal, vertical, rajada}
		PROIBIDO vestir(camisa,vermelha,passada,listrada)	PERMITIDO {camisa} {branca, preta, azul, lilás} {amarrotada}*/
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype", "ironing");
		action1.addElement("picture", "smooth");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","shirt");
		action2.addElement("color","black");
		action2.addElement("ironingtype", "ironing");
		action2.addElement("picture", "smooth");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment","shirt");
		action3.addElement("color","blue");
		action3.addElement("ironingtype", "ironing");
		action3.addElement("picture", "smooth");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);
		
		Context context4 = new Context("home", ContextType.ORGANIZATION);
		Entity entity4 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action4 = new BehaviorMultipleParameters("dress");
		action4.addElement("garment","shirt");
		action4.addElement("color","red");
		action4.addElement("ironingtype", "ironing");
		action4.addElement("picture", "gust");
		Constraint aConstraint4 = null; 
		Constraint dConstraint4 = null; 
		Norm norm4 = new Norm(4, DeonticConcept.PROHIBITION, context4, entity4, action4, aConstraint4, dConstraint4, State.NONE);
		normSet.add(norm4);*/
		
		/*
		1
		N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é obrigado a vestir camisa branca
		N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é obrigado a vestir calça preta
		N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é obrigado a vestir calça e camisa da mesma cor*/
		/*
		Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		 100
	 	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é obrigado a vestir camisa branca
		N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é obrigado a vestir calça branca
		N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é obrigado a vestir calça e camisa da mesma cor*/
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		2
		N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é obrigado a vestir camisa branca
		N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é obrigado a vestir calça branca
		N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é obrigado a vestir calça e camisa de cores diferentes*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		107
		N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
		N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça preta
		N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		108
		N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
		N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça preta
		N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		109
		N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
		N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça preta
		N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		110
		N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
		N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça preta
		N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		
		/*
		111
		N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
		N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça preta
		N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		112
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		3
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		4
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		113
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		5
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		114
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		/*
		115
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa da mesma cor*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		116
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa de cores diferentes*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		117
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa de cores diferentes*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		6
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa de cores diferentes*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	118
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa de cores diferentes*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	7
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa de cores diferentes*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	119
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa de cores diferentes*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	120
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	121
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	122
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	123
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	124
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	125
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	8
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	9
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	126
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	10
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	127
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	128
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		//jump a lot of scenarios
		
		/*
		133
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa da mesma cor*/

		/*		Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);
		*/
		
		/*
		134
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		 
		
		/*
		135
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		 
		
		/*
		136
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		137
		N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		138
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça preta
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","black");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		13
		N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
		N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
		N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		14
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		15
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		16
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		17
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		18
	N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
	N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
	N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa da mesma cor*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		139
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa de cores diferentes*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		140
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PERMITIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa de cores diferentes*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		141
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é OBRIGADO a vestir calça e camisa de cores diferentes*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.OBLIGATION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		142
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é PROIBIDO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é OBRIGADO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa de cores diferentes*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PROHIBITION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.OBLIGATION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		143
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PERMITIDO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PROIBIDO a vestir calça e camisa de cores diferentes*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		144
N1 = {O,casa, pessoa, vestir,ac, dc, none} 	--agente A é OBRIGADO a vestir camisa branca
N2 = {O,casa, pessoa, vestir,ac, dc, none}	--agente A é PROIBIDO a vestir calça branca
N3 = {O,casa, pessoa,vestir,ac,dc,none}		--agente A é PERMITIDO a vestir calça e camisa de cores diferentes*/

		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		 	CENARIO 1.1
		 	N1 = agente A é PERMITIDO a vestir camisa branca passada
			N2 = agente A é PERMITIDO a vestir calça branca passada
			N3 = agente A é PROIBIDO a vestir calça e camisa da mesma cor passada
		 */
		/*
		Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype","ironing");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		action2.addElement("ironingtype","ironing");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		action3.addElement("ironingtype","crumpled");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	 	CENARIO 1.2
		N1 = agente A é PERMITIDO a vestir camisa branca passada
		N2 = agente A é PERMITIDO a vestir calça branca passada
		N3 = agente A é PROIBIDO a vestir calça e camisa da mesma cor passada
	 */
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype","ironing");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		action2.addElement("ironingtype","ironing");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		action3.addElement("ironingtype","ironing");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
	 	----CENÁRIO 1.3
		N1 = agente A é PERMITIDO a vestir camisa branca passada
		N2 = agente A é PERMITIDO a vestir calça branca passada
		N3 = agente A é PROIBIDO a vestir calça e camisa da mesma DIFF amarrotada
	 */
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype","ironing");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		action2.addElement("ironingtype","ironing");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		action3.addElement("ironingtype","crumpled");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		CENÁRIO 1.4
		N1 = agente A é PERMITIDO a vestir camisa branca passada
		N2 = agente A é PERMITIDO a vestir calça branca passada
		N3 = agente A é PROIBIDO a vestir calça e camisa da mesma DIFF passada
	 */
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype","ironing");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.PERMISSION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		action2.addElement("ironingtype","ironing");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PERMISSION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		action3.addElement("ironingtype","ironing");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		 ----CENÁRIO 1.5:
		N1 = agente A é OBRIGADO a vestir camisa branca passada listrada
		N2 = agente A é PROIBIDO a vestir calça branca passada horizontal
		N3 = agente A é PROIBIDO a vestir calça e camisa da mesma EQUAL amarrotada vertical
		 */
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype","ironing");
		action1.addElement("picture","gust");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		action2.addElement("ironingtype","ironing");
		action2.addElement("picture","horizontal");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		action3.addElement("ironingtype","crumpled");
		action3.addElement("picture","vertical");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		----CENÁRIO 1.6
		N1 = agente A é OBRIGADO a vestir camisa branca passada listrada
		N2 = agente A é PROIBIDO a vestir calça branca amarrotada horizontal
		N3 = agente A é PROIBIDO a vestir calça e camisa da mesma EQUAL amarrotada vertical
		SEM CONFLITO*/
		
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype","ironing");
		action1.addElement("picture","gust");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		action2.addElement("ironingtype","crumpled");
		action2.addElement("picture","horizontal");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.EQUAL);
		action3.addElement("ironingtype","crumpled");
		action3.addElement("picture","vertical");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		
		/*
		 ----CENÁRIO 1.7:
		N1 = agente A é OBRIGADO a vestir camisa branca passada gust
		N2 = agente A é PROIBIDO a vestir calça branca passada horizontal
		N3 = agente A é PROIBIDO a vestir calça e camisa da mesma DIFF amarrotada vertical
		 */
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","white");
		action1.addElement("ironingtype","ironing");
		action1.addElement("picture","gust");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		action2.addElement("ironingtype","ironing");
		action2.addElement("picture","horizontal");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		action3.addElement("ironingtype","crumpled");
		action3.addElement("picture","vertical");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		 ----CENÁRIO 1.8:
		N1 = agente A é OBRIGADO a vestir camisa vermelha passada gust
		N2 = agente A é PROIBIDO a vestir calça branca passada horizontal
		N3 = agente A é PROIBIDO a vestir calça e camisa da mesma DIFF amarrotada vertical
		 */
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","red");
		action1.addElement("ironingtype","ironing");
		action1.addElement("picture","gust");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		action2.addElement("ironingtype","ironing");
		action2.addElement("picture","horizontal");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		action3.addElement("ironingtype","crumpled");
		action3.addElement("picture","vertical");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3); */
		
		/*
		----CENÁRIO 1.9
		N1 = agente A é OBRIGADO a vestir camisa vermelha passada listrada
		N2 = agente A é PROIBIDO a vestir calça branca amarrotada horizontal
		N3 = agente A é PROIBIDO a vestir calça e camisa da mesma DIFF amarrotada vertical
		SEM CONFLITO*/
		/*Context context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","red");
		action1.addElement("ironingtype","ironing");
		action1.addElement("picture","gust");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		action2.addElement("ironingtype","crumpled");
		action2.addElement("picture","horizontal");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		action3.addElement("ironingtype","crumpled");
		action3.addElement("picture","vertical");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		/*
		----CENÁRIO 1.10
		N1 = agente A é OBRIGADO a vestir camisa vermelha passada gust
		N2 = agente A é PROIBIDO a vestir calça branca amarrotada horizontal
		N3 = agente A é PROIBIDO a vestir calça e camisa da mesma EQUAL passada vertical
		*/
		/*ontext context1 = new Context("home", ContextType.ORGANIZATION);
		Entity entity1 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action1 = new BehaviorMultipleParameters("dress");
		action1.addElement("garment","shirt");
		action1.addElement("color","red");
		action1.addElement("ironingtype","ironing");
		action1.addElement("picture","gust");
		Constraint aConstraint1 = null; 
		Constraint dConstraint1 = null; 
		Norm norm1 = new Norm(1, DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
		normSet.add(norm1);
		
		Context context2 = new Context("home", ContextType.ORGANIZATION);
		Entity entity2 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action2 = new BehaviorMultipleParameters("dress");
		action2.addElement("garment","pant");
		action2.addElement("color","white");
		action2.addElement("ironingtype","crumpled");
		action2.addElement("picture","horizontal");
		Constraint aConstraint2 = null; 
		Constraint dConstraint2 = null; 
		Norm norm2 = new Norm(2, DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
		normSet.add(norm2);
		
		Context context3 = new Context("home", ContextType.ORGANIZATION);
		Entity entity3 = new Entity ("person", EntityType.ROLE);
		BehaviorMultipleParameters action3 = new BehaviorMultipleParameters("dress");
		action3.addElement("garment", ConflictCheckerMultipleNorms.GARMENT_SET);
		action3.addElement("color",ConflictCheckerMultipleNorms.DIFF);
		action3.addElement("ironingtype","ironing");
		action3.addElement("picture","vertical");
		Constraint aConstraint3 = null; 
		Constraint dConstraint3 = null; 
		Norm norm3 = new Norm(3, DeonticConcept.PROHIBITION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
		normSet.add(norm3);*/
		
		return normSet;
	}
	
	/**
	 * This method receives a date in String format and returns a DateTime (JodaTime library)
	 * @author eduardo.silvestre
	 */
	private static DateTime buildDateTime(String data) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
		DateTime d = dtf.parseDateTime(data);
		return d;
	}

}
