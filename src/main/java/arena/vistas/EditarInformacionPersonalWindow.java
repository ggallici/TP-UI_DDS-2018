	package arena.vistas;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

import arena.vm.EditarInformacionPersonalVM;
import dominio.Estudiante;

@SuppressWarnings("serial")
public class EditarInformacionPersonalWindow extends TransactionalDialog<EditarInformacionPersonalVM>
{
	private String token;

	public EditarInformacionPersonalWindow(WindowOwner owner, Estudiante estudiante, String token) {
		
		super(owner, new EditarInformacionPersonalVM(estudiante));
		
		this.token = token;
	}
	
	@Override
	public void createFormPanel(Panel panelPrincipal){
		
		setTitle("Informacion personal");
		
		panelPrincipal.setLayout(new VerticalLayout());
		
		GroupPanel panel = new GroupPanel(panelPrincipal);
		panel.setTitle("Modificar informacion personal");
		panel.setLayout(new ColumnLayout(2));
		
		new Label(panel).setText("Legajo: ");
		new Label(panel).setWidth(150).bindValueToProperty("legajo");
		new Label(panel).setText("Nombre: ");
		new TextBox(panel).setWidth(150).bindValueToProperty("nombre");
		new Label(panel).setText("Apellido: ");
		new TextBox(panel).setWidth(150).bindValueToProperty("apellido");
		new Label(panel).setText("Usuario GitHub: ");
		new TextBox(panel).setWidth(150).bindValueToProperty("usuarioGitHub");
	}
	
	@Override
	protected void addActions(Panel panelBotones) {
		
		new Button(panelBotones).setCaption("Guardar Cambios").onClick(this::editarInformacionPersonal).setAsDefault();
		new Button(panelBotones).setCaption("Cancelar").onClick(this::cancel);
	}
	
	public void editarInformacionPersonal() {
		
		getModelObject().editarInformacionPersonal(token);
		
		accept();
	}
}