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

    // Componentes globales para el módulo inferior de colaboradores
    private DefaultListModel<String> modeloColaboradores = new DefaultListModel<>();
    private JList<String> listaColaboradoresGui = new JList<>(modeloColaboradores);

    public MenuGUI(GestorEntidades gestor) {
        this.gestor = gestor;
        setTitle("Llanquihue Tour - Panel de Operations");
        setSize(1000, 750); // Incrementamos la altura para acomodar el nuevo panel cómodamente
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
        table.getColumnModel().getColumn(2).setPreferredWidth(420); // Detalles
        table.getColumnModel().getColumn(3).setPreferredWidth(250); // Alertas
        // ----------------------------------------------

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
        add(scrollPane, BorderLayout.CENTER);

        // --- PANEL DE BOTONES PRINCIPALES
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



        //NUEVO MÓDULO INFERIOR DE COLABORADORES

        JPanel panelColaboradores = new JPanel(new BorderLayout(5, 5));
        panelColaboradores.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 15, 15, 15),
                BorderFactory.createTitledBorder("Módulo de Colaboradores Externos (Soporte Operacional)")
        ));

        // Formulario de campos de texto
        JPanel formularioColab = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JTextField txtNom = new JTextField(10);
        JTextField txtTel = new JTextField(9);
        JTextField txtEmp = new JTextField(10);
        JButton btnAddColab = new JButton("Registrar Colaborador");
        JButton btnDelColab = new JButton("Quitar Colaborador");

        btnAddColab.setFont(new Font("Arial", Font.BOLD, 12));
        btnDelColab.setFont(new Font("Arial", Font.BOLD, 12));

        formularioColab.add(new JLabel("Nombre:"));
        formularioColab.add(txtNom);
        formularioColab.add(new JLabel("Fono:"));
        formularioColab.add(txtTel);
        formularioColab.add(new JLabel("Empresa:"));
        formularioColab.add(txtEmp);
        formularioColab.add(btnAddColab);
        formularioColab.add(btnDelColab);

        panelColaboradores.add(formularioColab, BorderLayout.NORTH);

        // Lista visual en Scroll
        listaColaboradoresGui.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollColab = new JScrollPane(listaColaboradoresGui);
        scrollColab.setPreferredSize(new Dimension(200, 80));
        panelColaboradores.add(scrollColab, BorderLayout.CENTER);



        JPanel panelSurContenedor = new JPanel(new BorderLayout());
        panelSurContenedor.add(panelButtons, BorderLayout.NORTH);
        panelSurContenedor.add(panelColaboradores, BorderLayout.SOUTH);
        add(panelSurContenedor, BorderLayout.SOUTH);




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
                            // Forzamos el re-guardado automático para que se persista el borrado directo de la lista
                            gestor.agregarEntidad(null);
                            gestor.getListaEntidades().remove(null);
                        } else {
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

        //  REGISTRAR NUEVO COLABORADOR INTERNO
        btnAddColab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNom.getText().trim();
                String fono = txtTel.getText().trim();
                String empresa = txtEmp.getText().trim();

                if (!nombre.isEmpty() && !fono.isEmpty() && !empresa.isEmpty()) {
                    ColaboradorExterno nuevoColab = new ColaboradorExterno(nombre, fono, empresa);
                    gestor.agregarEntidad(nuevoColab); // Guarda automáticamente en el TXT

                    txtNom.setText(""); txtTel.setText(""); txtEmp.setText("");
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(MenuGUI.this, "Por favor, complete todos los campos del colaborador.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        btnDelColab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaColaboradoresGui.getSelectedIndex();
                if (selectedIndex >= 0) {
                    String itemSeleccionado = listaColaboradoresGui.getSelectedValue();
                    Registrable colabEliminar = null;

                    for (Registrable ent : gestor.getListaEntidades()) {
                        if (ent instanceof ColaboradorExterno) {
                            ColaboradorExterno c = (ColaboradorExterno) ent;

                            if (itemSeleccionado.contains(c.getNombre())) {
                                colabEliminar = ent;
                                break;
                            }
                        }
                    }

                    if (colabEliminar != null) {
                        gestor.getListaEntidades().remove(colabEliminar);

                        gestor.agregarEntidad(null);
                        gestor.getListaEntidades().remove(null);
                        actualizarTabla();
                    }
                } else {
                    JOptionPane.showMessageDialog(MenuGUI.this, "Seleccione un colaborador de la lista inferior para quitarlo.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        actualizarTabla();
    }

    public void actualizarTabla() {
        tableModel.setRowCount(0);
        modeloColaboradores.clear();

        List<Registrable> guias = new ArrayList<>();
        List<Registrable> vehiculos = new ArrayList<>();
        List<Registrable> colaboradores = new ArrayList<>();
        List<Registrable> servicios = new ArrayList<>();

        for (Registrable entidad : gestor.getListaEntidades()) {
            if (entidad instanceof GuiaTuristico) {
                guias.add(entidad);
            } else if (entidad instanceof Vehiculo) {
                vehiculos.add(entidad);
            } else if (entidad instanceof ColaboradorExterno) {
                colaboradores.add(entidad); // Se filtran para irse abajo
            } else {
                servicios.add(entidad);
            }
        }


        List<Registrable> listaOrdenada = new ArrayList<>();
        listaOrdenada.addAll(guias);
        listaOrdenada.addAll(vehiculos);
        listaOrdenada.addAll(servicios);


        for (Registrable colab : colaboradores) {
            ColaboradorExterno c = (ColaboradorExterno) colab;
            modeloColaboradores.addElement(c.getNombre() + " | Empresa: " + c.getEmpresaAsociada() + " | Fono: " + c.getTelefono());
        }


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