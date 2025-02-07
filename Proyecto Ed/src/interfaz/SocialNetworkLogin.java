package interfaz;

import javax.swing.*;
import java.awt.*;

public class SocialNetworkLogin {

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Login de Red Social");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel de fondo
        JLabel background = new JLabel(new ImageIcon("C:\\\\Users\\\\rodri\\\\Documents\\\\GitHub\\\\Proyecto-de-Ed\\\\Proyecto Ed\\\\src\\\\fondos ed\\\\fondo.png"));
        background.setLayout(new BorderLayout());
        frame.add(background);

        // Panel de contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new GridLayout(3, 1, 10, 10));

        // Campo de usuario
        JPanel userPanel = new JPanel();
        userPanel.setOpaque(false);
        userPanel.setLayout(new FlowLayout());
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField(20);
        userPanel.add(userLabel);
        userPanel.add(userField);
        contentPanel.add(userPanel);

        // Campo de contraseña
        JPanel passwordPanel = new JPanel();
        passwordPanel.setOpaque(false);
        passwordPanel.setLayout(new FlowLayout());
        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordField = new JPasswordField(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        contentPanel.add(passwordPanel);

        // Botón de inicio de sesión
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout());
        JButton loginButton = new JButton("Iniciar Sesión");
        buttonPanel.add(loginButton);
        contentPanel.add(buttonPanel);

        // Agregar panel de contenido al panel de fondo
        background.add(contentPanel, BorderLayout.CENTER);

        // Acción del botón de inicio de sesión
        loginButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso"));

        frame.setVisible(true);
    }
}

