package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import componentesVisuales.PanelBordeOval;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import logica.Person;
import logica.RedSystem;
import logica.Request;
import componentesVisuales.AvatarCircular;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Color;
import componentesVisuales.BotonAnimacion;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
//Solicitudes = 0 para ver perfil del usuario
//Solicitues = 1 para  ver solicitudes de amistad
//Solicitudes = 2 para mandar solicitudes de amistad
public class InfoUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Person a;
	private RedSystem red;
	private Login father;
	private int aux;
	private List <Person> solic;
	private JTextField textFieldTrabC;
	private BotonAnimacion btnmcnSiguiente_1;
	private BotonAnimacion btnmcnSiguiente_2;
	private BotonAnimacion btnmcnConfirmar_1;
	private BotonAnimacion btnmcnAtrs;



	public InfoUsuario(MenuPrincAdmin menuAdmin,Person p, RedSystem r, int sol) {
		super(menuAdmin, true);
		a=p;
		red = r;
		aux =0;
		setBounds(100, 100, 548, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(55, 165, 255));
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		PanelBordeOval panelBordeOval = new PanelBordeOval(0);
		panelBordeOval.setBackground(new Color(176, 220, 255));
		panelBordeOval.setValorEsquinaOvalSI(60);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalII(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBounds(22, 11, 449, 284);
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

		JLabel labelCantTComun = new JLabel("Cantidad de trabajos en común:");
		labelCantTComun.setEnabled(false);
		labelCantTComun.setVisible(false);
		labelCantTComun.setFont(new Font("Arial", Font.PLAIN, 18));
		labelCantTComun.setBounds(10, 242, 278, 33);
		panelBordeOval.add(labelCantTComun);

		textFieldTrabC = new JTextField();
		textFieldTrabC.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldTrabC.setEnabled(false);
		textFieldTrabC.setVisible(false);
		textFieldTrabC.setBounds(277, 242, 96, 28);
		panelBordeOval.add(textFieldTrabC);
		textFieldTrabC.setColumns(10);

		btnmcnSiguiente_1 = new BotonAnimacion();
		btnmcnSiguiente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(aux < solic.size()) {
					if(sol == 1 ) {
						aux ++;
						usuario.setText(solic.get(aux).getNick());
						ocupacion.setText(solic.get(aux).getOccupation());
						pais.setText(solic.get(aux).getCountry().name());
						amigosC.setText(Integer.toString(red.cantAmigos(solic.get(aux))));
						trabajosPC.setText(Integer.toString(red.cantTrabajos(solic.get(aux))));
					}
				}
			}
		});
		btnmcnSiguiente_1.setEnabled(false);
		btnmcnSiguiente_1.setText("Siguiente ");
		btnmcnSiguiente_1.setVisible(false);
		btnmcnSiguiente_1.setBounds(384, 328, 77, 29);
		contentPanel.add(btnmcnSiguiente_1);

		BotonAnimacion btnmcnAtras = new BotonAnimacion();
		btnmcnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnmcnAtras.setText("Atrás ");
		btnmcnAtras.setBounds(22, 328, 77, 29);
		contentPanel.add(btnmcnAtras);

		BotonAnimacion btnmcnConfirmar = new BotonAnimacion();
		btnmcnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sol == 1) {
					boolean j = red.crearNuevaRelacion(usuario.getText(), p);
					if(j) {
						JOptionPane.showMessageDialog(InfoUsuario.this, "Solicitud Aceptada.");
						solic.remove(aux);
						aux ++;
						usuario.setText(solic.get(aux).getNick());
						ocupacion.setText(solic.get(aux).getOccupation());
						pais.setText(solic.get(aux).getCountry().name());
						amigosC.setText(Integer.toString(red.cantAmigos(solic.get(aux))));
						trabajosPC.setText(Integer.toString(red.cantTrabajos(solic.get(aux))));
					}
				}	 
			}
		});
		btnmcnConfirmar.setForeground(new Color(0, 255, 0));
		btnmcnConfirmar.setText("Confirmar ");
		btnmcnConfirmar.setEnabled(false);
		btnmcnConfirmar.setVisible(false);
		btnmcnConfirmar.setBounds(270, 328, 77, 29);
		contentPanel.add(btnmcnConfirmar);

		if(sol == 0) {
			usuario.setText(p.getNick());
			ocupacion.setText(p.getOccupation());
			pais.setText(p.getCountry().name());
			amigosC.setText(Integer.toString(red.cantAmigos(p)));
			trabajosPC.setText(Integer.toString(red.cantTrabajos(p)));
		}


		if(sol == 1) {
			solic = solicitudes();
			if(!solic.isEmpty()) {
				btnmcnConfirmar.setEnabled(true);
				btnmcnConfirmar.setVisible(true);
				btnmcnSiguiente_1.setEnabled(true);
				btnmcnSiguiente_1.setVisible(true);
				usuario.setText(solic.get(aux).getNick());
				ocupacion.setText(solic.get(aux).getOccupation());
				pais.setText(solic.get(aux).getCountry().name());
				amigosC.setText(Integer.toString(red.cantAmigos(solic.get(aux))));
				trabajosPC.setText(Integer.toString(red.cantTrabajos(solic.get(aux))));
			}
			else {
				JOptionPane.showMessageDialog(InfoUsuario.this, "No hay solicitudes de amistad");

			}

		}
	}


	public InfoUsuario(MenuUsuario menuUsuario,Person p, RedSystem r, int sol) {
		super(menuUsuario, true);
		a=p;
		red = r;
		aux =0;
		setBounds(100, 100, 548, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(55, 165, 255));
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		PanelBordeOval panelBordeOval = new PanelBordeOval(0);
		panelBordeOval.setBackground(new Color(176, 220, 255));
		panelBordeOval.setValorEsquinaOvalSI(60);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalII(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBounds(22, 11, 449, 284);
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

		JLabel labelCantTComun = new JLabel("Cantidad de trabajos en común:");
		labelCantTComun.setEnabled(false);
		labelCantTComun.setVisible(false);
		labelCantTComun.setFont(new Font("Arial", Font.PLAIN, 18));
		labelCantTComun.setBounds(10, 242, 278, 33);
		panelBordeOval.add(labelCantTComun);

		textFieldTrabC = new JTextField();
		textFieldTrabC.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldTrabC.setEnabled(false);
		textFieldTrabC.setVisible(false);
		textFieldTrabC.setBounds(277, 242, 96, 28);
		panelBordeOval.add(textFieldTrabC);
		textFieldTrabC.setColumns(10);

		BotonAnimacion btnmcnSiguiente = new BotonAnimacion();
		btnmcnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(aux < solic.size()) {
					if(sol == 1 ) {
						aux ++;
						if(aux< solic.size()) {
							usuario.setText(solic.get(aux).getNick());
							ocupacion.setText(solic.get(aux).getOccupation());
							pais.setText(solic.get(aux).getCountry().name());
							amigosC.setText(Integer.toString(red.cantAmigos(solic.get(aux))));
							trabajosPC.setText(Integer.toString(red.cantTrabajos(solic.get(aux))));
						}
					}
				}
			}
		});
		btnmcnSiguiente.setEnabled(false);
		btnmcnSiguiente.setText("Siguiente ");
		btnmcnSiguiente.setVisible(false);
		btnmcnSiguiente.setBounds(384, 328, 77, 29);
		contentPanel.add(btnmcnSiguiente);

		BotonAnimacion btnmcnAtras = new BotonAnimacion();
		btnmcnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnmcnAtras.setText("Atrás ");
		btnmcnAtras.setBounds(22, 328, 77, 29);
		contentPanel.add(btnmcnAtras);

		BotonAnimacion btnmcnConfirmar = new BotonAnimacion();
		btnmcnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sol == 1) {
					boolean j = red.crearNuevaRelacion(usuario.getText(), p);
					if(j) {
						JOptionPane.showMessageDialog(InfoUsuario.this, "Solicitud Aceptada.");
						solic.remove(aux);
						aux ++;
						if(aux < solic.size()) {
							usuario.setText(solic.get(aux).getNick());
							ocupacion.setText(solic.get(aux).getOccupation());
							pais.setText(solic.get(aux).getCountry().name());
							amigosC.setText(Integer.toString(red.cantAmigos(solic.get(aux))));
							trabajosPC.setText(Integer.toString(red.cantTrabajos(solic.get(aux))));
						}
					}	
				}
			}
		});
		btnmcnConfirmar.setForeground(new Color(0, 255, 0));
		btnmcnConfirmar.setText("Confirmar ");
		btnmcnConfirmar.setEnabled(false);
		btnmcnConfirmar.setVisible(false);
		btnmcnConfirmar.setBounds(270, 328, 77, 29);
		contentPanel.add(btnmcnConfirmar);

		if(sol == 0) {
			usuario.setText(p.getNick());
			ocupacion.setText(p.getOccupation());
			pais.setText(p.getCountry().name());
			amigosC.setText(Integer.toString(red.cantAmigos(p)));
			trabajosPC.setText(Integer.toString(red.cantTrabajos(p)));
		}


		if(sol == 1) {
			solic = solicitudes();
			if(!solic.isEmpty()) {
				btnmcnConfirmar.setEnabled(true);
				btnmcnConfirmar.setVisible(true);
				btnmcnSiguiente.setEnabled(true);
				btnmcnSiguiente.setVisible(true);
				usuario.setText(solic.get(aux).getNick());
				ocupacion.setText(solic.get(aux).getOccupation());
				pais.setText(solic.get(aux).getCountry().name());
				amigosC.setText(Integer.toString(red.cantAmigos(solic.get(aux))));
				trabajosPC.setText(Integer.toString(red.cantTrabajos(solic.get(aux))));
			}
			else {
				JOptionPane.showMessageDialog(InfoUsuario.this, "No hay solicitudes de amistad");

			}

		}
	}

	/**
	 * @wbp.parser.constructor
	 */

	public InfoUsuario(SolicitudesOpciones menuUsuario,Person p, RedSystem r, int sol) {
		super(menuUsuario, true);
		a=p;
		red = r;
		aux =0;
		setBounds(100, 100, 527, 468);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(55, 165, 255));
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		PanelBordeOval panelBordeOval = new PanelBordeOval(0);
		panelBordeOval.setBackground(new Color(176, 220, 255));
		panelBordeOval.setValorEsquinaOvalSI(60);
		panelBordeOval.setValorEsquinaOvalSD(60);
		panelBordeOval.setValorEsquinaOvalII(60);
		panelBordeOval.setValorEsquinaOvalID(60);
		panelBordeOval.setBounds(22, 11, 449, 339);
		contentPanel.add(panelBordeOval);
		panelBordeOval.setLayout(null);

		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setAvatar(new ImageIcon(InfoUsuario.class.getResource("/fotos/Imagen de WhatsApp 2025-02-04 a las 19.39.50_96be228b.jpg")));
		avatarCircular.setBounds(10, 21, 114, 106);
		panelBordeOval.add(avatarCircular);

		JLabel usuario = new JLabel("zhrs");
		usuario.setFont(new Font("Arial", Font.PLAIN, 24));
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setBounds(134, 46, 199, 33);
		panelBordeOval.add(usuario);

		JLabel ocupacion = new JLabel("afd");
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

		JLabel labelCantTComun = new JLabel("Cantidad de trabajos en común:");
		labelCantTComun.setFont(new Font("Arial", Font.PLAIN, 18));
		labelCantTComun.setBounds(10, 242, 278, 33);
		panelBordeOval.add(labelCantTComun);

		textFieldTrabC = new JTextField();
		textFieldTrabC.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldTrabC.setBounds(277, 242, 96, 28);
		panelBordeOval.add(textFieldTrabC);
		textFieldTrabC.setColumns(10);

		btnmcnConfirmar_1 = new BotonAnimacion();
		btnmcnConfirmar_1.setBounds(344, 296, 77, 29);
		panelBordeOval.add(btnmcnConfirmar_1);
		btnmcnConfirmar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!act()) {
					boolean ab = red.crearSolicitud(a, solic.get(aux), Integer.parseInt(textFieldTrabC.getText()));
					if(ab && (!(textFieldTrabC.getText().equalsIgnoreCase("")))) {
						JOptionPane.showMessageDialog(InfoUsuario.this, "Solicitud Enviada.");
						menuUsuario.getFather().inic("Solicitud de amistad enviada a "+ solic.get(aux).getNick());
						solic.remove(aux);
						if(solic.size()> aux) {
							usuario.setText(solic.get(aux).getNick());
							ocupacion.setText(solic.get(aux).getOccupation());
							pais.setText(solic.get(aux).getCountry().name());
							amigosC.setText(Integer.toString(red.cantAmigos(solic.get(aux))));
							trabajosPC.setText(Integer.toString(red.cantTrabajos(solic.get(aux))));
							textFieldTrabC.setText("");
							if(aux+1 == solic.size()) {
								btnmcnSiguiente_2.setEnabled(false);
							}
							if(aux-1 <= 0)
								btnmcnAtrs.setEnabled(false);
						}
						else {
							dispose();
						}
					}
					else
						JOptionPane.showMessageDialog(InfoUsuario.this, "Ya se le ha enviado una solicitud de amistad ");
				}
				else {
					JOptionPane.showMessageDialog(InfoUsuario.this, "Solicitud no enviada. El campo del trabajo en común tiene que ser un número entero.");
					textFieldTrabC.setText("");
				}	 
			}
		});
		btnmcnConfirmar_1.setForeground(new Color(0, 255, 0));
		btnmcnConfirmar_1.setText("Enviar");

		btnmcnSiguiente_2 = new BotonAnimacion();
		btnmcnSiguiente_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aux ++;
				if(aux < solic.size()) {
					usuario.setText(solic.get(aux).getNick());
					ocupacion.setText(solic.get(aux).getOccupation());
					pais.setText(solic.get(aux).getCountry().name());
					amigosC.setText(Integer.toString(red.cantAmigos(solic.get(aux))));
					trabajosPC.setText(Integer.toString(red.cantTrabajos(solic.get(aux))));
					textFieldTrabC.setText("");
					btnmcnAtrs.setEnabled(true);
					if(aux+1 == solic.size()) {
						btnmcnSiguiente_2.setEnabled(false);
					}
				}
			}
		});
		btnmcnSiguiente_2.setText("Siguiente ");
		btnmcnSiguiente_2.setBounds(392, 374, 77, 29);
		contentPanel.add(btnmcnSiguiente_2);

		BotonAnimacion btnmcnAtras = new BotonAnimacion();
		btnmcnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnmcnAtras.setText("Salir");
		btnmcnAtras.setBounds(22, 374, 77, 29);
		contentPanel.add(btnmcnAtras);

		btnmcnAtrs = new BotonAnimacion();
		btnmcnAtrs.setEnabled(false);
		btnmcnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aux--;
				if(aux >=0) {
					usuario.setText(solic.get(aux).getNick());
					ocupacion.setText(solic.get(aux).getOccupation());
					pais.setText(solic.get(aux).getCountry().name());
					amigosC.setText(Integer.toString(red.cantAmigos(solic.get(aux))));
					trabajosPC.setText(Integer.toString(red.cantTrabajos(solic.get(aux))));
					btnmcnAtras.setEnabled(true);
					btnmcnSiguiente_2.setEnabled(true);
					if(aux+1 == solic.size()) {
						btnmcnAtras.setEnabled(false);
					}
				}
			}
		});
		btnmcnAtrs.setText("Atrás ");
		btnmcnAtrs.setBounds(302, 374, 77, 29);
		contentPanel.add(btnmcnAtrs);

		solic = personasSinRel();
		if(solic.size()>0) {
			usuario.setText(solic.get(aux).getNick());
			ocupacion.setText(solic.get(aux).getOccupation());
			pais.setText(solic.get(aux).getCountry().name());
			amigosC.setText(Integer.toString(red.cantAmigos(solic.get(aux))));
			trabajosPC.setText(Integer.toString(red.cantTrabajos(solic.get(aux))));
		}
		if(solic.size()<2) {
			btnmcnSiguiente_2.setEnabled(false);
		}

	}


	public List<Person> solicitudes(){
		List <Person> solicitudes = new ArrayList<Person>();
		Queue<Request>  s = (Queue<Request>)a.getSolicitudAmistad().clone();
		Person temp = new Person();
		while(!s.isEmpty()) {
			Request aux = s.poll();
			temp = (Person)aux.getPersonaEnvia();
			solicitudes.add(temp);
		}
		return solicitudes;
	}
	public List<Person> personasSinRel(){
		List<Person> sinRelacion = new ArrayList<Person>();
		Vertex vertex = red.findNick(a.getNick());
		LinkedList <Vertex> vertices = vertex.getAdjacents();
		Iterator <Vertex> it = red.getGraph().getVerticesList().iterator();
		while(it.hasNext()) {
			Vertex temp = it.next();
			if(!(vertices.contains(temp)) && (vertex != temp)) {
				sinRelacion.add((Person)temp.getInfo());
			}
		}
		return sinRelacion;
	}
	public boolean act () {
		char [] temp = textFieldTrabC.getText().toCharArray();
		int aux = 0;
		boolean c= false;
		while(temp.length < aux + 1 && !c) {
			if(temp[aux] != '1' || temp[aux] != '2' || temp[aux] != '3' || temp[aux] != '4' || temp[aux] != '5' ||temp[aux] != '6' || temp[aux] != '7' || temp[aux] != '8' || temp[aux] != '9' || temp[aux] != '0') {
				c = true;
			}
			else
				aux ++;
		}
		return c;
	}
}
