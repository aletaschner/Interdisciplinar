package DAO;

import DAO.ConectaMYSQL;

public class TestaConex�o {

	public static void main(String[] args) {

		//Vamos alterar esse c�digo em breve.
		ConectaMYSQL conecta = new ConectaMYSQL();

		try {
			conecta.getConnection();
			System.out.println("Conectou com sucesso!");

		} catch (Exception e) {
			System.out.println("Zicou: " + e.getMessage());
		}

	}

}
