package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cu.edu.cujae.ceis.graph.vertex.Vertex;
import logica.Person;
import logica.RedSystem;
import componentesVisuales.PanelBordeOval;
import java.awt.Color;
import javax.swing.border.LineBorder;
import componentesVisuales.BotonAnimacion;
import componentesVisuales.AvatarCircular;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostarUsuariosIslas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private RedSystem sistema;
	private JTable table;

	public MostarUsuariosIslas(MenuPrincAdmin father,RedSystem system) {
		super(father, true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Listado de Usuarios");
		sistema= system;
		setBounds(100, 100, 732, 549);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 99, 641, 336);
		contentPanel.add(scrollPane);

		String [] nodos= obtenerNick();
		table = new JTable();
		table.setBorder(new LineBorder(Color.BLACK, 1, true));
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
				},
				new String[] {
						"Nombre", "Contarse\u00F1a ", "Ocupaci\u00F3n", "Pa\u00EDs"
				}
				));
		scrollPane.setViewportView(table);

		PanelBordeOval panelBordeOval = new PanelBordeOval(0);
		panelBordeOval.setBackground(new Color(91, 182, 255));
		panelBordeOval.setValorEsquinaOvalSI(60);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalII(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBounds(20, 71, 677, 388);
		contentPanel.add(panelBordeOval);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(42, 167, 255));
		panel.setBounds(0, 0, 716, 510);
		contentPanel.add(panel);
		panel.setLayout(null);

		BotonAnimacion btnmcnAtrs = new BotonAnimacion();
		btnmcnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnmcnAtrs.setText("Atrás");
		btnmcnAtrs.setBounds(623, 474, 68, 24);
		panel.add(btnmcnAtrs);

		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setAvatar(new ImageIcon(MostarUsuariosIslas.class.getResource("/fotos/FotoUsuarios.png")));
		avatarCircular.setBounds(21, 11, 56, 49);
		panel.add(avatarCircular);

		JLabel lblNewLabel = new JLabel("Listado de Usuarios");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		lblNewLabel.setBounds(79, 20, 479, 32);
		panel.add(lblNewLabel);


		llenarTabla();
	}
	private String [] obtenerNick() {
		String [] nikcs = new String [sistema.getGraph().getVerticesList().size()+1]; 
		Iterator<Vertex> it= sistema.getGraph().getVerticesList().iterator();
		nikcs[0]="Nodos";
		int i=1;
		while(it.hasNext()) {
			nikcs[i]= ((Person)it.next().getInfo()).getNick();
			i++;

		}		

		return nikcs;
	}

	private void llenarTabla() {
		DefaultTableModel modelodefault= new DefaultTableModel(new String[] {"Nombre", "Contarse\u00F1a ", "Ocupaci\u00F3n", "Pa\u00EDs"},sistema.getGraph().getVerticesList().size()){
			public boolean isCellEditable(int row, int column) {return false;}};
			table.setModel(modelodefault);
			TableModel modeloDatos= table.getModel();
			int i= 0;
			Iterator<Vertex> it= sistema.getGraph().getVerticesList().iterator();
			while(it.hasNext()){
				Person aux= (Person)it.next().getInfo();
				modeloDatos.setValueAt(aux.getNick(), i,0);
				modeloDatos.setValueAt(aux.getPassword(), i,1);
				modeloDatos.setValueAt(aux.getOccupation(), i,2);
				modeloDatos.setValueAt(aux.getCountry(), i,3);
				i++;
			}
	}


	
}
