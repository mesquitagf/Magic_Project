package com.api.Magic;

import com.api.Magic.Model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class MagicApplication {

	public static void main(String[] args) {

		//SpringApplication.run(MagicApplication.class, args);

		//System.out.println("Test");
		CreatureCard monsterDemon = new CreatureCard("Raphael, Fiendish Savior", CardType.CREATURE, CreatureType.DEMON,
				new ManaCost(ManaType.BLACK, 4), "Test", "4", "4");

		//System.out.println(monsterDemon.getManaCost().getManaCostInfo());

		monsterDemon.getInfo();
	}
}
