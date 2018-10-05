package arena;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import arena.vistas.PrincipalWindow;

public class LectorDeNotasApplication extends Application {

	public static void main(String[] args) throws Exception {		
		
		new LectorDeNotasApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		
		return new PrincipalWindow(this);
	}
}