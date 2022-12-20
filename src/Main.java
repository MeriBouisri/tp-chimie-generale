import java.awt.EventQueue;
import view.EventHandler;
import view.MainFrame;

public class Main {
	
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
