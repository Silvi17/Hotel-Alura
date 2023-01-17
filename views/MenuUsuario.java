package views;	

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import javax.swing.JSeparator;

@SuppressWarnings({ "serial" })
public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel lblBusquedaDeReservas;
	private JLabel labelRegistroH;
	private JLabel labelRegistro_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
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
	public MenuUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/nombre-hotel.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 142, 145));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(true);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(40, 200, 250));
		panelMenu.setBounds(0, 0, 257, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(30, 30, 190, 190);
		panelMenu.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/nombre-hotel.png"))); //
		
		/////////////// 
		
		
		JPanel btnRegistroHuesped = new JPanel();
		btnRegistroHuesped.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistroHuesped.setBackground(new Color(52, 142, 145));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistroHuesped.setBackground(new Color(33, 54, 53));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistroHuesped registro = new RegistroHuesped();
				registro.setVisible(true);
				dispose();
			}
		});
		btnRegistroHuesped.setBounds(0, 255, 257, 56);
		btnRegistroHuesped.setBackground(new Color(33, 54, 53));
		panelMenu.add(btnRegistroHuesped);
		btnRegistroHuesped.setLayout(null);
		
		/////////////// 
		
		JPanel btnBusqueda = new JPanel();
		btnBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBusqueda.setBackground(new Color(52, 142, 145));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBusqueda.setBackground(new Color(33, 54, 53));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();
				
			}
		});
		btnBusqueda.setBounds(0, 312, 257, 56);
		btnBusqueda.setBackground(new Color(33, 54, 53));
		panelMenu.add(btnBusqueda);
		btnBusqueda.setLayout(null);
		
				
				
				labelRegistro_1 = new JLabel("Registro de reservas");		
				labelRegistro_1.setBounds(23, 10, 205, 34);
				btnBusqueda.add(labelRegistro_1);
				labelRegistro_1.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/reservado.png")));
				labelRegistro_1.setForeground(SystemColor.text);
				labelRegistro_1.setFont(new Font("Roboto", Font.PLAIN, 18));
				labelRegistro_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		/////////////// 
				
			JPanel btsearch = new JPanel();
			btsearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btsearch.setBackground(new Color(52, 142, 145));				
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btsearch.setBackground(new Color(33, 54, 53));	
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					Busqueda busqueda = new Busqueda();
					busqueda.setVisible(true);
					dispose();
				}
			});
			btsearch.setBounds(0, 369, 257, 56);
			btsearch.setBackground(new Color(33, 54, 53));
			panelMenu.add(btsearch);
			btsearch.setLayout(null);
			
							
			lblBusquedaDeReservas = new JLabel("Búsquedas");
			lblBusquedaDeReservas.setBounds(23, 10, 205, 34);
			btsearch.add(lblBusquedaDeReservas);
			lblBusquedaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/pessoas.png")));
			lblBusquedaDeReservas.setForeground(SystemColor.text);
			lblBusquedaDeReservas.setFont(new Font("Roboto", Font.PLAIN, 18));
			lblBusquedaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
			
		labelRegistroH = new JLabel("Registro de Huésped");
		labelRegistroH.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/reservado.png")));
		labelRegistroH.setForeground(SystemColor.text);
		labelRegistroH.setBounds(23, 10, 205, 34);
		labelRegistroH.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelRegistroH.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistroHuesped.add(labelRegistroH);

		
		
		
				
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 230, 201, 2);
		panelMenu.add(separator);
		

		/////////////// 
		
		

		
		header.setLayout(null);
		header.setBackground(new Color(42, 145, 145));
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(891, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setBackground(new Color(42, 142, 145));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
	    JPanel panelFecha = new JPanel();
	    panelFecha.setBackground(new Color(52, 142, 145));
	    panelFecha.setBounds(256, 84, 688, 121);
	    contentPane.add(panelFecha);
	    panelFecha.setLayout(null);
	    
	    JLabel lblNewLabel_1 = new JLabel("OCEAN PALACE: Resort y Spa Hotel");
	    lblNewLabel_1.setBounds(186, 10, 331, 42);
	    panelFecha.add(lblNewLabel_1);
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 20));
	    
	    JLabel labelFecha = new JLabel("New label");
	    labelFecha.setBounds(35, 64, 294, 36);
	    panelFecha.add(labelFecha);
	    labelFecha.setForeground(Color.WHITE);
	    labelFecha.setFont(new Font("Roboto", Font.PLAIN, 26));
	    Date fechaActual = new Date(); //fecha y hora actual
	    String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual); //formatear la fecha en una cadena
	    labelFecha.setText("Hoy es " + fecha); //setear la representacion en cadena de la fecha
	    
	    JLabel lblNewLabel = new JLabel("Bienvenido/a");
	    lblNewLabel.setForeground(new Color(255, 255, 255));
	    lblNewLabel.setBackground(new Color(240, 240, 240));
	    lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 22));
	    lblNewLabel.setBounds(312, 235, 147, 46);
	    contentPane.add(lblNewLabel);
	    
	    String textoDescripcion1 = "<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas:</body></html>";
	    JLabel labelDescripcion_1 = new JLabel(textoDescripcion1);
	    labelDescripcion_1.setForeground(new Color(255, 255, 255));
	    labelDescripcion_1.setFont(new Font("Roboto", Font.PLAIN, 16));
	    labelDescripcion_1.setBounds(300, 350, 569, 60);
	    contentPane.add(labelDescripcion_1);
	    
	    JLabel lblNewLabel_3 = new JLabel("• Registro de Reservas y Huéspedes");
	    lblNewLabel_3.setForeground(new Color(255, 255, 255));
	    lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 16));
	    lblNewLabel_3.setBounds(312, 444, 295, 27);
	    contentPane.add(lblNewLabel_3);
	    
	    JLabel lblNewLabel_3_1 = new JLabel("• Edición de Reservas y Huéspedes existentes");
	    lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
	    lblNewLabel_3_1.setFont(new Font("Roboto", Font.PLAIN, 16));
	    lblNewLabel_3_1.setBounds(312, 482, 355, 27);
	    contentPane.add(lblNewLabel_3_1);
	    
	    JLabel lblNewLabel_3_2 = new JLabel("• Eliminar todo tipo de registros");
	    lblNewLabel_3_2.setForeground(new Color(255, 255, 255));
	    lblNewLabel_3_2.setFont(new Font("Roboto", Font.PLAIN, 16));
	    lblNewLabel_3_2.setBounds(312, 520, 295, 27);
	    contentPane.add(lblNewLabel_3_2);
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}