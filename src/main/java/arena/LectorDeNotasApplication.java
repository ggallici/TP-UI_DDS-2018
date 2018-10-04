package arena;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import arena.vistas.PrincipalWindow;
import repositorios.FixtureEstudiantes;
import repositorios.RepositorioEstudiantes;

public class LectorDeNotasApplication extends Application {

	public static void main(String[] args) throws Exception {		
		
		RepositorioEstudiantes.getInstancia().agregarVarios(FixtureEstudiantes.getInstancia().getEstudiantes());
		
		new LectorDeNotasApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		
		return new PrincipalWindow(this);
	}
}