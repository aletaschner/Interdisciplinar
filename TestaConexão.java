package Model.Dao;

import Model.Dao.ConectaSqlite;

public class TestaConexão {

	public static void main(String[] args) {

		//Vamos alterar esse código em breve.
		ConectaSqlite conecta = new ConectaSqlite();

		try {
			conecta.getConnection();
			System.out.println("Conectou com sucesso!");
			
		} catch (Exception e) {
			System.out.println("Zicou: " + e.getMessage());
		}

	}

}
