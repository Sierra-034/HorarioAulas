/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.modelo.tablas;

import itsco.aulas.dao.DaoManager;

/**
 *
 * @author Samuel Gomez
 */
public class TableModelFactory {
    
    private final DaoManager manager;
    private TableModelAula aula;
    private TableModelDocente docente;
    private TableModelGrupo grupo;
    private TableModelMateria materia;
    
    private static TableModelFactory factory;

    private TableModelFactory(DaoManager manager) {
        this.manager = manager;
    }
    
    //Este método solo debería ser llamado una vez
    public static void createTableModelFactory(DaoManager manager) {
        if(factory == null)
            factory = new TableModelFactory(manager);
    }
    
    //Este método sebe ser llamado siempre después de crateTableModelFactory
    //de lo contrario mandará una referencia null
    public static TableModelFactory getInstance() {
        return factory;            
    }
    
    public TableModelAula getTableModelAula() {
        if(aula == null) 
            aula = new TableModelAula(manager.createDaoAula());
        
        return aula;
    }

    public TableModelDocente getTableModelDocente() {
        if(docente == null)
            docente = new TableModelDocente(manager.createDaoDocente());
            
        return docente;
    }

    public TableModelGrupo getTableModelGrupo() {
        if(grupo == null)
            grupo = new TableModelGrupo(manager.createDaoGrupo());
        
        return grupo;
    }

    public TableModelMateria getTableModelMateria() {
        if(materia == null)
            materia = new TableModelMateria(manager.createDaoMateria());
        
        return materia;
    }  
    
}
