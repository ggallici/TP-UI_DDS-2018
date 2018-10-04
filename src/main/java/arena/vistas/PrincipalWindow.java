package arena.vistas;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections15.Transformer;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.GroupPanel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import arena.vm.PrincipalVM;
import dominio.Nota;
import dominio.Tarea;


@SuppressWarnings("serial")
public class PrincipalWindow extends SimpleWindow<PrincipalVM>{

	public PrincipalWindow(WindowOwner owner) {
		
		super(owner, new PrincipalVM());
	}

	@Override
	protected void createFormPanel(Panel panelPrincipal) {
		
		setTitle("Lector de notas");
		
		
		//AUTENTICACION
		GroupPanel panelLegajo = new GroupPanel(panelPrincipal);
		panelLegajo.setTitle("Autenticacion:");
		panelLegajo.setLayout(new ColumnLayout(2));
		new Label(panelLegajo).setText("Ingrese legajo:");
		new TextBox(panelLegajo).setWidth(295).bindValueToProperty("legajo");
		new Button(panelLegajo).setCaption("Buscar estudiante").onClick(this::buscarEstudiante);
		
		
		//INFORMACION PERSONAL
		GroupPanel panelInformacionPersonal = new GroupPanel(panelPrincipal);
		panelInformacionPersonal.setTitle("Informacion personal");
		panelInformacionPersonal.setLayout(new ColumnLayout(2));
		new Label(panelInformacionPersonal).setText("Legajo: ");
		new Label(panelInformacionPersonal).setWidth(150).bindValueToProperty("estudiante.legajo");
		new Label(panelInformacionPersonal).setText("Nombre: ");
		new Label(panelInformacionPersonal).setWidth(150).bindValueToProperty("estudiante.nombre");
		new Label(panelInformacionPersonal).setText("Apellido: ");
		new Label(panelInformacionPersonal).setWidth(150).bindValueToProperty("estudiante.apellido");
		new Label(panelInformacionPersonal).setText("Usuario GitHub: ");
		new Label(panelInformacionPersonal).setWidth(150).bindValueToProperty("estudiante.usuarioGitHub");
		new Button(panelInformacionPersonal).setCaption("Editar informacion").onClick(this::editarInformacionEstudiante);
		
		
		//TAREAS
		GroupPanel panelTareas = new GroupPanel(panelPrincipal);
		panelTareas.setTitle("Tareas asignadas");
		
		Panel panelAprobo = new Panel(panelTareas);
		panelAprobo.setLayout(new HorizontalLayout());
		new Label(panelAprobo).setText("Estado de la asignatura:");
		new Label(panelAprobo).setWidth(150);
		
		Panel panelTablaTareas = new Panel(panelTareas);
		Table<Tarea> tablaTareas = new Table<>(panelTablaTareas, Tarea.class);
		tablaTareas.setNumberVisibleRows(5);
		tablaTareas.bindItemsToProperty("estudiante.tareas");
		new Column<Tarea>(tablaTareas).setTitle("Descripcion").setFixedSize(250).bindContentsToProperty("descripcion");
		new Column<Tarea>(tablaTareas).setTitle("Notas").setFixedSize(100).bindContentsToProperty("notas").setTransformer(new Transformer<List<Nota>, String>() {

			@Override
			public String transform(List<Nota> notas) {
				
				return "[" + notas.stream().map(nota -> nota.getValor()).collect(Collectors.joining(", ")) + "]";
			}
		});
		new Column<Tarea>(tablaTareas).setTitle("Esta aprobada?").setFixedSize(50).bindContentsToProperty("estaAprobada").setTransformer(new Transformer<Boolean, String>() {

			@Override
			public String transform(Boolean estaAprobada) {
				
				return estaAprobada ? "Si" : "No";
			}
		});
	}

	@Override
	protected void addActions(Panel panelBotones) { }
	
	public void buscarEstudiante() {
		
		getModelObject().buscarEstudiante();
	}
	
	public void editarInformacionEstudiante() {
		
		new EditarInformacionPersonalWindow(this, getModelObject().getEstudiante()).open();
	}
}