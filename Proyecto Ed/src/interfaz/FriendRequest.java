package interfaz;
import javax.swing.*;
import java.awt.*;
import componentesVisuales.PanelAnimacionCurvas;

public class FriendRequest {

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Solicitud de Amistad");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Panel de fondo
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\rodri\\Documents\\GitHub\\Proyecto-de-Ed\\Proyecto Ed\\src\\fondos ed\\fondo.png"));
        background.setLayout(new BorderLayout());
        frame.getContentPane().add(background);

        // Panel de contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(null);
        
        // Foto de perfil
        JLabel profilePic = new JLabel(new ImageIcon("C:\\Users\\rodri\\Documents\\GitHub\\Proyecto-de-Ed\\Proyecto Ed\\src\\fondos ed\\Imagen de WhatsApp 2025-02-04 a las 19.39.50_96be228b.jpg"));
        profilePic.setBounds(0, 0, 384, 120);
        profilePic.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(profilePic);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 241, 384, 120);
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout());
                
                        JButton acceptButton = new JButton("Aceptar");
                        buttonPanel.add(acceptButton);
                        
                                // Acción de los botones
                                acceptButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Solicitud aceptada"));
        
                // Nombre de la persona
                JLabel nameLabel = new JLabel("Nombre de la Persona");
                buttonPanel.add(nameLabel);
                nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
                nameLabel.setForeground(Color.WHITE);
        JButton declineButton = new JButton("Rechazar");
        buttonPanel.add(declineButton);

        contentPanel.add(buttonPanel);

        // Agregar panel de contenido al panel de fondo
        background.add(contentPanel, BorderLayout.CENTER);
        
        PanelAnimacionCurvas panelAnimacionCurvas = new PanelAnimacionCurvas((Color) null, (Color) null, (Color) null, (Color) null);
        panelAnimacionCurvas.setInicioGradiente(Color.WHITE);
        panelAnimacionCurvas.setColorFinalAnimacion(new Color(255, 255, 255));
        panelAnimacionCurvas.setColorInicioAnimacion(new Color(128, 0, 0));
        panelAnimacionCurvas.setFinGradiente(new Color(0, 255, 0));
        panelAnimacionCurvas.setBounds(0, 0, 384, 361);
        contentPanel.add(panelAnimacionCurvas);
        declineButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Solicitud rechazada"));

        frame.setVisible(true);
    }
}