package controller;

import java.time.LocalDateTime;

import dao.BigliettoDAO;
import dao.IBigliettoDAO;
import module.Biglietto;

public class Main {

	
	public static void main(String[] args) {
		
		IBigliettoDAO bigliettoDAO = new BigliettoDAO();
		
		Biglietto b1 = new Biglietto(LocalDateTime.now());
		System.out.println(b1.toString()); 
		try {
			bigliettoDAO.save(b1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
