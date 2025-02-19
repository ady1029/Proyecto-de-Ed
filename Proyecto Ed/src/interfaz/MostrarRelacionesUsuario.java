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
import java.io.IOException;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class MostrarRelacionesUsuario extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private RedSystem sistema;
	private JTable table;
	private GeneralTree<Person> arbol;
	private JTextArea textArea;

	public MostrarRelacionesUsuario(MenuPrincAdmin father,RedSystem system) {
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
		scrollPane.setBounds(36, 144, 641, 251);
		contentPanel.add(scrollPane);

		String [] nodos= obtenerNick();
		table = new JTable();
		table.setBorder(new LineBorder(Color.BLACK, 1, true));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nivel", "Usuario"
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


		JComboBox comboBox = new JComboBox(obtenerNick());
		comboBox.setBounds(27, 27, 146, 22);
		panelBordeOval.add(comboBox);

		BotonAnimacion btnmcnBuscar = new BotonAnimacion();
		btnmcnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a= (String)comboBox.getSelectedItem();
				Vertex aux= sistema.findNick(a);
				textArea.setText("");
				try {
					llenarTabla((Person)aux.getInfo());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnmcnBuscar.setText("Buscar");
		btnmcnBuscar.setBounds(208, 27, 65, 22);
		panelBordeOval.add(btnmcnBuscar);

		JLabel lblNewLabel_1 = new JLabel("Recorrido del arbol a lo ancho por niveles");
		lblNewLabel_1.setBounds(20, 350, 253, 14);
		panelBordeOval.add(lblNewLabel_1);

		textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setBounds(291, 331, 213, 65);
		panelBordeOval.add(textArea);

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
		avatarCircular.setAvatar(new ImageIcon(MostrarRelacionesUsuario.class.getResource("/fotos/LogoConeccionPersonas.png")));
		avatarCircular.setBounds(21, 11, 56, 49);
		panel.add(avatarCircular);

		JLabel lblNewLabel = new JLabel("Relaciones de un Usuario ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		lblNewLabel.setBounds(79, 20, 479, 32);
		panel.add(lblNewLabel);


	}
	private String [] obtenerNick() {
		String [] nikcs = new String [sistema.getGraph().getVerticesList().size()]; 
		Iterator<Vertex> it= sistema.getGraph().getVerticesList().iterator();
		int i=0;
		while(it.hasNext()) {
			nikcs[i]= ((Person)it.next().getInfo()).getNick();
			i++;

		}		

		return nikcs;
	}

	private void llenarTabla(Person p) throws IOException {
		arbol= sistema.obtenerTodasconexiones(p);
		mostarIteratotr();
		int ab = arbol.treeHeight()+1;
		DefaultTableModel modelodefault= new DefaultTableModel(new String[] {"Nivel", "Usuario"},arbol.treeHeight()+1){
			public boolean isCellEditable(int row, int column) {return false;}};
			table.setModel(modelodefault);
			TableModel modeloDatos= table.getModel();
			int i= 1;
			Queue <BinaryTreeNode<Person>> visitados= new LinkedList<BinaryTreeNode<Person>>();
			visitados.offer(arbol.getNodeRoot());
			modeloDatos.setValueAt(0, 0,0);
			modeloDatos.setValueAt(p.getNick(), 0, 1);
			while(i<=arbol.treeHeight()){
				ArrayList <BinaryTreeNode<Person>> nivel= recorrerArbol(visitados, arbol);
				modeloDatos.setValueAt(i, i,0);
				String a="";
				for(BinaryTreeNode<Person> current: nivel) {
					a=a+current.getInfo().getNick()+",";
				}
				if(a!="") {
					modeloDatos.setValueAt(a.substring(0, a.length()-1), i,1);
				}
				i++;
				a= "";
			}
	}
	private ArrayList <BinaryTreeNode<Person>> recorrerArbol (Queue <BinaryTreeNode<Person>> visitados, GeneralTree<Person> arbol ) {
		ArrayList <BinaryTreeNode<Person>> nivelActual= new ArrayList();
		BinaryTreeNode<Person> actual= visitados.poll();
		nivelActual.addAll(arbol.getNodeSons(actual));
		for(BinaryTreeNode<Person> btn: nivelActual) {
			visitados.offer(btn);
		}

		return nivelActual;

	}
	private void mostarIteratotr() {
		InBreadthIterator<Person> it=arbol.inBreadthIterator();
		while(it.hasNext()) {
			Person p= it.next();
			textArea.setText(textArea.getText()+","+p.getNick());
		}
		if(textArea.getText().substring(textArea.getText().length()-1).equals(","))
		textArea.setText(textArea.getText().substring(1, textArea.getText().length()-1));
		else
			textArea.setText(textArea.getText().substring(1));
	}
}
