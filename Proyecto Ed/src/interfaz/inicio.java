package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import componentesVisuales.PanelAnimacionCurvas;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import componentesVisuales.BotonAnimacion;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio frame = new inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1185, 892);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelAnimacionCurvas panelAnimacionCurvas = new PanelAnimacionCurvas((Color) null, (Color) null, (Color) null, (Color) null);
		panelAnimacionCurvas.setFinGradiente(new Color(163, 193, 222));
		panelAnimacionCurvas.setColorFinalAnimacion(new Color(192, 192, 192));
		panelAnimacionCurvas.setColorInicioAnimacion(new Color(192, 192, 192));
		panelAnimacionCurvas.setInicioGradiente(new Color(107, 148, 184));
		panelAnimacionCurvas.setForeground(new Color(117, 147, 174));
		panelAnimacionCurvas.setBounds(0, 0, 1175, 855);
		contentPane.add(panelAnimacionCurvas);
		panelAnimacionCurvas.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rodri\\Documents\\GitHub\\Proyecto-de-Ed\\Proyecto Ed\\src\\fondos ed\\OIP (1).jpg"));
		lblNewLabel.setBounds(60, 90, 517, 584);
		panelAnimacionCurvas.add(lblNewLabel);
		
		BotonAnimacion btnmcnInciar = new BotonAnimacion();
		btnmcnInciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnmcnInciar.setColorEfecto(new Color(255, 255, 255));
		btnmcnInciar.setBackground(new Color(192, 192, 192));
		btnmcnInciar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 49));
		btnmcnInciar.setText("Iniciar");
		btnmcnInciar.setBounds(690, 159, 368, 118);
		panelAnimacionCurvas.add(btnmcnInciar);
		
		BotonAnimacion btnmcnCrditos = new BotonAnimacion();
		btnmcnCrditos.setColorEfecto(new Color(255, 255, 255));
		btnmcnCrditos.setText("Créditos");
		btnmcnCrditos.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 49));
		btnmcnCrditos.setBackground(Color.LIGHT_GRAY);
		btnmcnCrditos.setBounds(690, 340, 368, 118);
		panelAnimacionCurvas.add(btnmcnCrditos);
		
		BotonAnimacion btnmcnSalir = new BotonAnimacion();
		btnmcnSalir.setColorEfecto(new Color(255, 255, 255));
		btnmcnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnmcnSalir.setText("Salir");
		btnmcnSalir.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 49));
		btnmcnSalir.setBackground(Color.LIGHT_GRAY);
		btnmcnSalir.setBounds(690, 517, 368, 118);
		panelAnimacionCurvas.add(btnmcnSalir);
	}
}
