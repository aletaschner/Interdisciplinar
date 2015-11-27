package DAO;

import DAO.ConectaMYSQL;

public class TestaConexão {

	public static void main(String[] args) {

		//Vamos alterar esse código em breve.
		ConectaMYSQL conecta = new ConectaMYSQL();

		try {
			conecta.getConnection();
			System.out.println("Conectou com sucesso!");

		} catch (Exception e) {
			System.out.println("Zicou: " + e.getMessage());
		}

	}

}
