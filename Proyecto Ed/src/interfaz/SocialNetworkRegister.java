package interfaz;

import javax.swing.*;
import java.awt.*;

public class SocialNetworkRegister {

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Registro de Red Social");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel de fondo
        JLabel background = new JLabel(new ImageIcon("C:\\\\\\\\Users\\\\\\\\rodri\\\\\\\\Documents\\\\\\\\GitHub\\\\\\\\Proyecto-de-Ed\\\\\\\\Proyecto Ed\\\\\\\\src\\\\\\\\fondos ed\\\\\\\\fondo.png"));
        background.setLayout(new BorderLayout());
        frame.add(background);

        // Panel de contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new GridLayout(5, 1, 10, 10)); // 5 filas, 1 columna, con espaciado de 10 píxeles

        // Campo de nick
        JTextField nickField = new JTextField();
        nickField.setBorder(BorderFactory.createTitledBorder("Nick"));
        contentPanel.add(nickField);

        // Campo de profesión
        JTextField professionField = new JTextField();
        professionField.setBorder(BorderFactory.createTitledBorder("Profesión"));
        contentPanel.add(professionField);

        // Campo de país
        JTextField countryField = new JTextField();
        countryField.setBorder(BorderFactory.createTitledBorder("País"));
        contentPanel.add(countryField);

        // Campo de contraseña
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder("Contraseña"));
        contentPanel.add(passwordField);

        // Botón de registro
        JButton registerButton = new JButton("Registrarse");
        contentPanel.add(registerButton);

        // Agregar panel de contenido al panel de fondo
        background.add(contentPanel, BorderLayout.CENTER);

        // Acción del botón de registro
        registerButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Registro exitoso"));

        frame.setVisible(true);
    }
}

