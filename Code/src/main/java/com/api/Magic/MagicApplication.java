package com.api.Magic;

import com.api.Magic.Model.Entity.CreatureCard;
import com.api.Magic.Model.Entity.ManaCost;
import com.api.Magic.Model.Enum.CardType;
import com.api.Magic.Model.Enum.CreatureType;
import com.api.Magic.Model.Enum.ManaType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class MagicApplication {

	public static void main(String[] args) {

		//SpringApplication.run(MagicApplication.class, args);

		CreatureCard monsterDemon = new CreatureCard("Raphael, Fiendish Savior", CardType.CREATURE, CreatureType.DEMON,
				new ManaCost(ManaType.BLACK, 4), "Test", "4", "4");

		monsterDemon.getInfo();
	}
}
