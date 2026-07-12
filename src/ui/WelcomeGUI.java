package ui;

import data.GestorEntidades;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeGUI extends JFrame {
    private GestorEntidades gestor;

    // El constructor ahora recibe el gestor de datos de forma obligatoria
    public WelcomeGUI(GestorEntidades gestor) {
        this.gestor = gestor;

        setTitle("Llanquihue Tour - Bienvenida");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("¡Bienvenido a Llanquihue Tour!", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        add(lblTitulo, BorderLayout.NORTH);

        JLabel lblSubtitulo = new JLabel("Sistema Interno de Gestión de Operaciones", JLabel.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.ITALIC, 13));
        lblSubtitulo.setForeground(Color.GRAY);
        add(lblSubtitulo, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
        JButton btnEntrar = new JButton("Entrar a Llanquihue Tour");
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnEntrar.setPreferredSize(new Dimension(240, 40));
        btnEntrar.setBackground(new Color(40, 167, 69));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFocusPainted(false);

        panelBoton.add(btnEntrar);
        add(panelBoton, BorderLayout.SOUTH);

        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pasamos correctamente el control de datos al menú operativo
                MenuGUI ventanaPrincipal = new MenuGUI(gestor);
                ventanaPrincipal.setVisible(true);
                dispose();
            }
        });
    }
}