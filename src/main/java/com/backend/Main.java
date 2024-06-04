package com.backend;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Obtener la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Iniciar una transacción
            transaction = session.beginTransaction();

            Categoria category = new Categoria();
            category.setNombre("Prueba");
            category.setDescripcion("Descripcion prueba");

            // Guardar el objeto Producto en la base de datos
            session.save(category);

            // Commit de la transacción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Cerrar el SessionFactory
        HibernateUtil.shutdown();

    }
}