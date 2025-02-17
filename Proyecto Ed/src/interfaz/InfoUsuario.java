package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import componentesVisuales.PanelBordeOval;
import logica.Person;
import logica.RedSystem;
import componentesVisuales.AvatarCircular;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Color;
import componentesVisuales.BotonAnimacion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//Solicitudes = 0 para ver perfil del usuario
//Solicitues = 1 para  ver solicitudes de amistad
//Solicitudes = 2 para mandar solicitudes de amistad
public class InfoUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Person a;
	private RedSystem red;
	private Login father;
	public InfoUsuario(Person p, RedSystem r) {
		a=p;
		red = r;
		setBounds(100, 100, 491, 358);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(55, 165, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		PanelBordeOval panelBordeOval = new PanelBordeOval(0);
		panelBordeOval.setBackground(new Color(176, 220, 255));
		panelBordeOval.setValorEsquinaOvalSI(60);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalII(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBounds(22, 11, 439, 243);
		contentPanel.add(panelBordeOval);
		panelBordeOval.setLayout(null);
		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setAvatar(new ImageIcon(InfoUsuario.class.getResource("/fotos/Imagen de WhatsApp 2025-02-04 a las 19.39.50_96be228b.jpg")));
		avatarCircular.setBounds(10, 21, 114, 106);
		panelBordeOval.add(avatarCircular);
		
		JLabel usuario = new JLabel("");
		usuario.setFont(new Font("Arial", Font.PLAIN, 24));
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setBounds(134, 46, 199, 33);
		panelBordeOval.add(usuario);
		
		JLabel ocupacion = new JLabel("");
		ocupacion.setFont(new Font("Arial", Font.PLAIN, 24));
		ocupacion.setBounds(144, 79, 189, 33);
		panelBordeOval.add(ocupacion);
		
		JLabel lblPais = new JLabel("Pais :");
		lblPais.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPais.setBounds(10, 138, 61, 33);
		panelBordeOval.add(lblPais);
		
		JLabel lblCantidadDeTrabajos = new JLabel("Cantidad de amigos: ");
		lblCantidadDeTrabajos.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCantidadDeTrabajos.setBounds(10, 168, 170, 33);
		panelBordeOval.add(lblCantidadDeTrabajos);
		
		JLabel pais = new JLabel("");
		pais.setFont(new Font("Arial", Font.PLAIN, 18));
		pais.setBounds(61, 138, 206, 33);
		panelBordeOval.add(pais);
		
		JLabel amigosC = new JLabel("");
		amigosC.setFont(new Font("Arial", Font.PLAIN, 18));
		amigosC.setBounds(190, 173, 61, 22);
		panelBordeOval.add(amigosC);
		
		JLabel lblCantidadDeTrabajos_1 = new JLabel("Cantidad de trabajos publicados: ");
		lblCantidadDeTrabajos_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCantidadDeTrabajos_1.setBounds(10, 199, 278, 33);
		panelBordeOval.add(lblCantidadDeTrabajos_1);
		
		JLabel trabajosPC = new JLabel("");
		trabajosPC.setFont(new Font("Arial", Font.PLAIN, 18));
		trabajosPC.setBounds(277, 204, 61, 22);
		panelBordeOval.add(trabajosPC);
		
		BotonAnimacion btnmcnSiguiente = new BotonAnimacion();
		btnmcnSiguiente.setEnabled(false);
		btnmcnSiguiente.setText("Siguiente ");
		btnmcnSiguiente.setVisible(false);
		btnmcnSiguiente.setBounds(375, 275, 77, 29);
		contentPanel.add(btnmcnSiguiente);
		
		BotonAnimacion btnmcnAtras = new BotonAnimacion();
		btnmcnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuUsuario frame = new MenuUsuario(father,red,p);
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnmcnAtras.setText("Atrás ");
		btnmcnAtras.setBounds(22, 275, 77, 29);
		contentPanel.add(btnmcnAtras);
		
		usuario.setText(p.getNick());
		ocupacion.setText(p.getOccupation());
		pais.setText(p.getCountry().name());
		int cantA = red.cantAmigos(p);
		String a = Integer.toString(cantA);
		amigosC.setText(a);
		
		BotonAnimacion btnmcnConfirmar = new BotonAnimacion();
		btnmcnConfirmar.setForeground(new Color(0, 255, 0));
		btnmcnConfirmar.setText("Confirmar ");
		btnmcnConfirmar.setEnabled(false);
		btnmcnConfirmar.setVisible(false);
		btnmcnConfirmar.setBounds(266, 275, 77, 29);
		contentPanel.add(btnmcnConfirmar);
		
		
		
	}
}
