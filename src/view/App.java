package view;

import java.awt.EventQueue;

public class App {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainFrame window = new MainFrame();
					EventHandler eventHandler = new EventHandler();
					eventHandler.listenTo(window);
					window.setMouseListener(eventHandler);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
