package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;
import logica.Comunity;
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
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class MostrarComunidades extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private RedSystem sistema;
	private JTable table;
	private GeneralTree<Person> arbol;

	public MostrarComunidades(MenuPrincAdmin father,RedSystem system) {
		super(father, true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Listado de Usuarios");
		sistema= system;
		setBounds(100, 100, 732, 575);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 85, 641, 378);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.setBorder(new LineBorder(Color.BLACK, 1, true));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Comunidades", "Usuario"
				}
				));
		scrollPane.setViewportView(table);

		PanelBordeOval panelBordeOval = new PanelBordeOval(0);
		panelBordeOval.setBackground(new Color(91, 182, 255));
		panelBordeOval.setValorEsquinaOvalSI(60);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalII(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBounds(20, 71, 677, 407);
		contentPanel.add(panelBordeOval);
		panelBordeOval.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(42, 167, 255));
		panel.setBounds(0, 0, 716, 536);
		contentPanel.add(panel);
		panel.setLayout(null);

		BotonAnimacion btnmcnAtrs = new BotonAnimacion();
		btnmcnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnmcnAtrs.setText("Atrás");
		btnmcnAtrs.setBounds(626, 501, 68, 24);
		panel.add(btnmcnAtrs);

		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setAvatar(new ImageIcon(MostrarLideresInvestigacion.class.getResource("/fotos/LogoConeccionPersonas.png")));
		avatarCircular.setBounds(21, 11, 56, 49);
		panel.add(avatarCircular);

		JLabel lblNewLabel = new JLabel("Comunidades ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		lblNewLabel.setBounds(79, 20, 479, 32);
		panel.add(lblNewLabel);

		llenarTabla();
	}
	private void llenarTabla() {
		LinkedList<Comunity> comunidades= sistema.obtenerComunidades();
		int total=0;
		for(Comunity comunidad: comunidades) {
			total+=comunidad.getCantdintegrantes();
		}
		DefaultTableModel modelodefault= new DefaultTableModel(new String[] {"Comunidades", "Usuario"},total){
			public boolean isCellEditable(int row, int column) {return false;}};
			table.setModel(modelodefault);
			TableModel modeloDatos= table.getModel();
			int i= 1;
			int j=0;
			for(Comunity aux: comunidades) {
				modeloDatos.setValueAt("Comunidad "+i, j,0);
				Iterator<Person> it= aux.getIntegrantes().iterator();
				while(it.hasNext()){
					Person actual= it.next();
					modeloDatos.setValueAt(actual.getNick(), j,1);
					j++;
				}
				i++;
			}
	}
}