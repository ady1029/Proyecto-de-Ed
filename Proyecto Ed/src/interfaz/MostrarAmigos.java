package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import componentesVisuales.BotonAnimacion;
import componentesVisuales.AvatarCircular;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import componentesVisuales.PanelBordeOval;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import logica.Person;
import logica.RedSystem;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarAmigos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private RedSystem app;
	private JTable table;
	private Person p;

	/**
	 * Create the dialog.
	 */
	public MostrarAmigos(MenuUsuario menuUsuario, RedSystem b, Person a) {
		super(menuUsuario, true);
		app = b;
		p = a;
		setBounds(100, 100, 729, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(42, 167, 255));
		panel.setBounds(0, 0, 716, 510);
		contentPanel.add(panel);
		
		BotonAnimacion btnmcnAtrs = new BotonAnimacion();
		btnmcnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnmcnAtrs.setText("Atrás");
		btnmcnAtrs.setBounds(623, 474, 68, 24);
		panel.add(btnmcnAtrs);
		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setAvatar(new ImageIcon(MostrarAmigos.class.getResource("/fotos/FotoUsuarios.png")));
		avatarCircular.setBounds(21, 11, 56, 49);
		panel.add(avatarCircular);
		
		JLabel lblListadoDeAmigos = new JLabel("Listado de Amigos");
		lblListadoDeAmigos.setFont(new Font("Arial", Font.PLAIN, 19));
		lblListadoDeAmigos.setBounds(79, 20, 479, 32);
		panel.add(lblListadoDeAmigos);
		
		PanelBordeOval panelBordeOval = new PanelBordeOval(0);
		panelBordeOval.setValorEsquinaOvalSI(60);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalII(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBackground(new Color(91, 182, 255));
		panelBordeOval.setBounds(14, 70, 677, 388);
		panel.add(panelBordeOval);
		panelBordeOval.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 641, 336);
		panelBordeOval.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(Color.BLACK, 1, true));
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
				},
				new String[] {
						"Nombre", "Ocupaci\u00F3n", "Pa\u00EDs"
				}
				));
		scrollPane.setViewportView(table);
		llenarTabla();
	}
	private String [] obtenerNick() {
		String [] nikcs = new String [app.cantAmigos(p) + 1]; 
		Vertex a = app.findNick(p.getNick());
		List <Vertex> b = a.getAdjacents();
		Iterator<Vertex> it= b.iterator();
		nikcs[0]="Nodos";
		int i=1;
		while(it.hasNext()) {
			nikcs[i]= ((Person)it.next().getInfo()).getNick();
			i++;

		}		

		return nikcs;
	}

	private void llenarTabla() {
		DefaultTableModel modelodefault= new DefaultTableModel(new String[] {"Nombre", "Ocupaci\u00F3n", "Pa\u00EDs"},app.cantAmigos(p)){
			public boolean isCellEditable(int row, int column) {return false;}};
			table.setModel(modelodefault);
			TableModel modeloDatos= table.getModel();
			int i= 0;
			Vertex a = app.findNick(p.getNick());
			List <Vertex> b = a.getAdjacents();
			Iterator<Vertex> it= b.iterator();
			while(it.hasNext()){
				Person aux= (Person)it.next().getInfo();
				modeloDatos.setValueAt(aux.getNick(), i,0);
				modeloDatos.setValueAt(aux.getOccupation(), i,1);
				modeloDatos.setValueAt(aux.getCountry(), i,2);
				i++;
			}
	}
}
