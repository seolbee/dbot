package dbot;

import listener.LunchListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

public class MainApp {
	public static void main(String[] args) {
		JDABuilder builder = new JDABuilder(AccountType.BOT);
		String token = "NjI2NjExMTczNDc0Njk3MjE4.XYwnyQ.CNZE5CUxYKapskC2lPbFGWG9syE";
		builder.setToken(token);
		
		try {
			builder.addEventListeners(new LunchListener());
			builder.build();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러표시");
		}
	}
}
