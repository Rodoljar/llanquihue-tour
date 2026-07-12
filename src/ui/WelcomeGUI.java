package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeGUI extends JFrame {

    public WelcomeGUI() {
        // Configuración de la ventana de bienvenida
        setTitle("Llanquihue Tour - Bienvenida");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new BorderLayout());

        // 1. Título de bienvenida
        JLabel lblTitulo = new JLabel("¡Bienvenido a Llanquihue Tour!", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        add(lblTitulo, BorderLayout.NORTH);

        // 2. Subtítulo descriptivo
        JLabel lblSubtitulo = new JLabel("Sistema Interno de Gestión de Operaciones", JLabel.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.ITALIC, 13));
        lblSubtitulo.setForeground(Color.GRAY);
        add(lblSubtitulo, BorderLayout.CENTER);

        // 3. Panel del botón de ingreso
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
        JButton btnEntrar = new JButton("Entrar a Llanquihue Tour");
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnEntrar.setPreferredSize(new Dimension(240, 40));
        btnEntrar.setBackground(new Color(40, 167, 69)); // Color verde amigable
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFocusPainted(false);

        panelBoton.add(btnEntrar);
        add(panelBoton, BorderLayout.SOUTH);

        // Accionador: Al hacer clic, abre el panel principal y cierra esta pantalla
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGUI ventanaPrincipal = new MenuGUI();
                ventanaPrincipal.iniciar(); // Despliega la gran tabla que ya armamos
                dispose(); // Destruye y cierra la ventana de bienvenida para liberar memoria
            }
        });
    }
}