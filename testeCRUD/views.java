import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class views extends JFrame {

	private JPanel contentPane;
	private JTextField idtxt;
	private JTextField usertxt;
	private JTextField passtxt;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					views frame = new views();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public views() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel idlabel = new JLabel("ID: (alterar) ");
		idlabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idlabel.setBounds(30, 30, 80, 22);
		contentPane.add(idlabel);
		
		JLabel userlabel = new JLabel("Usu\u00E1rio:");
		userlabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userlabel.setBounds(30, 60, 80, 22);
		contentPane.add(userlabel);
		
		JLabel passlabel = new JLabel("Senha:");
		passlabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passlabel.setBounds(30, 90, 80, 22);
		contentPane.add(passlabel);

		idtxt = new JTextField();
		idtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idtxt.setBounds(142, 30, 140, 22);
		contentPane.add(idtxt);
		idtxt.setColumns(10);
		
		usertxt = new JTextField();
		usertxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usertxt.setBounds(142, 60, 140, 22);
		contentPane.add(usertxt);
		usertxt.setColumns(18);
		
		passtxt = new JTextField();
        passtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passtxt.setBounds(142, 90, 140, 22);
		contentPane.add(passtxt);
		passtxt.setColumns(18);
		
		JButton enterbtn = new JButton("Entrar");
		enterbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		enterbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
				logar();
			}
		});
		enterbtn.setBounds(30, 130, 140, 30);
		contentPane.add(enterbtn);
		
		JButton cancelbtn = new JButton("Cancelar");
		cancelbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelbtn.setBounds(264, 130, 140, 30);
		contentPane.add(cancelbtn);
		
		JButton cadastrobtn = new JButton("Cadastrar");
		cadastrobtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cadastrobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
				listar();
				limpar();
			}
		});
		cadastrobtn.setBounds(30, 210, 374, 30);
		contentPane.add(cadastrobtn);

		JButton buscarbtn = new JButton("Listar");
		buscarbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buscarbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		buscarbtn.setBounds(315, 30, 89, 23);
		contentPane.add(buscarbtn);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][][] {
			},
			new String[] {
				"Usu\u00E1rio", "ID", "Senha"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setVisible(true);
		table.setBounds(30, 279, 374, 271);
		contentPane.add(table);

		JButton alterarbtn = new JButton("Alterar");
		alterarbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
				listar();
				limpar();
			}
		});
		alterarbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		alterarbtn.setBounds(315, 60, 89, 23);
		contentPane.add(alterarbtn);

		JButton excluirbtn = new JButton("Excluir");
		excluirbtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		excluirbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				listar();
				limpar();
			}
		});
		excluirbtn.setBounds(315, 90, 89, 23);
		contentPane.add(excluirbtn);
	}

	private void limpar() {
		usertxt.setText("");
		passtxt.setText("");
		idtxt.setText("");
		usertxt.requestFocus();
	}

	private void logar(){
		try {
			String user = usertxt.getText();
			String password = passtxt.getText();

			user objuser = new user();
			objuser.setUser(user);
			objuser.setPassword(password);

			userDAO objdao = new userDAO();
			ResultSet rset = objdao.logar(objuser);

			if (rset.next()) {
				systemView view = new systemView();
				view.setVisible(true);

				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha inválida.");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	} 

	private void cadastrar() {
			String user = usertxt.getText();
			String password = passtxt.getText();

			user objuser = new user();
			objuser.setUser(user);
			objuser.setPassword(password);

			userDAO objdao = new userDAO();
			objdao.cadastrar(objuser);
	}

	private void listar(){
		try {
			userDAO objdao = new userDAO();

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);

			ArrayList<user> lista = objdao.buscar();

			for(int i = 0; i < lista.size(); i++) {
				model.addRow(new Object[] {
					lista.get(i).getId(),
					lista.get(i).getUser(),
					lista.get(i).getPassword()
				});
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	private void alterar() {
  		int id = Integer.parseInt(idtxt.getText());
		String user = usertxt.getText();
		String senha = passtxt.getText();

		user objuser = new user();
		objuser.setId(id);
		objuser.setUser(user);
		objuser.setPassword(senha);

		userDAO objdao = new userDAO();
		objdao.alterar(objuser);
	}

	public void excluir() {
		int id = Integer.parseInt(idtxt.getText());
		
		user objuser = new user();
		objuser.setId(id);

		userDAO objdao = new userDAO();
		objdao.excluir(objuser);
	}
}
