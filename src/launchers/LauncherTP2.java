package launchers;

import java.awt.Point;

import tp.model.agents.Agent;
import tp.model.agents.Animal;
import tp.model.agents.Sexe;

public class LauncherTP2 {
	
	public static void main(String [] args) {
		//tests unitaires de la classe Animal
				//TODO décommentez les lignes pour approfondir le test unitaire
				//complétez la méthode pour tester les nouvelles fonctionnalités que vous allez implémenter
				Animal a = new Animal();
				Animal b = new Animal(Sexe.Male);
				Animal c = new Animal(Sexe.Assexue);
				Animal d = new Animal(Sexe.Femelle,new Point(25,30));
				Animal e = new Animal(Sexe.Femelle,new Point(25,30));

				/*
				 * les lignes suivantes doivent afficher à terme: NomDeLaClasse n° id_animal(sexe, (position x; position y)).
				 * ex: 28 (FEMELLE, (25;30))
				 */
				System.out.println("*** Animaux créés: **********");
				System.out.println(a);
				System.out.println(a.toString());
				System.out.println(b);
				System.out.println(c);
				System.out.println(d);

				System.out.println("*** Getters et setters **********");


				System.out.println(d.getSexe());
				Sexe ss = d.getSexe();
				ss=Sexe.Male;
				System.out.println(d.getSexe());

				//les lignes suivantes devraient afficher la même chose....

				System.out.println(d.getCoord());
				Point pt = d.getCoord();
				pt.x=50;
				System.out.println(d.getCoord());


				//TODO ajoutez vos propres tests de getters et setters

				//TODO test vieillir

				//TODO test seDeplacer

				//TODO test id
				System.out.println(a.getId());
				System.out.println(b.getId());
				

				/*
				 * Test comparaison
				 */
				System.out.println(d==e);
				System.out.println(d.equals(e));
				System.out.println("Bonjour"=="Bonjour");
				System.out.println("Bonjour".equals("Bonjour"));
			}
		
	}
