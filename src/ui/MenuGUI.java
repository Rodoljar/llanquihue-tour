package ui;

import data.GestorEntidades;
import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuGUI extends JFrame {
    private GestorEntidades gestor;
    private JTable table;
    private DefaultTableModel tableModel;

    public MenuGUI(GestorEntidades gestor) {
        this.gestor = gestor;
        setTitle("Llanquihue Tour - Panel de Operaciones");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Panel de Control Unificado - Llanquihue Tour", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        add(lblTitle, BorderLayout.NORTH);

        String[] columns = {"Tipo de Entidad", "Nombre / Modelo", "Detalles del Registro", "Alertas y Recomendaciones"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setRowHeight(24);

        // --- CONFIGURACIÓN DE ANCHOS PROPORCIONALES ---
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(0).setPreferredWidth(130); // Tipo de Entidad
        table.getColumnModel().getColumn(1).setPreferredWidth(180); // Nombre / Modelo
        table.getColumnModel().getColumn(2).setPreferredWidth(420); // ¡Mucho más espacio para los detalles!
        table.getColumnModel().getColumn(3).setPreferredWidth(250); // Alertas y Recomendaciones
        // ----------------------------------------------

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));

        JButton btnAddGuide = new JButton("Agregar Guía");
        JButton btnAddVehicle = new JButton("Agregar Vehículo");
        JButton btnDelete = new JButton("Eliminar Registro");
        JButton btnExit = new JButton("Salir");

        btnAddGuide.setFont(new Font("Arial", Font.BOLD, 14));
        btnAddVehicle.setFont(new Font("Arial", Font.BOLD, 14));
        btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
        btnDelete.setBackground(new Color(220, 53, 69));
        btnDelete.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));
        btnExit.setBackground(new Color(108, 117, 125));
        btnExit.setForeground(Color.WHITE);

        panelButtons.add(btnAddGuide);
        panelButtons.add(btnAddVehicle);
        panelButtons.add(btnDelete);
        panelButtons.add(btnExit);
        add(panelButtons, BorderLayout.SOUTH);

        btnAddGuide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(MenuGUI.this, "Ingrese Nombre del Guía:");
                if (nombre == null || nombre.trim().isEmpty()) return;

                String telefono = JOptionPane.showInputDialog(MenuGUI.this, "Ingrese Teléfono de Contacto:");
                if (telefono == null || telefono.trim().isEmpty()) return;

                String tour = JOptionPane.showInputDialog(MenuGUI.this, "Ingrese el Tour Asignado:");
                if (tour == null || tour.trim().isEmpty()) return;

                String vehiculo = JOptionPane.showInputDialog(MenuGUI.this, "Ingrese el Vehículo a Cargo:");
                if (vehiculo == null || vehiculo.trim().isEmpty()) return;

                GuiaTuristico nuevoGuia = new GuiaTuristico(nombre, telefono, tour, vehiculo);
                gestor.agregarEntidad(nuevoGuia);
                actualizarTabla();
            }
        });

        btnAddVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelo = JOptionPane.showInputDialog(MenuGUI.this, "Ingrese Modelo del Vehículo:");
                if (modelo == null || modelo.trim().isEmpty()) return;

                String patente = JOptionPane.showInputDialog(MenuGUI.this, "Ingrese Patente:");
                if (patente == null || patente.trim().isEmpty()) return;

                String capStr = JOptionPane.showInputDialog(MenuGUI.this, "Ingrese Capacidad de Pasajeros:");
                if (capStr == null || capStr.trim().isEmpty()) return;

                try {
                    int capacidad = Integer.parseInt(capStr);
                    Vehiculo nuevoVehiculo = new Vehiculo(patente, modelo, capacidad);
                    gestor.agregarEntidad(nuevoVehiculo);
                    actualizarTabla();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MenuGUI.this, "La capacidad debe ser un valor numérico.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(MenuGUI.this, "¿Desea eliminar el registro seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        // Buscamos el objeto real usando el modelo para evitar errores de desfase por el ordenamiento
                        String patenteONombre = (String) tableModel.getValueAt(selectedRow, 1);
                        Registrable aEliminar = null;

                        for (Registrable ent : gestor.getListaEntidades()) {
                            if (ent instanceof GuiaTuristico && ((GuiaTuristico) ent).getNombre().equals(patenteONombre)) {
                                aEliminar = ent;
                                break;
                            } else if (ent instanceof Vehiculo && ((Vehiculo) ent).getModelo().equals(patenteONombre)) {
                                aEliminar = ent;
                                break;
                            }
                        }

                        if (aEliminar != null) {
                            gestor.getListaEntidades().remove(aEliminar);
                        } else {
                            // Resguardo por posición si es un servicio precargado
                            gestor.eliminarEntidad(selectedRow);
                        }
                        actualizarTabla();
                    }
                } else {
                    JOptionPane.showMessageDialog(MenuGUI.this, "Por favor, seleccione una fila de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        actualizarTabla();
    }

    public void actualizarTabla() {
        tableModel.setRowCount(0);

        // Listas auxiliares para separar por categorías y forzar un orden visual limpio
        List<Registrable> guias = new ArrayList<>();
        List<Registrable> vehiculos = new ArrayList<>();
        List<Registrable> colaboradores = new ArrayList<>();
        List<Registrable> servicios = new ArrayList<>();

        // Clasificamos cada entidad de la lista original
        for (Registrable entidad : gestor.getListaEntidades()) {
            if (entidad instanceof GuiaTuristico) {
                guias.add(entidad);
            } else if (entidad instanceof Vehiculo) {
                vehiculos.add(entidad);
            } else if (entidad instanceof ColaboradorExterno) {
                colaboradores.add(entidad);
            } else {
                servicios.add(entidad);
            }
        }

        // Unificamos las listas manteniendo un orden estricto de visualización
        List<Registrable> listaOrdenada = new ArrayList<>();
        listaOrdenada.addAll(guias);
        listaOrdenada.addAll(vehiculos);
        listaOrdenada.addAll(colaboradores);
        listaOrdenada.addAll(servicios);

        // Poblamos la tabla con el conjunto ordenado
        for (Registrable entidad : listaOrdenada) {
            String tipo = "";
            String nombreModelo = "";
            String detalles = "";
            String alerta = "";

            if (entidad instanceof GuiaTuristico) {
                GuiaTuristico g = (GuiaTuristico) entidad;
                tipo = "Guía";
                nombreModelo = g.getNombre();
                detalles = "Contacto: " + g.getTelefono() + " | Tour: " + g.getTourAsignado() + " | Vehículo: " + g.getVehiculoAsignado();
                alerta = "Credencial Sernatur Activa";
            }
            else if (entidad instanceof Vehiculo) {
                Vehiculo v = (Vehiculo) entidad;
                tipo = "Vehículo";
                nombreModelo = v.getModelo();
                detalles = "Patente: " + v.getPatente() + " | Capacidad: " + v.getCapacidadPasajeros() + " pasajeros";
                alerta = v.getCapacidadPasajeros() > 15 ? "Requiere Licencia Profesional A2/A3" : "Licencia Clase B";
            }
            else if (entidad instanceof ColaboradorExterno) {
                ColaboradorExterno c = (ColaboradorExterno) entidad;
                tipo = "Colaborador Ext.";
                nombreModelo = c.getNombre();
                detalles = "Empresa: " + c.getEmpresaAsociada() + " | Fono: " + c.getTelefono();
                alerta = "Revisar vigencia del convenio contractual";
            }
            else if (entidad instanceof RutaGastronomica) {
                RutaGastronomica r = (RutaGastronomica) entidad;
                tipo = "Ruta Gastronómica";
                nombreModelo = r.getNombre();
                detalles = "Valor: $" + r.getPrecio() + " | Paradas: " + r.getNumeroDeParadas() + " | Guía: " + (r.getGuia() != null ? r.getGuia().getNombre() : "Sin guía");
                alerta = "TIPS: Llevar efectivo para propinas o consumos extras";
            }
            else if (entidad instanceof PaseoLacustre) {
                PaseoLacustre p = (PaseoLacustre) entidad;
                tipo = "Paseo Lacustre";
                nombreModelo = p.getNombre();
                detalles = "Valor: $" + p.getPrecio() + " | Embarcación: " + p.getTipoEmbarcacion();
                alerta = "SEGURIDAD: Uso obligatorio de chaleco salvavidas";
            }
            else if (entidad instanceof ExcursionCultural) {
                ExcursionCultural ec = (ExcursionCultural) entidad;
                tipo = "Excursión Cultural";
                nombreModelo = ec.getNombre();
                detalles = "Valor: $" + ec.getPrecio() + " | Sitio: " + ec.getLugarHistorico();
                alerta = "Ticket de ingreso incluido en el servicio";
            }

            tableModel.addRow(new Object[]{tipo, nombreModelo, detalles, alerta});
        }

        gestor.desplegarResumenEntidades();
    }
}