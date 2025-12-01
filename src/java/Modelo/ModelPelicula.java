/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Entidad.Pelicula;
import Utils.MysqlDBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class ModelPelicula {

    public Pelicula[] getPeliculas() {

        int posicion = 0;
        Pelicula[] obj_peliculas = null;
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String sql = "select * from pelicula where id= 1";
            cn = MysqlDBConexion.getConexion();
            ps = cn.prepareStatement(sql);
            /*ps.setString (1, log); ps.setString (2, pas); */
            rs = ps.executeQuery();
            if (rs.last()) {

                int tamanio = rs.getRow();
                obj_peliculas = new Pelicula[tamanio];
                rs.beforeFirst();
            }
            while (rs.next()) {
                Pelicula obj_pelicula = new Pelicula();
                obj_pelicula.setCodigo(rs.getInt("codigo"));
                obj_pelicula.setNombre(rs.getString("nombre"));
                obj_pelicula.setGenero(rs.getString("genero"));
                obj_pelicula.setClasificacion(rs.getString("clasificacion"));
                obj_pelicula.setDuracion(rs.getString("duracion"));
                obj_pelicula.setDirector(rs.getString("director"));
                obj_pelicula.setActores(rs.getString("actores"));
                obj_pelicula.setSinopsis(rs.getString("sinopsis"));
                obj_peliculas[posicion] = obj_pelicula;
                posicion++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return obj_peliculas;
    }

    public Pelicula getPelicula() {
        Pelicula obj_pelicula = new Pelicula();
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String sql = "select * from pelicula where id= (select max (id) from pelicula)";
            cn = MysqlDBConexion.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
//obj_pelicula.setCodigo (rs.getInt("codigo"));
                obj_pelicula.setNombre(rs.getString("nombre"));
                obj_pelicula.setGenero(rs.getString("genero"));
                obj_pelicula.setClasificacion(rs.getString("clasificacion"));
                obj_pelicula.setDuracion(rs.getString("duracion"));
                obj_pelicula.setDirector(rs.getString("director"));
                obj_pelicula.setActores(rs.getString("actores"));
                obj_pelicula.setSinopsis(rs.getString("sinopsis"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return obj_pelicula;
    }

    public boolean savePelicula(Pelicula prm_pelicula) {
        Pelicula obj_pelicula = null;
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            String sql = "insert into pelicula "
                    + "(nombre, genero, clasificacion, duracion, director, actores, sinopsis) "
                    + "values ('" + prm_pelicula.getNombre()
                    + "','" + prm_pelicula.getGenero() + "', '" + prm_pelicula.getClasificacion()
                    + "','" + prm_pelicula.getDuracion() + "','" + prm_pelicula.getDirector()
                    + "','" + prm_pelicula.getActores() + "', '" + prm_pelicula.getSinopsis() + "')";
            
            System.out.println(">>> QUERY: "  + sql);
            cn = MysqlDBConexion.getConexion();
            ps = cn.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {

                e2.printStackTrace();
            }
            return true;
        }
    }
}
