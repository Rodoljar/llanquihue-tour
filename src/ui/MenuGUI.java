package ui;

import data.GestorEntidades;
import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame {
    private GestorEntidades gestor = new GestorEntidades();
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public MenuGUI() {
        setTitle("Llanquihue Tour - Panel de Operaciones");
        setSize(950, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Panel de Control Unificado - Llanquihue Tour", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        add(lblTitulo, BorderLayout.NORTH);

        String[] columnas = {"Tipo de Entidad", "Nombre / Modelo", "Detalles del Registro", "Alertas y Recomendaciones"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modeloTabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 15, 10, 15));
        add(scrollPane, BorderLayout.CENTER);

        // PANEL DE BOTONES (Se agrega botón Salir)
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));

        JButton btnAgregarGuia = new JButton("Agregar Guía");
        JButton btnAgregarVehiculo = new JButton("Agregar Vehículo");
        JButton btnEliminar = new JButton("Eliminar Registro");
        JButton btnSalir = new JButton("Salir"); // <-- Botón nuevo

        // Estilos de botones
        btnEliminar.setBackground(new Color(220, 53, 69)); // Rojo
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);

        btnSalir.setBackground(new Color(108, 117, 125)); // Gris oscuro profesional
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFocusPainted(false);

        panelBotones.add(btnAgregarGuia);
        panelBotones.add(btnAgregarVehiculo);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir); // <-- Agregado al panel visual
        add(panelBotones, BorderLayout.SOUTH);

        actualizarTabla();

        // ACCIONADORES DE EVENTOS
        btnAgregarGuia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Nombre completo del Guía:");
                String telefono = JOptionPane.showInputDialog("Teléfono de contacto:");
                if (nombre != null && !nombre.trim().isEmpty() && telefono != null) {
                    gestor.agregarEntidad(new GuiaTuristico(nombre, telefono));
                    actualizarTabla();
                }
            }
        });

        btnAgregarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelo = JOptionPane.showInputDialog("Modelo del Vehículo:");
                String patente = JOptionPane.showInputDialog("Patente del Vehículo:");
                String capStr = JOptionPane.showInputDialog("Capacidad máxima de pasajeros:");
                if (modelo != null && patente != null && capStr != null) {
                    try {
                        int capacidad = Integer.parseInt(capStr);
                        gestor.agregarEntidad(new Vehiculo(patente, modelo, capacidad));
                        actualizarTabla();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Error: La capacidad debe ser un número válido.");
                    }
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tabla.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    int respuesta = JOptionPane.showConfirmDialog(null,
                            "¿Está seguro de que desea eliminar la fila seleccionada?",
                            "Confirmar Acción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        gestor.eliminarEntidad(filaSeleccionada);
                        actualizarTabla();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla para poder eliminarla.");
                }
            }
        });

        // Evento Botón Salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra toda la aplicación de manera segura
            }
        });
    }

    public void iniciar() {
        setVisible(true);
    }

    private void actualizarTabla() {
        gestor.desplegarResumenEntidades(); // Sigue imprimiendo en consola simultáneamente
        modeloTabla.setRowCount(0);

        for (Registrable entidad : gestor.getListaEntidades()) {
            String tipo = "";
            String nombreModelo = "";
            String detalles = "";
            String alertaRecomendacion = "-";

            if (entidad instanceof GuiaTuristico) {
                GuiaTuristico g = (GuiaTuristico) entidad;
                tipo = "Guía";
                nombreModelo = g.getNombre();
                detalles = "Contacto: " + g.getTelefono();
                alertaRecomendacion = "Credencial Sernatur Activa";
            } else if (entidad instanceof Vehiculo) {
                Vehiculo v = (Vehiculo) entidad;
                tipo = "Vehículo";
                nombreModelo = v.getModelo();
                detalles = "Patente: " + v.getPatente() + " | Capacidad: " + v.getCapacidadPasajeros() + " pasajeros";
                alertaRecomendacion = v.getCapacidadPasajeros() > 15 ? "Requiere Licencia Profesional A2/A3" : "Licencia Clase B";
            } else if (entidad instanceof ColaboradorExterno) {
                ColaboradorExterno c = (ColaboradorExterno) entidad;
                tipo = "Colaborador Ext.";
                nombreModelo = c.getNombre();
                detalles = "Empresa: " + c.getEmpresaAsociada() + " | Fono: " + c.getTelefono();
                alertaRecomendacion = "Revisar vigencia del convenio contractual";
            } else if (entidad instanceof RutaGastronomica) {
                RutaGastronomica r = (RutaGastronomica) entidad;
                tipo = "Ruta Gastronómica";
                nombreModelo = r.getNombre();
                detalles = "Valor: $" + r.getPrecio() + " | Paradas: " + r.getNumeroDeParadas() + " | Guía: " + (r.getGuia() != null ? r.getGuia().getNombre() : "Sin asignar");
                alertaRecomendacion = "TIPS: Llevar efectivo para propinas opcionales";
            } else if (entidad instanceof PaseoLacustre) {
                PaseoLacustre p = (PaseoLacustre) entidad;
                tipo = "Paseo Lacustre";
                nombreModelo = p.getNombre();
                detalles = "Valor: $" + p.getPrecio() + " | Embarcación: " + p.getTipoEmbarcacion() + " | Guía: " + (p.getGuia() != null ? p.getGuia().getNombre() : "Sin asignar");
                alertaRecomendacion = "SEGURIDAD: Uso obligatorio de chaleco salvavidas";
            } else if (entidad instanceof ExcursionCultural) {
                ExcursionCultural ex = (ExcursionCultural) entidad;
                tipo = "Excursión Cultural";
                nombreModelo = ex.getNombre();
                detalles = "Valor: $" + ex.getPrecio() + " | Sitio: " + ex.getLugarHistorico() + " | Guía: " + (ex.getGuia() != null ? ex.getGuia().getNombre() : "Sin asignar");
                alertaRecomendacion = "Ticket de ingreso incluido en el servicio";
            }
            modeloTabla.addRow(new Object[]{tipo, nombreModelo, detalles, alertaRecomendacion});
        }
    }
}