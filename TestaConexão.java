package Model.Dao;

import Model.Dao.ConectaSqlite;

public class TestaConex�o {

	public static void main(String[] args) {

		//Vamos alterar esse c�digo em breve.
		ConectaSqlite conecta = new ConectaSqlite();

		try {
			conecta.getConnection();
			System.out.println("Conectou com sucesso!");
			
		} catch (Exception e) {
			System.out.println("Zicou: " + e.getMessage());
		}

	}

}
