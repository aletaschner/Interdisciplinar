//implementacao da interface Initializable para o fx entender que esta eh a crontroler referente a tela
//@FXML notacao pra dizer q aqueles campos sao referentes aos campos datela
// verifica se o usuario e senha estao corretos e cria secao
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import model.Sessao;
import model.Usuario;
import DAO.UsuarioDAO;
import view.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControlerLogin implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	private TextField user;
	@FXML
	private PasswordField senha;

	public void confirmar(ActionEvent event) {
		String usuario = "";
		String password = "";
		try {
			usuario = user.getText().toString();
			password = senha.getText().toString();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Caracteres Incorretos no campo usuario ou senha", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (password.isEmpty())
			JOptionPane.showMessageDialog(null, "Senha Vazia", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		else {
			try {
				Usuario U = new UsuarioDAO().getDetalhe(usuario);
				if (U != null) {
					if (U.getUsuarioSenha() != null) {
						if (U.getUsuarioSenha().equals(password)) {
							Sessao Log = Sessao.getInstance();
							Log.setUsuario(U);
							Login.getStage().close();
						} else {
							JOptionPane.showMessageDialog(null, "Senha Incorreta", "Aviso",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Usuario Incorreto", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Usuario Incorreto", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

	public void limpar(ActionEvent Event) {
		System.exit(0);
	}

}
