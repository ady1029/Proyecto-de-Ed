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

public class MostrarMatrizAdjacencia extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private RedSystem sistema;
	private JTable table;

	public MostrarMatrizAdjacencia(MenuPrincAdmin father,RedSystem system) {
		super(father, true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Matriz de adyacencia de las relaciones de los usuarios ");
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
			},nodos
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
		avatarCircular.setAvatar(new ImageIcon(MostrarMatrizAdjacencia.class.getResource("/fotos/LogoConeccionPersonas.png")));
		avatarCircular.setBounds(21, 11, 56, 49);
		panel.add(avatarCircular);
		
		JLabel lblNewLabel = new JLabel("Matriz de Adyacencia de las Relaciones de los Usuarios");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		lblNewLabel.setBounds(79, 20, 479, 32);
		panel.add(lblNewLabel);
		
		
		llenarTabla(nodos);
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
	
	private void llenarTabla(String [] nodos) {
		DefaultTableModel modelodefault= new DefaultTableModel(nodos,nodos.length-1){public boolean isCellEditable(int row, int column) {return false;}};
		table.setModel(modelodefault);
		TableModel modeloDatos= table.getModel();
		for( int i=0; i<nodos.length-1;i++){
			modeloDatos.setValueAt(nodos[i+1], i,0);
			char[] nodoAdj= obtenerAdjacencia(nodos[i+1]);
			for(int j=0; j< nodoAdj.length; j++) {
				modeloDatos.setValueAt(nodoAdj[j], i,j+1);
			}
			
		}

	}
	
	
	private char[] obtenerAdjacencia(String actual) {
		char [] nodoAdj= new char[sistema.getGraph().getVerticesList().size()];
		Vertex aux= sistema.findNick(actual);
		Iterator it= sistema.getGraph().getVerticesList().iterator();
		int i=0;
		while(it.hasNext()) {
			Vertex current= (Vertex) it.next();
			if(aux.isAdjacent(current))
				nodoAdj[i]='1';
			else nodoAdj[i]='0';
			i++;
			}
		return nodoAdj;
		
	}
}
