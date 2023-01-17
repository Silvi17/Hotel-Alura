package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;

import com.hotel.jdbc.controller.ReservaController;
import com.hotel.jdbc.controller.HuespedController;
import com.hotel.jdbc.modelo.Reservas;
import com.hotel.jdbc.modelo.Huespedes;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modeloH, modeloR;

	private JLabel labelAtras;
	private JLabel labelExit;
	
    private JButton btnEditar, btnEliminar;
	
	private HuespedController huespedController;
	private ReservaController reservaController;
	public String seleccion = "";
	public String seleccionTable;
	
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		tbReservas = new JTable();
		
		this.reservaController = new ReservaController();
	    this.huespedController = new HuespedController();
	    
        
        
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 142, 145));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		//JPanel btnEliminar = new JPanel();
		btnEliminar = new JButton();
		btnEliminar.setForeground(new Color(33, 54, 53));
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(33, 54, 53));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setBackground(new Color(33, 54, 53));
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(new Color(255, 255, 255));
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setBackground(new Color(33, 54, 53));
		lblNewLabel_4.setForeground(new Color(33, 54, 53));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(294, 63, 347, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(92, 142, 145));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		
		
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		tbReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionTable = "reservas";
			}
		});
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), tbReservas, null);
		modeloR = (DefaultTableModel) tbReservas.getModel();
		modeloR.addColumn("Número de Reserva");
		modeloR.addColumn("Fecha Check In");
		modeloR.addColumn("Fecha Check Out");
		modeloR.addColumn("Valor");
		modeloR.addColumn("Forma de Pago");
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		tbHuespedes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionTable = "huespedes";
			}
		});
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), tbHuespedes, null);
		modeloH = (DefaultTableModel) tbHuespedes.getModel();
		modeloH.addColumn("Numero de Huesped");
		modeloH.addColumn("Nombre");
		modeloH.addColumn("Apellido");
		modeloH.addColumn("Fecha de Nacimiento");
		modeloH.addColumn("Nacionalidad");
		modeloH.addColumn("Telefono");
		//modeloH.addColumn("Numero de Reserva");
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/nombre-hotel.png")));
		lblNewLabel_2.setBounds(53, 41, 122, 120);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(new Color(33, 54, 53));
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(92, 142, 145));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(92, 142, 145));
		separator_1_2.setBackground(new Color(92, 142, 145));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limpiarTabla();

				filtrar();
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(33, 54, 53));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBackground(new Color(33, 54, 53));
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(new Color(255, 255, 255));
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		// 	JPanel btnEditar = new JPanel();
		btnEditar = new JButton();
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(33, 54, 53));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setBackground(new Color(33, 54, 53));
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(new Color(255, 255, 255));
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		setResizable(false);
		
		
		cargarTabla();
	}
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
	    }
	    
	    private void configurarAccionesDelFormulario() {
	    	btnEditar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	modificar();
	                limpiarTabla();
	                cargarTabla();
	               
	            }
	        });
	    	
	        btnEliminar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	eliminar();
	                limpiarTabla();
	                cargarTabla();
	            }
	        });
	        
	        btnEliminar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	eliminar();
	                limpiarTabla();
	                cargarTabla();
	            }
	        });
	        
	    }
	    
	    private void limpiarTabla() {
	    	
	        DefaultTableModel tb = (DefaultTableModel) tbReservas.getModel();
	        int a = tbReservas.getRowCount()-1;
	        for (int i = a; i >= 0; i--) {          
	        	tb.removeRow(tb.getRowCount()-1);
	        }

	        DefaultTableModel tb2 = (DefaultTableModel) tbHuespedes.getModel();
	        int b = tbHuespedes.getRowCount()-1;
	        for (int i = b; i >= 0; i--) {          
	        	tb2.removeRow(tb2.getRowCount()-1);
	        }
	        
	        modeloH.getDataVector().clear();
	        modeloR.getDataVector().clear();
	        modeloR.setRowCount(0);
	    }

	    
	    private void cargarTabla() {

	        var reservas = this.reservaController.listar();
	        reservas.forEach(reserva-> modeloR.addRow(
	        		
	                new Object[] {
	                		reserva.getId(),
	                		reserva.getFechaEntrada(),
	                		reserva.getFechaSalida(),
	                		reserva.getValor(),
	                		reserva.getFormaPago() 
	                		}));

	    	
	        var huespedes = this.huespedController.listar();
	        
	        huespedes.forEach(huesped-> modeloH.addRow(
	        		
	                new Object[] {
	                		huesped.getId(),
	                		huesped.getNombre(),
	                		huesped.getApellido(),
	                		huesped.getFechaNacimiento(), 
	                		huesped.getNacionalidad(), 
	                		huesped.getTelefono()
	                		}));

	    	configurarAccionesDelFormulario();
	    }	 
	    
	    private boolean tieneFilaElegida() {
	    	return tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0 || tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0;
	    }
	    
	    private void modificar() {
	        // if (tieneFilaElegida()) {
	    	//   JOptionPane.showMessageDialog(this, "Por favor, elije un item");
	    	//		return;
	    	//}

	         if  (seleccionTable == "huespedes" ){
	       
		        Optional.ofNullable(modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
	            .ifPresentOrElse(fila -> {
	            	
	                Integer id = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
	                String Nombre = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 1);
	                String Apellido = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 2);
	                String FechaNacimiento = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 3);
	                String Nacionalidad = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 4);
	                String Telefono = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 5);
	                
	                var filasModificadas = this.huespedController.modificar(id, Nombre, Apellido, FechaNacimiento, Nacionalidad, Telefono );
	                	
	                JOptionPane.showMessageDialog(this, String.format("%d item modificado con éxito!", filasModificadas));
	            }, () -> JOptionPane.showMessageDialog(this, "Por favor, elija un ítem"));
	         } 
	         
	        if  (seleccionTable == "reservas" ){

		        Optional.ofNullable(modeloR.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
	            .ifPresentOrElse(fila -> {
	            
	            	Integer id = Integer.valueOf(modeloR.getValueAt(tbReservas.getSelectedRow(), 0).toString());
	                Date FechaEntrada = (Date) modeloR.getValueAt(tbReservas.getSelectedRow(), 1);
	                Date FechaSalida = (Date) modeloR.getValueAt(tbReservas.getSelectedRow(), 2);
	                Integer Valor = Integer.valueOf(modeloR.getValueAt(tbReservas.getSelectedRow(), 3).toString());
	                String FormaPago = (String) modeloR.getValueAt(tbReservas.getSelectedRow(), 4);
	                
	                var filasModificadas = this.reservaController.modificar(id, FechaEntrada, FechaSalida, Valor, FormaPago, id);
	                	
	                JOptionPane.showMessageDialog(this, String.format("%d ítem modificado con éxito!", filasModificadas));
	            }, () -> JOptionPane.showMessageDialog(this, "Por favor, elija un ítem"));
	        
	        } 
	    }
	    
	    private void eliminar() {
	        // if (tieneFilaElegida()) {
	    	//    	JOptionPane.showMessageDialog(this, "Por favor, elija un ítem");
	    	//    	return;
	    	//}
	    	
	    	
	    	if  (seleccionTable == "reservas" ){
	    	
		        Optional.ofNullable(modeloR.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
	            .ifPresentOrElse(fila -> {
	                Integer id = Integer.valueOf(modeloR.getValueAt(tbReservas.getSelectedRow(), 0).toString());

	                var filasModificadas = this.reservaController.eliminar(id);

	                modeloR.removeRow(tbReservas.getSelectedRow());

	                JOptionPane.showMessageDialog(this,
	                        String.format("%d ítem eliminado con éxito!", filasModificadas));
	            }, () -> JOptionPane.showMessageDialog(this, "Por favor, elija un ítem"));
                
	    	} 
	    	if  (seleccionTable == "huespedes" ){

	    		Optional.ofNullable(modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
	            .ifPresentOrElse(fila -> {
	                Integer id = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());

	                var filasModificadas = this.huespedController.eliminar(id);

	                modeloH.removeRow(tbHuespedes.getSelectedRow());

	                JOptionPane.showMessageDialog(this,
	                        String.format("%d ítem eliminado con éxito!", filasModificadas));
	           }, () -> JOptionPane.showMessageDialog(this, "Por favor, elija un ítem"));
	    	}
	    }
	    
	    private void filtrar() {
	    	
	    	String txtFiltado = txtBuscar.getText();
	    	Boolean validar = false;
	    	
	    	if (txtFiltado.length() != 0) {
	    		limpiarTabla();
	    		validar = true;
		    	List<Reservas> reservaCoincidencia = this.reservaController.listarOnly(txtFiltado);
		    	reservaCoincidencia.forEach(reserva-> modeloR.addRow(
		        		
		                new Object[] {
		                		reserva.getId(),
		                		reserva.getFechaEntrada(),
		                		reserva.getFechaSalida(),
		                		reserva.getValor(),
		                		reserva.getFormaPago() 
		                		}));
	
		    	List<Huespedes> huespedesCoincidencia = this.huespedController.listarOnly(txtFiltado);    
		    	huespedesCoincidencia.forEach(huesped-> modeloH.addRow(	        		
	            new Object[] {
	            		huesped.getId(),
	            		huesped.getNombre(),
	            		huesped.getApellido(),
	            		huesped.getFechaNacimiento(), 
	            		huesped.getNacionalidad(), 
	            		huesped.getTelefono(),
	            		huesped.getIdReserva()
	            		}));
		    	return;
	    	}
	    	if (!validar) {
	    		cargarTabla();
	    	}
		}
	    
	    
	    
}