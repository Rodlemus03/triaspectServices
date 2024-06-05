package com.backend;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Obtener la sesión de Hibernate
        BDManage manejoBd=new BDManage();
        Transaction transaction=null;
        Session sesion=manejoBd.getSession();


        try {
            // Iniciar una transacción
            transaction = sesion.beginTransaction();

            Categoria category = new Categoria();
            category.setNombre("Prueba2");
            category.setDescripcion("Descripcion prueba2");

            // Guardar el objeto Producto en la base de datos
            sesion.save(category);

            // Commit de la transacción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            sesion.close();
        }

        // Cerrar el SessionFactory
        HibernateUtil.shutdown();

    }
}