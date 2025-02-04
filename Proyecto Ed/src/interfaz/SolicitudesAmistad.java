package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

import componentesVisuales.AvatarCircular;

import javax.swing.ImageIcon;
import componentesVisuales.BotonAnimacion;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;

public class SolicitudesAmistad extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitudesAmistad frame = new SolicitudesAmistad();
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
	public SolicitudesAmistad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AvatarCircular avatarCircular = new AvatarCircular();
		ArrayList <ImageIcon> iconos = new ArrayList<ImageIcon>();
		iconos.add(new ImageIcon("E:\\Carrera\\1er año\\2do semestre\\DPOO\\Laboratorio 5\\Imagen de WhatsApp 2025-02-03 a las 23.51.29_c78aa3d6.png"));
		avatarCircular.setAvatar(new ImageIcon("E:\\Carrera\\1er año\\2do semestre\\DPOO\\Laboratorio 5\\Imagen de WhatsApp 2025-02-03 a las 23.51.29_c78aa3d6.png"));
		avatarCircular.setBounds(24, 67, 163, 163);
		contentPane.add(avatarCircular);
		
		JLabel lblNewLabel = new JLabel("Información");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 67, 197, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNick = new JLabel("Nick :");
		lblNick.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNick.setBounds(213, 105, 46, 14);
		contentPane.add(lblNick);
		
		JLabel lblPais = new JLabel("Pais :");
		lblPais.setFont(new Font("Arial", Font.PLAIN, 17));
		lblPais.setBounds(213, 130, 46, 20);
		contentPane.add(lblPais);
		
		JLabel lblNewLabel_1 = new JLabel("Ocupacion :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(213, 152, 110, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAmigosEnComun = new JLabel("Amigos en comun");
		lblAmigosEnComun.setBounds(213, 189, 122, 25);
		contentPane.add(lblAmigosEnComun);
		
		JLabel label = new JLabel("Nick :");
		label.setFont(new Font("Arial", Font.PLAIN, 17));
		label.setBounds(280, 105, 145, 17);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Pais :");
		label_1.setFont(new Font("Arial", Font.PLAIN, 17));
		label_1.setBounds(269, 130, 157, 20);
		contentPane.add(label_1);
		
		JLabel lblSolicitudesDeAmistad = new JLabel("Solicitudes de Amistad ");
		lblSolicitudesDeAmistad.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicitudesDeAmistad.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblSolicitudesDeAmistad.setBounds(-16, 11, 275, 27);
		contentPane.add(lblSolicitudesDeAmistad);
		
		BotonAnimacion btnmcnConfirmar = new BotonAnimacion();
		btnmcnConfirmar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnmcnConfirmar.setText("Confirmar");
		btnmcnConfirmar.setBounds(173, 231, 157, 27);
		contentPane.add(btnmcnConfirmar);
		
		JLabel label_2 = new JLabel("Ocupacion :");
		label_2.setFont(new Font("Arial", Font.PLAIN, 17));
		label_2.setBounds(327, 152, 173, 26);
		contentPane.add(label_2);
		
		BotonAnimacion btnmcnSigiuente = new BotonAnimacion();
		btnmcnSigiuente.setText("Siguiente");
		btnmcnSigiuente.setFont(new Font("Arial", Font.PLAIN, 16));
		btnmcnSigiuente.setBounds(370, 289, 157, 27);
		contentPane.add(btnmcnSigiuente);
		
		BotonAnimacion btnmcnAtras = new BotonAnimacion();
		btnmcnAtras.setText("Atras");
		btnmcnAtras.setFont(new Font("Arial", Font.PLAIN, 16));
		btnmcnAtras.setBounds(41, 289, 128, 27);
		contentPane.add(btnmcnAtras);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel.setBounds(10, 49, 531, 223);
		contentPane.add(panel);
	}
}
