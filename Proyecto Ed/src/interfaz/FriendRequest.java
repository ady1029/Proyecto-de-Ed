package interfaz;
import javax.swing.*;
import java.awt.*;

public class FriendRequest {

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Solicitud de Amistad");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel de fondo
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\rodri\\Documents\\GitHub\\Proyecto-de-Ed\\Proyecto Ed\\src\\fondos ed\\fondo.png"));
        background.setLayout(new BorderLayout());
        frame.add(background);

        // Panel de contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new GridLayout(3, 1));
        
        // Foto de perfil
        JLabel profilePic = new JLabel(new ImageIcon("C:\\Users\\rodri\\Documents\\GitHub\\Proyecto-de-Ed\\Proyecto Ed\\src\\fondos ed\\Imagen de WhatsApp 2025-02-04 a las 19.39.50_96be228b.jpg"));
        profilePic.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(profilePic);

        // Nombre de la persona
        JLabel nameLabel = new JLabel("Nombre de la Persona");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setForeground(Color.WHITE); // Texto blanco para mejor visibilidad
        contentPanel.add(nameLabel);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout());

        JButton acceptButton = new JButton("Aceptar");
        JButton declineButton = new JButton("Rechazar");

        buttonPanel.add(acceptButton);
        buttonPanel.add(declineButton);

        contentPanel.add(buttonPanel);

        // Agregar panel de contenido al panel de fondo
        background.add(contentPanel, BorderLayout.CENTER);

        // Acción de los botones
        acceptButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Solicitud aceptada"));
        declineButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Solicitud rechazada"));

        frame.setVisible(true);
    }
}