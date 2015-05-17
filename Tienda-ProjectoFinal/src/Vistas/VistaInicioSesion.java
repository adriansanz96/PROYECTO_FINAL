package Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import Controlador.ControlladorMenu;

import javax.swing.JPasswordField;

public class VistaInicioSesion extends JPanel {
	private ArrayList<String> usuarios;
	JComboBox usuario;
	private JPasswordField Contrasena;

	
	public VistaInicioSesion() {
		setLayout(null);
		//ETIQUETAS
		JLabel label = new JLabel("Contrase\u00F1a");
		label.setBounds(10, 42, 67, 14);
		add(label);
		JLabel label_1 = new JLabel("Usuario");
		label_1.setBounds(28, 12, 46, 19);
		add(label_1);
		
		//COMBOBOX
		usuario = new JComboBox();
		usuario.setBounds(87, 11, 140, 20);
		add(usuario);
		
		//CAJA CONTRASEÑA
		Contrasena = new JPasswordField();
		Contrasena.setBounds(87, 39, 140, 20);
		add(Contrasena);
		
		//BOTON
		JButton button = new JButton("Entrar");
		//ACCION DEL BOTON
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(Contrasena.getPassword().length == 0){
					
					//SI ESTA VACIO
					Menu.mensaje("Introduce la contraseña");
				}else{
					//SI NO ESTA VACIO
						ControlladorMenu.getInstance().checkUser((String)usuario.getSelectedItem(),Contrasena.getPassword());
						
						
					
						}}
				});

		button.setBounds(237, 12, 89, 44);
		add(button);
		
		
	}
	//Añadir Usuarios
	public void putUsuarios(ArrayList<String> usuarios){
		usuario.removeAllItems();
	    for(String s:usuarios){
	    	usuario.addItem(s);
	    }
	    this.repaint();
	}
}


