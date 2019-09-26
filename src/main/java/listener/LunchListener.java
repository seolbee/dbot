package listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LunchListener extends ListenerAdapter{
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		String msg = event.getMessage().getContentRaw();
		
		if(msg.startsWith("!dbot")) {
			int idx = msg.indexOf(" "); //첫번째로 나오는 공백을 찾아서
			if(idx < 0) {
				sayMsg("hi. my name is dbot", event);
				return;
			}
			
			String cmd = msg.substring(idx + 1);
			idx = cmd.indexOf("");
			String param = "";
			if(idx > 0) {
				param = cmd.substring(idx + 1);
				cmd = cmd.substring(0, idx);
			}
			
			switch(cmd) {
			case "echo":
				if(param == "") {
					sayMsg("echo 명령어는 메아리 할 말을 입력합니다.", event);
				} else {
					sayMsg(param, event);
				}
				break;
			case "help":
				sayMsg("echo : !dbot echo 할 말 쓰기", event);
				break;
			}
		}
	}
	
	private void sayMsg(String msg, MessageReceivedEvent e) {
		e.getChannel().sendMessage(msg).queue();
	}
}
